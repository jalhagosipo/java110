package bitcamp.java110.cms.servlet.teacher;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.TeacherDao;
import bitcamp.java110.cms.domain.Teacher;

@WebServlet("/teacher/add")
public class TeacherAddController  extends HttpServlet{

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,HttpServletResponse response) 
            throws ServletException,IOException {

        // POST 방식으로 들어온 한글 데이터는
        // 다음 메서드를 호출하여 어떤 인코딩인지 알려줘야
        // getParameter() 호출할 때 정상적으로 디코딩 할 것이다.
        request.setCharacterEncoding("UTF-8");
        
        Teacher m = new Teacher();

        m.setName(request.getParameter("name"));
        m.setEmail(request.getParameter("email"));
        m.setPassword(request.getParameter("password"));
        m.setTel(request.getParameter("tel"));
        m.setPay(Integer.parseInt(request.getParameter("pay")));
        m.setSubjects(request.getParameter("subjects"));

        TeacherDao teacherDao = (TeacherDao)this.getServletContext()
                .getAttribute("teacherDao");
        
        try {
            
            teacherDao.insert(m);
            response.sendRedirect("list");
            
        }catch(Exception e) {
            request.setAttribute("error",e);
            request.setAttribute("message", "강사 등록 오류!");
            request.setAttribute("refresh", "3;url=list");
            
            request.getRequestDispatcher("/error").forward(request, response);
        }
        
    }
}