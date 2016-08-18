package com.fro.sqslambda.sample;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.sqs.model.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorkerLambda {

    public void myHandler(Message message, Context context) {
        LambdaLogger lambdaLogger = context.getLogger();
        lambdaLogger.log("Processing message [" + message.getBody() + "] from lambda\n");
    }
}
