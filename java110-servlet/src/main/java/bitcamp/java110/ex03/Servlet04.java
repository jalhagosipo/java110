/* 클라이언트로 출력하기 - Binary 출력
 * 
 * binary = 텍스트 에디타러 직접편집이 불가능. ex) .hwp,.exe,.ppt,...
 * text = 편집가능. ex) .txt,.html,.csv,.cs,...
 * 
 */
package bitcamp.java110.ex03;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


/*
 * webapp에 둔 pic1은 보이지만 web-inf아래에둔 pic2는 안보임
 * */
@WebServlet("/ex03/servlet04")
public class Servlet04 extends GenericServlet{ 

    private static final long serialVersionUID = 1L;

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        // 웹애플리케이션 정보를 다루는 객체를 얻는다.
        ServletContext ctx = this.getServletContext();

        // ServletContext 객체를 통해 현재 웹 애플리케이션의 실제 경로를 알아낸다.
        String filepath = ctx.getRealPath("/WEB-INF/pic2.jpg");

        res.setContentType("image/jpeg");
        
        try (
                BufferedInputStream in = new BufferedInputStream(new FileInputStream(filepath));
                BufferedOutputStream out = new BufferedOutputStream(res.getOutputStream());
            ){
            int b;

            while((b = in.read()) != -1) {
                out.write(b);
            }

            out.flush();
        }
    }
}

