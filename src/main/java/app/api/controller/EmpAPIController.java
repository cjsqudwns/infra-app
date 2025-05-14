package app.api.controller;

import app.entity.Emp;
import app.service.EmpService;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class EmpAPIController {

    private final EmpService empService;

    @DeleteMapping("/emp/{empno}")
    public Emp deleteEmp(@PathVariable Integer empno) {
        return empService.deleteEmp(empno);
    }
}