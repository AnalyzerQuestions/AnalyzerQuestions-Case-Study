package br.edu.ifpb.ws.analyzerQuestionsRESTful.entities;

import java.util.List;

public class MSG {

	private String header;
	private List<String> messages;

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void setMessages(List<String> messages) {
		this.messages = messages;
	}

	@Override
	public String toString() {
		return "MSG [header=" + header + ", messages=" + messages + "]";
	}
	
	

}
