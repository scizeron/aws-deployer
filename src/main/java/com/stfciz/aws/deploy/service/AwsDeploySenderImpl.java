package com.stfciz.aws.deploy.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.aws.messaging.core.QueueMessagingTemplate;
import org.springframework.stereotype.Component;

import com.stfciz.aws.deploy.AwsDeployConstants;
import com.stfciz.aws.deploy.AwsDeployerMessage;

@Component
public class AwsDeploySenderImpl implements AwsDeployConstants, AwsDeploySender {

  @Autowired
  private QueueMessagingTemplate queueMessagingTemplate;
  
  /* (non-Javadoc)
   * @see com.stfciz.aws.deploy.service.AwsDeploySender#send(com.stfciz.aws.deploy.AwsDeployerMessage)
   */
  @Override
  public void send(AwsDeployerMessage message) {
    this.queueMessagingTemplate.convertAndSend(QUEUE_NAME, message);
  }
}
