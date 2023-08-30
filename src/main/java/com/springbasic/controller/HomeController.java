package com.springbasic.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.springbasic.vo.Studant;

/**
 * Handles requests for the application home page.
 */
@Controller // 현재 객체가 컨트롤러 객체 임을 의미한다
public class HomeController {
	
	// 로그를 남겨주는 객체
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class); 
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	// 아래의 home메서드가 "/"(매핑URI)가 get방식으로 호출될때 실행됨을 의미
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale); // 로그 출력
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate ); // 바인딩
		
		// viewResolver 객체에게 "home" 문자열을 반환
		// "/WEB-INF/views/" + "home" + ".jsp"; <-경로에 있는 jsp가 객체화 되어 최종 servlet에 의해 response됨
		return "home"; 
	}
	
	@RequestMapping(value = "/doAct1", method = RequestMethod.GET)
	public String doAction1() {
		System.out.println("doAction1이 실행됨!");
		
		// 반환값 타입이 String인 경우에는 해당하는 "view페이지이름"을 반환
		return "doAction1";	// doAction1.jsp를 호출
	}
	@RequestMapping("/doAct2") // "/doAct2" 가 GET방식으로 호출 될때
	public void doAction2() {
		logger.info("doAction2가 호출됨!");
		
		// 반환값 타입이 void인 경우에는 해당하는 "/WEB-INF/views/" + 매핑uri + ".jsp" 페이지를 반환
	}
	
	@RequestMapping("/doAct3")
	public String doAction3(Model model) {
		logger.info("doAction3가 호출됨!");
		String name = "kym";
		
		model.addAttribute("name", name); // 바인딩
		
		
		return "doAction3";	
	}
	
	@RequestMapping("/doAct4")
	public ModelAndView doAction4() {
		logger.info("doAction4가 호출됨!");
		
		String name = "kym";
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("name", name); // 바인딩
		
		mav.setViewName("doAction4");
		
		return mav;
	}
	
	@RequestMapping("/doAct5")
	public void doAction5(Model model) {
		logger.info("doAction5가 호출됨!");
		
		Studant stu = new Studant("20230829", "ray");
		
		// 바인딩 하는 객체의 이름을 지정하지 않을 경우에는 자동으로 클래스의 이름으로 바인딩(단, 앞글자는 소문자)
		model.addAttribute(stu); 

		
	}
	
}
