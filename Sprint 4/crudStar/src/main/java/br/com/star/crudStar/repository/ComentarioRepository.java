package br.com.star.crudStar.repository;

import br.com.star.crudStar.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentarioRepository extends JpaRepository < Comentario, Long> {

}
