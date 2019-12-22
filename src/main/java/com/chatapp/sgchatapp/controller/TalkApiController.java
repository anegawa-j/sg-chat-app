package com.chatapp.sgchatapp.controller;
import com.chatapp.sgchatapp.model.TalkApiModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/chatapi")
public class TalkApiController {

  private static final String TALK_API_URI = "https://api.a3rt.recruit-tech.co.jp/talk/v1/smalltalk";

  @RequestMapping(value= "/call", method= RequestMethod.POST)
  public String call(@RequestBody TalkApiModel model)
      throws JsonProcessingException, URISyntaxException {

    String data = "apikey="+model.getApikey() + "&query=" + model.getQuery();

    URI uri = new URI(TALK_API_URI);
    RestTemplate client = new RestTemplate(new SimpleClientHttpRequestFactory());

    final HttpHeaders headers = new HttpHeaders();
    headers.setContentType(new MediaType(MediaType.APPLICATION_JSON, Charset.forName("utf-8")));

    RequestEntity<String> req = RequestEntity
        .post(uri)
        .headers(headers)
        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
        .body(data);

    ResponseEntity<String> res = client.exchange(req, String.class);

    return res.getBody();
  }

  @RequestMapping(value= "/sayYes", method = RequestMethod.GET)
  public String sayYes() {
    return "Say Yes!!!!!";
  }

}
