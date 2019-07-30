package br.com.star.crudStar.repository;

import br.com.star.crudStar.model.Amigos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface AmigosRepository extends JpaRepository<Amigos, Long>{

    @Modifying
    @Transactional
    @Query("UPDATE Amigos d.Usuario SET d. = :usuario WHERE d.id = :id")
    void updateListaDeAmigosById(@Param("usuario") String usuario, @Param("id") Long id);

}
