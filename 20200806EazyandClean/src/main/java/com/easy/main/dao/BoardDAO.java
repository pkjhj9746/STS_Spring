package com.easy.main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.easy.main.dto.BCommentDto;
import com.easy.main.dto.BDto;

import util.DBConn;

public class BoardDAO {

	public BoardDAO() {
		// TODO Auto-generated constructor stub
	}
	public ArrayList<BDto> select(){
		  ArrayList<BDto> dtos=new ArrayList<BDto>();
		  
		  Connection con=DBConn.getConnection();
		  
		  String sql="select * from Notice_board_file order by bGroup desc,bStep asc";
		  Statement st=null;
		  ResultSet rs=null;
		  
		  try {
		   st=con.createStatement();
		   rs=st.executeQuery(sql);
		   while(rs.next()) {
		    dtos.add(new BDto(
		      rs.getInt("bId"),
		      rs.getInt("bHit"),
		      rs.getInt("bGroup"),
		      rs.getInt("bStep"),
		      rs.getInt("bIndent"),
		      rs.getString("bName"),
		      rs.getString("bTitle"),
		      rs.getString("bContent"),
		      rs.getTimestamp("bDate"),
		      rs.getString("memID"),
		      rs.getInt("memType"),
		      rs.getString("bFile")
		      )
		      );
		      
		   }
		   DBConn.close(st, rs);
		  } catch (Exception e) {
		   // TODO Auto-generated catch block
		   e.printStackTrace();
		  }
		  return dtos;
		 }

