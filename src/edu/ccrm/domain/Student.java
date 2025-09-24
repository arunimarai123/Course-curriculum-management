package edu.ccrm.domain;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Student extends Person {
    private final String regNo;
    private Status status;
    private final List<String> enrolledCourseCodes = new ArrayList<>();
    private LocalDate dob;

    public enum Status { ACTIVE, INACTIVE, SUSPENDED }

    public Student(String id, String regNo, String fullName, String email) {
        super(id, fullName, email);
        this.regNo = regNo;
        this.status = Status.ACTIVE;
    }

    public String getRegNo() { return regNo; }
    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public void enrollCourse(String courseCode) {
        Objects.requireNonNull(courseCode);
        if (!enrolledCourseCodes.contains(courseCode)) enrolledCourseCodes.add(courseCode);
    }
    public void unenrollCourse(String courseCode) { enrolledCourseCodes.remove(courseCode); }
    public List<String> getEnrolledCourseCodes() { return Collections.unmodifiableList(enrolledCourseCodes); }

    @Override
    public String profile() {
        return String.format("Student: %s | RegNo: %s | Status: %s", fullName, regNo, status);
    }
}
