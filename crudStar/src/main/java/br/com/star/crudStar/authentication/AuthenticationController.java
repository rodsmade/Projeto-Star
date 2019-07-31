package br.com.star.crudStar.authentication;

import br.com.star.crudStar.exception.BackendException;
import br.com.star.crudStar.role.Role;
import br.com.star.crudStar.role.RoleName;
import br.com.star.crudStar.role.RoleRepository;
import br.com.star.crudStar.security.LoginRequest;
import br.com.star.crudStar.security.SignUpRequest;
import br.com.star.crudStar.security.jwt.JwtAuthenticationResponse;
import br.com.star.crudStar.security.jwt.JwtTokenProvider;
import br.com.star.crudStar.user.User;
import br.com.star.crudStar.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Collections;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthenticationController {

  @Autowired
  private AuthenticationManager authenticationManager;

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private RoleRepository roleRepository;

  @Autowired
  private PasswordEncoder passwordEncoder;

  @Autowired
  private JwtTokenProvider tokenProvider;

  @PostMapping("/sign-in")
  public ResponseEntity<JwtAuthenticationResponse> authenticateUser(
      @Valid @RequestBody LoginRequest loginRequest) {
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            loginRequest.getHandleOrEmail(),
            loginRequest.getPassword()
        )
    );

    SecurityContextHolder.getContext().setAuthentication(authentication);

    String jwt = tokenProvider.generateToken(authentication);
    return ResponseEntity.ok(new JwtAuthenticationResponse(jwt, "Bearer"));
  }

  @PostMapping("/sign-up")
  public ResponseEntity<AuthenticationResponse> registerUser(
      @Valid @RequestBody SignUpRequest signUpRequest) {
    if (userRepository.existsByHandle(signUpRequest.getHandle()) || userRepository
        .existsByEmail(signUpRequest.getEmail())) {
      return ResponseEntity.badRequest()
          .body(new AuthenticationResponse(false, "Handle or E-mail Address already in use."));
    }

    Role userRole = roleRepository.findByName(RoleName.ROLE_USER)
        .orElseThrow(() -> new BackendException("User Role not set."));

    // Creating user's account
    User user = new User();
    user.setName(signUpRequest.getName());
    user.setHandle(signUpRequest.getHandle());
    user.setEmail(signUpRequest.getEmail());
    user.setSenha(passwordEncoder.encode(signUpRequest.getPassword()));
    user.setRoles(Collections.singleton(userRole));

    URI location = ServletUriComponentsBuilder
        .fromCurrentContextPath().path("/users/{Handle}")
        .buildAndExpand(userRepository.save(user).getHandle()).toUri();

    return ResponseEntity.created(location)
        .body(new AuthenticationResponse(true, "User registered successfully."));
  }

}
