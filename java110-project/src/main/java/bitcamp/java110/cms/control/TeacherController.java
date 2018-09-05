package bitcamp.java110.cms.control;
import java.util.Scanner;

import bitcamp.java110.cms.dao.StudentList;
import bitcamp.java110.cms.dao.TeacherList;
import bitcamp.java110.cms.domain.Student;
import bitcamp.java110.cms.domain.Teacher;

public class TeacherController {

    public static Scanner keyIn;

    


    public static void serviceTeacherMenu() {

        while (true) {
            System.out.print("강사 관리> ");
            String command = keyIn.nextLine();
            if (command.equals("list")) {
                printTeachers();
            } else if (command.equals("add")) {
                inputTeachers();
            } else if (command.equals("quit")) {
                break;
            }else if (command.equals("delete")) {
                deleteTeacher();
            } else if (command.equals("detail")) {
                detailTeacher();
            }  else {
                System.out.println("유효하지 않는 명령입니다.");
            }
        }
    }

    private static void deleteTeacher() {
        System.out.println("삭제할 번호? ");
        int no = Integer.parseInt(keyIn.nextLine());

        if(no<0 || no>=TeacherList.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }

        TeacherList.remove(no);
    }

    private static void detailTeacher() {
        System.out.println("조회할 번호? ");
        int no = Integer.parseInt(keyIn.nextLine());

        if(no<0 || no>=TeacherList.size()) {
            System.out.println("무효한 번호입니다.");
            return;
        }
        
        Teacher teacher = TeacherList.get(no);
        
        System.out.printf("이름: %s\n",teacher.getName());
        System.out.printf("이메일: %s\n",teacher.getEmail());
        System.out.printf("암호: %s\n",teacher.getPassword());
        System.out.printf("전화: %s\n",teacher.getTel());
        System.out.printf("과목: %s\n",teacher.getSubjects());
        System.out.printf("페이: %d\n",teacher.getPay());
    }

    static {
        Teacher s= new Teacher();
        s.setName("a");
        TeacherList.add(s);

        s= new Teacher();
        s.setName("b");
        TeacherList.add(s);

        s= new Teacher();
        s.setName("c");
        TeacherList.add(s);

        s= new Teacher();
        s.setName("d");
        TeacherList.add(s);

        s= new Teacher();
        s.setName("e");
        TeacherList.add(s);
    }

    private static void printTeachers() {

        int count = 0;
        for (int i=0;i<TeacherList.size();i++) {
            Teacher s = TeacherList.get(i);
            
            System.out.printf("%d: %s, %s, %s, %s, %d, [%s]\n",
                    i,
                    s.getName(),
                    s.getEmail(), 
                    s.getPassword(), 
                    s.getTel(),
                    s.getPay(),
                    s.getSubjects());
        }
    }



    private static void inputTeachers() {
        while (true) {
            Teacher m = new Teacher();

            System.out.print("이름? ");
            m.setName(keyIn.nextLine());

            System.out.print("이메일? ");
            m.setEmail(keyIn.nextLine());

            System.out.print("암호? ");
            m.setPassword(keyIn.nextLine());

            System.out.print("전화? ");
            m.setTel(keyIn.nextLine());

            System.out.print("시급? ");
            m.setPay(Integer.parseInt(keyIn.nextLine()));

            System.out.print("강의과목?(예:자바,C,C++) ");
            m.setSubjects(keyIn.nextLine());


            TeacherList.add(m);


            System.out.println("계속 하시겠습니까?(Y/n) ");
            String answer = keyIn.nextLine();
            if (answer.toLowerCase().equals("n")) {
                break;
            }
        }

    }

 

}
