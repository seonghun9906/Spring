package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.dto.DemoDTO;

import org.springframework.web.bind.annotation.PostMapping;




// @Controller : 해당 클래스를 컨트롤러 클래스로 스프링빈에 등록
// 스프링빈 : 스프링이 관리해주는 자바 객체
@Controller //Controller 로 만드는것 , 어노테이션
public class HomeController {
	// / 주소에 대해 get 요청이 front 로 부터 오면 아래 메서드가 실행
	@GetMapping("/") // "/" : 주소요청 (서버 시작 주소.) , 호출이 된다. 자바의 method
	// method 이름 ; index
	// return 타입 : String
	//	매개변수 : X 
	public String index() {
		// templates 폴더에 있는 index.html을 화면에 띄워라
		// hello 로 바꿧을땐 위와 같은 hello.html을 화면에 띄어라 라는 표현
		return "index";
	}
	// /hi 로 get 주소 요청을 했을때 hi.html 출력
	//get 주소 요청은 그냥 주소 요청하는 의미.
	@GetMapping("/hi")
	public String hi() {
		return "hi";
	}

	// /param1 주소를 처리하기 위한 메서드
	@GetMapping("/param1")
	// p1이라는 이름으로 전달된 파라미터를 받아서 String p1에 담는다.
	// p1이라는 이름은 index 의 p1과 가지면 좋음.
	public String param1(@RequestParam("p1") String p1) {
		System.out.println("p1"+p1);
		return "index";
	}
	
	@GetMapping("/param2")
	public String param2(@RequestParam("p1") String p1,
			@RequestParam("p2") String p2){
		System.out.println("p1 = " + p1);
		System.out.println("p2 = " + p2);
		return "index";
	}
	// form1 주소요청에 form1.html 출력
	@GetMapping("/form1")
		public String form1() {
			return "form1";
		}
	//getMapping 은 파일 자체를 브라우져에 띄우는 역할이여서 파일명이랑 return 명을 같게 해야함.
	
	@PostMapping("/form1-param")
		public String form1Param(@RequestParam("p1") String p1,
								@RequestParam("p2") String p2) {
		System.out.println("p1 = " + p1);
		System.out.println("p2 = " + p2);
		return "index";
		
	}
	
	
	@GetMapping("/model1")
	public String model1(Model model) {
		String str1 = "오늘은 금요일";
		// addAttribute : 화면에 가져갈 데이터를 담음
		model.addAttribute("s1", str1);
		return "model1";
	}
	
	@GetMapping("/form2")
	public String form2() {
		System.out.println("form2 메서드 호출");
		return "form2";
	}
	
	@PostMapping("/form2-param")
	public String form2Param(@RequestParam("p1") String p1, Model model){
		// 입력을 하고 전송버튼을 클릭하면 form-2param2라는 주소로 입력값을 전달한다.
		model.addAttribute("p1",p1);
		// 컨트롤러에서는 전달받은 값을 model에 담아서
	System.out.println("p1 = " + p1);
	return "model2";
	// model2.html로 전달
	}
	
	@GetMapping("/form3")
	public String form3() {
		return "form3";
	
	}

	// public String postMethodName(@RequestParam("name") String name,@RequestParam("age") String age) {
	//	System.out.println("name : " + name);
	//	System.out.println("age : " + age);
	//	System.out.println("name = " + name ", age = " + age);
	//	return "model3";
	
	@PostMapping("/form-param3")
	public String formparam3(@ModelAttribute DemoDTO demoDTO, Model model) {
		System.out.println(demoDTO);
		model.addAttribute("demo",demoDTO);
		return "model3";
	}
	/*DTO를 쓰려면 무조건 setter가 있어야함 */

	@GetMapping("/method4")
	public String model4(Model model) {
		List<DemoDTO> list = new ArrayList<>();
		for(int i=1; i<=10; i++) {
			DemoDTO demoDTO = new DemoDTO();
			demoDTO.setName("name"+i);
			demoDTO.setAge(i);
			list.add(demoDTO);
		}
		model.addAttribute("list", list);
		return "model4";
	}
	
}

	

