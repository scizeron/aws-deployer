package com.stfciz.aws.deploy.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Component;

import com.stfciz.aws.deploy.AwsDeployerMessage;
import com.stfciz.aws.deploy.service.Sender;
import com.stfciz.aws.deploy.service.MessageConstants;

/**
 * 
 * @author stfciz
 *
 */
@Component
public class SenderImpl implements Sender {

  @Autowired
  private QueueMessagingTemplate queueMessagingTemplate;
  
  @Override
  public void send(AwsDeployerMessage message) {
    this.queueMessagingTemplate.convertAndSend(MessageConstants.QUEUE_NAME, message);
  }
}
