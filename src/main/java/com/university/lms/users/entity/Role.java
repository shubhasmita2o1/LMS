package com.university.lms.users.entity;

import com.university.lms.common.BaseEntity;
import com.university.lms.users.enums.RoleType;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "roles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Role extends BaseEntity {

    @Column(nullable = false, unique = true, length = 50)
    private String name;                    // e.g. "FACULTY"

    @Column(length = 255)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "role_type", nullable = false, unique = true, length = 40)
    private RoleType roleType;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "role_permissions",
            joinColumns = @JoinColumn(name = "role_id"),
            inverseJoinColumns = @JoinColumn(name = "permission_id")
    )
    @Builder.Default
    private Set<Permission> permissions = new HashSet<>();
}
