package com.university.lms.users.repository;

import com.university.lms.users.entity.Permission;
import com.university.lms.users.enums.PermissionAction;
import com.university.lms.users.enums.ResourceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Long> {

    Optional<Permission> findByResourceAndAction(ResourceType resource, PermissionAction action);

    boolean existsByResourceAndAction(ResourceType resource, PermissionAction action);
}
