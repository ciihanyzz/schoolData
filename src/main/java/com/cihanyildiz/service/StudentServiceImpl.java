package com.cihanyildiz.service;

import com.cihanyildiz.entity.Student;
import com.cihanyildiz.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(Student student) {
        Student newStudent = studentRepository.save(student);
        return newStudent;
    }

    @Override
    public List<Student> getAllStudent() {
        List<Student> allStudent = studentRepository.findAll();
        return allStudent;
    }

    @Override
    public Student getStudentById(Long id) {
        Student getStudent = studentRepository.findById(id).orElse(null);
        return getStudent;
    }

    @Override
    public Student updateStudent(Long id, Student student) {
        Optional<Student> existingStudent = studentRepository.findById(id);
        if (existingStudent.isPresent()){
            Student updatedStudent = existingStudent.get();
            updatedStudent.setFirstName(student.getFirstName());
            updatedStudent.setLastName(student.getLastName());
            updatedStudent.setGender(student.getGender());
            updatedStudent.setSchoolNumber(student.getSchoolNumber());
            updatedStudent.setSchoolClass(student.getSchoolClass());
            studentRepository.save(updatedStudent);

            return updatedStudent;

        }
        return null;
    }

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
