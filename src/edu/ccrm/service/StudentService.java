package edu.ccrm.service;

import edu.ccrm.domain.Student;
import java.util.*;

public class StudentService {
    private final Map<String, Student> store = new HashMap<>(); // id -> student

    public Student addStudent(String id, String regNo, String fullName, String email) {
        if (store.containsKey(id)) throw new IllegalArgumentException("Student with id exists");
        Student s = new Student(id, regNo, fullName, email);
        store.put(id, s);
        return s;
    }

    public Optional<Student> findById(String id) { return Optional.ofNullable(store.get(id)); }
    public List<Student> listAll() { return new ArrayList<>(store.values()); }
}
