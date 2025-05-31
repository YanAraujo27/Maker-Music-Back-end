package app.scr.makermusic.exception;

import app.scr.makermusic.dto.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(InvalidAuthorizationException.class)
    public ResponseEntity<ApiResponse> handleInvalidAuthorizationException(InvalidAuthorizationException ex) {
        ApiResponse response = new ApiResponse(401, "Usuário inválido");
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(InvalidTokenException.class)
    public ResponseEntity<ApiResponse> handleInvalidTokenException(InvalidTokenException ex) {
        ApiResponse response = new ApiResponse(401, "Usuário inválido");
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler(AlunoNotFoundException.class)
    public ResponseEntity<String> handleAlunoNotFoundException(AlunoNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(ex.getMessage());
    }

    @ExceptionHandler(ProfessorNotFoundException.class)
    public ResponseEntity<String> handleProfessorNotFoundException(ProfessorNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(ex.getMessage());
    }

    @ExceptionHandler(MateriaNotFoundException.class)
    public ResponseEntity<String> handleMateriaNotFoundException(MateriaNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_ACCEPTABLE).body(ex.getMessage());
    }
}
