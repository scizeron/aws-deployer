package com.stfciz.aws.deploy.service;

import com.stfciz.aws.deploy.AwsDeployerMessage;

/**
 * 
 * @author stfciz
 *
 */
public final class AwsDeployerMessageCmdLineConverter {

  private static final String SHELL_SCRIPT = "/bin/admin.sh";

  /**
   * 
   */
  private AwsDeployerMessageCmdLineConverter() {
    /** EMPTY **/
  }
  
  /**
   * 
   * @param message
   * @return
   */
  public static String convert(AwsDeployerMessage message) {
    StringBuilder command = new StringBuilder();

    final String action = message.getAction();
    
    command.append("sh").append(" ");
    command.append(message.getRootDirectory()).append(SHELL_SCRIPT).append(" ");
    command.append(action).append(" ");
        
    if ("config".equals(action) || "install".equals(action)) {
      command.append("-s3b").append(" ").append(message.getBucketName()).append(" ");
      command.append("-cv").append(" ").append(message.getVersion()).append(" ");
      command.append("-ci").append(" ").append(message.getArtifactId()).append("-conf-").append(message.getEnv()).append(" ");
      command.append("-cg").append(" ").append(message.getGroupId()).append(" ");
    }
    
    if ("install".equals(action)) {
      command.append("-av").append(" ").append(message.getVersion()).append(" ");
      command.append("-ai").append(" ").append(message.getArtifactId()).append(" ");
      command.append("-ag").append(" ").append(message.getGroupId());      
    }
    
    return command.toString();
  }
  
}