	public void insert(String bName, String bTitle, String bContent, String bFile) {
		// TODO Auto-generated method stub
		Connection con = DBConn.getConnection();
		Statement st = null;

		try {
			st = con.createStatement();
			
			//insert into Notice_board_file(bId,bName,bTitle,bContent,bGroup,bStep,bIndent)
			//values (Notice_board_file_seq.nextval,'"+bName+"','"+bTitle+"','"+bContent+"',
			//    Notice_board_file_seq.currval,0,0);
			
			String sql = null;
			sql = String.format("insert into Notice_board_file(bId,bName,bTitle,bContent,bGroup,bStep,bIndent,bFile) "
			+ "values (Notice_board_file_seq.nextval,'"+bName+"','"+bTitle+"','"+bContent+"',"
			+"Notice_board_file_seq.currval,0,0,'"+bFile+"')");
			System.out.println(sql);
			st.executeUpdate(sql);
			DBConn.close(st);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public BDto select(String bId) {
		  updateHit(bId);
		  BDto dto=null;
		  Connection con=DBConn.getConnection();
		  String sql;
		  sql=String.format("select * from Notice_board_file where bId=%s order by bGroup desc,bStep asc ",bId);
		  Statement st=null;
		  ResultSet rs=null;
		  
		  try {
		   st=con.createStatement();
		   rs=st.executeQuery(sql);
		   while(rs.next()) {
		    dto=new BDto(
		      rs.getInt("bId"),
		      rs.getInt("bHit"),
		      rs.getInt("bGroup"),
		      rs.getInt("bStep"),
		      rs.getInt("bIndent"),
		      rs.getString("bName"),
		      rs.getString("bTitle"),
		      rs.getString("bContent"),
		      rs.getTimestamp("bDate"),
		      rs.getString("memID"),
		      rs.getInt("memType"),
		      rs.getString("bFile"));
		      
		   }
		   DBConn.close(st,rs);
		  } catch (Exception e) {
		   e.printStackTrace();
		  }
		  return dto;
	}
	public BDto select2(String bId) {
		  BDto dto=null;
		  Connection con=DBConn.getConnection();
		  String sql;
		  sql=String.format("select * from Notice_board_file where bId=%s order by bGroup desc,bStep asc ",bId);
		  Statement st=null;
		  ResultSet rs=null;
		  
		  try {
		   st=con.createStatement();
		   rs=st.executeQuery(sql);
		   while(rs.next()) {
		    dto=new BDto(
		      rs.getInt("bId"),
		      rs.getInt("bHit"),
		      rs.getInt("bGroup"),
		      rs.getInt("bStep"),
		      rs.getInt("bIndent"),
		      rs.getString("bName"),
		      rs.getString("bTitle"),
		      rs.getString("bContent"),
		      rs.getTimestamp("bDate"),
		      rs.getString("memID"),
		      rs.getInt("memType"),
		      rs.getString("bFile"));
		      
		   }
		   DBConn.close(st,rs);
		  } catch (Exception e) {
		   e.printStackTrace();
		  }
		  return dto;
	}
	public List<BCommentDto> selectComment(String bId) {
		  BCommentDto bcommentDto =null;
		  Connection con=DBConn.getConnection();
		  List<BCommentDto> list = new ArrayList<BCommentDto>();
		  String sql;
		  sql=String.format("select * from Notice_board_comment_id_page where NOTICE_COMMENT_BOARD=%s order by NOTICE_COMMENT_NUM desc",bId);
		  System.out.println(sql);
		  Statement st=null;
		  ResultSet rs=null;
		  
		  try {
		   st=con.createStatement();
		   rs=st.executeQuery(sql);
		   while(rs.next()) {
			  bcommentDto=new BCommentDto(
		      rs.getInt("NOTICE_COMMENT_NUM"),
		      rs.getInt("NOTICE_COMMENT_BOARD"),
		      rs.getString("NOTICE_COMMENT_ID"),
		      rs.getString("NOTICE_COMMENT_DATE"),
		      rs.getString("NOTICE_COMMENT_CONTENT"),
			  rs.getInt("NOTICE_COMMENT_INDENT"),
			  rs.getInt("NOTICE_COMMENT_GROUPID"),
			  rs.getInt("NOTICE_COMMENT_STEP"));
			  
			  list.add(bcommentDto);
			  
			  
		   }
		   DBConn.close(st,rs);
		  } catch (Exception e) {
		   e.printStackTrace();
		  }
		  return  list;
	}
	public void updateHit(String bId) {
				Connection con = DBConn.getConnection();
				Statement st = null;

				try {
					st = con.createStatement();
					
					String sql = null;
					sql = String.format("update Notice_board_file "
					+"set bHit=bHit+1 "
					+"where bId=%s",bId);
					System.out.println(sql);
					st.executeUpdate(sql);
					DBConn.close(st);
				} catch (Exception e) {
					e.printStackTrace();
				}
		
	}
	
	public void downdateHit(String bId) {
		Connection con = DBConn.getConnection();
		Statement st = null;
		try {
			st = con.createStatement();
			
			String sql = null;
			sql = String.format("update Notice_board_file "
			+"set bHit=bHit-1 "
			+"where bId=%s",bId);
			System.out.println(sql);
			st.executeUpdate(sql);
			DBConn.close(st);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	public void downdateHit(int bId) {
		Connection con = DBConn.getConnection();
		Statement st = null;

		try {
			st = con.createStatement();
			
			String sql = null;
			sql = String.format("update Notice_board_file "
			+"set bHit=bHit-2 "
			+"where bId=%d",bId);
			System.out.println(sql);
			st.executeUpdate(sql);
			DBConn.close(st);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void delete(String bId) {
				Connection con = DBConn.getConnection();
				Statement st = null;

				try {
					st = con.createStatement();
					
					String sql = null;
					sql = String.format("delete Notice_board_file where bId=%s",bId);
					System.out.println(sql);
					st.executeUpdate(sql);
					DBConn.close(st);
				} catch (Exception e) {
					e.printStackTrace();
				}
	}

	public void update(String bId, String bTitle, String bContent, String bFile) {
		Connection con = DBConn.getConnection();
		Statement st = null;

		try {
			st = con.createStatement();
			
			String sql = null;
			sql = String.format("update Notice_board_file "
			+"set bContent='%s',bTitle='%s', bFile='%s' "
			+"where bId=%s",bContent,bTitle,bFile,bId);
			System.out.println(sql);
			st.executeUpdate(sql);
			DBConn.close(st);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void reply(String bId, String bGroup, String bIndent, String bStep, String bName, String bTitle,
			String bContent) {
		//같은 그룹에 자기보다 큰스텝을 하나씩 증가하는
		// 작업을 한다.
		replyShape(bGroup,bStep);
		
				Connection con = DBConn.getConnection();
				Statement st = null;

				try {
					st = con.createStatement();					
		
					String sql = null;
					sql = String.format("insert into Notice_board_file(bId,bName,bTitle,bContent,bGroup,bStep,bIndent) "
							+ "values (Notice_board_file_seq.nextval,'"+bName+"','"
							+bTitle+"','"+bContent+"',"
							+"%s,%d,%d)"
						,bGroup
						,Integer.parseInt(bStep)+1
						,Integer.parseInt(bIndent)+1
					);
					System.out.println(sql);
					st.executeUpdate(sql);
					DBConn.close(st);
				} catch (Exception e) {
					e.printStackTrace();
				}		
	}

	private void replyShape(String bGroup, String bStep) {
		// bGroup중에서 bstep보다 큰 데이터들을 하나씩 증가시킨다.
		Connection con = DBConn.getConnection();
		PreparedStatement ps=null;

		try {
			
			String sql = null;
			sql = "update Notice_board_file "
			+"set bstep=bstep+1 "
			+"where bGroup=? and bstep > ?";
			System.out.println(sql);
			ps=con.prepareStatement(sql);
			ps.setInt(1, Integer.parseInt(bGroup));
			ps.setInt(2, Integer.parseInt(bStep));
			
			ps.executeUpdate();
			DBConn.close(ps);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public ArrayList<BDto> select(String page, String pageDataCount) {
		ArrayList<BDto> dtos=new ArrayList<BDto>();
		  
		  Connection con=DBConn.getConnection();		  
//		  select * from(
//				    select rownum m, sub.*
//				    from (select * 
//				          from Notice_board_file 
//				          order by bgroup desc, bStep asc) sub
//				    where rownum <=2*10
//				   ) 
//				where m>=(2-1)*10+1;
		  String sql=String.format("select * from("+
				  						"select rownum m, sub.* "+
				  						"from (select * "+
				  						"from Notice_board_file "+ 
				  						"order by bGroup desc,bStep asc) sub "+
				  						"where rownum <= %s*%s "+ 
				  						"where m>=(%s-1)*%s+1",page,pageDataCount,page,pageDataCount);
		  System.out.println(sql);		
		  
		  //String sql="select * from Notice_board_file order by bGroup desc,bStep asc";
		  Statement st=null;
		  ResultSet rs=null;
		  
		  try {
		   st=con.createStatement();
		   rs=st.executeQuery(sql);
		   while(rs.next()) {
		    dtos.add(new BDto(
		      rs.getInt("bId"),
		      rs.getInt("bHit"),
		      rs.getInt("bGroup"),
		      rs.getInt("bStep"),
		      rs.getInt("bIndent"),
		      rs.getString("bName"),
		      rs.getString("bTitle"),
		      rs.getString("bContent"),
		      rs.getTimestamp("bDate"),
		      rs.getString("memID"),
		      rs.getInt("memType"),
		      rs.getString("bFile")));		      
		   }
		   DBConn.close(st, rs);
		  } catch (Exception e) {
		   e.printStackTrace();
		  }
		  return dtos;
	}

	public int dataCount() {
		  int returnValue=0;
		  Connection con=DBConn.getConnection();
		  String sql;
		  sql=String.format("select  count(bId) bCount from Notice_board_file");
		  Statement st=null;
		  ResultSet rs=null;
		  
		  try {
		   st=con.createStatement();
		   rs=st.executeQuery(sql);
		   while(rs.next()) {
		     returnValue= rs.getInt("bCount");
		   }
		   DBConn.close(st,rs);
		  } catch (Exception e) {
		   e.printStackTrace();
		  }
		  return returnValue;
	}
	public int dataCoCount(String bId) {
		  int returnValue=0;
		  Connection con=DBConn.getConnection();
		  String sql;
		  sql=String.format("select  count(*) bCount from Notice_board_comment_id_page where NOTICE_COMMENT_BOARD=%s",bId);
		  Statement st=null;
		  ResultSet rs=null;
		  
		  try {
		   st=con.createStatement();
		   rs=st.executeQuery(sql);
		   while(rs.next()) {
		     returnValue= rs.getInt("bCount");
		   }
		   DBConn.close(st,rs);
		  } catch (Exception e) {
		   e.printStackTrace();
		  }
		  return returnValue;
	}
	public ArrayList<BCommentDto> searchCoSelect(String page, String pageDataCount, String bId) {
		ArrayList<BCommentDto> dtos=new ArrayList<BCommentDto>();
		  
		  Connection con=DBConn.getConnection();
//		  String query = "select bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent from mvc_board order by bGroup desc, bStep asc";
//		  String sql=String.format("select * from \r\n" + 
//		  		"(select rownum m,NOTICE_COMMENT_NUM, NOTICE_COMMENT_BOARD, NOTICE_COMMENT_ID, NOTICE_COMMENT_DATE,NOTICE_COMMENT_CONTENT,NOTICE_COMMENT_INDENT,NOTICE_COMMENT_GROUPID,NOTICE_COMMENT_STEP  \r\n" + 
//		  		"from (select NOTICE_COMMENT_NUM, NOTICE_COMMENT_BOARD, NOTICE_COMMENT_ID, NOTICE_COMMENT_DATE,NOTICE_COMMENT_CONTENT,NOTICE_COMMENT_INDENT,NOTICE_COMMENT_GROUPID,NOTICE_COMMENT_STEP   \r\n" + 
//		  		"from Notice_board_comment_id_page where NOTICE_COMMENT_BOARD="+bId+" order by NOTICE_COMMENT_NUM desc)sub  \r\n" + 
//		  		"where rownum <= %s*%s  order by NOTICE_COMMENT_BOARD)  where m>=(%s-1)*%s+1",page,pageDataCount,
//					page,pageDataCount);
		  
		  String sql=String.format("select * from \r\n" + 
			  		"(select rownum m,NOTICE_COMMENT_NUM, NOTICE_COMMENT_BOARD, NOTICE_COMMENT_ID, NOTICE_COMMENT_DATE,NOTICE_COMMENT_CONTENT,NOTICE_COMMENT_INDENT,NOTICE_COMMENT_GROUPID,NOTICE_COMMENT_STEP  \r\n" + 
			  		"from (select NOTICE_COMMENT_NUM, NOTICE_COMMENT_BOARD, NOTICE_COMMENT_ID, NOTICE_COMMENT_DATE,NOTICE_COMMENT_CONTENT,NOTICE_COMMENT_INDENT,NOTICE_COMMENT_GROUPID,NOTICE_COMMENT_STEP   \r\n" + 
			  		"from Notice_board_comment_id_page where NOTICE_COMMENT_BOARD="+bId+" order by NOTICE_COMMENT_GROUPID desc, NOTICE_COMMENT_STEP asc)sub  \r\n" + 
			  		"where rownum <= %s*%s  order by NOTICE_COMMENT_BOARD)  where m>=(%s-1)*%s+1",page,pageDataCount,
						page,pageDataCount);
		  
		  System.out.println(sql);		
		  
		  //String sql="select * from Notice_board_file order by bGroup desc,bStep asc";
		  Statement st=null;
		  ResultSet rs=null;
		  
		  try {
		   st=con.createStatement();
		   rs=st.executeQuery(sql);
		   while(rs.next()) {
		    dtos.add(new BCommentDto(
		      rs.getInt("NOTICE_COMMENT_NUM"),
		      rs.getInt("NOTICE_COMMENT_BOARD"),	
		      rs.getString("NOTICE_COMMENT_ID"),
		      rs.getString("NOTICE_COMMENT_DATE"),
		      rs.getString("NOTICE_COMMENT_CONTENT"),
			  rs.getInt("NOTICE_COMMENT_INDENT"),
			  rs.getInt("NOTICE_COMMENT_GROUPID"),
			  rs.getInt("NOTICE_COMMENT_STEP")));		      
		   }
		  DBConn.close(st, rs);
		  } catch (Exception e) {
		   e.printStackTrace();
		  }
		  return dtos;
	}
	public ArrayList<BDto> searchSelect(String page, String pageDataCount
			, String searchCol, String searchVal) {
		ArrayList<BDto> dtos=new ArrayList<BDto>();
		  
		  Connection con=DBConn.getConnection();		  
//		  select * from(
//				    select rownum m, sub.*
//				    from (select * 
//				          from Notice_board_file 
//				          order by bgroup desc, bStep asc) sub
//				    where rownum <=2*10 and bTitle like '%%죽음%%'
//				)
//				where m>=(2-1)*10+1;
		  String sql=String.format("select * from("+
					"select rownum m, sub.* "+
					"from (select * "+
							"from Notice_board_file "+ 
							"order by bGroup desc,bStep asc) sub "+
							"where rownum <= %s*%s and %s like '%%%s%%') "+ 
					"where m>=(%s-1)*%s+1",page,pageDataCount,
					searchCol,searchVal,
					page,pageDataCount);
		  System.out.println(sql);		
		  
		  //String sql="select * from Notice_board_file order by bGroup desc,bStep asc";
		  Statement st=null;
		  ResultSet rs=null;
		  
		  try {
		   st=con.createStatement();
		   rs=st.executeQuery(sql);
		   while(rs.next()) {
		    dtos.add(new BDto(
		      rs.getInt("bId"),
		      rs.getInt("bHit"),
		      rs.getInt("bGroup"),
		      rs.getInt("bStep"),
		      rs.getInt("bIndent"),
		      rs.getString("bName"),
		      rs.getString("bTitle"),
		      rs.getString("bContent"),
		      rs.getTimestamp("bDate"),
		      rs.getString("memID"),
		      rs.getInt("memType"),
		      rs.getString("bFile")));
		      
		   }
		  DBConn.close(st, rs);
		  } catch (Exception e) {
		   e.printStackTrace();
		  }
		  return dtos;
	}

	public int dataCount(String searchCol, String searchVal) {
		int returnValue=0;
		  Connection con=DBConn.getConnection();
		  String sql;
		  sql=String.format("select  count(bId) bCount from Notice_board_file "
		  +  "where %s like '%%%s%%' ",searchCol,searchVal);
		  Statement st=null;
		  ResultSet rs=null;
		  
		  try {
		   st=con.createStatement();
		   rs=st.executeQuery(sql);
		   while(rs.next()) {
		     returnValue= rs.getInt("bCount");
		   }
		   DBConn.close(st,rs);
		  } catch (Exception e) {
		   e.printStackTrace();
		  }
		  return returnValue;
	}
	public void insertBoardComment(BCommentDto bcommentDto) {
		downdateHit(bcommentDto.getNOTICE_COMMENT_BOARD());
		// TODO Auto-generated method stub
		String sql = String.format("insert into Notice_board_comment_id_page "
				+ "(NOTICE_COMMENT_NUM, NOTICE_COMMENT_BOARD, NOTICE_COMMENT_ID,  NOTICE_COMMENT_CONTENT, NOTICE_COMMENT_INDENT, NOTICE_COMMENT_GROUPID, NOTICE_COMMENT_STEP) " + 
				"values(Comment_num_seq.nextval, %d, '%s', '%s', 0,Comment_num_seq.currval,0)", 
				bcommentDto.getNOTICE_COMMENT_BOARD(),
				bcommentDto.getNOTICE_COMMENT_ID(), 
				bcommentDto.getNOTICE_COMMENT_CONTENT());
		System.out.println(sql);
		Connection con=DBConn.getConnection();
		Statement st=null;		
		  
		try {
			   st=con.createStatement();
			   st.executeUpdate(sql);
			   DBConn.close(st);
		} catch (Exception e) {
				e.printStackTrace();
		}
		
	}	
	
	
	public void insertBoardCommentReply(BCommentDto bcommentDto) {
		replyShapeComment(bcommentDto.getNOTICE_COMMENT_GROUPID(),bcommentDto.getNOTICE_COMMENT_STEP());
		downdateHit(bcommentDto.getNOTICE_COMMENT_BOARD());
		// TODO Auto-generated method stub
		System.out.println();
		System.out.println(	"NOTICE_COMMENT_GROUPID  " +bcommentDto.getNOTICE_COMMENT_GROUPID());
		System.out.println("NOTICE_COMMENT_INDENT "+bcommentDto.getNOTICE_COMMENT_INDENT());
		System.out.println();
		String sql = String.format("insert into Notice_board_comment_id_page "
				+ "(NOTICE_COMMENT_NUM, NOTICE_COMMENT_BOARD, NOTICE_COMMENT_ID,  NOTICE_COMMENT_CONTENT, NOTICE_COMMENT_INDENT, NOTICE_COMMENT_GROUPID, NOTICE_COMMENT_STEP) " + 
				"values(Comment_num_seq.nextval, %d, '%s', '%s',%d ,%d, %d)", 
				bcommentDto.getNOTICE_COMMENT_BOARD(),
				bcommentDto.getNOTICE_COMMENT_ID(), 
				bcommentDto.getNOTICE_COMMENT_CONTENT(),
				bcommentDto.getNOTICE_COMMENT_INDENT()+1,
				bcommentDto.getNOTICE_COMMENT_GROUPID(),
				bcommentDto.getNOTICE_COMMENT_STEP()+1);
		System.out.println(sql);
		Connection con=DBConn.getConnection();
		Statement st=null;		
		  
		try {
			   st=con.createStatement();
			   st.executeUpdate(sql);
			   DBConn.close(st);
		} catch (Exception e) {
				e.printStackTrace();
		}
		
	}	
	
	private void replyShapeComment(int  NOTICE_COMMENT_GROUPID, int NOTICE_COMMENT_STEP) {
		Connection con=DBConn.getConnection();;
		Statement st=null;
		
		try {
			String query = String.format("update Notice_board_comment_id_page set NOTICE_COMMENT_STEP = NOTICE_COMMENT_STEP+1 where NOTICE_COMMENT_GROUPID = %s and NOTICE_COMMENT_STEP > %s",  NOTICE_COMMENT_GROUPID, NOTICE_COMMENT_STEP);
			System.out.println(query);
			   st=con.createStatement();
			   st.executeUpdate(query);
	
		}catch(Exception e1) {
			e1.printStackTrace();
		}finally {
			try {			
				DBConn.close(st);
			}catch(Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
}
