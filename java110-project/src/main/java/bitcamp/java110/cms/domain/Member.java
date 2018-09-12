package bitcamp.java110.cms.domain;

import java.io.Serializable;

public class Member implements Serializable{// 인터페이스는 상위클래스에 해두면 하위는 자동으로 됨.
    // 여러 속성의 값을 관리하기 쉽도록 사용자 정의 데이터 타입을 만들어 사용한다.

    private static final long serialVersionUID = 1L;
    
    protected String name;
    protected String email;
    
    // transient(일시적인) -> 직렬화해서 데이터보낼때 대상에서 제외된다.(Serializable대상에서제외)
    protected transient String password;

    // 인스턴스의 메모리를 다루는 operator=setter/getter=accessor=propterty=message
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }



}
