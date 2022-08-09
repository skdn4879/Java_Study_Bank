package kr.co.start.bankbook;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/bankbook/*")
public class BankBookController {

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list() {
		System.out.println("list호출");
		
		return "bankbook/list";
	}
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String detail(Long bookNum) {
		//최종 데이터타입과 URL파라미터이름이 일치하게 매개변수로 받으면 알아서 파싱해줌
		System.out.println("detail호출");
		System.out.println("bookNum : " + bookNum);
		
		return "bankbook/detail";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public String add() {
		return "bankbook/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public String add(BankBookDto bankBookDto) throws Exception {
		BankBookDao bankBookDao = new BankBookDao();
		int result = bankBookDao.setBankBook(bankBookDto);
		
		if(result == 1) {
			System.out.println("bankbook 입력 완료");
		}
		
		return "bankbook/add";
	}
	
}
