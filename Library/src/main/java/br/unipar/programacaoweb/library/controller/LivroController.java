package br.unipar.programacaoweb.library.controller;

import br.unipar.programacaoweb.library.model.Livro;
import br.unipar.programacaoweb.library.service.LivroService;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@GetMapping("/Livro")
public class LivroController {

    private LivroService livroService;


    public LivroController(LivroService livroService){
        this.livroService = livroService;
    }

    @GetMapping("/Listar")
    public ResponseEntity<List<Livro>> listarlivros() {
        List<Livro> livros = livroService.listaTodos();
        if (livros.isEmpty()) {
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(livros);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Livro> buscarLivroPorID(@PathVariable Long id){
        Livro livro = LivroService.BuscarPorId(id);
        if (livro == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(livro);
    }

  @GetMapping("/buscar/titulo/{titulo}")
    public ResponseEntity<List<Livro>> buscarLivrosPorTitulo(@PathVariable String titulo) {
        List<Livro> livros = livroService.buscarPorTitulo(titulo);
        if(livros.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(livros);
    }

    @PostMapping("/Salvar")
    public ResponseEntity<Livro> salvarLivro(@RequestBody Livro livro) {
        Livro livroSalvo = livroService.salvar(livro);

        return ResponseEntity.status(HttpStatus.CREATED).body(livroSalvo);
    }

    @DeleteMapping("/excluir/{id}")
    public ResponseEntity<Void> excluirLivro(@PathVariable long id){
        Livro livro = livroService.BuscarPorId(id);
        if(livro == null) {
            return ResponseEntity.notFound().build();
        }
        livroService.excluir(id);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("editar/{id}")
    public ResponseEntity<Livro> editarLivro(@PathVariable Long id, @RequestBody Livro livro) {
        Livro livroAtual = livroService.BuscarPorId(id);
        if(livroAtual == null) {
            return ResponseEntity.notFound().build();
        }

        livroAtual.setTitulo(livro.getTitulo());
        livroAtual.setNumeroPaginas(livro.getNumeroPaginas());
        livroAtual.setGenero(livro.getGenero());

        return ResponseEntity.ok(livroService.salvar(livroAtual));
    }
}
