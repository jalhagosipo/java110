package bitcamp.java110.cms.servlet.teacher;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import bitcamp.java110.cms.domain.Teacher;
import bitcamp.java110.cms.service.TeacherService;

@MultipartConfig(maxFileSize=2_000_000)// 사진크기 약 2메가가 넘어가지않도록함.
@WebServlet("/teacher/add")
public class TeacherAddServlet  extends HttpServlet{

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html;charset=UTF-8");
        
        // form.jsp 인클루딩
        RequestDispatcher rd = request.getRequestDispatcher("/teacher/form.jsp");
        rd.include(request, response);
    }
    
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

        TeacherService teacherService = (TeacherService)this.getServletContext()
                .getAttribute("teacherService");
        
        try {
            // 사진 데이터 처리
            Part part = request.getPart("file1");
            if (part.getSize() > 0) {
                String filename = UUID.randomUUID().toString();
                part.write(this.getServletContext()
                           .getRealPath("/upload/" + filename));
                m.setPhoto(filename);
            }
           
            teacherService.add(m);
            response.sendRedirect("list");
            
        }catch(Exception e) {
            request.setAttribute("error",e);
            request.setAttribute("message", "강사 등록 오류!");
            request.setAttribute("refresh", "3;url=list");
            
            request.getRequestDispatcher("/error").forward(request, response);
        }
        
    }
}