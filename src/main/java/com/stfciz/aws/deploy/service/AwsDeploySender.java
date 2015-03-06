package com.stfciz.aws.deploy.service;

import com.stfciz.aws.deploy.AwsDeployerMessage;

public interface AwsDeploySender {

  void send(AwsDeployerMessage message);

}