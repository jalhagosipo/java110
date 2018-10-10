<%@ page language="java" 
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"
    trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset='UTF-8'>
<title>학생 관리</title>
<link rel='stylesheet' href='../css/common.css'>
<style>
table,th,td{
   border:1px solid gray;
}
#photo-image{
    height: 100px;
}
</style>
</head>
<body>

<jsp:include page="../header.jsp" />

<h1>학생 상세정보(MVC)</h1>

<table>
<tbody>
    <tr><th>번호</th><th>${student.no}</th></tr>
    <tr><th>이름</th><th>${student.name}</th></tr>
    <tr><th>이메일</th><th>${student.email}</th></tr>
    <tr><th>암호</th><th>${student.password}</th></tr>
    <tr><th>전화</th><th>${student.tel}</th></tr>
    <tr><th>최종학력</th><th>${student.school}</th></tr>
    <tr><th>재직여부</th><th>${student.working}</th></tr>
            <tr>
        <th>사진</th>
<c:choose>
<c:when test="${not empty student.photo}">
        <td><img id='photo-image' src='/upload/${student.photo}'></td>
</c:when>
<c:otherwise>
        <td><img id='photo-image' src='/img/anonymous.png'></td>
</c:otherwise>
</c:choose>
    </tr>
</tbody>
</table>
<button type='button' onclick='remove()'>삭제</button>
<script>
function remove() {
   location.href = 'delete?no=${student.no}'
}
</script>
<jsp:include page="../footer.jsp" />

</body>
</html>
