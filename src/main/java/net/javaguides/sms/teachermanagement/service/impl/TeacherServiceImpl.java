package net.javaguides.sms.teachermanagement.service.impl;

import net.javaguides.sms.teachermanagement.entity.Teacher;
import net.javaguides.sms.teachermanagement.repository.TeacherRepository;
import net.javaguides.sms.teachermanagement.service.TeacherService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {

    private TeacherRepository teacherRepository;

    public TeacherServiceImpl(TeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }


    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }
}
