package com.stfciz.aws.deploy.service;

import com.stfciz.aws.deploy.AwsDeployerMessage;

/**
 * 
 * @author stfciz
 *
 */
public interface AwsDeployerMessageProcessor {

  /**
   * 
   * @param message
   * @throws Exception
   */
  void process(AwsDeployerMessage message) throws Exception;
}
