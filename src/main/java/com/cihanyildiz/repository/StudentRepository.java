package com.cihanyildiz.repository;

import com.cihanyildiz.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

  //  public Student findStudentByFirstName(String firstName);

}
