package edu.ccrm.domain;

import java.util.Objects;

// Immutable value class for course code
public final class CourseCode {
    private final String value;
    public CourseCode(String value) {
        if (value == null || value.isBlank()) throw new IllegalArgumentException("Invalid course code");
        this.value = value.toUpperCase();
    }
    public String value() { return value; }
    @Override public String toString() { return value; }
    @Override public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CourseCode)) return false;
        CourseCode that = (CourseCode) o;
        return value.equals(that.value);
    }
    @Override public int hashCode() { return Objects.hash(value); }
}
