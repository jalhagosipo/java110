// 객체 생성하기 : Spring IoC 컨테이너 사용 III
package ex01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test06 {

    public static void main(String[] args) {
        
        
        ClassPathXmlApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext("ex01/app-context3.xml");
        
        Car obj = (Car)iocContainer.getBean("c1");
        
        System.out.println(obj);
        
        iocContainer.close();
    }
}