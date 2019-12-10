package com.chatbot.app.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.chatbot.app.dto.ChatbotDTO;
import com.chatbot.app.dto.LoginDTO;
import com.chatbot.app.response.ChatbotResponse;
import com.chatbot.app.response.Result;
import com.chatbot.app.response.Row;


@RestController
@RequestMapping("/api")
public class ChatbotController {

	
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
//		response.setResponse(loginDTO);
//		response.setStatus("SUCCESS");
//		response.setMessage("Login API successfully consumed!");
		return new ResponseEntity<ChatbotResponse>(response, HttpStatus.OK);
	}
}
