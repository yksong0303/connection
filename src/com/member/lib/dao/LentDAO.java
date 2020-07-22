package com.member.lib.dao;

import java.util.List;
import java.util.Map;

public interface LentDAO {
	int insertLent(Map<String,Object> Lent);
	int updateLent(Map<String,Object> Lent);
	int deleteLent(int lNum);
	List<Map<String,Object>>selectLentList(Map<String,Object> Lent);
	Map<String,Object> selectLent(int lNum);
	List<Map<String,Object>> selectNumLentBookList();
}
