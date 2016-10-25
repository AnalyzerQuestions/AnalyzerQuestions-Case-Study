package br.edu.ifpb.ws.analyzerQuestionsRESTful.so;

import retrofit.http.GET;

public interface StackExchange {


    @GET("/errors")
    Response<Error> getErrors();

}
