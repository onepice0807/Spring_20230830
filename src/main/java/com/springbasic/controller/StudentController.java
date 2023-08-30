package com.springbasic.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.springbasic.vo.Studant;

@Controller
@RequestMapping("/student/*") // /student/*의 모든 uri에 대해 mapping
public class StudentController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	@RequestMapping("outputStudent") // "/student/outputStudent"
	public void outputStudent(Model model) {
		logger.info("outputStudent가 호출됨!");

		Studant stu = new Studant("20230829", "ray");

		// 바인딩 하는 객체의 이름을 지정하지 않을 경우에는 자동으로 클래스의 이름으로 바인딩(단, 앞글자는 소문자)
		model.addAttribute(stu);

	}
	
	@RequestMapping("inputStudent")
	public void inputStudentGET() {
		
	}
	
	// DTO가 없거나 얻어올 파라메터의 양이 많지 않다면..
	// @RequestParam으로 파라메터를 수집할 수 있다
//	@RequestMapping(value = "saveStudent", method = RequestMethod.POST)
//	public void inputStudentPOST(@RequestParam("stuNo") String stuNo, @RequestParam("stuName") String stuName, Model model) {
//		logger.info("saveStudent가 호출됨!");
//		logger.info("학번" + stuNo);
//		logger.info("이름" + stuName);
//		
//		Studant stu = new Studant(stuNo, stuName);
//		model.addAttribute("inputStudent",stu);
//		
//	}
	

	// DTO가 있거나 얻어올 파라메터의 양이 많다면..
	// DTO 클래스를 메서드의 매개변수로 넣어주면
	// 내부에서 Student의 객체를 기본생성자로 호출하여 빈 객테를 만들고,
	// setter를 이용하여 jsp에서 넘겨진 파라메터를 세팅하여 수집한다
//	@RequestMapping(value = "saveStudent", method = RequestMethod.POST)
//	public void inputStudentPOST(Studant stu, Model model) {
//		logger.info("saveStudent가 호출됨!, " + stu.toString());
//		
//		model.addAttribute("inputStudent",stu);
//		
//	}
	
	// RedirectAttributes : redirect할떄 쿼리스트링으로 어떤 값을 넘기고자 할때 사용하는 객체
	@RequestMapping(value = "saveStudent", method = RequestMethod.POST)
	public String inputStudentPOST(Studant stu, Model model, RedirectAttributes rttr) {
		logger.info("saveStudent가 호출됨!, " + stu.toString());
		
		// Service 단을 거쳐 DB에 insert 했다면..
		
		
		// redirect할때 어떤 값을 넘겨주고자 한다면..
		rttr.addAttribute("status", "success"); // 쿼리스트링으로 붙어 넘어온다
		rttr.addFlashAttribute("status", "success"); // 쿼리스트링으로 값이 넘어오지 않는다
		
		
		return "redirect:homeStudent"; // redirect를 할 경우
		
	}
	
	@RequestMapping(value = "homeStudent", method = RequestMethod.GET)
	public void homeStudent(@ModelAttribute String status) {
		logger.info(status);
	}
	
	@RequestMapping(value = "output", method = RequestMethod.GET)
	public @ResponseBody Studant sampleStidant() {
		Studant tmp = new Studant("999999", "kym");
		
		return tmp;
	}
	
	
	
	
}
