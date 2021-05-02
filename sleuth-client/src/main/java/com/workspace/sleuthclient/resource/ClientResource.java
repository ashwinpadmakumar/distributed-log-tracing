/**
 * Description: Client Resource implementation.
 *
 * @author: Ashwin Padmakumar
 * @since: 2021-05-02
 * @version: 0.1
 */

package com.workspace.sleuthclient.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/rest/noop")
public class ClientResource {

  private static final Logger logger = LoggerFactory.getLogger(ClientResource.class);
  private static final String URL = "http://sleuth-server:8081/rest/noop/server";

  @Autowired
  private RestTemplate restTemplate;

  @GetMapping(value = "/client")
  public String noop() {
    logger.info("Before calling the server");
    String response = restTemplate.getForObject(URL, String.class);
    logger.info("After calling the server");

    return response;
  }

}
