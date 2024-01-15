package com.example.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.student.dto.StudentDTO;
import com.example.student.service.StudentService;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class StudentController {
	@Autowired
	private StudentService studentService;
	
	// 학생등록 화면 출력
	@GetMapping("/save")
	public String save() {
		return "save";
	}
	
	// 학생등록 처리
	@PostMapping("/save")
	public String save(@ModelAttribute StudentDTO studentDTO) {
		System.out.println("StudentDTO = " + studentDTO);
		// StudentService 클래스의 save 메서드로 StudentDTO 객체 전달 
		studentService.save(studentDTO);
		return "index";
	}
	
	@GetMapping("/list")
	public String findAll(Model model) {
		// DB에서 목록 데이터를 가져옴
		List<StudentDTO> studentDTOs = studentService.findAll();
		// 리스트 데이터를 model에 담음
		model.addAttribute("studentList", studentDTOs);
		// list.html로 이동
		return"list";
		
	}
	
}
