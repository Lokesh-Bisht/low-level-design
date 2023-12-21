package com.example.geektrust.utils;

import com.example.geektrust.models.CourseRegistration;

import java.util.Comparator;

public class SortCourseRegistrationByCourseRegistrationId implements Comparator<CourseRegistration> {

    @Override
    public int compare(CourseRegistration o1, CourseRegistration o2) {
        return o1.getCourseRegistrationId().compareTo(o2.getCourseRegistrationId());
    }
}
