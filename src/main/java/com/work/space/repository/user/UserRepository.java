package com.work.space.repository.user;

import com.work.space.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Transactional
    @Modifying
    @Query("DELETE FROM User u WHERE u.phone=:phone")
    int delete(@Param("phone") Long phone);

    @Query("SELECT u FROM User u WHERE u.phone =:phone")
    Optional<User> getByPhone(@Param("phone") Long phone);
}
