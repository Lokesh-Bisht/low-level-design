/**
 * Author: Lokesh Bisht
 */

package dev.lokeshbisht.CourseScheduling.repository;

import dev.lokeshbisht.CourseScheduling.models.Course;

import java.util.HashMap;
import java.util.HashSet;

public class CourseRepository {

    private static CourseRepository courseRepository;

    private HashSet<String> instructors;

    private HashMap<String, Course> courseOfferingIdToCourseHashMap;

    private CourseRepository() {
        instructors = new HashSet<>();
        courseOfferingIdToCourseHashMap = new HashMap<>();
    }

    public static CourseRepository getInstance() {
        if (courseRepository == null) {
            return courseRepository = new CourseRepository();
        }
        return courseRepository;
    }

    public HashSet<String> getInstructors() {
        return instructors;
    }

    public HashMap<String, Course> getCourseOfferingIdToCourseHashMap() {
        return courseOfferingIdToCourseHashMap;
    }

    public void saveInstructor(String instructor) {
        instructors.add(instructor);
    }

    public void saveCourse(String courseOfferingId, Course course) {
        courseOfferingIdToCourseHashMap.put(courseOfferingId, course);
    }
}
