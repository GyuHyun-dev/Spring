package com.yedam.app.emp.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.yedam.app.emp.service.EmpService;
import com.yedam.app.emp.service.EmpVO;
@CrossOrigin("*")
// @Controller
@RestController  // 내부에있는 모든 메소드는 데이터를 반환한다 라는 어노테이션 때문에 @ResponseBody(데이터 전달) 생략 가능
public class EmpRestController {
	
	@Autowired
	EmpService empService;
	
	// 전체조회
	@GetMapping("emps")
	// @ResponseBody
	public List<EmpVO> getEmpList() {   // model 필요없음 서비스 결과를 그대로 보내기 때문에
		return empService.getEmpAll();
	}
	
	// 단건조회
	@GetMapping("emps/{eid}")
	// @ResponseBody
	public EmpVO getEmpInfo(@PathVariable Integer eid) {
		EmpVO empVO = new EmpVO();
		empVO.setEmployeeId(eid);
		return empService.getEmpInfo(empVO);
	}
	
	// 등록
	@PostMapping("emps")
	// @ResponseBody						// 넘어온 사원값을 @RequestBody 담음
	public Map<String, Object> insertEmpInfo(@RequestBody EmpVO empVO) {  
		int eid = empService.insertEmpInfo(empVO);
		
		Map<String, Object> map = new HashMap<>();
		return map;
	}
	
	// 수정
	@PutMapping("emps/{id}")
	// @ResponseBody
	public Map<String, Object> updateEmpInfo(@PathVariable Integer id,
											 @RequestBody EmpVO empVO) {
		empVO.setEmployeeId(id);
		return empService.updateEmpInfo(empVO);
	}
	
	// 삭제
	@DeleteMapping("emps/{id}")
	// @ResponseBody
	public boolean deleteEmpInfo(@PathVariable Integer id) {
		return empService.deleteEmpInfo(id);
	}
}
