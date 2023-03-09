package net.javaguides.sms.studentmanagement.repository;

import net.javaguides.sms.studentmanagement.entity.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void itShouldCheckIfStudentExistsByEmail() {
        //given
        String email = "ranja@gmail.com";
        Student student = new Student("Ranja", "Ramana", email);
        underTest.save(student);

        //when
        boolean result = underTest.selectExistsEmail(email);

        //then
        assertThat(result).isTrue();
    }
}