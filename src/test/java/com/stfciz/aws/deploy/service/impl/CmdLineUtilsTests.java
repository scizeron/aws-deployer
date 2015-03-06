package com.stfciz.aws.deploy.service.impl;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;

import com.stfciz.aws.deploy.AwsDeployerMessage;

/**
 * 
 * @author stfciz
 *
 */
public class CmdLineUtilsTests {

  /**
   * 
   */
  @Test public void convert() {
    // given
    AwsDeployerMessage message = new AwsDeployerMessage();
    message.setRootDirectory("/home/ec2-user/apps/myapp");
    message.setAction("install");
    message.setArtifactId("myapp");
    message.setGroupId("com.stfciz");
    message.setBucketName("mybucket");
    message.setEnv("dev");
    message.setRole("myapp");
    message.setVersion("0.0.1-SNAPSHOT");
    
    // then
    String command = CmdLineUtils.convert(message);
    
    // then
    Assert.assertThat(command, CoreMatchers.is("sh /home/ec2-user/apps/myapp/bin/admin.sh install -s3b mybucket -cv 0.0.1-SNAPSHOT -ci myapp-conf-dev -cg com.stfciz -av 0.0.1-SNAPSHOT -ai myapp -ag com.stfciz"));
  }
  
  /**
   * @throws Exception 
   * 
   */
  @Test public void process() throws Exception {
    // given
    String [] command = {"java", "-version"};
    
    // when
    boolean result = CmdLineUtils.process(command);
    
    // then
    Assert.assertThat(result,  CoreMatchers.is(true));
  }
}
