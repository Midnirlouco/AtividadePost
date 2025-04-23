package br.unipar.programacaoweb.library.repository;

import br.unipar.programacaoweb.library.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

}
