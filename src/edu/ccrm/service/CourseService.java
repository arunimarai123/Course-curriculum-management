package edu.ccrm.service;

import edu.ccrm.domain.Course;
import java.util.*;

public class CourseService {
    private final Map<String, Course> store = new HashMap<>(); // code -> course

    public Course addCourse(Course c) {
        String code = c.getCode().toString();
        if (store.containsKey(code)) throw new IllegalArgumentException("Course exists: " + code);
        store.put(code, c);
        return c;
    }

    public Optional<Course> findByCode(String code) { return Optional.ofNullable(store.get(code)); }
    public List<Course> listAll() { return new ArrayList<>(store.values()); }
}
