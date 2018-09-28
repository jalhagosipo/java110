package bitcamp.java110.cms.servlet.student;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bitcamp.java110.cms.dao.StudentDao;
import bitcamp.java110.cms.domain.Student;

@WebServlet("/student/detail")
public class StudentDetailController  extends HttpServlet{

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response) 
            throws ServletException,IOException {
        
        int no = Integer.parseInt(request.getParameter("no"));
        
        StudentDao studentDao = (StudentDao)this.getServletContext()
                .getAttribute("studentDao");

        Student student = studentDao.findByNo(no);

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>학생 관리</title>");
        out.println("<style>");
        out.println("table,th,td{");
        out.println("   border:1px solid gray;");
        out.println("}");
        out.println("</style>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>학생 상세정보</h1>");
        
        if (student == null) {
            System.out.println("해당 번호의 학생 정보가 없습니다!");
        }else {

            out.println("<table>");
            out.println("<tbody>");
            out.printf("    <tr><th>번호</th><th>%d</th></tr>\n",student.getNo());
            out.printf("    <tr><th>이름</th><th>%s</th></tr>\n",student.getName());
            out.printf("    <tr><th>이메일</th><th>%s</th></tr>\n", student.getEmail());
            out.printf("    <tr><th>암호</th><th>%s</th></tr>\n", student.getPassword());
            out.printf("    <tr><th>전화</th><th>%s</th></tr>\n", student.getTel());
            out.printf("    <tr><th>최종학력</th><th>%s</th></tr>\n", student.getSchool());
            out.printf("    <tr><th>재직여부</th><th>%b</th></tr>\n", student.isWorking());
            out.println("</tbody>");
            out.println("</table>");

            out.println("<button type='button' onclick='remove()'>삭제</button>");
        }

        out.println("<script>");
        out.println("function remove() {");
        out.printf("   location.href = 'delete?no=%d'\n",student.getNo()); 
        out.println("}");
        out.println("</script>");
        
        out.println("</body>");
        out.println("</html>");
    }
}
