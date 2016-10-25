package br.edu.ifpb.ws.analyzerQuestionsRESTful.so;

import java.util.ArrayList;
import java.util.List;

public class SOClient {
	
	public List<QuestionPojo> getQuestions(){
		
		StackExchangeApi api = new StackExchangeApi();
		
		StackExchangeSite service =api.getSiteService("pt.stackoverflow");
		
		List<QuestionPojo> listResult = new ArrayList<>();
		
		Response<QuestionPojo> result = service.getQuestions();
		
		listResult = result.getItems();
		
		return listResult;
		
	}
}
