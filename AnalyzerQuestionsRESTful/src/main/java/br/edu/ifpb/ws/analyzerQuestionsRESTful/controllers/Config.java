package br.edu.ifpb.ws.analyzerQuestionsRESTful.controllers;

public class Config {

	private String time;

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Config [time=" + time + "]";
	}

}
