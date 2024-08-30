/*
 * @ (#) CourseList.java         1.0 8/30/2024
 *
 * Copyright (c) 2024.IUH .All right reserved.
 */
package edu.iuh.fit.ktpm;

import java.util.*;

/*
 * @description:This class represents a bank with many bank accounts
 * @author: Tran Thi Hai Yen
 * @date:   8/30/2024
 * @version: 1.0
 * @created: 8/30/2024
 */
public class CourseList {
    private Course[] courses;
    private int count;

    /**
     * Constructor for CourseList
     *
     * @param size the size of the array
     * @throws IllegalArgumentException if the size is less than or equal to 0
     */
    public CourseList(int size) {
        if (size <= 0) {
            throw new IllegalArgumentException("Length of the array must be greater than 0");
        }
        courses = new Course[size];
        count = 0;
    }

    /**
     * Get the list of courses
     *
     * @return the list of courses
     */
    public Course[] getCourses() {
        return Arrays.copyOf(courses, count);
    }

    /**
     * Add a course to the list
     *
     * @param course the course to be added
     * @return true if the course is added successfully, false otherwise
     */
    public boolean addCourse(Course course) {
        if (course == null || count == courses.length || isExist(course)) {
            return false;
        }
        courses[count++] = course;
        return true;
    }

    /**
     * Check if the course already exists in the list
     *
     * @param course the course to be checked
     * @return true if the course exists, false otherwise
     */
    private boolean isExist(Course course) {
        if (course == null) return false;
        return Arrays.stream(courses, 0, count).anyMatch(course::equals);
    }

    /**
     * Remove a course from the list
     *
     * @param id the id of the course to be removed
     * @return true if the course is removed successfully, false otherwise
     */
    public boolean removeCourse(String id) {
        if (id == null) return false;
        for (int i = 0; i < count; i++) {
            if (courses[i].getId().equals(id)) {
                for (int j = i; j < count - 1; j++) {
                    courses[j] = courses[j + 1];
                }
                courses[--count] = null;
                return true;
            }
        }
        return false;
    }

    /**
     * Search a course by id
     *
     * @param id the id of the course to be searched
     * @return the course if found, null otherwise
     */
    public Course searchCourseById(String id) {
        if (id == null) return null;
        for (int i = 0; i < count; i++) {
            if (courses[i].getId().equals(id)) {
                return courses[i];
            }
        }
        return null;
    }

    /**
     * Search courses by title
     *
     * @param keyword the keyword to search
     * @return an array of courses that match the keyword, or null if none found
     */
    public Course[] searchCourseByTitle(String keyword) {
        if (keyword == null || keyword.isEmpty()) return null;
        List<Course> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (courses[i].getTitle().toLowerCase().contains(keyword.toLowerCase())) {
                result.add(courses[i]);
            }
        }
        return result.isEmpty() ? null : result.toArray(new Course[0]);
    }

    /**
     * Search courses by department
     *
     * @param department the department to search
     * @return an array of courses that match the department, or null if none found
     */
    public Course[] searchCourseByDepartment(String department) {
        if (department == null || department.isEmpty()) return null;
        List<Course> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (courses[i].getDepartment().equals(department)) {
                result.add(courses[i]);
            }
        }
        return result.isEmpty() ? null : result.toArray(new Course[0]);
    }

    /**
     * Sort courses by title
     *
     * @return an array of courses sorted by title
     */
    public Course[] sortCoursesByTitle() {
        Course[] result = Arrays.copyOf(courses, count);
        Arrays.sort(result, Comparator.comparing(Course::getTitle, String::compareToIgnoreCase));
        return result;
    }

    /**
     * Find courses with the maximum credit
     *
     * @return an array of courses with maximum credit
     */
    public Course[] findCoursesWithMaxCredit() {
        if (count == 0) return null;
        int maxCredit = Arrays.stream(courses, 0, count).mapToInt(Course::getCredit).max().orElse(0);
        List<Course> maxCreditCourses = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            if (courses[i].getCredit() == maxCredit) {
                maxCreditCourses.add(courses[i]);
            }
        }
        return maxCreditCourses.isEmpty() ? null : maxCreditCourses.toArray(new Course[0]);
    }

    /**
     * Find the department with the most courses
     *
     * @return the department with the most courses
     */
    public String findDepartmentWithMostCourses() {
        if (count == 0) return null;
        Map<String, Integer> departmentCount = new HashMap<>();
        for (int i = 0; i < count; i++) {
            departmentCount.put(courses[i].getDepartment(), departmentCount.getOrDefault(courses[i].getDepartment(), 0) + 1);
        }
        return departmentCount.entrySet().stream().max(Map.Entry.comparingByValue()).map(Map.Entry::getKey).orElse(null);
    }

    /**
     * Print all courses in the list
     */
    public void printCourses() {
        System.out.printf("%-10s%-30s%5s\t%-10s\n", "ID", "Title", "Credit", "Department");
        for (int i = 0; i < count; i++) {
            System.out.println(courses[i]);
        }
    }
}


