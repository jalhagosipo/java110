package bitcamp.java110.cms.dao;

import bitcamp.java110.cms.domain.Manager;
import bitcamp.java110.cms.domain.Student;

public class ManagerList {
    static Manager[] managers = new Manager[100];
    static int managerIndex = 0;
    
    private static void increaseStorage() {
        //배열 크기 늘리기
        Manager[] newList = new Manager[managers.length+3];
        for(int i=0;i<managers.length;i++) {
            newList[i] = managers[i];
        }

        managers = newList;
        
    }
    public static void add(Manager manager) {
        
        if(managerIndex == managers.length) {
            increaseStorage();
        }

        managers[managerIndex++] = manager;
    }
    
    public static void remove(int no) {
        
        if(no<0 || no>=managerIndex) {
            return;
        }

        for(int i=no;i<=managerIndex-2;i++) {
            managers[i] = managers[i+1];
        }
        managerIndex--;
    }
    public static int size() {
        return managerIndex;
    }
   
    public static Manager get(int no) {
        // TODO Auto-generated method stub
        if(no<0 || no>=managerIndex) {
            return null;
        }
        return managers[no];
    }
}
