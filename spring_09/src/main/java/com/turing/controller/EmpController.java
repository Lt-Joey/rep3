package com.turing.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.turing.entity.Emp;
import com.turing.mapper.EmpMapper;
import com.turing.service.IEmpService;

@Controller
public class EmpController {
	@Autowired
	private IEmpService empService;
	
	@RequestMapping("/list")
	public String list(Model model) {
		List<Emp> list=empService.findAll();
		model.addAttribute("list",list);
		return "show";
	}
	
	//返回所有员工的JSON对象
	@RequestMapping("/list2")
	@ResponseBody
	public List<Emp> list2(Model model) {
		List<Emp> list=empService.findAll();
		return list;
	}
	
	//Ajax的测试方法
	@RequestMapping(value="/test1",method = RequestMethod.GET)
	@ResponseBody
	public String test1() {
		return "Hello Ajax";
	}
	//检查用户名是否可以注册
	@RequestMapping(value="/checkName",method =RequestMethod.GET)
	@ResponseBody
	public String checkName(String name) {
		//true表示存在 false不存在
		boolean result = empService.findByName(name);
		return result?"true":"false";
	}
	

	@RequestMapping(value="/regist",method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView regist2(Emp emp) {
		int result = empService.addEmp(emp);
		return null;
	}
}
