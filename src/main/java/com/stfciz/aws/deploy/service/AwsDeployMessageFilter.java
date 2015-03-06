package com.stfciz.aws.deploy.service;

import com.stfciz.aws.deploy.AwsDeployerMessage;

public interface AwsDeployMessageFilter {
  
  boolean accept(AwsDeployerMessage message);

}
