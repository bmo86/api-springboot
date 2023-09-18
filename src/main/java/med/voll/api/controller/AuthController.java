package med.voll.api.controller;


import jakarta.validation.Valid;
import med.voll.api.domain.users.dto.DataLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;


    @PostMapping
    public ResponseEntity<DataLogin> login(@RequestBody @Valid DataLogin data) {
        Authentication token = new UsernamePasswordAuthenticationToken(data.login(), data.password());
        authenticationManager.authenticate(token);
        return ResponseEntity.ok().build();
    }


}
