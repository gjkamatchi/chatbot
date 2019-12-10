package com.chatbot.app.dto;

import java.io.Serializable;
import java.util.List;

public class ChatbotDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private List<Parameters> _parameters;
	public List<Parameters> get_parameters() {
		return _parameters;
	}
	public void set_parameters(List<Parameters> _parameters) {
		this._parameters = _parameters;
	}


	
	
}
