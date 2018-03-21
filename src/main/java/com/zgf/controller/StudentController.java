package com.zgf.controller;

import com.zgf.dto.StudentDto;
import com.zgf.service.StudentService;
import com.zgf.util.LayuiTemlateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class StudentController {
	
	@Autowired
	private StudentService service;
	
	@GetMapping("/student/show")
	public ModelAndView datagridPage(ModelAndView mav, HttpSession session) {
        mav.setViewName("student");
        //mav.addObject("currNo",session.getAttribute("currNo")!=null?(Integer)session.getAttribute("currNo"):1);
		System.out.println("----0");
        mav.addObject("currNo",(Integer)session.getAttribute("currNo"));
		System.out.println("----0");
		return  mav;
	}
	
	@GetMapping("/student/data")
	public LayuiTemlateUtil<StudentDto> datagridData(@RequestParam(value="name",required=false)String name
			, @RequestParam(value="minAge",required=false)Integer minAge
			, @RequestParam(value="maxAge",required=false)Integer maxAge
			, @RequestParam("page")Integer page
			, @RequestParam("limit")Integer limit
			, HttpSession session) {
		System.out.println("----1");
		session.setAttribute("currNo",page);
		System.out.println("----1");
		Map<String, Object> paramsFrom = new HashMap<>();
		paramsFrom.put("name", name);
		paramsFrom.put("minAge", minAge);
		paramsFrom.put("maxAge", maxAge);
		paramsFrom.put("page", (page-1)*limit);
		paramsFrom.put("limit", limit);
		return new LayuiTemlateUtil<StudentDto>(0, "", service.count(paramsFrom),service.student(paramsFrom));
	}

	@PostMapping("/student")
	public Map<String, Object> addStudent(StudentDto studentDto) {
		Map<String, Object> res = new HashMap<>();
		res.put("state",service.addStudent(studentDto));
		return res;
	}

	@PutMapping("/student")
	public Map<String, Object> editStudent(StudentDto studentDto) {
		Map<String, Object> res = new HashMap<>();
		res.put("state",service.editStudent(studentDto));
		return res;
	}

	@DeleteMapping("/student/{id}")
	public Map<String, Object> removeStudent(@PathVariable Integer id) {
        Map<String, Object> res = new HashMap<>();
        res.put("state",service.removeStudent(id));
        return res;
	}

	@DeleteMapping("/student")
	public Map<String, Object> removeStudents(@RequestBody int[] ids) {
		Map<String, Object> res = new HashMap<>();
		res.put("state",service.removeStudents(ids));
		return res;
	}

	@GetMapping("/student/{id}")
	public StudentDto detailStudent(@PathVariable Integer id) {
		return service.detailStudent(id);
	}

}
