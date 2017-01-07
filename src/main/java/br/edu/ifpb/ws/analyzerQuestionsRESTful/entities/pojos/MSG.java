package br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.pojos;

import java.util.List;

public class MSG {

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
