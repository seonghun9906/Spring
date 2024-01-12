package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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

}
