package edu.ccrm.domain;

import java.util.Objects;

public final class Course {
    private final CourseCode code;
    private final String title;
    private final int credits;
    private final String instructor;
    private final Semester semester;
    private final String department;

    private Course(Builder b) {
        this.code = b.code;
        this.title = b.title;
        this.credits = b.credits;
        this.instructor = b.instructor;
        this.semester = b.semester;
        this.department = b.department;
    }

    public static class Builder {
        private CourseCode code;
        private String title;
        private int credits;
        private String instructor;
        private Semester semester;
        private String department;

        public Builder code(String code) { this.code = new CourseCode(code); return this; }
        public Builder title(String title) { this.title = title; return this; }
        public Builder credits(int credits) { this.credits = credits; return this; }
        public Builder instructor(String instructor) { this.instructor = instructor; return this; }
        public Builder semester(Semester semester) { this.semester = semester; return this; }
        public Builder department(String department) { this.department = department; return this; }
        public Course build() {
            Objects.requireNonNull(code); Objects.requireNonNull(title);
            if (credits <= 0) throw new IllegalArgumentException("credits must be positive");
            return new Course(this);
        }
    }

    public CourseCode getCode() { return code; }
    public String getTitle() { return title; }
    public int getCredits() { return credits; }
    public String getInstructor() { return instructor; }
    public Semester getSemester() { return semester; }
    public String getDepartment() { return department; }

    @Override
    public String toString() {
        return String.format("%s - %s (%d credits) [%s]", code, title, credits, semester);
    }
}
