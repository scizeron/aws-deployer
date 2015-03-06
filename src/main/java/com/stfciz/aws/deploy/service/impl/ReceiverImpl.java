package com.stfciz.aws.deploy.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stfciz.aws.deploy.AwsDeployerMessage;
import com.stfciz.aws.deploy.service.MessageFilter;
import com.stfciz.aws.deploy.service.Receiver;
import com.stfciz.aws.deploy.service.MessageConstants;
import com.stfciz.aws.deploy.service.MessageProcessor;

/**
 * 
 * @author stfciz
 *
 */
@Component
public class ReceiverImpl implements Receiver {

  private static final Logger LOGGER = LoggerFactory.getLogger(Receiver.class);
  
  private ObjectMapper debug = new ObjectMapper();
  
  @Autowired
  private MessageProcessor messageProcessor;
  
  @Autowired
  private MessageFilter messageFilter;
    
  @Override
  @MessageMapping(MessageConstants.QUEUE_NAME)
  public void listen(AwsDeployerMessage message) throws Exception {
    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("Receive : {}",  this.debug.writeValueAsString(message));
    }
    
    if (this.messageFilter.accept(message)) {
      this.messageProcessor.process(message);  
    } else {
      throw new IllegalArgumentException("The message is rejected");
    }
  }
}
