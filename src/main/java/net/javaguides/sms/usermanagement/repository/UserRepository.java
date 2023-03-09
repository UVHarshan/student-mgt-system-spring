package net.javaguides.sms.usermanagement.repository;

import net.javaguides.sms.usermanagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long > {
}
