package com.stfciz.aws.deploy.service;

import com.stfciz.aws.deploy.AwsDeployerMessage;

/**
 * 
 * @author stfciz
 *
 */
public interface AwsDeploySender {

  /**
   * 
   * @param message
   */
  void send(AwsDeployerMessage message);

}