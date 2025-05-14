package app.service;

import app.entity.Emp;
import app.repository.EmpRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityNotFoundException;

@RequiredArgsConstructor
@Service
@Transactional
public class EmpService {

    private final EmpRepository empRepository;
    
    @Transactional
    public Emp deleteEmp(Integer empno) {
        Emp emp = empRepository.findById(empno)
                .orElseThrow(() -> new EntityNotFoundException("사원이 존재하지 않습니다. empno=" + empno));
        empRepository.delete(emp);
        return emp;
    }
    
}