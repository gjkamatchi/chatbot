package com.chatbot.app.dto;

import java.util.List;

public class LoginDTO {
	private List<UserDetails> _parameters;

	public List<UserDetails> get_parameters() {
		return _parameters;
	}

	public void set_parameters(List<UserDetails> _parameters) {
		this._parameters = _parameters;
	}
}
