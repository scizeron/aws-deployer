package com.stfciz.aws.deploy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.stfciz.aws.deploy.AwsDeployerMessage;
import com.stfciz.aws.deploy.service.Sender;
/**
 * 
 * @author stfciz
 *
 */
@RestController
public class AwsDeployerController {

  @Autowired
  private Sender sender;
  
  @RequestMapping(value="/send", method={RequestMethod.POST}, consumes={MediaType.APPLICATION_JSON_VALUE})
  @ResponseStatus(value=HttpStatus.OK)
  public void send(@RequestBody AwsDeployerMessage message) {
   this.sender.send(message);
  }
}
