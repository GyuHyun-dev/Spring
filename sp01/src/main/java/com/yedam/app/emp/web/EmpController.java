package com.yedam.app.emp.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;

@Controller
public class EmpController {
	@Autowired
	EmpService empService;
	
	//@Autowired
	//DeptService deptService;
	
	// GET    : 단순조회, 빈 페이지 호출
	// POST   : 데이터 조작(등록, 수정, 삭제)
	
	// 전체조회
	@GetMapping("empList")    // 모델을 이용하는 방법은 데이터를 넘길 페이지가 없어서 따로 처리
	public String getEmpList(Model model) {
		List<EmpVO> list = empService.getEmpAll();
		model.addAttribute("empList", list);
		return "emp/empList";
	}
	
	// 사원조회
	@GetMapping("empInfo")
	public String getEmpInfo(EmpVO empVO, Model model) {
		EmpVO findVO = empService.getEmpInfo(empVO);
		model.addAttribute("empInfo", findVO);
		return "emp/empInfo";
	}
	
	// 사원등록 - FROM
	@GetMapping("empInsert")
	public String insertEmpInfoForm() {
		return "emp/empInsert";
	}
	
	// 사원등록 - PROCESS
	@PostMapping("empInsert")
	public String insertEmpInfoProcess(EmpVO empVO) {
		int empId = empService.insertEmpInfo(empVO);
		
		String path = null;
		if(empId > -1) {
			path = "redirect:empInfo?employeeId=" + empId;  // redirect 방식은 get 방식으로!
		} else {
			path = "redirect:empList";
		}
		return path;
	}
	
	// 사원수정 - PROCESS : Ajax => @ResponseBody
	// 1) QueryString => 커맨드 객체 이용해서 사용
	@PostMapping("empUpdate")
	@ResponseBody
	public Map<String, Object> empUpdateProcess(EmpVO empVO) {
		return empService.updateEmpInfo(empVO);
	}
	
	// 2) JSON => @RequestBody 를 이용해서 사용
	@PostMapping("empUpdateAjax")
	@ResponseBody
	public Map<String, Object> empUpdateAjaxProcess(@RequestBody EmpVO empVO) {
		return empService.updateEmpInfo(empVO);
	}
	
	// 사원삭제 - PROCESS
	@GetMapping("empDelete")
	public String empDelete(@RequestParam Integer eid) {
		empService.deleteEmpInfo(eid);
		return "redirect:empList";
	}
}