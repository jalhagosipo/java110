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
import bitcamp.java110.cms.dao.ManagerDao;
import bitcamp.java110.cms.domain.Manager;

@Component
public class ManagerFile2Dao implements ManagerDao{

    static String defaultFilename = "data/manager2.dat";
    // static 으로 디폴트를정해준다. 그냥이면오류. 
    
    String filename;
    private List<Manager> list = new ArrayList<>();

    @SuppressWarnings("unchecked")
    public ManagerFile2Dao(String filename) {
        this.filename=filename;

        File dataFile = new File(filename);
        try(
                FileInputStream in0 = new FileInputStream(dataFile);
                BufferedInputStream in1 =
                        new BufferedInputStream(in0);
                ObjectInputStream in = new ObjectInputStream(in1);
                ){
            
            list= (List<Manager>)in.readObject();
            
            /*while(true) {
                try {
                    Manager m = (Manager)in.readObject();
                    list.add(m);
                }catch(Exception e) {
//                    e.printStackTrace();
                    break;
                }
            }*/
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public ManagerFile2Dao() {
        this(defaultFilename);// 항상 첫째줄이어야함. error:Constructor call must be the first statement in a constructor
    }

    private void save() {
        File dataFile = new File(filename);
        try(
                FileOutputStream out0 = new FileOutputStream(dataFile); // decorator아님.(concrete)
                BufferedOutputStream out1 = new BufferedOutputStream(out0); // decorator
                ObjectOutputStream out = new ObjectOutputStream(out1); // decorator
                // decorator 방식으로한거.기능을 붙였다 뗐다하는 방식. decorator는 생성자에 리더혹은라이터를필요로하는클래스들.
                ){
            
            out.writeObject(list);
            /*for (Manager s:list) {
                out.writeObject(s);
            }*/
            out.flush();
        }catch(Exception e) {
            e.printStackTrace();
        }
    }

    public int insert(Manager manager) {
        for(Manager item:list) {
            if(item.getEmail().equals(manager.getEmail())) {
                return 0;
            }
        }
        list.add(manager);
        save();
        return 1;
    }

    public List<Manager> findByAll() {
        return list;
    }

    public Manager findByEmail(String email) {
        for(Manager item:list) {
            if(item.getEmail().equals(email)) {
                return item;
            }
        }
        return null;
    }

    public int delete(String email) {
        for(Manager item:list) {
            if(item.getEmail().equals(email)) {
                list.remove(item);
                return 1;
            }
        }
        return 0;
    }
}
