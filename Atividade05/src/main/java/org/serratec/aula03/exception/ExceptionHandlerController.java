package org.serratec.aula03.exception;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

 @ControllerAdvice
 public class ExceptionHandlerController extends ResponseEntityExceptionHandler {
    

  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
          HttpHeaders headers, HttpStatusCode status, WebRequest request) {
      
		List<String> erros = new ArrayList<>();
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			erros.add(error.getField() + ": " + error.getDefaultMessage());

		}
		
        ErroResposta erroResposta = new ErroResposta(status.value(),
        		"Existem campos inválidos, confira o preenchimento", LocalDateTime.now(), ex.getBindingResult().getFieldErrors().stream().map(e -> e.getDefaultMessage()).toList());
            
      return super.handleExceptionInternal(ex, erroResposta, headers, status, request);
  }

  @ExceptionHandler(RecursoNaoEncontradoException.class)

    public ResponseEntity<ErroResposta> tratarRecursoNaoEncontrado(
    		RecursoNaoEncontradoException ex) {
        ErroResposta erro = new ErroResposta(
        		HttpStatus.NOT_FOUND.value(),
        		ex.getMessage(),
        		LocalDateTime.now(),
        		new ArrayList<>());
        
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
  
    }
  
  @ExceptionHandler(EnumValidationException.class)
  public ResponseEntity<ErroResposta> tratarEnumValidation(EnumValidationException ex) {
      ErroResposta erro = new ErroResposta(
              HttpStatus.BAD_REQUEST.value(), 
              ex.getMessage(), 
              LocalDateTime.now(), 
              new ArrayList<>()
      );
      
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
  }
  
  @Override
  protected ResponseEntity<Object> handleHttpMessageNotReadable(org.springframework.http.converter.HttpMessageNotReadableException ex,
          HttpHeaders headers, HttpStatusCode status, WebRequest request) {

      String mensagem = "Erro na leitura do JSON: Verifique se os valores de Enum ou formatos de data estão corretos.";
      
          if (ex.getCause() != null && ex.getCause().getCause() instanceof EnumValidationException) {
          mensagem = ex.getCause().getCause().getMessage();
      }

      ErroResposta erroResposta = new ErroResposta(
              status.value(),
              mensagem,
              LocalDateTime.now(),
              new ArrayList<>()
      );

      return ResponseEntity.status(status).body(erroResposta);
  }
  
}
 
 


