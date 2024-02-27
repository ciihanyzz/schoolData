package com.cihanyildiz.controller;

import com.cihanyildiz.entity.Teacher;
import com.cihanyildiz.service.TeacherService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    private final TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        this.teacherService = teacherService;
    }

    @GetMapping
    public ResponseEntity<List<Teacher>> getAllTeachers(){
        return ResponseEntity.ok(teacherService.getAllTeacher());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getTeacherById(@PathVariable Long id){
        return ResponseEntity.ok(teacherService.getTeacherById(id));
    }

    @PostMapping
    public ResponseEntity<Teacher> createTeacher(@RequestBody Teacher teacher){
        return new ResponseEntity<>(teacherService.createTeacher(teacher), HttpStatus.CREATED);
            // burda niye " new ResponseEntity" de diğerlerinde değil
    }

    @PutMapping("/{id}")
    public ResponseEntity<Teacher> updatedTeacher(@PathVariable Long id, @RequestBody Teacher teacher){
        return ResponseEntity.ok(teacherService.updateTeacher(id,teacher));
    }

    @DeleteMapping
    public void deleteTeacher(@PathVariable Long id){
        teacherService.deleteTeacher(id);
    }
}
