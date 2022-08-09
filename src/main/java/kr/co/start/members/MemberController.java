package kr.co.start.members;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller	// 이 클래스는 Controller 역할이라는 설명과 Container에게 이 클래스의 객체 생성을 위임
@RequestMapping(value = "/member/*")	//이 주소와 밑의 주소가 합쳐져서 판단된다.
public class MemberController {

	// annotation
	// @ : 설명 + 실행
	
	// RequestMapping의 value는 절대경로
	//	/member/login
	@RequestMapping(value = "login")
	public String login() {
		System.out.println("로그인 실행");
		
		return "member/login";
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
		
		BankMembersDao bankMembersDao = new BankMembersDao();
		
		int result = bankMembersDao.setJoin(bankMembersDto);
		if(result == 1) {
			System.out.println("회원가입 성공");
		}
		
		return "member/join";
	}
	
}
