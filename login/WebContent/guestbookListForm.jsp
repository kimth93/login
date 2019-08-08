<%@page import="kr.ac.skuniv.login.service.GuestbookService"%>
<%@page import="kr.ac.skuniv.login.dto.Guestbook"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	List<Guestbook> guestbookList = (List<Guestbook>)request.getAttribute("guestbookList"); 
	
%>
<% 
/* 	GuestbookService guestbookService = new GuestbookService(); 
	Guestbook guestbook1 = (Guestbook)request.getAttribute("GuestInfo"); */
	String id = (String)session.getAttribute("login");
%>
<center>
<h1>방명록 작성</h1>
<form action="guestbookWrite" method="post">
<input type ="hidden" name="id" value ="<%=id %>" >
	작성자 : <%=id %>
	내용 : <input name="content" type="text"/>
	<input type="submit" value="작성"/>
</form>
<a href="logoutForm.jsp">로그아웃</a>
<%if(guestbookList != null){ %>
<h1>방명록</h1>


<table>
	<tr>
		<th>번호</th>
		<th>아이디</th>
		<th>내용</th>
		<th>날짜</th>
	</tr>
	
	
	<% for(Guestbook guestbook : guestbookList){
	%>
		<tr>
			<td><%=guestbook.getNum() %></td>
			<td><%=guestbook.getId() %></td>
			<td><%=guestbook.getContent() %></td>
			<td><%=guestbook.getDate() %></td>
			<td><a href="guestbookDel?id=<%=guestbook.getId() %>">삭제</a></td>
			
			
		</tr>
	<% }//for end
	}//if end%>
</table>
</center>



</body>
</html>