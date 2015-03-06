package com.stfciz.aws.deploy.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.stfciz.aws.deploy.AwsDeployerMessage;

@Component
public class AwsDeployerMessageCmdLineProcessorImpl implements AwsDeployerMessageProcessor {

  private static final Logger LOGGER = LoggerFactory.getLogger(AwsDeployerMessageProcessor.class);
  
  @Override
  public void process(AwsDeployerMessage message) throws Exception {
    final String action = message.getAction();

    Runtime runtime = Runtime.getRuntime();
    StringBuilder command = new StringBuilder();
    
    command.append("sh").append(" ");
    command.append(message.getRootDirectory()).append("/bin/admin.sh").append(" ");
    command.append(action).append(" ");
        
    if ("config".equals(action) || "install".equals(action)) {
      command.append("-s3b").append(" ").append(message.getBucketName());
      command.append("-cv").append(" ").append(message.getVersion()).append(" ");
      command.append("-ci").append(" ").append(message.getArtifactId()).append(" ");
      command.append("-cg").append(" ").append(message.getGroupId()).append(" ");
    }
    
    if ("install".equals(action)) {
      command.append("-av").append(" ").append(message.getVersion()).append(" ");
      command.append("-ai").append(" ").append(message.getArtifactId()).append(" ");
      command.append("-ag").append(" ").append(message.getGroupId());      
    }
    
    Process exec = runtime.exec(command.toString());
    int exitVal = exec.waitFor();
    
    if (exitVal > 0) {
      LOGGER.error("{} : {}", command, exitVal);
    } else {
      LOGGER.debug("{} : {}", command, exitVal);
    }
  }
}