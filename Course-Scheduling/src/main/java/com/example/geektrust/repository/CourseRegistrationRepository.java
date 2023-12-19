/**
 * Author: Lokesh Bisht
 */

package com.example.geektrust.repository;

import com.example.geektrust.models.CourseRegistration;

import java.util.HashMap;

public class CourseRegistrationRepository {

    private static CourseRegistrationRepository courseRegistrationRepository;

    private final HashMap<String, Integer> courseOfferingIdToRegistrationCountHashMap;

    private final HashMap<String, CourseRegistration> courseRegistrationIdToCourseRegistrationHashMap;

    private CourseRegistrationRepository() {
        courseOfferingIdToRegistrationCountHashMap = new HashMap<>();
        courseRegistrationIdToCourseRegistrationHashMap = new HashMap<>();
    }

    public static CourseRegistrationRepository getInstance() {
        if (courseRegistrationRepository == null) {
            return courseRegistrationRepository = new CourseRegistrationRepository();
        }
        return courseRegistrationRepository;
    }

    public HashMap<String, Integer> getCourseOfferingIdToRegistrationCountHashMap() {
        return courseOfferingIdToRegistrationCountHashMap;
    }

    public HashMap<String, CourseRegistration> getCourseRegistrationIdToCourseRegistrationHashMap() {
        return courseRegistrationIdToCourseRegistrationHashMap;
    }

    public void saveEmployeeCourseRegistration(CourseRegistration courseRegistration) {
        String courseOfferingId = courseRegistration.getCourseOfferingId();
        int totalRegistrations = 1;
        if (courseOfferingIdToRegistrationCountHashMap.containsKey(courseOfferingId)) {
            totalRegistrations = courseOfferingIdToRegistrationCountHashMap.get(courseOfferingId) + 1;
        }
        courseOfferingIdToRegistrationCountHashMap.put(courseOfferingId, totalRegistrations);
        courseRegistrationIdToCourseRegistrationHashMap.put(courseRegistration.getCourseRegistrationId(), courseRegistration);
    }

    public void deleteCourseRegistration(CourseRegistration courseRegistration) {
        String courseOfferingId = courseRegistration.getCourseOfferingId();
        String courseRegistrationId = courseRegistration.getCourseRegistrationId();
        int totalRegistrations = courseOfferingIdToRegistrationCountHashMap.get(courseOfferingId) - 1;
        courseOfferingIdToRegistrationCountHashMap.put(courseOfferingId, totalRegistrations);
        courseRegistrationIdToCourseRegistrationHashMap.remove(courseRegistrationId);
    }

    public void updateCourseRegistration(String courseRegistrationId, CourseRegistration courseRegistration) {
        courseRegistrationIdToCourseRegistrationHashMap.put(courseRegistrationId, courseRegistration);
    }
}
