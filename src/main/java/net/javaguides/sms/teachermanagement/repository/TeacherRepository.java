package net.javaguides.sms.teachermanagement.repository;

import net.javaguides.sms.teachermanagement.entity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
