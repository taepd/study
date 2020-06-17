package service;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dao.MemberDao;
import vo.Member;

@Service
public class JoinService {

	private SqlSession sqlsession;
	
	@Autowired
	public void setSqlsession(SqlSession sqlsession) {
		this.sqlsession = sqlsession;
	}
	
	//회원 가입
	public String insert(final Member member) throws ClassNotFoundException, SQLException {
	  
		MemberDao memberdao = sqlsession.getMapper(MemberDao.class);
		
		try {
			memberdao.insert(member);			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:login.htm";

	}
	
}
