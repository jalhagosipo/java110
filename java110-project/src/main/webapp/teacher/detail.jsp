<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@page import="bitcamp.java110.cms.domain.Teacher"%>

<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>강사 관리</title>
<link rel='stylesheet' href='../css/common.css'>
<style>
table,th,td{
   border:1px solid gray;
}
</style>
</head>
<body>

<jsp:include page="../header.jsp" />

<h1>강사 상세정보(MVC)</h1>

<%
Teacher t = (Teacher)request.getAttribute("teacher");
if(t == null){
%>
<p>해당번호의 강사가 없습니다!</p>
<%
}else{
%>
<table>
<tbody>
    <tr><th>번호</th><th><%=t.getNo()%></th></tr>
    <tr><th>이름</th><th><%=t.getName()%></th></tr>
    <tr><th>이메일</th><th><%=t.getEmail()%></th></tr>
    <tr><th>암호</th><th><%=t.getPassword()%></th></tr>
    <tr><th>전화</th><th><%=t.getTel()%></th></tr>
    <tr><th>시급</th><th><%=t.getPay()%></th></tr>
    <tr><th>강의과목</th><th><%=t.getSubjects()%></th></tr>
</tbody>
</table>
<button type='button' onclick='remove()'>삭제</button>
<script>
function remove() {
   location.href = 'delete?no=<%=t.getNo()%>'
}
</script>

<%
}
%>
<jsp:include page="../footer.jsp" />
</body>
</html>
