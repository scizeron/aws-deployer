package com.stfciz.aws.deploy.service;

import com.stfciz.aws.deploy.AwsDeployerMessage;

public interface AwsDeployerMessageProcessor {

  void process(AwsDeployerMessage message) throws Exception;
}
