package com.member.lib.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.member.lib.dao.MemberDAO;
import com.member.lib.dao.Impl.MemberDAOImpl;
import com.member.lib.service.MemberService;

public class MemberServiceImpl implements MemberService {
	private MemberDAO memberDAO = new MemberDAOImpl();

	public Map<String, Object> insertMember(Map<String, Object> Member) {
		int result = memberDAO.insertMember(Member);
		Map<String,Object> rMap = new HashMap<>();
		rMap.put("msg","멤버등록 완료~");
		if(result!=1) {
			rMap.put("msg","멤버등록 오류");
		}
		rMap.put("cnt",result);
		// TODO Auto-generated method stub
		return rMap;
	}

	public Map<String, Object> updateMember(Map<String, Object> Member) {
		int result = memberDAO.updateMember(Member);
		Map<String,Object> rMap = new HashMap<>();
		rMap.put("msg","멤버수정 완료~");
		if(result!=1) {
			rMap.put("msg","멤버수정 오류");
		}
		rMap.put("cnt",result);
		// TODO Auto-generated method stub
		return rMap;
	}

	public Map<String, Object> deleteMember(int mNum) {
		int result = memberDAO.deleteMember(mNum);
		Map<String,Object> rMap = new HashMap<>();
		rMap.put("msg","멤버삭제 완료~");
		if(result!=1) {
			rMap.put("msg","멤버삭제 오류");
		}
		rMap.put("cnt",result);
		// TODO Auto-generated method stub
		return rMap;
	}

	public List<Map<String, Object>> selectMemberList(Map<String, Object> Member) {
		return memberDAO.selectMemberList(Member);
	}

	public Map<String, Object> selectMember(int mNum) {
		return memberDAO.selectMember(mNum);
	}
	public static void main(String[] args) {
		MemberService memberService = new MemberServiceImpl();
		
		
//		Map<String,Object> rMap = memberService.deleteMember(33);
//		System.out.println(rMap); 삭제
		
		Map<String,Object> member =  new HashMap<>();
		member.put("m_name", "오순");
		member.put("m_id", "오튀");
		member.put("m_pwd", "오징12");
		member.put("m_num", 38 );
//		Map<String,Object> rMap = memberService.insertMember(member);
//		System.out.println(rMap);
		
//		List<Map<String,Object>> memberList = memberService.selectMemberList(member);
//		for(Map<String,Object>mem:memberList) {
//			System.out.println(mem);
//		}
		Map<String,Object> rMap = memberService.updateMember(member);
		System.out.println(rMap);
		
		
		
		
	}

}
