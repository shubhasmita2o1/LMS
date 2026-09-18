package com.university.lms.users.entity;

import com.university.lms.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

/**
 * Named role that groups a set of permissions.
 * Roles themselves are not scoped — scoping happens on UserRoleAssignment.
 */
@Entity
@Table(name = "roles", indexes = {
        @Index(name = "idx_role_code", columnList = "code", unique = true)
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role extends BaseEntity {

    /**
     * Unique machine-readable code.
     * e.g. "SUPER_ADMIN", "FACULTY", "HOD", "STUDENT"
     */
    @Column(nullable = false, unique = true, length = 50)
    private String code;

    @Column(nullable = false, length = 100)
    private String name;

    @Column(length = 500)
    private String description;

    /**
     * System roles cannot be deleted or have their core permissions changed easily.
     */
    @Column(name = "is_system_role", nullable = false)
    @Builder.Default
    private Boolean isSystemRole = false;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "role_permissions",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    @Builder.Default
    private Set<Permission> permissions = new HashSet<>();
}
