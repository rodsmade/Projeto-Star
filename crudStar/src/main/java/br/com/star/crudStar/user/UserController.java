package br.com.star.crudStar.user;

import br.com.star.crudStar.exception.ResourceNotFoundException;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
public class UserController {

  private static final String NOT_FOUND = "Não foi encontrado um usuário com o id: ";

  @Autowired
  private UserRepository userRepository;

  @GetMapping("/user/me")
  @PreAuthorize("hasRole('USER')")
  public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
    return new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getName());
  }

  @PostMapping("/user/check-username-availability")
  public UserIdentityAvailability checkUsernameAvailability(
      @RequestParam String username) {
    Boolean isAvailable = !userRepository.existsByUsername(username);
    return new UserIdentityAvailability(isAvailable);
  }

  @PostMapping("/user/check-email-availability")
  public UserIdentityAvailability checkEmailAvailability(
      @RequestParam String email) {
    Boolean isAvailable = !userRepository.existsByEmail(email);
    return new UserIdentityAvailability(isAvailable);
  }

  @PostMapping("/users")
  public UserProfile getUserProfile(@RequestParam String username) {
    User user = userRepository.findByUsername(username)
        .orElseThrow(() -> new ResourceNotFoundException("User not found."));

    return new UserProfile(user.getId(), user.getUsername(), user.getName());
  }

  // ______________________________________________________________________


  // Método CREATE
  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping("/user")
  @ApiOperation(value = "Criar usuário")
  public User createUser(@Valid @RequestBody User user) {
    return userRepository.save(user);
  }

  // Método READ
  @GetMapping("/user")
  @ApiOperation("Busca usuários")
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  @GetMapping("/user/{id}")
  @ApiOperation("Busca um usuário")
  public ResponseEntity<User> getUserId(@PathVariable(value = "id") Long userId)
          throws ResourceNotFoundException {
    User user = userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException(NOT_FOUND + userId));
    return ResponseEntity.ok().body(user);
  }

  @PatchMapping("/user/{id}")
  @ApiOperation("Atualiza o user")
  public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId,
                                         @Valid @RequestBody User userDetails) {
    User user = userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException(NOT_FOUND + userId));

    user.setUsername(userDetails.getUsername());
    user.setEmail(userDetails.getEmail());
    user.setName(userDetails.getName());
    user.setSobrenome(userDetails.getSobrenome());
    user.setNascimento(userDetails.getNascimento());

    final User updatedUser = userRepository.save(user);
    return ResponseEntity.ok(updatedUser);
  }

  @DeleteMapping("/user/{id}")
  @ApiOperation("Deleta usuário por id")
  public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long userId)
          throws ResourceNotFoundException {
    User user = userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " + userId));

    userRepository.delete(user);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
  }



}
