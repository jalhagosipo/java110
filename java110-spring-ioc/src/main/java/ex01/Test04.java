// 객체 생성하기 : Spring IoC 컨테이너 사용
package ex01;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test04 {

    public static void main(String[] args) {
        
        
        // 객체의 생성, 소멸과 의존객체 주입을 관리하는 bean container(=IoC 컨테이너,bean의 생성-소멸관리)
        //bean(자바용어)=object(역할강조)=instance(값을강조할때사용)
        // bean container(=IoC 컨테이너) 생성하기
        ClassPathXmlApplicationContext iocContainer = 
                new ClassPathXmlApplicationContext("ex01/app-context.xml");
        
        // ioc 컨테이너에서 객체 꺼내기 
        Car obj = (Car)iocContainer.getBean("c1");
        
        System.out.println(obj);
        
        iocContainer.close();
    }
}