package com.mycompany.app;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.Map;

public class HelloWorldHandler implements RequestHandler<Map<String, Object>, Map<String, Object>> {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();

    @Override
    public Map<String, Object> handleRequest(Map<String, Object> input, Context context) {
        LambdaLogger logger = context.getLogger();
        Map<String, Object> output = new HashMap<>();
        output.put("greeting", "Hello, lambda world");
        output.put("input", input);
        output.put("context", context);
        logger.log("ENVIRONMENT VARIABLES: " + gson.toJson(System.getenv()));
        logger.log("CONTEXT: " + gson.toJson(context));
        // process event
        logger.log("EVENT: " + gson.toJson(input));
        logger.log("EVENT TYPE: " + input.getClass());
        return output;
    }
}