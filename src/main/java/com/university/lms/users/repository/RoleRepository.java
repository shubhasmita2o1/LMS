package com.university.lms.users.repository;

import com.university.lms.users.entity.Role;
import com.university.lms.users.enums.RoleType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

    Optional<Role> findByRoleType(RoleType roleType);

    Optional<Role> findByName(String name);

    boolean existsByRoleType(RoleType roleType);
}
