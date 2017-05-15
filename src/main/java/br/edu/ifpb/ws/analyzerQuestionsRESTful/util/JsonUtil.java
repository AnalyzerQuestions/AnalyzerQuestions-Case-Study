package br.edu.ifpb.ws.analyzerQuestionsRESTful.util;

import com.google.gson.Gson;

import br.edu.ifpb.ws.analyzerQuestionsRESTful.dto.ConfigDTO;

public class JsonUtil {

	public static ConfigDTO loadFromJSONGson(String jsonString) {
		Gson gson = new Gson();
		ConfigDTO config = gson.fromJson(jsonString, ConfigDTO.class);
		return config;
	}
}
