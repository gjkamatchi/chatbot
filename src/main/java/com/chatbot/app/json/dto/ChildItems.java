package com.chatbot.app.json.dto;

public class ChildItems {

	private String id;
	private String name;
	private Boolean containsChildren;
	private String apiPath;
	private String text;
	private Params params;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Boolean getContainsChildren() {
		return containsChildren;
	}
	public void setContainsChildren(Boolean containsChildren) {
		this.containsChildren = containsChildren;
	}
	public String getApiPath() {
		return apiPath;
	}
	public void setApiPath(String apiPath) {
		this.apiPath = apiPath;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Params getParams() {
		return params;
	}
	public void setParams(Params params) {
		this.params = params;
	}
	
	

}
