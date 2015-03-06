package com.stfciz.aws.deploy.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.stfciz.aws.deploy.AwsDeployerMessage;
import com.stfciz.aws.deploy.service.MessageFilter;

/**
 * 
 * @author stfciz
 *
 */
@Component
public class MessageFilterImpl implements MessageFilter {

  private static final Logger LOGGER = LoggerFactory
      .getLogger(MessageFilter.class);

  @Value("#{instanceData.myRole}")
  private String myRole;

  @Override
  public boolean accept(AwsDeployerMessage message) {
    if (this.myRole == null) {
      LOGGER.warn("The 'myRole' tag is missing on the EC2 instance");
      return false;
    }

    if (message.getRole() == null) {
      LOGGER.warn("The message roles missing");
      return false;
    }

    boolean accept = this.myRole.equals(message.getRole());

    if (!accept) {
      LOGGER.debug("The 'myRole' tag : {} <> {}", this.myRole,
          message.getRole());
    }
    return accept;
  }

}
