package bitcamp.java110.cms.server;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerApp {

    public static void main(String[] args) throws Exception {

        // 클라이언트 연결을 기다리는 서버 소켓 준비
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("서버 실행 중...");
        while(true) {
            try(

                    Socket socket = serverSocket.accept();
                    PrintStream out = new PrintStream(
                            new BufferedOutputStream(
                                    socket.getOutputStream()));
                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(
                                    socket.getInputStream())); 
                    ){
                System.out.println(in.readLine());
                out.println("OK");out.flush();

                while(true) {
                    String requestLine = in.readLine();
                    if(requestLine.equals("EXIT")) {
                        out.println("goodbye");
                        out.println();
                        out.flush();
                        break;
                    }
                    out.println(requestLine);
                    out.println();//답변이 끝났음을 알리는 빈 문자열을 보내야 하니까 이 줄을 추가한 것임.
                    out.flush();
                }
            }
        }
    }
}






















