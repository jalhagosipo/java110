/* HttpSession 보관소 생성 및 값 저장
 * session 객체가 클라이언트마다 따로 생성됨.
 * ServletContext는 전부 공용이라 개별적으로할껀 session으로만들어야함.
 * request는 요청할때만들어져서 응답할때소멸함.
 */
package bitcamp.java110.ex07;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ex07/servlet03")
public class Servlet03 extends HttpServlet{ 

    private static final long serialVersionUID = 1L;

    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) 
            throws ServletException, IOException {

        // HttpSession 보관소 준비하기
        // => 각 클라이언트마다 별도의 HttpSession 객체가 생성된다.
        // => 
        HttpSession session = req.getSession();
        
        // HttpSession 보관소에 값 저장하기
        session.setAttribute("ccc", req.getParameter("name"));
        
        res.setContentType("text/plain;charset=UTF-8");
        PrintWriter out = res.getWriter();

        out.println("/ex07/servlet03 실행!");
        out.println("HttpSession에 값 보관!");
    }
}
