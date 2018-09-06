package bitcamp.java110.cms.util;

public class LinkedList<T> {
    
    private Node<T> first;
    private Node<T> last;
    private int length;
    
    public LinkedList() {
        first = last = new Node<T>();
    }
    
    public void add(T obj) {
        last.value = obj;
        Node<T> node = new Node<>();
        node.prev = last;
        last.next = node;
        last = node;
        length++;
    }
    
    public T get(int index) {
        
        if(index<0||index>=length) {
            return null;
        }
        
        Node<T> cursor = first;
        
        for(int count=0;count<index;count++) {
            cursor  = cursor.next;
        }
        
        return cursor.value;
    }
    
    public T remove(int index) {
        length--;
        
        Node<T> cursor = first;
        
        for(int count=0;count<index;count++) {
            cursor = cursor.next;
        }
        
        if(cursor == first) {
            first = first.next;
            first.prev=null;
            return cursor.value;
        }
        
        cursor.prev.next= cursor.next;
        cursor.next.prev= cursor.prev;
        
        return cursor.value;
    }
    
    public void insert(int index,T obj) {
        if(index<0 || index>=length) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        
        length++;
        
        Node<T> node = new Node<>();
        node.value = obj;
        
        Node<T> cursor = first;
        for(int count=0;count<index;count++) {
            cursor = cursor.next;
        }
        
        //이전노드가 있어야만이전노드를 새노드에 연결할수있다.
        if(cursor !=first) {
        cursor.prev.next  = node;//현재노드의 이전노드가 새노드를 가리킴
        node.prev  = cursor.prev;//새노드는 현재노드의 이전노드를 가리킴
        }
        cursor.prev = node;//현재노드는 새노드를 가리킴
        node.next = cursor;//새노드의 다음은 현재 노드를 가리킴
    }
    
    public int size() {
        return this.length;
    }
    
    
    
    class Node<T2>{
        T2 value;
        Node<T2> next;
        Node<T2> prev;
        
        public Node() {}
        
        public Node(T2 value,Node<T2> prev) {
            this.value = value;
            this.prev = prev;
        }
    }
}
