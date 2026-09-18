package com.university.lms.users.entity;

import com.university.lms.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

/**
 * Fine-grained permission using module.action style.
 * Example codes: "course.create", "exam.grade", "attendance.mark", "user.manage"
 */
@Entity
@Table(name = "permissions", indexes = {
        @Index(name = "idx_permission_code", columnList = "code", unique = true),
        @Index(name = "idx_permission_module", columnList = "module")
})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Permission extends BaseEntity {

    /**
     * Unique machine-readable code in module.action format.
     * e.g. "course.create", "exam.publish", "fee.refund"
     */
    @Column(nullable = false, unique = true, length = 100)
    private String code;

    @Column(nullable = false, length = 150)
    private String name;

    @Column(length = 500)
    private String description;

    /**
     * Logical module / domain this permission belongs to.
     * e.g. "course", "exam", "attendance", "user", "finance"
     */
    @Column(nullable = false, length = 50)
    private String module;

    /**
     * Action part of the permission.
     * e.g. "create", "read", "update", "delete", "grade", "publish", "approve"
     */
    @Column(nullable = false, length = 50)
    private String action;
}
