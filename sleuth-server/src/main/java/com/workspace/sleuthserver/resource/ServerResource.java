/**
 * Description: Server resource implementation.
 *
 * @author: Ashwin Padmakumar
 * @since: 2021-05-02
 * @version: 0.1
 */

package com.workspace.sleuthserver.resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/noop")
public class ServerResource {

  private static final Logger logger = LoggerFactory.getLogger(ServerResource.class);

  @GetMapping(value = "/server")
  public String noop() {
    logger.info("Reached server");
    return "Hello World";
  }
}
