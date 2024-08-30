/*
 * @ (#) TestCourse.java         1.0 8/30/2024
 *
 * Copyright (c) 2024.IUH .All right reserved.
 */
package edu.iuh.fit.ktpm;

import java.util.InputMismatchException;
import java.util.Scanner;

/*
 * @description:This class represents a bank with many bank accounts
 * @author: Tran Thi Hai Yen
 * @date:   8/30/2024
 * @version: 1.0
 * @created: 8/30/2024
 */
public class TestCourse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CourseList courseList = new CourseList(10);

        initData(courseList);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Add Course");
            System.out.println("2. Remove Course");
            System.out.println("3. Search Course by ID");
            System.out.println("4. Search Courses by Title");
            System.out.println("5. Search Courses by Department");
            System.out.println("6. Sort Courses by Title");
            System.out.println("7. Find Courses with Maximum Credit");
            System.out.println("8. Find Department with Most Courses");
            System.out.println("9. Print All Courses");
            System.out.println("0. Exit");
            System.out.print("Choose an option: ");

            int choice = 0;
            try {
                choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline
            } catch (InputMismatchException e) {
                scanner.nextLine(); // Clear invalid input
                System.out.println("Invalid choice. Please enter a number between 0 and 9.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("Enter Course ID: ");
                    String id = scanner.nextLine();
                    System.out.print("Enter Course Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Course Credit: ");
                    int credit = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Course Department: ");
                    String department = scanner.nextLine();
                    try {
                        Course course = new Course(id, title, credit, department);
                        if (courseList.addCourse(course)) {
                            System.out.println("Course added successfully.");
                        } else {
                            System.out.println("Failed to add course. It may already exist or the list is full.");
                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 2:
                    System.out.print("Enter Course ID to remove: ");
                    id = scanner.nextLine();
                    if (courseList.removeCourse(id)) {
                        System.out.println("Course removed successfully.");
                    } else {
                        System.out.println("Failed to remove course. Course ID not found.");
                    }
                    break;
                case 3:
                    System.out.print("Enter Course ID to search: ");
                    id = scanner.nextLine();
                    Course course = courseList.searchCourseById(id);
                    if (course != null) {
                        System.out.println("Course found: " + course);
                    } else {
                        System.out.println("Course not found.");
                    }
                    break;
                case 4:
                    System.out.print("Enter Course Title keyword to search: ");
                    String keyword = scanner.nextLine();
                    Course[] coursesByTitle = courseList.searchCourseByTitle(keyword);
                    if (coursesByTitle != null) {
                        System.out.println("Courses found:");
                        for (Course c : coursesByTitle) {
                            System.out.println(c);
                        }
                    } else {
                        System.out.println("No courses found.");
                    }
                    break;
                case 5:
                    System.out.print("Enter Department to search: ");
                    department = scanner.nextLine();
                    Course[] coursesByDepartment = courseList.searchCourseByDepartment(department);
                    if (coursesByDepartment != null) {
                        System.out.println("Courses found:");
                        for (Course c : coursesByDepartment) {
                            System.out.println(c);
                        }
                    } else {
                        System.out.println("No courses found.");
                    }
                    break;
                case 6:
                    Course[] sortedCourses = courseList.sortCoursesByTitle();
                    System.out.println("Sorted Courses:");
                    for (Course c : sortedCourses) {
                        System.out.println(c);
                    }
                    break;
                case 7:
                    Course[] maxCreditCourses = courseList.findCoursesWithMaxCredit();
                    if (maxCreditCourses != null) {
                        System.out.println("Courses with maximum credit:");
                        for (Course c : maxCreditCourses) {
                            System.out.println(c);
                        }
                    } else {
                        System.out.println("No courses found.");
                    }
                    break;
                case 8:
                    String departmentWithMostCourses = courseList.findDepartmentWithMostCourses();
                    if (departmentWithMostCourses != null) {
                        System.out.println("Department with most courses: " + departmentWithMostCourses);
                    } else {
                        System.out.println("No courses found.");
                    }
                    break;
                case 9:
                    courseList.printCourses();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please enter a number between 0 and 9.");
            }
        }
    }

    private static void initData(CourseList courseList) {
        Course course1 = new Course("FIT101", "Java Programming", 3, "FIT");
        Course course2 = new Course("FIT102", "Web Programming", 3, "FIT");
        Course course3 = new Course("FIT103", "Database Programming", 3, "FIT");
        Course course4 = new Course("FIT104", "Mobile Programming", 3, "FIT");
        Course course5 = new Course("FIT105", "Software Engineering", 3, "FIT");
        Course course6 = new Course("FIT106", "Data Science", 3, "FIT");
        Course course7 = new Course("FIT107", "Machine Learning", 3, "FIT");
        Course course8 = new Course("FIT108", "Artificial Intelligence", 3, "FIT");

        courseList.addCourse(course1);
        courseList.addCourse(course2);
        courseList.addCourse(course3);
        courseList.addCourse(course4);
        courseList.addCourse(course5);
        courseList.addCourse(course6);
        courseList.addCourse(course7);
        courseList.addCourse(course8);
    }
}




