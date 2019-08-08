package kr.ac.skuniv.login.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.skuniv.login.dto.Member;
import kr.ac.skuniv.login.service.MemberService;


@WebServlet("/memberSave")
public class MemberSaveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberService service = new MemberService();
		request.setCharacterEncoding("utf-8");
		Member member = new Member();
		member.setId(request.getParameter("id"));
		member.setName(request.getParameter("name"));
		member.setPassword(request.getParameter("password"));
		member.setEmail(request.getParameter("email"));
		service.memberJoin(member);
		
		response.sendRedirect("loginForm.jsp");
		
//		request.setAttribute("resultFlag", resultFlag); 	//앞에는 이름 뒤에는 실제 값
//		request.setAttribute("memberInfo", member);
//		RequestDispatcher rd=request.getRequestDispatcher("memberSave.jsp");
//		rd.forward(request, response); 	//memberSave.jsp로 넘겨줌

		
		
		
	}

}
