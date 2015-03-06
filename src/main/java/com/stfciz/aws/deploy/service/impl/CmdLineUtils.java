package com.stfciz.aws.deploy.service.impl;

import java.util.Arrays;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.stfciz.aws.deploy.AwsDeployerMessage;

/**
 * 
 * @author stfciz
 *
 */
public final class CmdLineUtils {

  private static final Logger LOGGER = LoggerFactory.getLogger(CmdLineUtils.class);
  
  private static final String SHELL_SCRIPT = "/bin/admin.sh";

  /**
   * 
   */
  private CmdLineUtils() {
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
  
  /**
   * 
   * @param command
   * @return
   * @throws Exception
   */
  public static boolean process(String... command) throws Exception {
    String cmdToString = Arrays.toString(command);
    LOGGER.debug("process : {}", cmdToString);
    ProcessBuilder pb = new ProcessBuilder(command);
    
    Process process = pb.start();
    int exitVal = process.waitFor();
    boolean ok = (exitVal == 0);
    if (ok) {
      LOGGER.debug("{} returns {}", cmdToString, exitVal);
    } else {
      LOGGER.error("{} returns {}", cmdToString, exitVal);
    }
    return ok;
  }
  
}
