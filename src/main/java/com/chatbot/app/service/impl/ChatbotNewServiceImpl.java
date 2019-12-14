package com.chatbot.app.service.impl;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import com.chatbot.app.json.dto.ChatbotJson;
import com.chatbot.app.response.ChatbotOptions;
import com.chatbot.app.service.ChatbotNewService;
import com.google.gson.Gson;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

@Service
public class ChatbotNewServiceImpl implements ChatbotNewService {

	private final static Logger LOGGER =  LoggerFactory.getLogger(ChatbotNewServiceImpl.class);
	
	
	@Override
	public ChatbotOptions getDetailsByCaseNumber(String selectedOption, String item, Long caseNumber)
			throws JsonSyntaxException, JsonIOException, FileNotFoundException, IOException {
		LOGGER.info("Enter into getChatbotSelectedItem()");
		ChatbotOptions chatbotOptions= new ChatbotOptions();
		chatbotOptions.setTitile("Case details not found!");
		LOGGER.info("Exit into getChatbotSelectedItem()");
		return chatbotOptions;
	}
	
	public ChatbotJson readJSON() throws JsonSyntaxException, JsonIOException, FileNotFoundException, IOException, ParseException {
		Gson gson = new Gson();
		Resource resource = new ClassPathResource("chatbot-json.json");
		ChatbotJson chatbotJson = gson.fromJson(new FileReader(resource.getFile()), ChatbotJson.class);
		return chatbotJson;
	}
	
	public Map<String, ?> readJSONFile() throws JsonSyntaxException, JsonIOException, FileNotFoundException, IOException, ParseException {
		Gson gson = new Gson();
		Resource resource = new ClassPathResource("chatbot-json.json");
		//ChatbotJson chatbotJson = gson.fromJson(new FileReader(resource.getFile()), ChatbotJson.class);
		Map<String, ?> chatbotJsonMap = gson.fromJson(new FileReader(resource.getFile()), Map.class);
		return chatbotJsonMap;
	}
	
	
	@SuppressWarnings("unchecked")
	public ChatbotOptions getChatbotSelectedOptions(final String selectedOption) throws JsonSyntaxException, JsonIOException, FileNotFoundException, IOException, ParseException {
		LOGGER.info("Enter into getChatbotSelectedOptions()");
		final Map<String, ?> chatbotJsonMap = readJSONFile();
		ChatbotOptions chatbotOptions= new ChatbotOptions();
		final List<String> optionList = new ArrayList<>();
		List<Map<String, Object>> parentMap = (List<Map<String, Object>>) chatbotJsonMap.get("items");
		for(Map<String, Object> map : parentMap) {
			List<Map<String, Object>> childItemMap = (List<Map<String, Object>>) map.get("items");
			if (null != childItemMap) {
				for (Map<String, Object> childMap : childItemMap) {
					LOGGER.info(childMap.toString());
					chatbotOptions.setTitile(childMap.get("text").toString());
					optionList.add(childMap.get("name").toString());
				}
			}
		}
		chatbotOptions.setOptions(optionList);
		LOGGER.info("Exit into getChatbotSelectedOptions()");
		return chatbotOptions;
	}
	
	public ChatbotOptions getChatbotSelectedItem(final String selectedOption,String item)
			throws JsonSyntaxException, JsonIOException, FileNotFoundException, IOException, ParseException {
		LOGGER.info("Enter into getChatbotSelectedItem()");
		final Map<String, ?> chatbotJsonMap = readJSONFile();
		ChatbotOptions chatbotOptions= new ChatbotOptions();
		List<Map<String, Object>> parentMap = (List<Map<String, Object>>) chatbotJsonMap.get("items");
		for(Map<String, Object> map : parentMap) {
			List<Map<String, Object>> childItemMap = (List<Map<String, Object>>) map.get("items");
			if (null != childItemMap) {
				for (Map<String, Object> childMap : childItemMap) {
					if(item.equalsIgnoreCase(childMap.get("name").toString())) {
						chatbotOptions.setTitile(childMap.get("text").toString());
					}
				}
			}
		}
		LOGGER.info("Exit into getChatbotSelectedItem()");
		return chatbotOptions;
	}

	@Override
	public ChatbotOptions getChatbotOptions()
			throws JsonSyntaxException, JsonIOException, FileNotFoundException, IOException, ParseException {
		return null;
	}

}
