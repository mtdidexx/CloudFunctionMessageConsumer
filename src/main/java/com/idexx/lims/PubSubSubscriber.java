package com.idexx.lims;

import com.google.cloud.functions.BackgroundFunction;
import com.google.cloud.functions.Context;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Base64;

public class PubSubSubscriber implements BackgroundFunction<PubSubMessage> {
    private static final Logger logger = LoggerFactory.getLogger(PubSubSubscriber.class);

    @Override
    public void accept(PubSubMessage payload, Context context) throws Exception {
        logger.info("Received Message with ID: {}", payload.getMessageId());
        String message = "";

        if (payload.getData() != null) {
            message = new String(Base64.getDecoder().decode(payload.getData().getBytes()));
        }
        logger.info("Message: {}", message);
    }
}
