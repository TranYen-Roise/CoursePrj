/*
 * @ (#) Course.java         1.0 8/30/2024
 *
 * Copyright (c) 2024.IUH .All right reserved.
 */
package edu.iuh.fit.ktpm;

import java.util.Objects;

/*
 * @description:This class represents a bank with many bank accounts
 * @author: Tran Thi Hai Yen
 * @date:   8/30/2024
 * @version: 1.0
 * @created: 8/30/2024
 */
public class Course {
    private String id;
    private String title;
    private int credit;
    private String department;
    /**
     * Constructor for Course
     *
     * @param id         The course id
     * @param title      The course title
     * @param credit     The course credit (must be greater than 0)
     * @param department The department responsible for the course
     * @throws IllegalArgumentException if id length < 3, credit <= 0, or title is empty
     */
    public Course(String id, String title, int credit, String department) {
        if (id == null || id.length() < 3 || !id.matches("[A-Za-z0-9]+")) {
            throw new IllegalArgumentException("Invalid course ID. Must be at least 3 characters long and contain only letters and digits.");
        }
        if (title == null || title.isEmpty()) {
            throw new IllegalArgumentException("Course title cannot be empty.");
        }
        if (credit <= 0) {
            throw new IllegalArgumentException("Course credit must be greater than 0.");
        }
        if (department == null) {
            throw new IllegalArgumentException("Department cannot be null.");
        }

        this.id = id;
        this.title = title;
        this.credit = credit;
        this.department = department;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getCredit() {
        return credit;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return String.format("%-10s%-30s%5d\t%-10s", id, title, credit, department);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Course course = (Course) obj;
        return id.equals(course.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}


