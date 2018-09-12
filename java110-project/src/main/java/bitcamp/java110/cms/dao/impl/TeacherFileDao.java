package bitcamp.java110.cms.dao.impl;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java110.cms.annotation.Component;
import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Teacher;

@Component
public class TeacherFileDao implements TeacherDao{

    private List<Teacher> list = new ArrayList<>();

    public TeacherFileDao() {
        File dataFile = new File("data/teacher.dat");
        try(
                BufferedReader in =
                new BufferedReader(new FileReader(dataFile))
        ){
            while(true) {
                String line = in.readLine();
                if(line == null)break;
                String[] values = line.split(",");
                
                Teacher s = new Teacher();
                s.setName(values[0]);
                s.setEmail(values[1]);
                s.setPassword(values[2]);
                s.setTel(values[3]);
                s.setPay(Integer.parseInt(values[4]));
                s.setSubjects(values[5]);
               
                list.add(s);
               
            }
            
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    private void save() {
        File dataFile = new File("data/teacher.dat");
        try(
                BufferedWriter out =
                new BufferedWriter(new FileWriter(dataFile))
        ){
            for (Teacher s:list) {
                out.write(String.format("%s,%s,%s,%s,%d,[%s]\n",
                        s.getName(), 
                        s.getEmail(), 
                        s.getPassword(), 
                        s.getTel(),
                        s.getPay(),
                        s.getSubjects()));
            }
            out.flush();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public int insert(Teacher teacher) {
        for(Teacher item:list) {
            if(item.getEmail().equals(teacher.getEmail())) {
                return 0;
            }
        }
        list.add(teacher);
        save();
        return 1;
    }

    public List<Teacher> findByAll() {
       return list;
    }

    public Teacher findByEmail(String email) {
        for(Teacher item:list) {
            if(item.getEmail().equals(email)) {
                return item;
            }
        }
        return null;
    }
    
    public int delete(String email) {
        for(Teacher item:list) {
            if(item.getEmail().equals(email)) {
                list.remove(item);
                return 1;
            }
        }
        return 0;
    }
}
