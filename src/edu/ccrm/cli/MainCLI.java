package edu.ccrm.cli;

import edu.ccrm.service.StudentService;
import edu.ccrm.service.CourseService;
import edu.ccrm.service.EnrollmentService;
import edu.ccrm.domain.Student;
import edu.ccrm.domain.Course;
import edu.ccrm.domain.Semester;

import java.util.List;
import java.util.Scanner;

public class MainCLI {
    private static final Scanner scanner = new Scanner(System.in);
    private static final StudentService studentService = new StudentService();
    private static final CourseService courseService = new CourseService();
    private static final EnrollmentService enrollmentService = new EnrollmentService();

    public static void main(String[] args) {
        seedSampleData();
        boolean exit = false;
        while (!exit) {
            printMenu();
            String choice = scanner.nextLine().trim();
            switch (choice) {
                case "1": manageStudents(); break;
                case "2": manageCourses(); break;
                case "3": manageEnroll(); break;
                case "4": listAll(); break;
                case "0": exit = true; break;
                default: System.out.println("Invalid choice"); break;
            }
        }
        System.out.println("Bye!"); 
    }

    private static void printMenu() {
        System.out.println("--- CCRM ---");
        System.out.println("1) Manage Students");
        System.out.println("2) Manage Courses");
        System.out.println("3) Enroll Student to Course");
        System.out.println("4) List Students & Courses");
        System.out.println("0) Exit");
        System.out.print("> ");
    }

    private static void manageStudents() {
        System.out.print("Enter id: "); var id = scanner.nextLine().trim();
        System.out.print("RegNo: "); var reg = scanner.nextLine().trim();
        System.out.print("Full Name: "); var name = scanner.nextLine().trim();
        System.out.print("Email: "); var email = scanner.nextLine().trim();
        Student s = studentService.addStudent(id, reg, name, email);
        System.out.println("Added: " + s.profile());
    }

    private static void manageCourses() {
        System.out.print("Course code: "); var code = scanner.nextLine().trim();
        System.out.print("Title: "); var title = scanner.nextLine().trim();
        System.out.print("Credits: "); var creditsStr = scanner.nextLine().trim();
        int credits = Integer.parseInt(creditsStr);
        System.out.print("Instructor: "); var instr = scanner.nextLine().trim();
        System.out.print("Semester (SPRING,SUMMER,FALL): "); var sem = scanner.nextLine().trim();
        Course c = new Course.Builder()
                .code(code)
                .title(title)
                .credits(credits)
                .instructor(instr)
                .semester(Semester.valueOf(sem.toUpperCase()))
                .department("Main")
                .build();
        courseService.addCourse(c);
        System.out.println("Added: " + c);
    }

    private static void manageEnroll() {
        System.out.print("Student id: "); var sid = scanner.nextLine().trim();
        System.out.print("Course code: "); var code = scanner.nextLine().trim();
        var sOpt = studentService.findById(sid);
        var cOpt = courseService.findByCode(code);
        if (sOpt.isEmpty()) { System.out.println("Student not found"); return; }
        if (cOpt.isEmpty()) { System.out.println("Course not found"); return; }
        enrollmentService.enroll(sOpt.get(), cOpt.get());
        System.out.println("Enrollment recorded"); 
    }

    private static void listAll() {
        System.out.println("Students:");
        for (Student s: studentService.listAll()) System.out.println(" - " + s);
        System.out.println("Courses:");
        for (Course c: courseService.listAll()) System.out.println(" - " + c);
    }

    private static void seedSampleData() {
        try {
            studentService.addStudent("s1", "2025STU001", "John Doe", "john@example.com");
            studentService.addStudent("s2", "2025STU002", "Alice Rao", "alice@example.com");
            var c1 = new Course.Builder().code("CS101").title("Intro to CS").credits(3)
                    .instructor("Prof Smith").semester(Semester.SPRING).department("CS").build();
            var c2 = new Course.Builder().code("MA101").title("Calculus I").credits(4)
                    .instructor("Dr. Kumar").semester(Semester.SPRING).department("Math").build();
            courseService.addCourse(c1); courseService.addCourse(c2);
        } catch (Exception e) {
            // ignore seed errors
        }
    }
}
