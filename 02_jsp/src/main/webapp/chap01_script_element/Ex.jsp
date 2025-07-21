<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%-- 1. 화면을 새로 고침 할 때마다 변수 count 값을 1 증가시켜서 화면에 출력하세요. --%>
<%! int count = 0;
%>
<%count++; %>  
<%=count%>
<%-- 2. "일", ... "토" 요일 정보를 배열에 저장하고 현재 요일 정보를 화면에 출력하세요. --%>
<%! String[] days = {"일", "월", "화", "수", "목", "금", "토"}; %>

<%-- 3. List<String> fruits에 과일명을 3개 저장하고 화면에 <ul> 태그로 출력하세요 --%>
<%
List<String> fruits = new ArrayList<>();
fruits.add("Apple");
fruits.add("Mango");
fruits.add("Strawberry");
%>
<ul>

<%for(String fruit : fruits) {
%>
 <li><%=fruit%></li>
<%} %>


</ul>


<%-- 4. Map<String, String> members에 nickname과 name을 하나의 Entry로 저장하세요. 멤버는 3명을 만들고 각 회원 정보를 <table> 태그로 출력하세요. --%>
<%-- Entry란 Map에서 한 쌍(key, value)을 한 번에 담아주는 객체 --%>
<% Map<String, String> members = new HashMap<>(); 
 members.put("jjj", "진성"); 
 members.put("ccc", "창민");
 members.put("ggg", "경진");
 %>
 <table border = 1>
 <tr>
 <th>닉네임</th>
 <th>이름</th>
 </tr>
 
 <% for(Map.Entry<String, String> entry : members.entrySet()) {%>
 
 <tr>
    <td><%=entry.getKey()%></td>
    <td><%=entry.getValue()%></td>
 </tr> <% } %>
 </table>


<%-- 5. int age에 임의의 나이를 저장하고, 20세 기준으로 "성인입니다." 또는 "미성년자입니다."를 화면에 출력하세요. --%>
 <%
 int age = 28;
 String result = ""; // 빈 문자열은 result의 초기값.
 
 if(age > 20) {
    result = "성인입니다.";
 } else {
    result = "미성년자입니다.";
 }
 %>
 <%=age%>
 <%=result %>
 
</body>
</html>