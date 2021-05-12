package com.mycompany.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.lambda.runtime.Context;
import com.mycompany.TestContext;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class HelloWorldHandlerTest {

    private static Map<String, Object> input;

    @BeforeAll
    public static void createInput() throws IOException {
        input = new HashMap<>();
        input.put("key", "value");
    }

    private Context createContext() {
        TestContext ctx = new TestContext();

        ctx.setFunctionName("Your Function Name");

        return ctx;
    }

    @Test
    public void testMyLambdaFunctionHandler() {
        HelloWorldHandler handler = new HelloWorldHandler();
        Context ctx = createContext();

        Map<String, Object> output = handler.handleRequest(input, ctx);

        assertEquals(input, output.get("input"));
        assertEquals(ctx, output.get("context"));
        assertEquals("Hello, lambda world", output.get("greeting"));
    }

}
