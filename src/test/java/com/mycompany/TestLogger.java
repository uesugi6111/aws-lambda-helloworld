package com.mycompany;

import com.amazonaws.services.lambda.runtime.LambdaLogger;

public class TestLogger implements LambdaLogger {

    @Override
    public void log(String message) {
        System.out.println("logger : " + message);
    }

    @Override
    public void log(byte[] message) {
        System.out.println("logger : " + message);
    }

}
