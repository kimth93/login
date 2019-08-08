package kr.ac.skuniv.login.service;

import java.util.List;

import kr.ac.skuniv.login.dao.GuestbookDAO;
import kr.ac.skuniv.login.dto.Guestbook;
import kr.ac.skuniv.login.dto.Member;



public class GuestbookService {

	GuestbookDAO dao = new GuestbookDAO();
	
	public boolean guestbookIdCheck(String id) {
		
		boolean idFlag = false;
		
		Guestbook guestbook = dao.getGuestbook(id);
		
		if(guestbook != null && guestbook.getId().equals(id)) {
			idFlag = true;
		}
		
		return idFlag;
		
	}
	
	public boolean guestbookAdd(Guestbook guestbook) {
		//Todo 데이터를 얻어와서 회원가입 하기 위해
		//필요한 로직이 존재한다면 여기에서 수행함
		
		
		//DB에 저장할 정보가 있다면 저장
		boolean resultFlag = dao.addGuestbook(guestbook);
		
		
		return resultFlag;
	}
	
	public List<Guestbook> getGuestbookList() {
		
		return dao.getGuestbookList();
	}
	
	public void deleteGuestbook(String id) {
		
		dao.deleteGuestbook(id);
		
	}
	
	public Guestbook getGuestbook(String id) {
		return dao.getGuestbook(id);
	}
	
	public void upGuestbook(Guestbook guestbook) {
		
		dao.upGuestbook(guestbook);
	}
	

}
