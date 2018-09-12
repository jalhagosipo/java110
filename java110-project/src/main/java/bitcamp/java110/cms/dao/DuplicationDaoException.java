package bitcamp.java110.cms.dao;

public class DuplicationDaoException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public DuplicationDaoException() {
        super();//반드시 !첫번째문장!에 슈퍼클래스생성자가 와야함.생략하면슈퍼클래스의 디폴트로호출함.
        
    }

    public DuplicationDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicationDaoException(String message) {
        super(message);
    }

}
