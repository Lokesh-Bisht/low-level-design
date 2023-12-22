/**
 * Author: Lokesh Bisht
 */

package dev.lokeshbisht.CourseScheduling.models;

import dev.lokeshbisht.CourseScheduling.enums.CourseStatus;

public class CourseRegistration {

    private String courseRegistrationId;

    private String employeeEmail;

    private String courseOfferingId;

    private CourseStatus status;

    public CourseRegistration(String courseRegistrationId, String employeeEmail, String courseOfferingId, CourseStatus status) {
        this.courseRegistrationId = courseRegistrationId;
        this.employeeEmail = employeeEmail;
        this.courseOfferingId = courseOfferingId;
        this.status = status;
    }

    public String getCourseRegistrationId() {
        return courseRegistrationId;
    }

    public void setCourseRegistrationId(String courseRegistrationId) {
        this.courseRegistrationId = courseRegistrationId;
    }

    public String getEmployeeEmail() {
        return employeeEmail;
    }

    public void setEmployeeEmail(String employeeEmail) {
        this.employeeEmail = employeeEmail;
    }

    public String getCourseOfferingId() {
        return courseOfferingId;
    }

    public void setCourseOfferingId(String courseOfferingId) {
        this.courseOfferingId = courseOfferingId;
    }

    public CourseStatus getStatus() {
        return status;
    }

    public void setStatus(CourseStatus status) {
        this.status = status;
    }
}
