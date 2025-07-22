<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- JSTL(JavaServerPage Standard Tag Library)에서 제공하는 Core 라이브러리를 사용합니다. --%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%--
  Core 라이브러리가 지원하는 태그
  
  1. <c:out>  값 출력
  2. <c:set>  서블릿 컨테이너에 데이터 저장    (setAttribute())
  3. <c:remove>  서블릿 컨테이너의 데이터 삭제 (removeAttribute())
  4. <c:if>      단일 조건 (else 지원 없음)
  5.<c:choose>   다중 조건
    <c:when>
    <c:otherwise>
  6.<c:forEach>  반복문
  7.<c:import>   다른 JSP/URL 포함
  8.<c:redirect> 리다이렉트
 --%>
 
 <%--서블릿 컨테이너에 데이터 저장 --%>
 <c:set var = "name" value="aaa" scope="page" />        <%-- 디폴트 scope --%>
 <c:set var = "name" value="bbb" scope="request" />     <%-- 디폴트 scope --%>
 <c:set var = "name" value="ccc" scope="session" />     <%-- 디폴트 scope --%>
 <c:set var = "name" value="ddd" scope="application" /> <%-- 디폴트 scope --%>

<hr>
                                                                                                        
<%-- <c:if> : 단일 조건 --%>
<c:set var="age" value="10"/>
<c:if test="${age ge 20}" >
<div>${age}살은 성인입니다.</div>
</c:if>
<c:if test="${age lt 20}">
  <div>${age}살은 미성년자입니다.</div>
</c:if>
<hr>

<%-- <c:choose : 다중 조건 --%>
<c:set var="score" value="100"/>
<c:choose>
<c:when test ="${score ge 90}"><div>${score}점 A학점</div></c:when>
<c:when test ="${score ge 80}"><div>${score}점 B학점</div></c:when>
<c:when test ="${score ge 70}"><div>${score}점 C학점</div></c:when>
<c:when test ="${score ge 60}"><div>${score}점 D학점</div></c:when>
<c:otherwise><div>${score}점 F학점</div></c:otherwise>
</c:choose>

<hr>

<%-- <c:forEach> : 일반 for문/향상 for문 모두 지원 --%>
<select>
<c:forEach var="x" begin="1" end="12" step="1">
<option>${x}월</option>
</c:forEach>
</select>
<%
  request.setAttribute("names",new String[]{"김말순", "최미자", "남궁연"});
%>
<c:forEach var="name" items = "${names}" varStatus="vs">
   <div>${name}, 인덱스: ${vs.index}, 몇 번째 요소인가?${vs.count }</div>
</c:forEach>

<%
  






%>









</body>
</html>