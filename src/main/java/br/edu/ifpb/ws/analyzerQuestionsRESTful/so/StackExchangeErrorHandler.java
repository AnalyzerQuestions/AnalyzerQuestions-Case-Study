package br.edu.ifpb.ws.analyzerQuestionsRESTful.so;

import retrofit.ErrorHandler;
import retrofit.RetrofitError;

public class StackExchangeErrorHandler implements ErrorHandler {

    public Throwable handleError(RetrofitError error) {
        return error;
    }

}
