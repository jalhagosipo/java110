package bitcamp.java110.cms.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.domain.Student;

//@Component
public class StudentFileDao implements StudentDao{

    private List<Student> list = new ArrayList<>();

    public StudentFileDao() {
        File dataFile = new File("data/student.dat");
        try(
                BufferedReader in =
                new BufferedReader(new FileReader(dataFile))
                // 오로지 close있는애들만여기선언할수있다.(..인터페이스AutoCloseable구현한애들) 그럼 따로 finally해서 close안해도됨.
        ){
            while(true) {
                String line = in.readLine();
                if(line == null)break;
                String[] values = line.split(",");
                
                Student s = new Student();
                s.setName(values[0]);
                s.setEmail(values[1]);
                s.setPassword(values[2]);
                s.setSchool(values[3]);
                s.setWorking(Boolean.parseBoolean(values[4]));
                s.setTel(values[5]);

                list.add(s);
               
            }
            
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void save() {
        File dataFile = new File("data/student.dat");
        try(
                BufferedWriter out =
                new BufferedWriter(new FileWriter(dataFile))
        ){
            for(Student s:list) {
                out.write(String.format("%s,%s,%s,%s,%b,%s\n"
                        , s.getName()
                        , s.getEmail()
                        , s.getPassword()
                        , s.getSchool()
                        , s.isWorking()
                        , s.getTel()));
            }
            out.flush();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public int insert(Student student) {
        for(Student item:list) {
            if(item.getEmail().equals(student.getEmail())) {
                return 0;
            }
        }
        list.add(student);
        save();
        return 1;
    }

    public List<Student> findByAll() {
        return list;
    }

    public Student findByEmail(String email) {
        for(Student item:list) {
            if(item.getEmail().equals(email)) {
                return item;
            }
        }
        return null;
    }

    public int delete(String email) {
        for(Student item:list) {
            if(item.getEmail().equals(email)) {
                list.remove(item);
                return 1;
            }
        }
        return 0;
    }
}
