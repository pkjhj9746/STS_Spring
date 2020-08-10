package com.easy.main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.easy.main.dto.MemberVO;

import util.DBManager;

public class MemberDAO {
	private MemberDAO() {
	}

	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {
		return instance;
	}

	public Connection getConnection() throws Exception {
		Connection conn = null;
		Context initContext = new InitialContext();
		Context envContext = (Context) initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource) envContext.lookup("jdbc/myoracle");
		conn = ds.getConnection();
		return conn;
	}

	// 사용자 인증시 사용하는 메소드
	public int userCheck(String memId , String memPwd ) {
		int result = -1;
		Connection conn = null;
		String sql = "select * from member where memId=?";		
		PreparedStatement pstmt = null;
		ResultSet rs = null;


		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			String memType = "1";

			rs = pstmt.executeQuery();

			if(rs.next()) {
				if(memPwd.equals(rs.getString("memPwd"))) {
					if(memType.equals(rs.getString("memType"))) {
						result = 2;
						//일반회원
					}else if(rs.getInt("memType") == 0 ) {
						result=3;
						//관리자
					}
				}else {
					result=0;
				}
			}else{
				result=-1;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			util.DBManager.close(conn, pstmt, rs);
		}
		return result;
	} 


	// 아이디로 회원 정보 가져오는 메소드
	public MemberVO getMember(String memId ) {
		MemberVO mVo = null;
		String sql = "select * from member where memId=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId );
			rs = pstmt.executeQuery();
			if (rs.next()) {
				mVo = new MemberVO();
				mVo.setMemNum (rs.getString("memNum"));
				mVo.setMemType (rs.getString("memType"));
				mVo.setMemId (rs.getString("memId"));
				mVo.setMemPwd (rs.getString("memPwd"));
				mVo.setMemName (rs.getString("memName"));
				mVo.setUser_birth_year (rs.getInt("user_birth_year"));
				mVo.setUser_birth_month (rs.getInt("user_birth_month"));
				mVo.setUser_birth_day (rs.getInt("user_birth_day"));
				mVo.setMemGen (rs.getString("memGen"));
				mVo.setMemEmail (rs.getString("memEmail"));
				mVo.setMemPhone (rs.getString("memPhone"));
				mVo.setMemAdd_1 (rs.getString("memAdd_1"));
				mVo.setMemAdd_2 (rs.getString("memAdd_2"));
				mVo.setMemAdd_3 (rs.getString("memAdd_3"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			util.DBManager.close(conn, pstmt);
		}
		return mVo;
	}

	public int confirmID(String memId ) {
		int result = -1;
		String sql = "select memId from member where memId=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId );
			rs = pstmt.executeQuery();
			if (rs.next()) {
				result = 1;
			} else {
				result = -1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			util.DBManager.close(conn, pstmt, rs);
		}
		return result;
	}

	public int insertMember(MemberVO mVo) {
		int result = -1;
		String sql = "insert into member values(id_seq.nextval, 1, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getMemId());
			pstmt.setString(2, mVo.getMemPwd());
			pstmt.setString(3, mVo.getMemName());
			pstmt.setInt(4, mVo.getUser_birth_year());
			pstmt.setInt(5, mVo.getUser_birth_month());
			pstmt.setInt(6, mVo.getUser_birth_day());
			pstmt.setString(7, mVo.getMemGen());
			pstmt.setString(8, mVo.getMemEmail());			
			pstmt.setString(9, mVo.getMemPhone());
			pstmt.setString(10, mVo.getMemAdd_1());
			pstmt.setString(11, mVo.getMemAdd_2());
			pstmt.setString(12, mVo.getMemAdd_3());
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			util.DBManager.close(conn, pstmt);
		}
		return result;
	}

	//관리자 추가 메소드
	public int insertAdmin(MemberVO mVo) {
		int result = -1;
		String sql = "insert into member values(admin_seq.nextval, 0, ?, ?, ?, 0, 0, 0, ?, ?, ?, 0, 0, 0)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getMemId());
			pstmt.setString(2, mVo.getMemPwd());
			pstmt.setString(3, mVo.getMemName());
			pstmt.setString(4, mVo.getMemGen());
			pstmt.setString(5, mVo.getMemEmail());			
			pstmt.setString(6, mVo.getMemPhone());
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			util.DBManager.close(conn, pstmt);
		}
		return result;
	}


	public int insert(MemberVO mVo) {
		int result = -1;
		String sql = "insert into member values(id_seq.nextval, 1, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVo.getMemId());
			pstmt.setString(2, mVo.getMemPwd());
			pstmt.setString(3, mVo.getMemName());
			pstmt.setInt(4, mVo.getUser_birth_year());
			pstmt.setInt(5, mVo.getUser_birth_month());
			pstmt.setInt(6, mVo.getUser_birth_day());
			pstmt.setString(7, mVo.getMemGen());
			pstmt.setString(8, mVo.getMemEmail());			
			pstmt.setString(9, mVo.getMemPhone());
			pstmt.setString(10, mVo.getMemAdd_1());
			pstmt.setString(11, mVo.getMemAdd_2());
			pstmt.setString(12, mVo.getMemAdd_3());
			result = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			util.DBManager.close(conn, pstmt);
		}
		return result;
	}

	public List<MemberVO> adminAllMember() {
		String sql = "select * from member order by memNum desc";
		System.out.println("select all 1번");
		List<MemberVO> list = new ArrayList<MemberVO>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				MemberVO mVo = new MemberVO();
				mVo.setMemNum (rs.getString("memNum"));
				mVo.setMemType (rs.getString("memType"));
				mVo.setMemId (rs.getString("memId"));
				mVo.setMemPwd (rs.getString("memPwd"));
				mVo.setMemName (rs.getString("memName"));
				mVo.setUser_birth_year (rs.getInt("user_birth_year"));
				mVo.setUser_birth_month (rs.getInt("user_birth_month"));
				mVo.setUser_birth_day (rs.getInt("user_birth_day"));
				mVo.setMemGen (rs.getString("memGen"));
				mVo.setMemEmail (rs.getString("memEmail"));
				mVo.setMemPhone (rs.getString("memPhone"));
				mVo.setMemAdd_1 (rs.getString("memAdd_1"));
				mVo.setMemAdd_2 (rs.getString("memAdd_2"));
				mVo.setMemAdd_3 (rs.getString("memAdd_3"));
				list.add(mVo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, ps, rs);
		}
		return list;
	}
	public MemberVO selectOneMemId(String memId) {
		String sql = "select * from member where memId = ?";
		MemberVO mVo = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = DBManager.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, memId);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				mVo = new MemberVO();
				mVo.setMemNum (rs.getString("memNum"));
				mVo.setMemType (rs.getString("memType"));
				mVo.setMemId (rs.getString("memId"));
				mVo.setMemPwd (rs.getString("memPwd"));
				mVo.setMemName (rs.getString("memName"));
				mVo.setUser_birth_year (rs.getInt("user_birth_year"));
				mVo.setUser_birth_month (rs.getInt("user_birth_month"));
				mVo.setUser_birth_day (rs.getInt("user_birth_day"));
				mVo.setMemGen (rs.getString("memGen"));
				mVo.setMemEmail (rs.getString("memEmail"));
				mVo.setMemPhone (rs.getString("memPhone"));
				mVo.setMemAdd_1 (rs.getString("memAdd_1"));
				mVo.setMemAdd_2 (rs.getString("memAdd_2"));
				mVo.setMemAdd_3 (rs.getString("memAdd_3"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.close(conn, pstmt, rs);
		}
		return mVo;
	}

	public void updateMember(MemberVO mVo) {

		String sql = "update member set memType=?,mempwd=?, memname=?,User_birth_year=?,User_birth_month=?,User_birth_day=?,"
				+ "memGen=?,memphone=?,memEmail=?,memAdd_1=?,memAdd_2=?,memAdd_3=? where memid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, mVo.getMemType());
			pstmt.setString(2, mVo.getMemPwd());
			pstmt.setString(3, mVo.getMemName());
			pstmt.setInt(4, mVo.getUser_birth_year());
			pstmt.setInt(5, mVo.getUser_birth_month());
			pstmt.setInt(6, mVo.getUser_birth_day());
			pstmt.setString(7, mVo.getMemGen());
			pstmt.setString(8, mVo.getMemPhone());
			pstmt.setString(9, mVo.getMemEmail());			

			pstmt.setString(10, mVo.getMemAdd_1());
			pstmt.setString(11, mVo.getMemAdd_2());
			pstmt.setString(12, mVo.getMemAdd_3());
			pstmt.setString(13, mVo.getMemId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			util.DBManager.close(conn, pstmt);
		}
	}
	
	public void updateAdmin(MemberVO mVo) {

		String sql = "update member set mempwd=?, memname=?, memGen=?,memphone=?,memEmail=? where memid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, mVo.getMemPwd());
			pstmt.setString(2, mVo.getMemName());
			pstmt.setString(3, mVo.getMemGen());
			pstmt.setString(4, mVo.getMemPhone());
			pstmt.setString(5, mVo.getMemEmail());			
			pstmt.setString(6, mVo.getMemId());
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			util.DBManager.close(conn, pstmt);
		}
	}

	public MemberVO selectOneMemByMemId(String memId) {
		// TODO Auto-generated method stub
		String sql = "select * from member where memId=?";
		MemberVO mVo = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;

		try {
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(1, memId);

			rs = ps.executeQuery();
			while(rs.next()) {
				mVo = new MemberVO();
				mVo.setMemNum (rs.getString("memNum"));
				mVo.setMemType (rs.getString("memType"));
				mVo.setMemId (rs.getString("memId"));
				mVo.setMemPwd (rs.getString("memPwd"));
				mVo.setMemName (rs.getString("memName"));
				mVo.setUser_birth_year (rs.getInt("user_birth_year"));
				mVo.setUser_birth_month (rs.getInt("user_birth_month"));
				mVo.setUser_birth_day (rs.getInt("user_birth_day"));
				mVo.setMemGen (rs.getString("memGen"));
				mVo.setMemEmail (rs.getString("memEmail"));
				mVo.setMemPhone (rs.getString("memPhone"));
				mVo.setMemAdd_1 (rs.getString("memAdd_1"));
				mVo.setMemAdd_2 (rs.getString("memAdd_2"));
				mVo.setMemAdd_3 (rs.getString("memAdd_3"));
			}

		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			util.DBManager.close(conn, ps, rs);
		}

		return mVo;
	}

	public void adminMemUpdate(String memId,int memType, String memPwd, String memName, int user_birth_year, int user_birth_month,
			int user_birth_day, String memGen, String memEmail, String memPhone, String memAdd_1, String memAdd_2,
			String memAdd_3) {
		String sql = "update member set memType=?, mempwd=?, memname=?,User_birth_year=?,User_birth_month=?,User_birth_day=?,"
				+ "memGen=?,memphone=?,memEmail=?,memAdd_1=?,memAdd_2=?,memAdd_3=? where memid=?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		MemberVO mVo = null;

		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, memType);
			pstmt.setString(2, memPwd);
			pstmt.setString(3, memName);
			pstmt.setInt(4, user_birth_year);
			pstmt.setInt(5, user_birth_year);
			pstmt.setInt(6,user_birth_day);
			pstmt.setString(7, memGen);
			pstmt.setString(8, memPhone);
			pstmt.setString(9, memEmail);			
			pstmt.setString(10,memAdd_1);
			pstmt.setString(11, memAdd_2);
			pstmt.setString(12, memAdd_3);
			pstmt.setString(13, memId);
			pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			util.DBManager.close(conn, pstmt);
		}
	}

	public void adminMemDelete(String memId) {
		// TODO Auto-generated method stub
		String sql = "update member set memType=2 where memId=?";
		
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DBManager.getConnection();
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, memId);
			ps.executeQuery();
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			util.DBManager.close(conn, ps);
		}
		
	}		

}


/*

}
 */