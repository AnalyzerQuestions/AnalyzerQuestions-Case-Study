package br.edu.ifpb.ws.analyzerQuestionsRESTful.dto;

import java.util.List;

public class MsgDTO {

	private String header;
	private List<String> subHeaders;

	public String getHeader() {
		return header;
	}

	public void setHeader(String header) {
		this.header = header;
	}

	public List<String> getSubHeaders() {
		return subHeaders;
	}

	public void setSubHeaders(List<String> subHeaders) {
		this.subHeaders = subHeaders;
	}

}
