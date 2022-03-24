package com.dominhtuan.exercise1.controlleradvice;



import com.dominhtuan.exercise1.dto.ExceptionDTO;
import com.dominhtuan.exercise1.exception.ChangePasswordException;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SystemControllerAdvice {
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionDTO> handleRuntimeException(RuntimeException e){
        return ResponseEntity.status(HttpStatus.BAD_GATEWAY).body(new ExceptionDTO(HttpStatus.BAD_GATEWAY.toString(),e.getMessage()));
    }
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ExceptionDTO> handleNotFoundException(NotFoundException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionDTO(HttpStatus.BAD_REQUEST.toString(),e.getMessage()));
    }
    @ExceptionHandler(ChangePasswordException.class)
    public ResponseEntity<ExceptionDTO> handleChangePasswordException(ChangePasswordException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionDTO(HttpStatus.BAD_REQUEST.toString(), e.getMessage()));
    }
}
