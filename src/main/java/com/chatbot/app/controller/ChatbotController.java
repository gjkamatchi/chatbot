package com.chatbot.app.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatbot.app.dto.ChatbotDTO;
import com.chatbot.app.dto.LoginDTO;
import com.chatbot.app.json.dto.ChatbotJson;
import com.chatbot.app.response.ChatbotOptions;
import com.chatbot.app.response.ChatbotResponse;
import com.chatbot.app.response.Result;
import com.chatbot.app.response.Row;
import com.chatbot.app.service.ChatbotNewService;
import com.chatbot.app.service.ChatbotService;
import com.google.gson.JsonIOException;
import com.google.gson.JsonSyntaxException;


@RestController
@RequestMapping("/api")
public class ChatbotController {

//	@Autowired
//	ChatbotService chatbotService;
	
	@Autowired
	ChatbotNewService chatbotService;
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping(path = "/accessdata")
	public ResponseEntity<ChatbotResponse> accessChatBotService(@RequestBody final ChatbotDTO chatbotDTO){
		ChatbotResponse response = new ChatbotResponse();
		List<Result> result = new ArrayList<>();
		Result res = new Result();
		List<Row> rowList = new ArrayList<>();
		Row row=new Row();
		row.setCasearrivaldate("09/07/2019");
		row.setCasetrackingno("1Z0970840377471567");
		row.setStatus("Shipped");
		row.setRowno("1");
		rowList.add(row);
		res.setRow(rowList);
		result.add(res);
		response.setResult(result);
		return new ResponseEntity<ChatbotResponse>(response, HttpStatus.OK);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@PostMapping(path = "/login")
	public ResponseEntity<ChatbotResponse> login(@RequestBody final LoginDTO loginDTO){
		ChatbotResponse response = new ChatbotResponse();
		return new ResponseEntity<ChatbotResponse>(response, HttpStatus.OK);
	}
	
	
//	@CrossOrigin(origins = "*", allowedHeaders = "*")
//	@GetMapping(path = "/getChatbotOptions")
//	public ChatbotOptions getChatbotOptions() throws JsonSyntaxException, JsonIOException, IOException, ParseException{
//		return chatbotService.getChatbotOptions();
//	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping(path = "/getSelectedOptions/{selectedOption}")
	public ChatbotOptions getSelectedOptions(@PathVariable(value = "selectedOption") final String selectedOption) throws JsonSyntaxException, JsonIOException, FileNotFoundException, IOException, ParseException{
		return chatbotService.getChatbotSelectedOptions(selectedOption);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping(path = "/getSelectedOptionsByItem/{selectedOption}/{item}")
	public ChatbotOptions getSelectedOptionsByItem(
			@PathVariable(value = "selectedOption") final String selectedOption,
			@PathVariable(value = "item") final String item) 
					throws JsonSyntaxException, JsonIOException, FileNotFoundException, IOException, ParseException{
		return chatbotService.getChatbotSelectedItem(selectedOption, item);
	}
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping(path = "/getCaseNumber/{selectedOption}/{item}/{casenumber}")
	public ResponseEntity<?> getCaseNumberBySelectedOptionAndItem(
			@PathVariable(value = "selectedOption") final String selectedOption,
			@PathVariable(value = "item") final String item,
			@PathVariable(value = "casenumber") final Long casenumber) 
					throws JsonSyntaxException, JsonIOException, FileNotFoundException, IOException{
		if (casenumber == 123) {
			ChatbotResponse response = new ChatbotResponse();
			List<Result> result = new ArrayList<>();
			Result res = new Result();
			List<Row> rowList = new ArrayList<>();
			Row row = new Row();
			row.setCasearrivaldate("09/07/2019");
			row.setCasetrackingno("1Z0970840377471567");
			row.setStatus("Shipped");
			row.setRowno("1");
			rowList.add(row);
			res.setRow(rowList);
			result.add(res);
			response.setResult(result);
			return new ResponseEntity<ChatbotResponse>(response, HttpStatus.OK);
		} else {
			ChatbotOptions chatbotOptions= new ChatbotOptions();
			chatbotOptions.setTitile("Case details not available!");
			return new ResponseEntity(chatbotOptions, HttpStatus.OK);
		}
	}
	
	
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	@GetMapping(path = "/initiate")
	public ResponseEntity<?> getJSONData() throws JsonSyntaxException, JsonIOException, FileNotFoundException, IOException, ParseException{
		//final ChatbotJson chatbotJson = chatbotService.readJSON();
		final Map<String, ?> chatbotJson = chatbotService.readJSONFile();
		return new ResponseEntity<>(chatbotJson, HttpStatus.OK);
	}
}
