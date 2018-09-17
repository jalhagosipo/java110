package bitcamp.java110.cms.server;

import java.util.HashMap;
import java.util.Map;

public class Request {
    String command;
    String appPath;
    String queryString;
    Map<String,String> paramMap = new HashMap<>();
    
    public Request(String command) {
        this.command=command;
        
        // 명령어에서 Query String을 분리한다.
        // ex) manager/add?name=aaa&email=aaa@test.com&password=1111
        String[] values = command.split("\\?"); // ?가 정규표현식에서 특별한명령어역할을하기때문에 \를추가함.근데이게또자바에서의미가있는거라 \를 하나더붙임.그럼?를 인식할수있게됨.
        this.appPath = values[0]; // ex) manager/add
        if(values.length>=2) { 
            queryString = values[1];// ex) name&email=aaa@test.com&password=1111

            parseQueryString(queryString);
        }
    }
    
    private void parseQueryString(String qs) {
        String[] values = qs.split("&");
        
        for(String value:values) {
            String[] kv = value.split("=");
            paramMap.put(kv[0],kv[1]);
        }
    }

    public String getParameter(String name) {
        return this.paramMap.get(name);
    }
    
    public String getCommand() {
        return this.command;
    }
    
    public String getAppPath() {
        return this.appPath;
    }
    
    public String getQueryString() {
        return this.queryString;
    }
    
    public static void main(String[] args) {
        String str = "manager/add?name=aaa&email=aaa@test.com&password=1111";
        
        Request req= new Request(str);
        
        System.out.println(req.getParameter("name"));
        System.out.println(req.getParameter("email"));
        System.out.println(req.getParameter("password"));
    }
}
