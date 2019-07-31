package br.com.star.crudStar.user;

import br.com.star.crudStar.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class UserController {

  @Autowired
  private UserRepository userRepository;

  @GetMapping("/user/me")
  @PreAuthorize("hasRole('USER')")
  public UserSummary getCurrentUser(@CurrentUser UserPrincipal currentUser) {
    return new UserSummary(currentUser.getId(), currentUser.getUsername(), currentUser.getName());
  }

  @PostMapping("/user/check-handle-availability")
  public UserIdentityAvailability checkHandleAvailability(
      @RequestParam String handle) {
    Boolean isAvailable = !userRepository.existsByHandle(handle);
    return new UserIdentityAvailability(isAvailable);
  }

  @PostMapping("/user/check-email-availability")
  public UserIdentityAvailability checkEmailAvailability(
      @RequestParam String email) {
    Boolean isAvailable = !userRepository.existsByEmail(email);
    return new UserIdentityAvailability(isAvailable);
  }

  @PostMapping("/users")
  public UserProfile getUserProfile(@RequestParam String handle) {
    User user = userRepository.findByHandle(handle)
        .orElseThrow(() -> new ResourceNotFoundException("User not found."));

    return new UserProfile(user.getId(), user.getHandle(), user.getName());
  }

}
