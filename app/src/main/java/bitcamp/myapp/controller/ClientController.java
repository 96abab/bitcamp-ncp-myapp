package bitcamp.myapp.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import bitcamp.myapp.service.ClientService;
import bitcamp.myapp.vo.Client;
import bitcamp.util.RestResult;
import bitcamp.util.RestStatus;

@RestController
@RequestMapping("/clients")
public class ClientController {

  Logger log = LogManager.getLogger(getClass());

  {
    log.trace("ClientController 생성됨!");
  }

  @Autowired private ClientService clientService;

  @PostMapping
  public Object insert(@RequestBody Client client) {
    clientService.add(client);
    return new RestResult()
        .setStatus(RestStatus.SUCCESS);
  }

  @GetMapping
  public Object list() {
    return new RestResult()
        .setStatus(RestStatus.SUCCESS)
        .setData(clientService.list());
  }

  @GetMapping("{no}")
  public Object view(@PathVariable int no) {
    return new RestResult()
        .setStatus(RestStatus.SUCCESS)
        .setData(clientService.get(no));
  }

  @PutMapping("{no}")
  public Object update(
      @PathVariable int no,
      @RequestBody Client client) {

    log.debug(client);

    client.setNo(no);
    clientService.update(client);

    return new RestResult()
        .setStatus(RestStatus.SUCCESS);
  }

  @DeleteMapping("{no}")
  public Object delete(@PathVariable int no) {
    clientService.delete(no);
    return new RestResult()
        .setStatus(RestStatus.SUCCESS);
  }

}
