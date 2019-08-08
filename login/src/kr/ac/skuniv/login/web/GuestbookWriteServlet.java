package kr.ac.skuniv.login.web;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.skuniv.login.dao.GuestbookDAO;
import kr.ac.skuniv.login.dto.Guestbook;
import kr.ac.skuniv.login.dto.Member;
import kr.ac.skuniv.login.service.GuestbookService;
import kr.ac.skuniv.login.service.MemberService;

@WebServlet("/guestbookWrite")
public class GuestbookWriteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	GuestbookDAO dao = new GuestbookDAO();
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		GuestbookService guestbookService = new GuestbookService();
		Guestbook guestbook = new Guestbook();
		
		
		guestbook.setId(request.getParameter("id"));
		guestbook.setContent(request.getParameter("content"));

		guestbookService.guestbookAdd(guestbook);

		
		response.sendRedirect("guestbookList");
		
	}

}
