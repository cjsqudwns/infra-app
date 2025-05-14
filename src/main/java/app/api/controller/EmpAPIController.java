package app.api.controller;

import app.repository.EmpRepository;
import app.service.EmpService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api")
public class EmpAPIController {

    private final EmpService empService;
}