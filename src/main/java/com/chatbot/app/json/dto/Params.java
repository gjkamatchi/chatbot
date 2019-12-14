package com.chatbot.app.json.dto;

import java.util.List;

public class Params {

	private String method;
	private List<String> inputs;
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public List<String> getInputs() {
		return inputs;
	}
	public void setInputs(List<String> inputs) {
		this.inputs = inputs;
	}
	
}
