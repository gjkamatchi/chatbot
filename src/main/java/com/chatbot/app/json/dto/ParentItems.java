package com.chatbot.app.json.dto;

import java.util.List;

public class ParentItems {

	private String id;
	private String name;
	private Boolean containsChildren;
	private String apiPath;
	private String text;
	private List<ChildItems> options;
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
	public List<ChildItems> getOptions() {
		return options;
	}
	public void setOptions(List<ChildItems> options) {
		this.options = options;
	}
//	public List<ChildItems> getItems() {
//		return items;
//	}
//	public void setItems(List<ChildItems> items) {
//		this.items = items;
//	}
	
	
	
}
