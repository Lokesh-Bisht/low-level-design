/**
 * Copyright (C) 2023 Lokesh Bisht
 *
 * Licensed under the Apache Software License version 2.0, available at http://www.apache.org/licenses/LICENSE-2.0
 */

package com.example.geektrust.dto;

import com.example.geektrust.enums.CourseStatus;

public class CourseAllotment {

    private final String courseRegistrationId;

    private final String employeeEmail;

    private final String courseOfferingId;

    private final String courseName;

    private final String instructor;

    private final String startDate;

    private final CourseStatus status;

    public CourseAllotment(Builder builder) {
        this.courseRegistrationId = builder.courseRegistrationId;
        this.employeeEmail = builder.employeeEmail;
        this.courseOfferingId = builder.courseOfferingId;
        this.courseName = builder.courseName;
        this.instructor = builder.instructor;
        this.startDate = builder.startDate;
        this.status = builder.status;
    }

    public String getCourseRegistrationId() {
        return courseRegistrationId;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public String getCourseOfferingId() {
        return courseOfferingId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getStartDate() {
        return startDate;
    }

    public CourseStatus getStatus() {
        return status;
    }

    public static class Builder {

        private String courseRegistrationId;

        private String employeeEmail;

        private String courseOfferingId;

        private String courseName;

        private String instructor;

        private String startDate;

        private CourseStatus status;

        public Builder() {}

        public Builder setCourseRegistrationId(String courseRegistrationId) {
            this.courseRegistrationId = courseRegistrationId;
            return this;
        }

        public Builder setEmployeeEmail(String employeeEmail) {
            this.employeeEmail = employeeEmail;
            return this;
        }

        public Builder setCourseOfferingId(String courseOfferingId) {
            this.courseOfferingId = courseOfferingId;
            return this;
        }

        public Builder setCourseName(String courseName) {
            this.courseName = courseName;
            return this;
        }

        public Builder setInstructor(String instructor) {
            this.instructor = instructor;
            return this;
        }

        public Builder setStartDate(String startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder setStatus(CourseStatus status) {
            this.status = status;
            return this;
        }

        public CourseAllotment build() {
            return new CourseAllotment(this);
        }
    }
}
