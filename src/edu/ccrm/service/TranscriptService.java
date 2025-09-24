package edu.ccrm.service;

import edu.ccrm.domain.Enrollment;
import edu.ccrm.domain.Grade;

import java.util.List;

public class TranscriptService {
    public static double computeGPA(List<Enrollment> enrollments, java.util.function.ToIntFunction<Enrollment> creditsFor) {
        double totalPoints = 0.0;
        int totalCredits = 0;
        for (Enrollment e : enrollments) {
            Grade g = e.getGrade();
            if (g == null) continue;
            int credits = creditsFor.applyAsInt(e);
            totalCredits += credits;
            totalPoints += g.points() * credits;
        }
        return totalCredits == 0 ? 0.0 : totalPoints / totalCredits;
    }
}
