package kr.ac.skuniv.login.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.skuniv.login.dto.Member;
import kr.ac.skuniv.login.service.MemberService;


@WebServlet("/memberList")
public class MemberListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//로그인한 사용자가 요청하면 리스트를 보여주고,
		//로그인하지 않은 사용자가 해당 페이지를 요청하면 로그인 폼으로 리다이렉트 시킨다.
		boolean loginFlag = false;
		//로그인 유무 체크
		//상태정보를 쿠키를 통해 유지했을때 확인방법
//		boolean loginFlag = false;
//		Cookie[] cookies = request.getCookies();
//		
//		if(cookies != null) {
//			for(Cookie cookie : cookies) {
//				if("login".equals(cookie.getName())) {
//					loginFlag = true;
//					break;
//					
//				}
//			}
//			
//		}
		
		//상태정보를 세션을 통해서 유지했을때 확인 방법
		
		HttpSession session = request.getSession();
		session.getAttribute("login");
		if(session.getAttribute("login")!=null) {
			
			loginFlag = true;
		}
		
		if(loginFlag) {
			
			MemberService memberService = new MemberService();
			List<Member> memberList = memberService.getMemberList();
		
			//보여주는 부분은 jsp
			request.setAttribute("memberList", memberList);
		
			RequestDispatcher rd = request.getRequestDispatcher("memberList.jsp");

			rd.forward(request, response);
		}else {
			response.sendRedirect("loginForm.jsp");
		}
		
	}

}
