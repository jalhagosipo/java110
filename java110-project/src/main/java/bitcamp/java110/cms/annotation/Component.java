package bitcamp.java110.cms.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* 애노테이션 유지정책
 * CLASS   : 컴파일 한 후에도 .class파일에 남겨둔다. 실행할 때는 참조할 수 없다.
 *           Reflection API로 클래스에서 애노테이션 정보를 추출할 수 없다.
 *           애노테이션 유지 정책을 지정하지 않으면 CLASS가 기본값이다.
 * SOURCE  : 컴파일 할 때 제거된다. 즉, .class 파일에 남겨두지 않는다.
 * RUNTIME : 컴파일 한 후에도 .class파일에 남겨둔다. 실행할 때도 참조할 수 있다.
 *           Reflection API로 클래스에서 애노테이션 정보를 추출할 수 있다.
 */
@Retention(RetentionPolicy.RUNTIME)// 컴파일 한후 .class파일에 남겨둔다.한개값이라면 value=을 안써도된다.
public @interface Component {

    String value() default "";
}
