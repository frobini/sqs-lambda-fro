package com.fro.sqslambda.sample;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;

public class Hello {

    public String myHandler(String word, Context context) {
        LambdaLogger logger = context.getLogger();
        logger.log("received : " + word);
        return "Hello " + word;
    }
}
