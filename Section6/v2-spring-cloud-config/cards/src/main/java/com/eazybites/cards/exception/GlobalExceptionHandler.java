package com.eazybites.cards.exception;

import com.eazybites.cards.constants.CardsConstants;
import com.eazybites.cards.dto.ErrorResponseDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String,String> validationErros = new HashMap<>();
           List<ObjectError> validationErrorList= ex.getBindingResult().getAllErrors();
           validationErrorList.forEach(error ->{
               String fieldName=((FieldError) error).getField();
               String fieldValue=error.getDefaultMessage();
               validationErros.put(fieldName,fieldValue);
           });
           return new ResponseEntity<>(validationErros, HttpStatus.BAD_REQUEST);
    }
   @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleResourceNotException(ResourceNotFoundException ex, WebRequest request) {
       ErrorResponseDto errorResponseDto = new ErrorResponseDto(request.getDescription(false),HttpStatus.NOT_FOUND,ex.getMessage(),LocalDateTime.now());
        return new ResponseEntity<>(errorResponseDto,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(CardAlreadyExistsException.class)
    public  ResponseEntity<ErrorResponseDto> handleCardAlreadyExistsException(CardAlreadyExistsException ex,WebRequest request){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(request.getDescription(false),HttpStatus.BAD_REQUEST,ex.getMessage(),LocalDateTime.now() );
        return new ResponseEntity<>(errorResponseDto,HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleGlobalException(Exception ex,WebRequest request){
        ErrorResponseDto errorResponseDto = new ErrorResponseDto(request.getDescription(false),HttpStatus.INTERNAL_SERVER_ERROR,ex.getMessage(),LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponseDto);
    }
}
