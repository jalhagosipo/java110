package bitcamp.java110.cms.util;

public class ArrayList<T> implements List<T>{
     private Object[] list = new Object[5];
     private int index = 0;
    
    private void increaseStorage() {
        //배열 크기 늘리기
        Object[] newList = new Object[list.length+3];
        for(int i=0;i<list.length;i++) {
            newList[i] = list[i];
        }

        list = newList;
        
    }
    public void add(T obj) {
        
        if(index == list.length) {
            increaseStorage();
        }

        list[index++] = obj;
    }
    
    public T remove(int no) {
        
        if(no<0 || no>=index) {
            return null;
        }
        
        @SuppressWarnings("unchecked")
        T removedObj = (T)list[no];
        
        for(int i=no;i<=index-2;i++) {
            list[i] = list[i+1];
        }
        index--;
        
        return removedObj;
        
    }
    public int size() {
        return index;
    }
   
    
    @SuppressWarnings("unchecked")
    public T get(int no) {
        // TODO Auto-generated method stub
        if(no<0 || no>=index) {
            return null;
        }
        return (T)list[no];
    }
}
