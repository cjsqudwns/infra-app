package app.api.controller;


import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.dto.EmpDto;
import app.entity.Emp;
import app.service.EmpService;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class EmpAPIController {

    private final EmpService empService;

    @GetMapping("/emps")
    public List<Emp> getEmps() {
    	List<Emp> emps = empService.getAllEmp();
    	return emps;
    }
    
    @GetMapping("/emp/{empno}")
	public Emp getDeptByDeptno(@PathVariable Integer empno) {
		Emp emp = empService.getEmpByEmpno(empno);
		return emp;
	}


    @PutMapping("/emp/{empno}")
    public EmpDto updateEmp(@RequestBody EmpDto updateEmpDto, @PathVariable("empno") Integer empno) {
        return empService.updateEmp(updateEmpDto, empno);
    }

}