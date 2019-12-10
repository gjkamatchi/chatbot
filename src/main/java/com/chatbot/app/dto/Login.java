package com.chatbot.app.dto;

public class Login {
	private String axpapp;
	private String seed;
	private String username;
	private String password;
	private String other;
	public String getAxpapp() {
		return axpapp;
	}
	public void setAxpapp(String axpapp) {
		this.axpapp = axpapp;
	}
	public String getSeed() {
		return seed;
	}
	public void setSeed(String seed) {
		this.seed = seed;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getOther() {
		return other;
	}
	public void setOther(String other) {
		this.other = other;
	}
}
