/**
 * Author: Lokesh Bisht
 */

package dev.lokeshbisht.CourseScheduling.service;

import dev.lokeshbisht.CourseScheduling.dto.CourseAllotment;

import java.util.List;

public interface RegistrationService {

    String courseRegistration(String employeeEmail, String courseOfferingId);

    String cancelCourseRegistration(String courseRegistrationId);

    List<CourseAllotment> allotCourse(String courseOfferingId);
}
