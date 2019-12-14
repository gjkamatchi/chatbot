package com.chatbot.app.json.dto;

import java.util.List;


public class ChatbotJson {

	private List<ParentItems> items;
	private String id;
	private String basePath;
	
	public List<ParentItems> getItems() {
		return items;
	}
	public void setItems(List<ParentItems> items) {
		this.items = items;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getBasePath() {
		return basePath;
	}
	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}
	@Override
	public String toString() {
		return "ChatbotJson [items=" + items + ", id=" + id + ", basePath=" + basePath + "]";
	}
	
	
}
