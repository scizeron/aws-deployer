package com.stfciz.aws.deploy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stfciz.aws.deploy.AwsDeployerMessage;

@Component
public class AwsDeployReceiverImpl implements AwsDeployReceiver {

  private static final Logger LOGGER = LoggerFactory.getLogger(AwsDeployReceiver.class);
  
  private ObjectMapper debug = new ObjectMapper();
  
  @Autowired
  private AwsDeployerMessageProcessor messageProcessor;
    
  /* (non-Javadoc)
   * @see com.stfciz.aws.deploy.service.AwsDeployReceiver#listen(com.stfciz.aws.deploy.AwsDeployerMessage)
   */
  @Override
  @MessageMapping(AwsDeployerConstants.QUEUE_NAME)
  public void listen(AwsDeployerMessage message) throws Exception {
    if (LOGGER.isDebugEnabled()) {
      LOGGER.debug("Receive : {}",  this.debug.writeValueAsString(message));
    }
    this.messageProcessor.process(message);
  }
}
