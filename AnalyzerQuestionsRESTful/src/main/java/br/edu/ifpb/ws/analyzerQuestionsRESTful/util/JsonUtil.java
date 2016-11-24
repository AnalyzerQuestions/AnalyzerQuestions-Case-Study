package br.edu.ifpb.ws.analyzerQuestionsRESTful.util;

import com.google.gson.Gson;

import br.edu.ifpb.ws.analyzerQuestionsRESTful.entities.pojos.Config;

public class JsonUtil {

	public static Config loadFromJSONGson(String jsonString) {
		Gson gson = new Gson();
		Config config = gson.fromJson(jsonString, Config.class);
		return config;
	}
}
