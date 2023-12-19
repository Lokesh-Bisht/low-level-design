/**
 * Copyright (C) 2023 Lokesh Bisht
 *
 * Licensed under the Apache Software License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */

package com.example.geektrust.service.impl;

import com.example.geektrust.enums.Errors;
import com.example.geektrust.exceptions.ValidationException;
import com.example.geektrust.models.Course;
import com.example.geektrust.repository.CourseRepository;
import com.example.geektrust.service.CourseService;

public class CourseServiceImpl implements CourseService {

    private static CourseService courseService;

    private final CourseRepository courseRepository;

    private CourseServiceImpl() {
        this.courseRepository = CourseRepository.getInstance();
    }

    public static CourseService getInstance() {
        if (courseService == null) {
            return courseService = new CourseServiceImpl();
        }
        return courseService;
    }

    private void inputValidation(Course course) throws ValidationException {
        boolean hasInstructor = courseRepository.getInstructors().contains(course.getInstructor());
        if (course.getCourseName().isEmpty() || course.getInstructor().isEmpty() || course.getStartDate().isEmpty() || hasInstructor) {
            throw new ValidationException(Errors.INPUT_DATA_ERROR.name());
        }
    }

    @Override
    public String addCourse(Course course) {
        try {
            inputValidation(course);
        } catch (ValidationException ex) {
            return ex.getMessage();
        }
        String instructor = course.getInstructor();
        String courseOfferingId = "OFFERING-" + course.getCourseName() + "-" + instructor;
        course.setCourseOfferingId(courseOfferingId);
        courseRepository.saveInstructor(instructor);
        courseRepository.saveCourse(courseOfferingId, course);
        return course.getCourseOfferingId();
    }
}
