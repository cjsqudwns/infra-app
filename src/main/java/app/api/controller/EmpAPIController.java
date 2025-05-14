package app.api.controller;

import app.dto.EmpDto;
import app.repository.EmpRepository;
import app.service.EmpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class EmpAPIController {

    private final EmpService empService;

    @PutMapping("/emp/{empno}")
    public EmpDto updateEmp(@RequestBody EmpDto updateEmpDto, @PathVariable("empno") Integer empno) {
        return empService.updateEmp(updateEmpDto, empno);
    }
}