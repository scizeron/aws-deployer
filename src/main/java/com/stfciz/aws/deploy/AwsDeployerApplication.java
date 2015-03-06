package com.stfciz.aws.deploy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

/**
 * 
 * @author stfciz
 *
 */
@SpringBootApplication
@ImportResource(value={"classpath:applicationContext-deploy.xml"})
public class AwsDeployerApplication {

  /**
   * 
   * @param args
   */
  public static void main(String[] args) {
    SpringApplication.run(AwsDeployerApplication.class, args);
  }


}