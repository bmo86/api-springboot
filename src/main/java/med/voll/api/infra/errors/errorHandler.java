package med.voll.api.infra.errors;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//Programacion basada a espectros AOP
@RestControllerAdvice //actua como un interceptor o como proxy
public class errorHandler {
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleError404(Exception e) {
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleError400(MethodArgumentNotValidException e) {
        var errors = e.getFieldErrors().stream().map(ErrorsData::new).toList();
        return ResponseEntity.badRequest().body(errors);
    }

    private record ErrorsData(String message, String error) {
        public ErrorsData(FieldError error) {
            this(error.getField(), error.getDefaultMessage());
        }
    }

}
