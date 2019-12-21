package com.chatapp.sgchatapp.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.stereotype.Controller;

@RestController
@RequestMapping("/chatapi")
public class TalkApiController {

  @RequestMapping(value= "/call", method= RequestMethod.GET)
  public String call() {
    return "Hello Spring MVC";
  }

  @RequestMapping(value= "/sayYes", method = RequestMethod.GET)
  public String sayYes() {
    return "Say Yes!!!!!";
  }

}
