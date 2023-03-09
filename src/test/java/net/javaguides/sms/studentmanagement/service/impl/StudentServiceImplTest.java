package net.javaguides.sms.studentmanagement.service.impl;

import net.javaguides.sms.studentmanagement.entity.Student;
import net.javaguides.sms.studentmanagement.repository.StudentRepository;
import net.javaguides.sms.studentmanagement.service.StudentService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StudentServiceImplTest {

    @Mock private StudentRepository stuRepository;
    private StudentService underTest;

    @BeforeEach
    void setUp() {
        underTest = new StudentServiceImpl(stuRepository);
    }

    @Test
    void canGetAllStudents() {
        // when  (BDT Test style)
        underTest.getAllStudents();

        // then
        verify(stuRepository).findAll();
    }

    @Test
    void canSaveStudent() {
        // given
        Student student = new Student("Ranja", "Ramana", "ranja@gmail.com");

        // when
        underTest.saveStudent(student);    // Calling the method in the service class

        // then
        // Creating an ArgumentCaptor for Student(Entity) class
        ArgumentCaptor<Student> studentArgumentCaptor = ArgumentCaptor.forClass(Student.class);
        // Verify that save method in Student Repository was invoked using mock object and capture the argument passed to that method
        verify(stuRepository).save(studentArgumentCaptor.capture());
        // Get the captured value to a Student type object
        Student capturedStudent = studentArgumentCaptor.getValue();
        // Check whether the captured Student( the object which the student repository method received) is equal to
        // the object which was passed to the service method
        assertThat(capturedStudent).isEqualTo(student);
    }

    @Test
    @Disabled
    void getStudentById() {
        // given
        Long studentId = 5L;

        // when
        underTest.getStudentById(studentId);

        // then
        ArgumentCaptor<Long> idArgumentCaptor = ArgumentCaptor.forClass(Long.class);
        verify(stuRepository).findById(idArgumentCaptor.capture());
        Long capturedId  = idArgumentCaptor.getValue();
        assertThat(capturedId).isEqualTo(studentId);
    }

    @Test
    void canUpdateStudent() {
        //given
        Student student = new Student("Dasun", "Shanaka", "dasun@gmail.com");

        // when
        underTest.updateStudent(student);

        // then
        ArgumentCaptor<Student> studentArgumentCaptor = ArgumentCaptor.forClass(Student.class);
        verify(stuRepository).save(studentArgumentCaptor.capture());
        Student capturedStudent = studentArgumentCaptor.getValue();
        assertThat(capturedStudent).isEqualTo(student);
    }

    @Test
    @Disabled
    void deleteStudentById() {
    }
}