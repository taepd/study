package ncontroller;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import vo.Member;
import dao.MemberDao;
import service.JoinService;

@Controller
@RequestMapping("/joinus/")
public class JoinController {
	
	private JoinService joinservice;
	
	@Autowired
	public void setJoinservice(JoinService joinservice) {
		this.joinservice = joinservice;
	}
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	//회원가입페이지
	@RequestMapping(value="join.htm" , method=RequestMethod.GET)
	public String join() {
		return  "joinus.join"; //"join.jsp"; 
	}
	
	//회원가입처리
	@RequestMapping(value="join.htm" , method=RequestMethod.POST)
	public String join(Member member) throws ClassNotFoundException, SQLException {
		member.setPwd(this.bCryptPasswordEncoder.encode(member.getPwd()));
		return joinservice.insert(member);  
	}
	
	//로그인 view
	@RequestMapping(value = "login.htm", method = RequestMethod.GET)
	public String login() {
		return "joinus.login"; //TIles 적용 때문에 이렇게 씀
	}
}











