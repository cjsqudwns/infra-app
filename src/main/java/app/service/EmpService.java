package app.service;

import java.util.List;

import org.springframework.stereotype.Service;

import app.dto.EmpDto;
import app.entity.Dept;
import app.entity.Emp;
import app.repository.DeptRepository;
import app.repository.EmpRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class EmpService {

    private final EmpRepository empRepository;
    
    @Transactional
    public List<Emp> getAllEmp() {
    	return empRepository.findAll();
    }
    
    @Transactional
    public Emp getEmpByEmpno(Integer empno) {
    	return empRepository.findById(empno)
    			.orElseThrow(() -> new EntityNotFoundException("사원 정보가 존재하지 않습니다."));
    }

    private final DeptRepository deptRepository;
    

    @Transactional
    public EmpDto updateEmp(EmpDto updateEmpDto, Integer empno) {
        Emp emp = empRepository.findById(empno)
                .orElseThrow(() -> new EntityNotFoundException("해당 직원의 정보가 존재하지 않습니다."));
        Dept dept =deptRepository.findById(updateEmpDto.getDeptno())
                .orElseThrow(() -> new EntityNotFoundException("해당 부서가 존재하지 않습니다."));

        emp.updateInfo(updateEmpDto, dept);

        return EmpDto.from(emp);

    }
}
