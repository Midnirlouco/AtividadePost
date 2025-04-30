package br.unipar.programacaoweb.library.repository;

import br.unipar.programacaoweb.library.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long> {

    List<Livro> findByTituloContaining(String titulo);

    List<Livro> findByGeneroContainingIgnoreCase(String genero);

    @Query("SELECT t FROM Livro WHERE t.titulo = :genero AND t.numeroPaginas >= :numeroPaginas")
    List<Livro> findByTituloeNumeroPaginas(@Param("genero") String genero,
                                           @Param("numeroPaginas") Integer numeroPaginas);
}
