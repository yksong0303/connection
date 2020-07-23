package com.member.lib.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.member.lib.dao.LentDAO;

import common.Connector;

public class LentDAOImpl implements LentDAO {

	public int insertLent(Map<String, Object> Lent) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = Connector.open();
			String sql = "insert into lent(l_num,l_lentdate,m_num,b_num )";
			sql += "values(seq_lent_l_num.nextval,sysdate,?,?)";
			ps = con.prepareStatement(sql);
			ps.setNString(1, Lent.get("m_num").toString());
			ps.setNString(2, Lent.get("b_num").toString());
			result = ps.executeUpdate();
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null) {
					ps.close();
				}
				if(con!=null) {
					con.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
			
		return result;
	}

	@Override
	public int updateLent(Map<String, Object> Lent) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = Connector.open();
			String sql = "update lent";
	         sql += " set l_recdate=sysdate,";
	         sql += " m_num=?,";
	         sql += " b_num=?";
	         sql += " where l_num=?";
			ps = con.prepareStatement(sql);
			  ps.setInt(1, (int) Lent.get("m_num"));
		         ps.setInt(2, (int) Lent.get("b_num"));
		         ps.setInt(3, (int) Lent.get("l_num"));

			result = ps.executeUpdate();
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null) {
					ps.close();
				}
				if(con!=null) {
					con.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
			
		return result;
	}

	@Override
	public int deleteLent(int lNum) {
		Connection con = null;
		PreparedStatement ps = null;
		int result = 0;
		try {
			con = Connector.open();
			String sql = "delete from book where l_num=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, lNum);
			result = ps.executeUpdate();
			con.commit();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null) {
					ps.close();
				}
				if(con!=null) {
					con.close();
				}
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
			
		return result;
	}

	@Override
	public List<Map<String, Object>> selectLentList(Map<String, Object> Lent) {
		 List<Map<String, Object>> lentList = new ArrayList<Map<String, Object>>();
	      Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      try {
	         con = Connector.open();
	         String sql = "select l.*,m.m_name,b.b_title from lent l, member m, book b\r\n" + 
	         		"where l.m_num=m.m_num\r\n" + 
	         		"and b.b_num = l.b_num";
	         ps = con.prepareStatement(sql);
	         rs = ps.executeQuery();
	         while (rs.next()) {
	            Map<String, Object> map = new HashMap<>();
	            map.put("l_num", rs.getInt("l_num"));
	            map.put("l_lentdate", rs.getString("l_lentdate"));
	            map.put("l_recdate", rs.getString("l_recdate"));
	            map.put("m_num", rs.getString("m_num"));
	            map.put("b_num", rs.getString("b_num"));
	            map.put("m_name", rs.getString("m_name"));
	            map.put("b_title", rs.getString("b_title"));
	            
	            lentList.add(map);
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         try {
	            if (ps != null) {
	               ps.close();
	            }
	            if (con != null) {
	               con.close();
	            }
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	      return lentList;
	   }


	@Override
	
	public Map<String, Object> selectLent(int lNum) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = Connector.open();
        String sql = "select l_num, l_lentdat, l_recdat, m_num, b_num from lent where l_num = ?";
        ps = conn.prepareStatement(sql);
        ps.setInt(1, lNum);
        rs = ps.executeQuery();
        while (rs.next()) {
           Map<String, Object> rMap = new HashMap<>();
           rMap.put("l_num", rs.getInt("l_num"));
           rMap.put("l_lentdat", rs.getString("l_lentdat"));
           rMap.put("l_recdat", rs.getString("l_recdat"));
           rMap.put("m_num", rs.getString("m_num"));
           rMap.put("b_num", rs.getString("b_num"));
           return rMap;
        }
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null) {
					ps.close();
				}
				if(conn!=null) {
					conn.close();
				}
			}catch(SQLException e) {
					e.printStackTrace();
				}
				
			}
			
		// TODO Auto-generated method stub
		return null;
	}
	public List<Map<String, Object>> selectNumLentBookList() {
		 List<Map<String, Object>> lentList = new ArrayList<Map<String, Object>>();
	      Connection con = null;
	      PreparedStatement ps = null;
	      ResultSet rs = null;
	      try {
	         con = Connector.open();
	         String sql = "select b_num, b_title from book\r\n" + 
	         		"where b_num not in(select b_num from lent\r\n" + 
	         		"where l_recdate is null)";
	         ps = con.prepareStatement(sql);
	         rs = ps.executeQuery();
	         while (rs.next()) {
	            Map<String, Object> map = new HashMap<>();
	            map.put("b_num", rs.getInt("b_num"));
	            map.put("b_title", rs.getString("b_title"));
	            lentList.add(map);
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         try {
	            if (ps != null) {
	               ps.close();
	            }
	            if (con != null) {
	               con.close();
	            }
	         } catch (SQLException e) {
	            e.printStackTrace();
	         }
	      }
	      return lentList;
	}
	   public static void main(String[] args) {
		   LentDAO lent = new LentDAOImpl();
		   Map<String, Object> map = new HashMap<>();
		   map.put("m_num", 35);
		   map.put("b_num",41);
		   System.out.println(lent.insertLent(map));
	   
	      
	   }


}
