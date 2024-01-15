package com.example.demo.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

//롬복 활용
//위와 같이 적으면 자동으로 적어짐.\
//DTO를 쓰려면 무조건 setter가 있어야함
public class DemoDTO {
	private String name;
	private int age;
}
//나중에는 DB 컬럼 이름과 또 같게 맍들어 줘야함.
// 지성훈은 추후 김승경에게 방석을 양도한다.
// 이는 지켜질 수 밖에 없는 약속으로 이를 지키지 않을 시 
// 방석을 압류한다. 