/**
 * Author: Lokesh Bisht
 */

package dev.lokeshbisht.service.impl;

import dev.lokeshbisht.dto.CourseAllotment;
import dev.lokeshbisht.models.Course;
import dev.lokeshbisht.service.CourseService;
import dev.lokeshbisht.service.OperationsService;
import dev.lokeshbisht.service.RegistrationService;

import java.util.List;

public class OperationsServiceImpl implements OperationsService {

    private static OperationsService operationsService;

    private final CourseService courseService;

    private final RegistrationService registrationService;

    private OperationsServiceImpl() {
        this.courseService =  CourseServiceImpl.getInstance();
        this.registrationService = RegistrationServiceImpl.getInstance();
    }

    public static OperationsService getInstance() {
        if (operationsService == null) {
            return operationsService = new OperationsServiceImpl();
        }
        return operationsService;
    }

    private void performAddCourseOperation(String[] input) {
        String courseName = input.length > 1 ? input[1] : "";
        String instructor = input.length > 2 ? input[2] : "";
        String startDate = input.length > 3 ? input[3] : "";
        int minEmployees = input.length > 4 ? Integer.parseInt(input[4]) : 0;
        int maxEmployees = input.length > 5 ? Integer.parseInt(input[5]) : 0;
        Course course = new Course(courseName, instructor, startDate, minEmployees, maxEmployees);
        System.out.println(courseService.addCourse(course));
    }

    private void performEnrollEmployeeInCourseOperation(String[] input) {
        String employeeEmail = input.length > 1 ? input[1] : "";
        String courseOfferingId = input.length > 2 ? input[2] : "";
        System.out.println(registrationService.courseRegistration(employeeEmail, courseOfferingId));
    }

    private void performAllotOperation(String[] input) {
        String courseOfferingId = input.length > 1 ? input[1] : "";
        List<CourseAllotment> courseAllotmentList = registrationService.allotCourse(courseOfferingId);
        for (CourseAllotment courseAllotment : courseAllotmentList) {
            String result = courseAllotment.getCourseRegistrationId() + " " + courseAllotment.getEmployeeEmail() + " "
                + courseAllotment.getCourseOfferingId() + " " + courseAllotment.getCourseName() + " "
                + courseAllotment.getInstructor() + " " + courseAllotment.getStartDate() + " " + courseAllotment.getStatus();
            System.out.println(result);
        }
    }

    private void performCancelRegistrationOperation(String[] input) {
        String courseRegistrationId = input.length > 1 ? input[1] : "";
        System.out.println(registrationService.cancelCourseRegistration(courseRegistrationId));
    }

    @Override
    public void performOperations(String[] input) {
        String operation = input[0];
        switch (operation) {
            case "ADD-COURSE-OFFERING":
                performAddCourseOperation(input);
                break;
            case "REGISTER":
                performEnrollEmployeeInCourseOperation(input);
                break;
            case "ALLOT":
                performAllotOperation(input);
                break;
            case "CANCEL":
                performCancelRegistrationOperation(input);
                break;
            default:
                break;
        }
    }
}
