<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true" 
%>
<!-- trimDirectiveWhitespaces : 엔터빼라는속성 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSP</title>
</head>
<body>
<h1>RequestDispatcher의 including vs include 지시명령</h1>

<jsp:include page="ex09_1.jsp"></jsp:include> <!-- 얘는 일반텍스트안됨.jsp여야만함 -->
<!-- include는 먼저 jsp에 포함한다음에 실행되는데 이건 실행을 위임하는거라 아예따로 서블릿파일이 생성된다. -->
<hr>

<jsp:include page="ex09_2.jsp"/><%-- </jsp:include> 꺽쇠사이에 아무것도없다면 이와같이써도된다.--%> 

</body>
</html>
