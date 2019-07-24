package org.com.star.crudStar.Comentario.repository;


import org.com.star.crudStar.Comentario.model.Comentario;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ComentarioRepository extends JpaRepository <Comentario, Long> {

}
