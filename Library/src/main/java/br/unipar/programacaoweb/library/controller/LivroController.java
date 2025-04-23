package br.unipar.programacaoweb.library.controller;

import br.unipar.programacaoweb.library.model.Livro;
import br.unipar.programacaoweb.library.service.LivroService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LivroController {

    private LivroService livroService;

    public LivroController(LivroService livroService){
        this.livroService = livroService;
    }

    @GetMapping("/Livro/Listar")
    public List<Livro> listarlivros() {
        return livroService.listaTodos();
    }
}
