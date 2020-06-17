package dao;

import java.sql.SQLException;
import vo.Member;

public interface MemberDao {
	
	//회원정보 얻기
	public Member getMember(String uid);
	
	//회원가입
	public int insert(Member member);

	//회원정보 수정
	public int updateMember(Member member);

}
