package com.fro.sqslambda.sample;

import com.amazonaws.regions.Region;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.sqs.AmazonSQS;
import com.amazonaws.services.sqs.AmazonSQSClient;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageRequest;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class HelloFromSqs {

    private static final Logger logger = LoggerFactory.getLogger(HelloFromSqs.class);

    private static final String QUEUE_URL = "https://sqs.eu-central-1.amazonaws.com/921516662737/sqs-lambda-fro-hello-queue";

    public String myHandler(String word, Context context) {

        AmazonSQS sqs = new AmazonSQSClient();
        Region euCentral1 = Region.getRegion(Regions.EU_CENTRAL_1);
        sqs.setRegion(euCentral1);

        ReceiveMessageRequest receiveMessageRequest = new ReceiveMessageRequest();
        receiveMessageRequest.setQueueUrl(QUEUE_URL);

        logger.info("Receiving messages on queue [" + QUEUE_URL + "]");
        ReceiveMessageResult receiveMessageResult = sqs.receiveMessage(receiveMessageRequest);

        List<Message> messages = receiveMessageResult.getMessages();
        logger.info("Found [" + messages.size() + "] messages");

        for (Message message : messages) {
            logger.info("Message [" + message.getMessageId() + "] : " + message.getBody());
        }

        return "DONE " + word;
    }
}
