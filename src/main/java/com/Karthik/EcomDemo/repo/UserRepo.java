package com.Karthik.EcomDemo.repo;

import com.Karthik.EcomDemo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User,Long> {
}
