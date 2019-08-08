package kr.ac.skuniv.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.ac.skuniv.common.DButil;
import kr.ac.skuniv.login.dto.Guestbook;
import kr.ac.skuniv.login.dto.Member;
public class GuestbookDAO {
	
	public boolean addGuestbook(Guestbook guestbook) {
		boolean resultFlag = false;
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DButil.getConnection();
			String sql = "insert into guestbook(id,content) values(?,?)";
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, guestbook.getId());
			ps.setString(2, guestbook.getContent());
			
			
			int resultCount = ps.executeUpdate();
			
			if(resultCount == 1)
				resultFlag = true;
			
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			DButil.close(conn, ps);
		}
		
		return resultFlag;
		
	}
	
	public int upGuestbook(Guestbook guestbook) {
		int resultCount = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DButil.getConnection();
			String sql = "update guestbook set content=? where id=? ";
			ps = conn.prepareStatement(sql);

			ps.setString(1, guestbook.getContent());
			ps.setString(2, guestbook.getId());

			
			resultCount = ps.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {

			DButil.close(conn, ps);
		}
		
		return resultCount;
		
	}
	
	public int deleteGuestbook(String id) {
		int resultCount=0;
		
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = DButil.getConnection();
			String sql = "delete from guestbook where id = ?";
			ps = conn.prepareStatement(sql);
			ps.setString(1,id);
			
			resultCount = ps.executeUpdate();
			
		}catch (Exception e) {
			e.printStackTrace();
			
		}finally {
			
			DButil.close(conn, ps);
		}
		return resultCount;
	}
	
	public Guestbook getGuestbook(String id) {
		Guestbook guestbook = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DButil.getConnection();
			String sql = "select num,id,content,date from guestbook where id =? ";
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				guestbook = new Guestbook();
				guestbook.setNum(rs.getInt(1));
				guestbook.setId(rs.getString(2));
				guestbook.setContent(rs.getString(3));
				guestbook.setDate(rs.getString(4));
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DButil.close(conn,ps,rs);
		}
		
		return guestbook;
		
	}
	
	public List<Guestbook> getGuestbookList() {
		List<Guestbook> guestbookList = new ArrayList<>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DButil.getConnection();
			String sql = "select num,id,content,date from guestbook";
			ps = conn.prepareStatement(sql);

			rs = ps.executeQuery();
			
			while(rs.next()) {
				Guestbook guestbook = new Guestbook();
				guestbook.setNum(rs.getInt(1));
				guestbook.setId(rs.getString(2));
				guestbook.setContent(rs.getString(3));
				guestbook.setDate(rs.getString(4));
				
				guestbookList.add(guestbook);
			}
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			DButil.close(conn,ps,rs);
		}
		
		return guestbookList;
	}
	


}
