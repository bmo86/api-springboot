package med.voll.api.infra.security.SecurityFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import med.voll.api.domain.users.User;
import med.voll.api.domain.users.repo.UserRepository;
import med.voll.api.infra.security.token.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class SecurityFilter extends OncePerRequestFilter {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UserRepository userRepository;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {

        var authHeader = request.getHeader("Authorization");
        if (authHeader != null) {
            var token = authHeader.replace("Bearer ", "");

            var username = tokenService.getSubject(token);
            if (username != null) {
                // token valid
                var user = userRepository.findByLogin(username);
                //forzamos un inicio de secion
                var auth = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());

                SecurityContextHolder.getContext().setAuthentication(auth);
            }
        }
        filterChain.doFilter(request, response);

    }
}
