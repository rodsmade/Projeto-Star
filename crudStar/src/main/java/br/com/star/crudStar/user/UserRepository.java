package br.com.star.crudStar.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  Optional<User> findByEmail(String email);

  Optional<User> findByHandleOrEmail(String handle, String email);

  List<User> findByIdIn(List<Long> userIds);

  Optional<User> findByHandle(String handle);

  Boolean existsByHandle(String handle);

  Boolean existsByEmail(String email);

}
