package br.edu.ifpb.ws.analyzerQuestionsRESTful.so;

import com.google.gson.*;
import retrofit.RequestInterceptor;
import retrofit.RestAdapter;
import retrofit.converter.GsonConverter;

import java.lang.reflect.Type;
import java.util.Date;

public class StackExchangeApi {

    public static final double VERSION = 2.2;
    public static final String ENDPOINT = "https://api.stackexchange.com/" + VERSION;

    private final RestAdapter.Builder builder;

    public StackExchangeApi() {

        Gson gson = new GsonBuilder()
            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
            .registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {
                public Date deserialize(JsonElement json, Type type, JsonDeserializationContext context) throws JsonParseException {
                    return new Date(json.getAsLong() * 1000);
                }
            }).create();
        this.builder = new RestAdapter.Builder()
            .setEndpoint(ENDPOINT)
            .setErrorHandler(new StackExchangeErrorHandler())
            //.setLogLevel(RestAdapter.LogLevel.FULL) //log da requisição
            .setConverter(new GsonConverter(gson));

    }

    public StackExchange getService() {
        return builder.build().create(StackExchange.class);
    }

    public StackExchangeSite getSiteService(final String site) {
        return builder
            .setRequestInterceptor(new RequestInterceptor() {
                public void intercept(RequestFacade request) {
                    request.addQueryParam("site", site);
                    request.addQueryParam("sort", "creation");
                    request.addQueryParam("tagged", "java");
                    request.addQueryParam("filter", "!*Lgp2fj2RgcY(RPd");
                }
            })
            .build()
            .create(StackExchangeSite.class);
    }
}
