package com.cihanyildiz.service;

import com.cihanyildiz.entity.Teacher;

import java.util.List;

public interface TeacherService {

    Teacher createTeacher(Teacher teacher);
    List<Teacher> getAllTeacher();
    Teacher getTeacherById(Long id);
    Teacher updateTeacher(Long id, Teacher teacher);
    void deleteTeacher(Long id);

}
