/**
 * Author: Lokesh Bisht
 */

package com.example.geektrust.service.impl;

import com.example.geektrust.dto.CourseAllotment;
import com.example.geektrust.enums.CourseStatus;
import com.example.geektrust.enums.Errors;
import com.example.geektrust.exceptions.ValidationException;
import com.example.geektrust.models.Course;
import com.example.geektrust.models.CourseRegistration;
import com.example.geektrust.repository.CourseRegistrationRepository;
import com.example.geektrust.repository.CourseRepository;
import com.example.geektrust.service.RegistrationService;
import com.example.geektrust.utils.SortCourseRegistrationByCourseRegistrationId;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RegistrationServiceImpl implements RegistrationService {

    private static RegistrationService registrationService;

    private final CourseRepository courseRepository;

    private final CourseRegistrationRepository courseRegistrationRepository;

    private RegistrationServiceImpl() {
        this.courseRepository = CourseRepository.getInstance();
        this.courseRegistrationRepository = CourseRegistrationRepository.getInstance();
    }

    public static RegistrationService getInstance() {
        if (registrationService == null) {
            return registrationService = new RegistrationServiceImpl();
        }
        return registrationService;
    }

    private boolean checkIfSeatsAreAvailable(Course course) {
        int totalCourseSeats = course.getMaxEmployees();
        int seatsFilled = courseRegistrationRepository
            .getCourseOfferingIdToRegistrationCountHashMap()
            .get(course.getCourseOfferingId());
        return seatsFilled < totalCourseSeats;
    }

    private void inputValidation(String employeeEmail, String courseOfferingId) throws ValidationException {
        if (employeeEmail.isEmpty() || courseOfferingId.isEmpty() || !employeeEmail.contains("@")) {
            throw new ValidationException(Errors.INPUT_DATA_ERROR.name());
        }
    }

    @Override
    public String courseRegistration(String employeeEmail, String courseOfferingId) {
        try {
            inputValidation(employeeEmail, courseOfferingId);
        } catch (ValidationException ex) {
            return ex.getMessage();
        }
        String employeeName = employeeEmail.substring(0, employeeEmail.indexOf('@'));
        Course course = courseRepository.getCourseOfferingIdToCourseHashMap().get(courseOfferingId);
        String courseRegistrationId = "REG-COURSE-" + employeeName + "-" + course.getCourseName();
        boolean notFirstRegistrant = courseRegistrationRepository.getCourseOfferingIdToRegistrationCountHashMap().containsKey(courseOfferingId);
        if (notFirstRegistrant && !checkIfSeatsAreAvailable(course)) {
            return Errors.COURSE_FULL_ERROR.toString();
        }
        CourseRegistration courseRegistration = new CourseRegistration(courseRegistrationId, employeeEmail, courseOfferingId, CourseStatus.ACCEPTED);
        courseRegistrationRepository.saveEmployeeCourseRegistration(courseRegistration);
        return courseRegistrationId + " " + courseRegistration.getStatus().toString();
    }

    @Override
    public String cancelCourseRegistration(String courseRegistrationId) {
        CourseRegistration courseRegistration = courseRegistrationRepository.getCourseRegistrationIdToCourseRegistrationHashMap().get(courseRegistrationId);
        if (CourseStatus.CONFIRMED.equals(courseRegistration.getStatus())) {
            return courseRegistrationId + " " + CourseStatus.CANCEL_REJECTED.toString();
        }
        courseRegistrationRepository.deleteCourseRegistration(courseRegistration);
        return courseRegistrationId + " " + CourseStatus.CANCEL_ACCEPTED.toString();
    }

    private void changeCourseStatus() {
        HashMap<String, CourseRegistration> courseRegistrationMap = courseRegistrationRepository.getCourseRegistrationIdToCourseRegistrationHashMap();
        for (Map.Entry<String, CourseRegistration> entry : courseRegistrationMap.entrySet()) {
            String courseOfferingId = entry.getValue().getCourseOfferingId();
            Course course = courseRepository.getCourseOfferingIdToCourseHashMap().get(courseOfferingId);
            int seatsFilled = courseRegistrationRepository.getCourseOfferingIdToRegistrationCountHashMap().get(courseOfferingId);
            if (seatsFilled >= course.getMinEmployees()) {
                entry.getValue().setStatus(CourseStatus.CONFIRMED);
            } else {
                entry.getValue().setStatus(CourseStatus.COURSE_CANCELED);
            }
            courseRegistrationRepository.updateCourseRegistration(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public List<CourseAllotment> allotCourse(String courseOfferingId) {
        changeCourseStatus();
        List<CourseRegistration> courseRegistrationList = new ArrayList<>();
        Map<String, CourseRegistration> result = courseRegistrationRepository.getCourseRegistrationIdToCourseRegistrationHashMap();
        for (Map.Entry<String, CourseRegistration> entry : result.entrySet()) {
            if (courseOfferingId.equalsIgnoreCase(entry.getValue().getCourseOfferingId())) {
                courseRegistrationList.add(entry.getValue());
            }
        }
        courseRegistrationList.sort(new SortCourseRegistrationByCourseRegistrationId());
        List<CourseAllotment> courseAllotmentList = new ArrayList<>();
        for (CourseRegistration courseRegistration : courseRegistrationList) {
            Course course = courseRepository.getCourseOfferingIdToCourseHashMap().get(courseOfferingId);
            CourseAllotment courseAllotment = new CourseAllotment.Builder()
                .setCourseRegistrationId(courseRegistration.getCourseRegistrationId())
                .setEmployeeEmail(courseRegistration.getEmployeeEmail())
                .setCourseOfferingId(courseOfferingId)
                .setCourseName(course.getCourseName())
                .setInstructor(course.getInstructor())
                .setStartDate(course.getStartDate())
                .setStatus(courseRegistration.getStatus())
                .build();
            courseAllotmentList.add(courseAllotment);
        }
        return courseAllotmentList;
    }
}
