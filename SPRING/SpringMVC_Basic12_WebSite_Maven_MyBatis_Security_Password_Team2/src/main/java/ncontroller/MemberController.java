package ncontroller;

import java.security.Principal;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import service.MemberService;
import vo.Member;


@Controller
@RequestMapping("/joinus/")
public class MemberController {

	@Autowired
	private MemberService memberservice;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@RequestMapping(value = "memberConfirm.htm", method = RequestMethod.GET)
	public String memberConfirm() {
		return "joinus.memberConfirm";
	}
	
	@RequestMapping(value = "memberConfirm.htm", method = RequestMethod.POST)
	public String memberConfirm(
			@RequestParam("password") String rawPassword,
			Principal principal) throws ClassNotFoundException, SQLException{
		String viewpage="";
		
		//회원정보
		//Member member = service.getMember(principal.getName());
		Member member = memberservice.getMember(principal.getName());
		
		//DB에서 가져온 암호화된 문자열
		String encodedPassword = member.getPwd();
		
		boolean result = bCryptPasswordEncoder.matches(rawPassword, encodedPassword);
		
		if(result){ //true = 비밀번호가 일치할 때
			viewpage="redirect:edit.htm";
		}else{
			viewpage="redirect:memberConfirm.htm";
		}
		return viewpage;
	}
	
	//회원 수정 view
	@RequestMapping(value = "edit.htm", method = RequestMethod.GET)
	public String edit(Model model, Principal principal) throws ClassNotFoundException, SQLException{
		Member member = memberservice.getMember(principal.getName());
		model.addAttribute("member", member);
		return "joinus.edit";
	}
	
	//회원 수정 처리
	@RequestMapping(value = "edit.htm", method = RequestMethod.POST)
	public String memberUpdate(Model model, Member member, Principal principal) throws ClassNotFoundException, SQLException{
		
		Member updatemember = memberservice.getMember(principal.getName());
		
		updatemember.setName(member.getName());
		updatemember.setCphone(member.getCphone());
		updatemember.setEmail(member.getEmail());
		updatemember.setPwd(bCryptPasswordEncoder.encode(member.getPwd()));
		memberservice.updateMember(updatemember);
		return "redirect:/index.htm";
	}
	
	
}
