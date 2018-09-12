package bitcamp.java110.cms.dao;

public class MandatoryValueDaoException extends RuntimeException{
    //runtimeexception이면 오류처리를 하라는 빨간줄이없다.따라서 처리를 안해도상관이없다.마우스를갖다대면어떤예외가있다는게보임.어떤에러인지 클래스이름으로 한눈에보임.
    //runtime은 개발자가 try/catch안해도 되서 안하게되면 빨갛게 오류나면서 jvm이 그냥 멈춤.따라서 그냥 무시하진말아라.app에서 처리했음.

    private static final long serialVersionUID = 1L;

    public MandatoryValueDaoException() {
        super();//반드시 !첫번째문장!에 슈퍼클래스생성자가 와야함.생략하면슈퍼클래스의 디폴트로호출함.
        
    }

    public MandatoryValueDaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public MandatoryValueDaoException(String message) {
        super(message);
    }

}
