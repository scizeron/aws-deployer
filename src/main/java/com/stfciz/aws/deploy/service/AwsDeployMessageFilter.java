package com.stfciz.aws.deploy.service;

import com.stfciz.aws.deploy.AwsDeployerMessage;

/**
 * 
 * @author stfciz
 *
 */
public interface AwsDeployMessageFilter {
  
  /**
   * 
   * @param message
   * @return
   */
  boolean accept(AwsDeployerMessage message);

}
