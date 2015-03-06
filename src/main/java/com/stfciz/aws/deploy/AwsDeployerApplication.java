package com.stfciz.aws.deploy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@ImportResource(value={"classpath:applicationContext-deploy.xml"})
@EnableScheduling
public class AwsDeployerApplication {

  /**
   * 
   * @param args
   */
  public static void main(String[] args) {
    SpringApplication.run(AwsDeployerApplication.class, args);
  }


}
