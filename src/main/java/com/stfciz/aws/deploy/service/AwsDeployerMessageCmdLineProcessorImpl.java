package com.stfciz.aws.deploy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.stfciz.aws.deploy.AwsDeployerMessage;

/**
 * 
 * @author stfciz
 *
 */
@Component
public class AwsDeployerMessageCmdLineProcessorImpl implements AwsDeployerMessageProcessor {

  private static final Logger LOGGER = LoggerFactory.getLogger(AwsDeployerMessageProcessor.class);
  
  @Override
  public void process(AwsDeployerMessage message) throws Exception {
    String command = AwsDeployerMessageCmdLineConverter.convert(message);
    LOGGER.debug("process : {}", command);
    Runtime runtime = Runtime.getRuntime();
    Process exec = runtime.exec(command);
    int exitVal = exec.waitFor();
    
    if (exitVal > 0) {
      LOGGER.error("{} : {}", command, exitVal);
    } else {
      LOGGER.debug("{} : {}", command, exitVal);
    }
  }
}