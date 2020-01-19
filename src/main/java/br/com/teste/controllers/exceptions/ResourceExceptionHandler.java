package br.com.teste.controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.validation.ConstraintViolationException;

@ControllerAdvice
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> handleExceptionClass(Exception ex, WebRequest request) {
		ErrorDetails details = new ErrorDetails();
		StackTraceElement stackTraceElement = ex.getStackTrace()[0];
		details.setMessage(ex.getClass().getSimpleName() + (stackTraceElement == null ? "" : " " + stackTraceElement.toString()));

		StandardError result = new StandardError(HttpStatus.INTERNAL_SERVER_ERROR,"Erro no Servidor, tente novamente mais tarde",
				request.getDescription(false).substring(request.getDescription(false).indexOf("=")+1), details);
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(result);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	protected ResponseEntity<Object> handleConstraintViolationException(ConstraintViolationException ex, WebRequest request) {
		StandardError result = new StandardError(HttpStatus.BAD_REQUEST, "ConstraintViolation",
				request.getDescription(false).substring(request.getDescription(false).indexOf("=")+1),
				getErrorDetailsException(ex, String.valueOf(request.hashCode())));
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(result);
	}

	private ErrorDetails getErrorDetailsException(ConstraintViolationException exception, String uniqueId){
		StringBuilder message = new StringBuilder();
		exception.getConstraintViolations().stream()
				.forEach(constraint -> message.append("<").append(constraint.getPropertyPath()).append(">: ").append(constraint.getMessage()).append(" | "));
		ErrorDetails errorDetails = new ErrorDetails();
		errorDetails.setMessage(message.toString().substring(0,message.toString().length()-2));
		errorDetails.setUniqueId(uniqueId);
		return errorDetails;
	}
}
