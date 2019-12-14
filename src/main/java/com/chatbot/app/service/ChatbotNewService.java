package com.chatbot.app.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

import org.json.simple.parser.ParseException;

import com.chatbot.app.json.dto.ChatbotJson;
import com.chatbot.app.response.ChatbotOptions;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;

public interface ChatbotNewService {

	ChatbotOptions getChatbotOptions() throws JsonSyntaxException, JsonIOException, FileNotFoundException, IOException, ParseException;
	
	ChatbotOptions getChatbotSelectedOptions(final String selectedOption) throws JsonSyntaxException, JsonIOException, FileNotFoundException, IOException,ParseException;
	
	ChatbotOptions getChatbotSelectedItem(final String selectedOption,final String item) throws JsonSyntaxException, JsonIOException, FileNotFoundException, IOException,ParseException;
	
	ChatbotOptions getDetailsByCaseNumber(final String selectedOption,final String item,final Long caseNumber) throws JsonSyntaxException, JsonIOException, FileNotFoundException, IOException,ParseException;
	
	ChatbotJson readJSON() throws JsonSyntaxException, JsonIOException, FileNotFoundException, IOException, ParseException;
	
	Map<String, ?> readJSONFile() throws JsonSyntaxException, JsonIOException, FileNotFoundException, IOException, ParseException;
	
}
