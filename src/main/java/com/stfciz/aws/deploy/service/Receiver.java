package com.stfciz.aws.deploy.service;

import com.stfciz.aws.deploy.AwsDeployerMessage;

/**
 * 
 * @author stfciz
 *
 */
public interface Receiver {

  /**
   * 
   * @param message
   * @throws Exception
   */
  void listen(AwsDeployerMessage message) throws Exception;

}