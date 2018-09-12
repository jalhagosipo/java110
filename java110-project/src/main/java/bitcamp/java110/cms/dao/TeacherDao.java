package bitcamp.java110.cms.dao;

import java.util.List;

import bitcamp.java110.cms.domain.Teacher;

public interface TeacherDao {
    
     int insert(Teacher teacher) throws MandatoryValueDaoException,DuplicationDaoException;

     List<Teacher> findByAll();

     Teacher findByEmail(String email);
    
     int delete(String email);
}
