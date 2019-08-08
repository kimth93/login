package kr.ac.skuniv.login.web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.skuniv.login.dto.Guestbook;
import kr.ac.skuniv.login.service.GuestbookService;

@WebServlet("/guestbookUpdate")
public class GuestbookUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GuestbookService guestbookService = new GuestbookService();
		request.setCharacterEncoding("utf-8");
		Guestbook guestbook = new Guestbook();
		guestbook.setContent(request.getParameter("content"));
		guestbookService.upGuestbook(guestbook);
		
		
	}

}
