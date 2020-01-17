package br.com.teste.controllers.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	protected ResponseEntity<Object> handleRuntimeException(Exception ex, WebRequest request) {
		ErrorDetails details = new ErrorDetails();
		StackTraceElement stackTraceElement = ex.getStackTrace()[0];
		details.setMessage(ex.getClass().getSimpleName()
				+ (stackTraceElement == null ? "" : " " + stackTraceElement.toString()));

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new StandardError(
						HttpStatus.INTERNAL_SERVER_ERROR,
						"Ops ocorreu um problema, tente novamente mais tarde",
						request.getContextPath(),
						details));
	}

}
