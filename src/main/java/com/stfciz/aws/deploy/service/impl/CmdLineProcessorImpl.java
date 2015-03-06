package com.stfciz.aws.deploy.service.impl;

import org.springframework.stereotype.Component;

import com.stfciz.aws.deploy.AwsDeployerMessage;
import com.stfciz.aws.deploy.service.MessageProcessor;

/**
 * 
 * @author stfciz
 *
 */
@Component
public class CmdLineProcessorImpl implements MessageProcessor {

  @Override
  public void process(AwsDeployerMessage message) throws Exception {
    CmdLineUtils.process(CmdLineUtils.convert(message));
  }
}