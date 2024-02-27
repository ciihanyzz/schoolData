package com.cihanyildiz.controller;

import com.cihanyildiz.entity.Student;
import com.cihanyildiz.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){
        return  ResponseEntity.ok(studentService.getAllStudent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@RequestBody Student student){
        return new ResponseEntity<>(studentService.createStudent(student), HttpStatus.CREATED);
    }

   @PutMapping("/{id}")
    public ResponseEntity<Student> updatedStudent(@PathVariable Long id, @RequestBody Student student ){
        return ResponseEntity.ok(studentService.updateStudent(id,student));
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id ){
        studentService.deleteStudent(id);
    }
                                            // dün konuşmuştuk id yi silsek bile numarasını kimse kullanılamıyor
                                            //  buraya @RequestBody Student student eklsek ne değişir

}
