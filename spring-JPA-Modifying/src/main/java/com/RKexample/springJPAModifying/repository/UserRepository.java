package com.RKexample.springJPAModifying.repository;

import com.RKexample.springJPAModifying.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends JpaRepository<Users,Long> {

    @Modifying
    @Transactional
    @Query("UPDATE Users u SET u.email = :email WHERE u.id = :id")
    int updateEmailById(@Param("id") Long id,@Param("email") String email);

    @Modifying
    @Transactional
    @Query("DELETE FROM Users u WHERE u.age > :age")
    int deleteUserOlderThan(@Param("age") int age);
}
