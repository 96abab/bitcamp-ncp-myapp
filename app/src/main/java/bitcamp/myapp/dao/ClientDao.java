package bitcamp.myapp.dao;

import java.util.List;
import java.util.Map;
import org.apache.ibatis.annotations.Mapper;
import bitcamp.myapp.vo.Client;

@Mapper
public interface ClientDao {
  void insert(Client t);
  List<Client> findAll();
  Client findByNo(int no);
  Client findByEmailAndPassword(Map<String, Object> params);
  int update(Client t);
  int delete(int no);
}







