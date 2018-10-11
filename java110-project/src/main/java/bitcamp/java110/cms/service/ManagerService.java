package bitcamp.java110.cms.service;

import java.util.List;

import bitcamp.java110.cms.domain.Manager;

public interface ManagerService {
    
    // 서비스 인터페이스는 업무 로직을 규칙으로 정의한다.
    // 따라서 메서드 이름은 업무에 가깝게 명명해야 한다.
    /*public abstract 항상 인터페이스속의 함수들은 이것들이 디폴트라 없애도됨*/
    void add(Manager manager);
    List<Manager> list();
    Manager get(int no);
    void delete(int no);
}
