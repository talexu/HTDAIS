package com.talexu.angularjs;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.talexu.domain.Student;

@Controller
@RequestMapping("/")
public class AngularJSController {

	@RequestMapping("/")
	public String index(Model model) {
		model.addAttribute("message", "Hello TaleXu");
		model.addAttribute("student", Student.getStudent());
		model.addAttribute("students", Student.getStudents());
//		return "showMessage";
		return "TipCards";
	}
}
