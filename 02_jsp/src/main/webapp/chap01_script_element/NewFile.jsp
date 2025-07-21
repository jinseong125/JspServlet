<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- 1. Comment : JSP 주석으로 클라이언트에 전달되지 않는 특징
✅ JSP 태그 4종 비교

1. <%@ ... %> (디렉티브) JSP 파일의 전역 설정 할 때 페이지 정보, import, contentType 지정 등
2. <%! ... %> (선언문) 클래스 레벨 변수/메소드 선언 할 때  서블릿 클래스의 멤버로 들어감
3. <%  ... %> (스크립틀릿) 코드 실행(제어문, 변수 등) 할 때  service 메소드 안에 코드 삽입됨
4. <%= ... %> (표현식)출력할 데이터가 있을 때 out.print()로 처리됨
 --%>
<!-- 비교 - HTML 주석 : 클라이언트에 전달되고 Java 코드는 주석 처리하지 못하는 특징 -->


<%-- 2. Declaration(선언부) : 멤버 변수, 메소드 선언에서 사용 (JSP가 변환된 서블릿의 멤버) --%>
<%!
  int count = 0;
  public String method() { return "Hello World"; }
%>

<%-- 3. 지시자(Directive) : 서블릿 컨테이너에 정보 전달을 위해서 사용 --%>
<%@ page session = "true" %>

<%-- 4. 스크립틀릿(Scriptlet) : 자바 코드 실행을 위해서 사용 --%>
<%
  int count = 10;
%>

<%-- 5. 표현식(Expression) : 값(변수, 메소드 호출 등)을 문자열 로 변환하여 브라우저에 출력하기 위해 사용 --%>
<%=this.count%>
<br>
<%=method()%>
<br>
<%=count%>


</body>
</html>