package com.university.lms.users.enums;

/**
 * Defines the hierarchical level at which a role assignment is scoped.
 * GLOBAL = platform-wide (Super Admin)
 * UNIVERSITY / CAMPUS / SCHOOL / DEPARTMENT / PROGRAM / COURSE = academic hierarchy
 */
public enum ScopeType {
    GLOBAL,
    UNIVERSITY,
    CAMPUS,
    SCHOOL,
    DEPARTMENT,
    PROGRAM,
    COURSE,
    SECTION
}
