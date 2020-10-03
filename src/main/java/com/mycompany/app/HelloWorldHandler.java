package com.mycompany.app;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.util.HashMap;
import java.util.Map;

public class HelloWorldHandler implements RequestHandler<Map<String, Object>, Map<String, Object>> {

    @Override
    public Map<String, Object> handleRequest(Map<String, Object> input, Context context) {
        Map<String, Object> output = new HashMap<>();
        output.put("greeting", "Hello, lambda world");
        output.put("input", input);
        output.put("context", context);
        return output;
    }
}