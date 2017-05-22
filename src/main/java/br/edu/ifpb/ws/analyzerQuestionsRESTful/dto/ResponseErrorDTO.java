package br.edu.ifpb.ws.analyzerQuestionsRESTful.dto;

public class ResponseErrorDTO {

	private String msg;

	public ResponseErrorDTO(String msg) {
		this.msg = msg;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

}
