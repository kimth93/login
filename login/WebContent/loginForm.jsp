<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>로그인 창</h1>

	<%
		String msg =(String)session.getAttribute("msg");
		session.removeAttribute("msg");
	if(msg != null) {
		
		out.print(msg);
	}
	%>
<form action="login" method="post">
	아이디 : <input type = "text" name = "id"><br>
	비밀번호 : <input type = "password" name ="password"><br>
	<input type="submit" value="로그인">
	<a href="memberSaveForm.jsp">회원가입</a>
	
</form>


</body>
</html>