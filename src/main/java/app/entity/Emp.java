package app.entity;

import app.dto.EmpDto;
import app.entity.Dept;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@ToString
@Builder
@Entity
public class Emp {
    @Id
    @Column(name = "empno")
    private Integer empno;

    @Column(name = "ename")
    private String ename;

    @Column(name = "job")
    private String job;

    @Column(name = "mgr")
    private Integer mgr;

    @Column(name = "hiredate")
    private LocalDate hiredate;

    @Column(name = "sal")
    private Double sal;

    @Column(name = "comm")
    private Double comm;

    @ManyToOne
    @JoinColumn(name = "deptno")
    private Dept dept;

    @Builder
    public Emp(int empno, String ename, String job, Integer mgr, LocalDate hiredate, Double sal, Double comm, Dept dept) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
        this.dept = dept;
    }

    public void updateInfo(EmpDto updateEmp, Dept updateDept) {
        this.empno = updateEmp.getEmpno();
        this.ename = updateEmp.getEname();
        this.job = updateEmp.getJob();
        this.mgr = updateEmp.getMgr();
        this.hiredate = updateEmp.getHiredate();
        this.sal = updateEmp.getSal();
        this.comm = updateEmp.getComm();
        this.dept = updateDept;
    }
}