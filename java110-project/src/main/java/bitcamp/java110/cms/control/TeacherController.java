package bitcamp.java110.cms.control;

import java.io.PrintWriter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import bitcamp.java110.cms.annotation.RequestMapping;
import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Teacher;
import bitcamp.java110.cms.server.Request;
import bitcamp.java110.cms.server.Response;

@Component
public class TeacherController {
    
    TeacherDao teacherDao;
    
    @Autowired
    public void setTeacherDao(TeacherDao teacherDao) {
        this.teacherDao = teacherDao;
    }

    @RequestMapping("teacher/add")
    public void add(Request request,Response response) {
            Teacher m = new Teacher();
            
            m.setName(request.getParameter("name"));
            m.setEmail(request.getParameter("email"));
            m.setPassword(request.getParameter("password"));
            m.setTel(request.getParameter("tel"));
            m.setPay(Integer.parseInt(request.getParameter("pay")));
            m.setSubjects(request.getParameter("subjects"));
            
            teacherDao.insert(m);
            
            PrintWriter out = response.getWriter();
            out.println("등록하였습니다.");
    }
    
    @RequestMapping("teacher/delete")
    public void delete(Request request,Response response) {
        int no = Integer.parseInt(request.getParameter("no"));
        
        PrintWriter out = response.getWriter();
        
        if (teacherDao.delete(no) > 0) {
            out.println("삭제하였습니다.");
        } else {
            out.println("번호에 해당하는 강사가 없습니다.");
        }
    }
    
    @RequestMapping("teacher/detail")
    public void detail(Request request,Response response) {
        int no = Integer.parseInt(request.getParameter("no"));
        Teacher t = teacherDao.findByNo(no);
        
        PrintWriter out = response.getWriter();
        
        if (t == null) {
            System.out.println("해당 번호의 강사 정보가 없습니다!");
            return;
        }
        
        out.printf("이름: %s\n", t.getName());
        out.printf("이메일: %s\n", t.getEmail());
        out.printf("암호: %s\n", t.getPassword());
        out.printf("전화: %s\n", t.getTel());
        out.printf("시급: %d\n", t.getPay());
        out.printf("강의과목: %s\n", t.getSubjects());
    }
    
    @RequestMapping("teacher/list")
    public void list(Request request,Response response) {
        PrintWriter out = response.getWriter();
        List<Teacher> list = teacherDao.findAll();
        
        for (Teacher t : list) {
            out.printf("%d, %s, %s, %d, [%s]\n",
                    t.getNo(),
                    t.getName(), 
                    t.getEmail(), 
                    t.getPay(),
                    t.getSubjects());
        }
    }
}
