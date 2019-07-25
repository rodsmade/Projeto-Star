package br.com.star.crudStar.demo.repository;

import br.com.star.crudStar.demo.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository<Comentario, Long> {
}
