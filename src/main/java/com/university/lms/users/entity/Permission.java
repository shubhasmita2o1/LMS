package com.university.lms.users.entity;

import com.university.lms.common.BaseEntity;
import com.university.lms.users.enums.PermissionAction;
import com.university.lms.users.enums.ResourceType;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "permissions", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"resource", "action"})
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Permission extends BaseEntity {

    @Column(nullable = false, length = 100)
    private String name;                    // e.g. "COURSE_CREATE"

    @Column(length = 255)
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 50)
    private ResourceType resource;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    private PermissionAction action;
}
