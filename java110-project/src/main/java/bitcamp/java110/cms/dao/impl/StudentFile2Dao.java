package bitcamp.java110.cms.dao.impl;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.domain.Student;

@Component
public class StudentFile2Dao implements StudentDao{

    private List<Student> list = new ArrayList<>();
    static String defaultFilename = "data/student2.dat";
    
    String filename;

    @SuppressWarnings("unchecked")
    public StudentFile2Dao(String filename) {
        this.filename=filename;

        File dataFile = new File(filename);
        try(
                FileInputStream in0 = new FileInputStream(dataFile);
                BufferedInputStream in1 =
                        new BufferedInputStream(in0);
                ObjectInputStream in = new ObjectInputStream(in1);
                ){
            
            list= (List<Student>)in.readObject();
            
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public StudentFile2Dao() {
        this(defaultFilename);
    }

    private void save() {
        File dataFile = new File(filename);
        try(
                FileOutputStream out0 = new FileOutputStream(dataFile); // decorator아님.(concrete)
                BufferedOutputStream out1 = new BufferedOutputStream(out0); // decorator
                ObjectOutputStream out = new ObjectOutputStream(out1); // decorator
        ){
            out.writeObject(list);
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
