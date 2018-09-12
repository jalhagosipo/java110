package bitcamp.java110.cms.dao;

import java.util.List;

import bitcamp.java110.cms.domain.Student;

public interface StudentDao {

    int insert(Student student) throws MandatoryValueDaoException,DuplicationDaoException;
    List<Student> findByAll();
    Student findByEmail(String email);
    int delete(String email);
}
