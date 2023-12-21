/**
 * Copyright (C) 2023 Lokesh Bisht
 *
 * Licensed under the Apache Software License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */

package dev.lokeshbisht.service.impl;

import dev.lokeshbisht.enums.Errors;
import dev.lokeshbisht.exceptions.ValidationException;
import dev.lokeshbisht.models.Course;
import dev.lokeshbisht.repository.CourseRepository;
import dev.lokeshbisht.service.CourseService;

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
