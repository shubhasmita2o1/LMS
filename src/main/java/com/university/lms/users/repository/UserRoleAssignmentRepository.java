package com.university.lms.users.repository;

import com.university.lms.users.entity.UserRoleAssignment;
import com.university.lms.users.enums.ScopeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRoleAssignmentRepository extends JpaRepository<UserRoleAssignment, Long> {

    List<UserRoleAssignment> findByUserIdAndIsActiveTrue(Long userId);

    List<UserRoleAssignment> findByUserIdAndScopeTypeAndScopeIdAndIsActiveTrue(
            Long userId, ScopeType scopeType, Long scopeId);

    @Query("""
            SELECT ura FROM UserRoleAssignment ura
            JOIN FETCH ura.role r
            LEFT JOIN FETCH r.permissions
            WHERE ura.user.id = :userId
              AND ura.isActive = true
              AND (ura.validFrom IS NULL OR ura.validFrom <= CURRENT_TIMESTAMP)
              AND (ura.validTo IS NULL OR ura.validTo >= CURRENT_TIMESTAMP)
            """)
    List<UserRoleAssignment> findActiveAssignmentsWithPermissions(@Param("userId") Long userId);
}
