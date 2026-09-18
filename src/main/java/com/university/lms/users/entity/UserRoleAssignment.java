package com.university.lms.users.entity;

import com.university.lms.common.BaseEntity;
import com.university.lms.users.enums.ScopeType;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

/**
 * Links a User to a Role within a specific academic scope.
 *
 * Examples:
 * - User A is FACULTY scoped to DEPARTMENT 12
 * - User A is also HOD scoped to DEPARTMENT 12
 * - User B is STUDENT scoped to PROGRAM 5
 * - User C is SUPER_ADMIN scoped to GLOBAL (scopeId = null)
 *
 * This design supports:
 * - Multiple roles per user
 * - Different scopes for the same role on different users
 * - Future resource ownership (a faculty "owns" a course via COURSE scope)
 */
@Entity
@Table(name = "user_role_assignments", indexes = {
        @Index(name = "idx_ura_user", columnList = "user_id"),
        @Index(name = "idx_ura_role", columnList = "role_id"),
        @Index(name = "idx_ura_scope", columnList = "scope_type, scope_id"),
        @Index(name = "idx_ura_user_role_scope", columnList = "user_id, role_id, scope_type, scope_id", unique = true)
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserRoleAssignment extends BaseEntity {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    /**
     * Hierarchical level of this assignment.
     */
    @Enumerated(EnumType.STRING)
    @Column(name = "scope_type", nullable = false, length = 30)
    private ScopeType scopeType;

    /**
     * ID of the scoped entity (university_id, campus_id, department_id, course_id, etc.).
     * Null when scopeType = GLOBAL.
     */
    @Column(name = "scope_id")
    private Long scopeId;

    /**
     * Optional validity window for temporary role assignments
     * (e.g. visiting faculty, acting HOD).
     */
    @Column(name = "valid_from")
    private Instant validFrom;

    @Column(name = "valid_to")
    private Instant validTo;

    /**
     * Soft control – assignment can be deactivated without deletion.
     * (isActive is already inherited from BaseEntity)
     */
}
