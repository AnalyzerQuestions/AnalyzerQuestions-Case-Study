package br.edu.ifpb.ws.analyzerQuestionsRESTful.so;

import retrofit.http.GET;

public interface StackExchangeSite {

    public static final String STACK_OVERFLOW = "pt.stackoverflow";

    
    @GET("/questions")
    Response<QuestionPojo> getQuestions();
    

}	
