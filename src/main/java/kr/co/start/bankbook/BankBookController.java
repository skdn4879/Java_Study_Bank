package kr.co.start.bankbook;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/bankbook/*")
public class BankBookController {
	
	@Autowired
	private BankBookService bankBookService;

	@RequestMapping(value = "list", method = RequestMethod.GET)
	public ModelAndView list(Model model) throws Exception {
		System.out.println("list호출");
		
		//BankBookDao bankBookDao = new BankBookDao();
		List<BankBookDto> ar = bankBookService.getList();
		model.addAttribute("list", ar);
		//이렇게 model을 매개변수로 받아서 쓰는것도 가능하고
		//ModelAndView객체가 Model도 포함이라 그걸 써도 된다.
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bankbook/list");
		//실제로 컨트롤러가 반환하는 객체는 viewName 정보를 포함한 ModelAndView 객체이다.
		// String, void 반환시 스프링이 자동으로 ModelAndView 객체를 생성하고 setViewName으로 넣어주는것이다.
		return mv;
	}
	
	/*@RequestMapping(value = "detail", method = RequestMethod.GET)
	public String detail(Long bookNum) throws Exception {
		//최종 데이터타입과 URL파라미터이름이 일치하게 매개변수로 받으면 알아서 파싱해줌
		System.out.println("detail호출");
		System.out.println("bookNum : " + bookNum);
		
		return "bankbook/detail";
	}*/
	
	@RequestMapping(value = "detail", method = RequestMethod.GET)
	public ModelAndView detail(BankBookDto bankBookDto) throws Exception {
		//최종 데이터타입과 URL파라미터이름이 일치하게 매개변수로 받으면 알아서 파싱해줌
		System.out.println("detail호출");
		ModelAndView mv = new ModelAndView();
		
		//BankBookDao bankBookDao = new BankBookDao();
		bankBookDto = bankBookService.getDetail(bankBookDto);
		
		mv.setViewName("bankbook/detail");
		mv.addObject("detail", bankBookDto);
		
		return mv;
	}
	
	@RequestMapping(value = "add", method = RequestMethod.GET)
	public void add() {
		//void로 리턴하면 url 경로가 viewName으로 반환
		//return "bankbook/add";
	}
	
	@RequestMapping(value = "add", method = RequestMethod.POST)
	public ModelAndView add(BankBookDto bankBookDto) throws Exception {
		//BankBookDao bankBookDao = new BankBookDao();
		int result = bankBookService.setBankBook(bankBookDto);
		
		if(result == 1) {
			System.out.println("bankbook 입력 완료");
		}
		
		ModelAndView mv = new ModelAndView();
		mv.setViewName("redirect:./list");
		
		return mv;
	}
	
}
