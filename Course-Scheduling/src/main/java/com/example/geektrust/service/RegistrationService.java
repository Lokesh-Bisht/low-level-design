/**
 * Author: Lokesh Bisht
 */

package com.example.geektrust.service;

import com.example.geektrust.dto.CourseAllotment;

import java.util.List;

public interface RegistrationService {

    String courseRegistration(String employeeEmail, String courseOfferingId);

    String cancelCourseRegistration(String courseRegistrationId);

    List<CourseAllotment> allotCourse(String courseOfferingId);
}
