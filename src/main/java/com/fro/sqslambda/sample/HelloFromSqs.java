package com.fro.sqslambda.sample;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;

public class HelloFromSqs {

    private static final String QUEUE_NAME = "sqs-lambda-fro-hello-queue";

    public String myHandler(String word, Context context) {
        LambdaLogger logger = context.getLogger();
        logger.log("Trying to list all queues\n");

        AmazonSQS sqs = new AmazonSQSClient();
        Region euCentral1 = Region.getRegion(Regions.EU_CENTRAL_1);
        sqs.setRegion(euCentral1);

        for (String queueUrl : sqs.listQueues().getQueueUrls()) {
            logger.log("Found queue [" + queueUrl + "]\n");
        }

        return "DONE " + word;
    }
}
