package service;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MemberDao;
import vo.Member;

@Service
public class MemberService {

private SqlSession sqlsession;
	
	@Autowired
	public void setSqlsession(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}
	
	//회원 정보 얻기... 로그인?
	public Member getMember(String uid) throws ClassNotFoundException, SQLException {  
		
		Member member = null;
		
		try {
			MemberDao memberdao = sqlsession.getMapper(MemberDao.class);
			member = memberdao.getMember(uid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return member;
	}
	
	public void updateMember(Member member){
		
		MemberDao memberdao = sqlsession.getMapper(MemberDao.class);
		int result = memberdao.updateMember(member);
		if(result > 0){
			System.out.println("업데이트 성고");
		}else{
			System.out.println("업데이트 실패");
		}
	}

	
}
