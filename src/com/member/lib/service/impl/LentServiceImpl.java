package com.member.lib.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.member.lib.dao.LentDAO;
import com.member.lib.dao.Impl.LentDAOImpl;
import com.member.lib.service.BookService;
import com.member.lib.service.LentService;

public class LentServiceImpl implements LentService {
	private LentDAO lentDAO = new LentDAOImpl();
	@Override
	public Map<String, Object> insertLent(Map<String, Object> Lent) {
		int result = lentDAO.insertLent(Lent);
		Map<String,Object> rMap = new HashMap<>();
		rMap.put("msg",(result==1)?"빌린책 입력 성공~":"빌린책 입력 실패");
		rMap.put("cnt", result);
		return rMap;
	}

	@Override
	public Map<String, Object> updateLent(Map<String, Object> Lent) {
		  Map<String, Object> rMap = new HashMap<>();
	      int result = lentDAO.insertLent(Lent);
	      rMap.put("msg", "연장 수정완료 ");
	      if (result != 1) {
	         rMap.put("msg", "error");
	      }
	      rMap.put("cnt", result);
	      return rMap;
	   }


	@Override
	
	public Map<String, Object> deleteLent(int lNum) {
		 Map<String, Object> rMap = new HashMap<>();
	      int result = lentDAO.deleteLent(lNum);
	      rMap.put("msg", "연장 반납완료 ");
	      if (result != 1) {
	         rMap.put("msg", "error");
	      }
	      rMap.put("cnt", result);
	      return rMap;
	   }
	
	public Map<String,Object> selectLent(int lNum){
		return lentDAO.selectLent(lNum);
	}


	@Override
	public List<Map<String, Object>> selectLentList(Map<String, Object> Lent) {
		// TODO Auto-generated method stub
		return lentDAO.selectLentList(Lent);
	}

	public List<Map<String, Object>> selectNumLentBookList() {
		return  lentDAO.selectNumLentBookList();
	}
	public static void main(String[] args) {
		LentService lentService = new LentServiceImpl();
		Map<String,Object> lent = new HashMap<>();
		lent.put("m_num",36);
		lent.put("b_num",22);
		System.out.println(lentService.insertLent(lent)); //하나만 찾기
	}

}
