package edu.ccrm.domain;

import java.time.LocalDateTime;

public class Enrollment {
    private final String studentId;
    private final String courseCode;
    private final LocalDateTime enrolledAt;
    private Double marks; // nullable until graded

    public Enrollment(String studentId, String courseCode) {
        this.studentId = studentId;
        this.courseCode = courseCode;
        this.enrolledAt = LocalDateTime.now();
    }

    public String getStudentId() { return studentId; }
    public String getCourseCode() { return courseCode; }
    public LocalDateTime getEnrolledAt() { return enrolledAt; }
    public Double getMarks() { return marks; }
    public void setMarks(Double marks) { this.marks = marks; }
    public Grade getGrade() { return marks == null ? null : Grade.fromScore(marks); }

    @Override
    public String toString() {
        return String.format("Enrollment[%s -> %s] marks=%s", studentId, courseCode, marks);
    }
}
