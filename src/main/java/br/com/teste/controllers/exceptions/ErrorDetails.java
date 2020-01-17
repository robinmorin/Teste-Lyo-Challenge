package br.com.teste.controllers.exceptions;

import java.io.Serializable;
import java.util.List;

public class ErrorDetails implements Serializable {

	private static final long serialVersionUID = 1L;

	private String uniqueId;
	private String informationCode;
	private String message;
	private List<String> args;

	public String getUniqueId() {
		return uniqueId;
	}

	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	public String getInformationCode() {
		return informationCode;
	}

	public void setInformationCode(String informationCode) {
		this.informationCode = informationCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getArgs() {
		return args;
	}

	public void setArgs(List<String> args) {
		this.args = args;
	}

	@Override
	public String toString() {
		return "ErrorDetais [uniqueId=" + uniqueId + ", informationCode=" + informationCode + ", message=" + message
				+ ", args=" + args + "]";
	}

}
