package bitcamp.myapp.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import bitcamp.myapp.dao.ClientDao;
import bitcamp.myapp.dao.MemberDao;
import bitcamp.myapp.service.ClientService;
import bitcamp.myapp.vo.Client;

@Service
public class DefaultClientService implements ClientService {

  @Autowired private MemberDao memberDao;
  @Autowired private ClientDao clientDao;

  @Transactional
  @Override
  public void add(Client client) {
    memberDao.insert(client);
    clientDao.insert(client);
  }

  @Override
  public List<Client> list() {
    return clientDao.findAll();
  }

  @Override
  public Client get(int no) {
    return clientDao.findByNo(no);
  }

  @Override
  public Client get(String email, String password) {
    Map<String,Object> paramMap = new HashMap<>();
    paramMap.put("email", email);
    paramMap.put("password", password);

    return clientDao.findByEmailAndPassword(paramMap);
  }

  @Transactional
  @Override
  public void update(Client client) {
    if (memberDao.update(client) == 1 &&
        clientDao.update(client) == 1) {
    } else {
      throw new RuntimeException("client가 존재하지 않습니다.");
    }
  }

  @Transactional
  @Override
  public void delete(int no) {
    if (clientDao.delete(no) == 1 &&
        memberDao.delete(no) == 1) {
    } else {
      throw new RuntimeException("client가 존재하지 않습니다.");
    }
  }
}





