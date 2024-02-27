package com.cihanyildiz.service;

import com.cihanyildiz.entity.Teacher;
import com.cihanyildiz.repository.TeacherRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService{

    private final TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    @Override
    public Teacher createTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public List<Teacher> getAllTeacher() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id).orElse(null);
    }

    @Override
    public Teacher updateTeacher(Long id, Teacher teacher) {
        Optional<Teacher> existingTeacher = teacherRepository.findById(id);
        if (existingTeacher.isPresent()){
            Teacher updatedTeacher = existingTeacher.get();
            updatedTeacher.setFirstName(teacher.getFirstName());
            updatedTeacher.setLastName(teacher.getLastName());
            updatedTeacher.setEmail(teacher.getEmail());
            updatedTeacher.setPhoneNumber(teacher.getPhoneNumber());
            updatedTeacher.setBranch(teacher.getBranch());
            updatedTeacher.setSalary(teacher.getSalary());
            teacherRepository.save(updatedTeacher);

            return updatedTeacher;
        }
        return null;
    }

    @Override
    public void deleteTeacher(Long id) {
        teacherRepository.deleteById(id);
        // neden .deleteById     .delete değil

    }
}
