package kr.co.start.members;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller	// 이 클래스는 Controller 역할이라는 설명과 Container에게 이 클래스의 객체 생성을 위임
@RequestMapping(value = "/member/*")	//이 주소와 밑의 주소가 합쳐져서 판단된다.
public class MemberController {

	@Autowired
	private BankMembersService bankMembersService;
	
	// annotation
	// @ : 설명 + 실행
	
	// RequestMapping의 value는 절대경로
	//	/member/login
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String login() {
		System.out.println("로그인 실행");
		
		return "member/login";
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(BankMembersDto bankMembersDto, HttpSession session) throws Exception {
		System.out.println("DB에 로그인 실행");
		//기본적으론 forward (응답으로 html, jsp)
		// redirect (응답으로 URL)
		// redirect:다시접속할URL주소(절대경로, 상대경로)
		
		bankMembersDto = bankMembersService.login(bankMembersDto);
		
		if(bankMembersDto != null) {
			session.setAttribute("member", bankMembersDto);
		}
		
		// /member/login 이므로 현재 경로는 / 밑에 member
		return "redirect:../";
		//return "home";
	}
	
	@RequestMapping(value = "logout", method = RequestMethod.GET)
	public String logout(HttpSession session) {
		
		session.removeAttribute("member");
		
		return "redirect:/";
		
	}
	
	//	/member/join
	@RequestMapping(value = "join", method = RequestMethod.GET)
	public String join() {
		System.out.println("조인 GET 실행");
		
		return "member/join";
	}
	
	//post
	/*@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(HttpServletRequest request) throws Exception {
		System.out.println("조인 POST 실행");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String phone = request.getParameter("phone");
		BankMembersDto bankMembersDto = new BankMembersDto(userName, password, name, email, phone);
		
		BankMembersDao bankMembersDao = new BankMembersDao();
		
		int result = bankMembersDao.setJoin(bankMembersDto);
		if(result == 1) {
			System.out.println("회원가입 성공");
		}
		
		return "member/join";
	}*/
	
	@RequestMapping(value = "join", method = RequestMethod.POST)
	public String join(BankMembersDto bankMembersDto) throws Exception {
		// DTO의 멤버 변수명들과 파라미터로 전달받는 파라미터명들이 일치하면 알아서 넣어줌(DTO 내에 Setter메소드 필요)
		// DB의 컬럼명과 DTO의 멤버변수명과 url, form으로 전달받는 파라미터이름이 동일해야한다. (DB컬럼명은 대소문자 구분안함)
		System.out.println("조인 POST 실행");
		
		//BankMembersDao bankMembersDao = new BankMembersDao();
		
		int result = bankMembersService.setJoin(bankMembersDto);
		if(result == 1) {
			System.out.println("회원가입 성공");
		}
		
		// 로그인폼으로 이동
		// redirect
		return "redirect:./login";
		
		//return "member/join";
	}
	
	@RequestMapping(value = "search", method = RequestMethod.GET)
	public String getSearchById() {
		return "member/search";
	}
	
	@RequestMapping(value = "search", method = RequestMethod.POST)
	public ModelAndView getSearchById(String search) throws Exception {
		//BankMembersDao bankMembersDao = new BankMembersDao();
		ArrayList<BankMembersDto> ar = bankMembersService.getSearchById(search);
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("list", ar);
		mv.setViewName("member/list");
		
		return mv;
	}
	
}
