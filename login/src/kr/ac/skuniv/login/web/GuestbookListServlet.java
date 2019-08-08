package kr.ac.skuniv.login.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.skuniv.login.dto.Guestbook;
import kr.ac.skuniv.login.service.GuestbookService;


@WebServlet("/guestbookList")
public class GuestbookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		GuestbookService guestbookService = new GuestbookService();
		List<Guestbook> guestbookList = guestbookService.getGuestbookList(); 
		
		//보여주는 부분은 jsp
		request.setAttribute("guestbookList", guestbookList);
		
		RequestDispatcher rd = request.getRequestDispatcher("guestbookListForm.jsp");

		rd.forward(request, response);
		
	}

}
