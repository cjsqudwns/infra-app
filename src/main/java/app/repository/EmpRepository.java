package app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import app.entity.Emp;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpRepository extends JpaRepository<Emp, Integer>{

}

