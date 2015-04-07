package br.com.justoeu.domain.response;

import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@XmlRootElement
public class APIResponse {

	public static final int ERROR = 1;
	public static final int WARNING = 2;
	public static final int INFO = 3;
	public static final int OK = 4;
	public static final int TOO_BUSY = 5;

	private int code;
	private String type;
	private String response;

	public APIResponse() {
	}

	public APIResponse(int code, String message) {
		this.code = code;
		switch (code) {
		case ERROR:
			setType("error");
			break;
		case WARNING:
			setType("warning");
			break;
		case INFO:
			setType("info");
			break;
		case OK:
			setType("ok");
			break;
		case TOO_BUSY:
			setType("too busy");
			break;
		default:
			setType("unknown");
			break;
		}
		this.response = message;
	}

	@XmlTransient
	public int getCode() { return code; }
	public String getType() { return type; }
	public String getResponse() { return response; }

	public void setCode(int code) { this.code = code; }
	public void setType(String type) { this.type = type; }
	public void setResponse(String response) { this.response = response; }
}