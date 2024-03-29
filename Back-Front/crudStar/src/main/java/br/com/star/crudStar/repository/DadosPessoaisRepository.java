package br.com.star.crudStar.repository;

import br.com.star.crudStar.model.DadosPessoais;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.math.BigDecimal;

public interface DadosPessoaisRepository extends JpaRepository <DadosPessoais,Long> {

    @Modifying
    @Transactional
    @Query("UPDATE DadosPessoais d SET d.url_foto_perfil = :url_foto_perfil WHERE d.id = :id")
    void updateUrlFotoPerfilById(@Param("url_foto_perfil") String url_foto_perfil, @Param("id") Long id);

}
