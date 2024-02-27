package com.cihanyildiz.service;

import com.cihanyildiz.entity.Student;

import java.util.List;

public interface StudentService {

    Student createStudent(Student student);
    List<Student> getAllStudent();
    Student getStudentById(Long id);
    Student updateStudent(Long id,Student student);
    void deleteStudent(Long id);
}
