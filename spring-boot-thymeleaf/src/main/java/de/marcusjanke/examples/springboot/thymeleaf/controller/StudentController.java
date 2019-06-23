package de.marcusjanke.examples.springboot.thymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

	@GetMapping("/greeting")
	public String greeting(@RequestParam(value = "name", required = false, defaultValue = "John Doe") String name, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("student", new Student(0, name));
		return "greeting";
	}

	@PostMapping(value = "/saveStudent")
    public String saveStudent(@ModelAttribute Student student, BindingResult errors, Model model) {
		model.addAttribute("name", student.getName());
		return "greeting";
    }
}