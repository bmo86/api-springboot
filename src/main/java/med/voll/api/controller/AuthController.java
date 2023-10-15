package med.voll.api.controller;


import jakarta.validation.Valid;
import med.voll.api.domain.users.User;
import med.voll.api.domain.users.dto.DataLogin;
import med.voll.api.infra.security.token.dto.DataJWTToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import med.voll.api.infra.security.token.TokenService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<DataJWTToken> login(@RequestBody @Valid DataLogin data) {
        Authentication authToken = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        var UserAuth = authenticationManager.authenticate(authToken);

        var jwtToken = tokenService.generateToken((User) UserAuth.getPrincipal());
        return ResponseEntity.ok(new DataJWTToken(jwtToken));
    }


}
