package bitcamp.java110.cms.dao;

import java.util.List;

import bitcamp.java110.cms.domain.Manager;

public interface ManagerDao {

     int insert(Manager manager);
     List<Manager> findByAll();
     Manager findByEmail(String email);
     int delete(String email);
}
