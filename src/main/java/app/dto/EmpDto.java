package app.dto;


import app.entity.Emp;
import lombok.Getter;
import lombok.ToString;


import java.time.LocalDate;


@ToString
@Getter
public class EmpDto {
    private Integer empno;
    private String ename;
    private String job;
    private Integer mgr;
    private LocalDate hiredate;
    private Double sal;
    private Double comm;
    private Integer deptno;


    public EmpDto(Integer empno, String ename, String job, Integer mgr, LocalDate hiredate, Double sal, Double comm, Integer deptno) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.sal = sal;
        this.comm = comm;
        this.deptno = deptno;
    }


    public static EmpDto of(Integer empno, String ename, String job, Integer mgr, LocalDate hiredate, Double sal, Double comm, Integer deptno) {
        return new EmpDto(empno, ename, job, mgr, hiredate, sal, comm, deptno);
    }


    public static EmpDto from(Emp emp){
        return of(emp.getEmpno(), emp.getEname(), emp.getJob(), emp.getMgr(), emp.getHiredate(), emp.getSal(), emp.getComm(), emp.getDept().getDeptno());
    }
}
