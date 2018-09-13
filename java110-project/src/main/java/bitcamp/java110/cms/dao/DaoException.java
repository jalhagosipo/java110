package bitcamp.java110.cms.dao;

public class DaoException extends RuntimeException{

    private static final long serialVersionUID = 1L;

    public DaoException() {
        super();//반드시 !첫번째문장!에 슈퍼클래스생성자가 와야함.생략하면슈퍼클래스의 디폴트로호출함.
        
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public DaoException(String message) {
        super(message);
    }
    public DaoException(Throwable cause) {
        super(cause);
    }
    public DaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
