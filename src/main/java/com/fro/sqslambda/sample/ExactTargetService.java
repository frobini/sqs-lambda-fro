package com.fro.sqslambda.sample;

import com.amazonaws.services.lambda.invoke.LambdaFunction;
import com.amazonaws.services.sqs.model.Message;

public interface ExactTargetService {
    @LambdaFunction(functionName = "SendCommunication")
    void sendCommunication(Message message);
}
