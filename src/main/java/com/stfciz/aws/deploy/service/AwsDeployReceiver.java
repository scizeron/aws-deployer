package com.stfciz.aws.deploy.service;

import com.stfciz.aws.deploy.AwsDeployerMessage;

public interface AwsDeployReceiver {

  void listen(AwsDeployerMessage message) throws Exception;

}