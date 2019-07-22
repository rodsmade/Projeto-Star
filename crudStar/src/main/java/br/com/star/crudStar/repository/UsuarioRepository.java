package br.com.star.crudStar.repository;

import br.com.star.crudStar.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
