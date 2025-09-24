package edu.ccrm.service;

import edu.ccrm.domain.Enrollment;
import edu.ccrm.domain.Student;
import edu.ccrm.domain.Course;
import edu.ccrm.domain.Grade;
import edu.ccrm.exception.DuplicateEnrollmentException;

import java.util.*;

public class EnrollmentService {
    private final Map<String, List<Enrollment>> enrollmentsByStudent = new HashMap<>();

    public Enrollment enroll(Student student, Course course) {
        List<Enrollment> list = enrollmentsByStudent.computeIfAbsent(student.getId(), k -> new ArrayList<>());
        for (Enrollment e : list) {
            if (e.getCourseCode().equals(course.getCode().toString())) {
                throw new DuplicateEnrollmentException("Already enrolled: " + course.getCode());
            }
        }
        Enrollment en = new Enrollment(student.getId(), course.getCode().toString());
        list.add(en);
        student.enrollCourse(course.getCode().toString());
        return en;
    }

    public void recordMarks(String studentId, String courseCode, double marks) {
        List<Enrollment> list = enrollmentsByStudent.get(studentId);
        if (list == null) throw new IllegalArgumentException("No enrollments for student");
        for (Enrollment e : list) {
            if (e.getCourseCode().equals(courseCode)) {
                e.setMarks(marks);
                return;
            }
        }
        throw new IllegalArgumentException("Enrollment not found");
    }

    public List<Enrollment> listEnrollments(String studentId) {
        return enrollmentsByStudent.getOrDefault(studentId, Collections.emptyList());
    }
}
