package br.unipar.programacaoweb.library.service;

import br.unipar.programacaoweb.library.model.Livro;
import br.unipar.programacaoweb.library.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public void salvar(Livro livro){
        livroRepository.save(livro);
    }

    public void excluir(Long id){
        livroRepository.deleteById(id);
    }

    public void BuscarPorId(Long id){
        livroRepository.findById(id).orElse(null);
    }

    public List<Livro> buscarPorTitulo(String titulo) {
        return livroRepository.findAll().stream()
                .filter(livro -> livro.getTitulo().equalsIgnoreCase(titulo))
                .toList();
    }

    public List<Livro> listaTodos() {
        return livroRepository.findAll();
    }
}
