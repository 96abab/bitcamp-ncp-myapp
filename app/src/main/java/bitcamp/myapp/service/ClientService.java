package bitcamp.myapp.service;

import java.util.List;
import bitcamp.myapp.vo.Client;

public interface ClientService {
  void add(Client client);
  List<Client> list();
  Client get(int no);
  Client get(String email, String password);
  void update(Client client);
  void delete(int no);
}





