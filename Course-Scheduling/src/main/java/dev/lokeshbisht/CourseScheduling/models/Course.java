/**
 * Author: Lokesh Bisht
 */

package dev.lokeshbisht.models;

public class Course {

    private String courseOfferingId;

    private String courseName;

    private String instructor;

    private String startDate;

    private int minEmployees;

    private int maxEmployees;

    public Course(String courseName, String instructor, String startDate, int minEmployees, int maxEmployees) {
        this.courseName = courseName;
        this.instructor = instructor;
        this.startDate = startDate;
        this.minEmployees = minEmployees;
        this.maxEmployees = maxEmployees;
    }

    public String getCourseOfferingId() {
        return courseOfferingId;
    }

    public void setCourseOfferingId(String courseOfferingId) {
        this.courseOfferingId = courseOfferingId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public int getMinEmployees() {
        return minEmployees;
    }

    public void setMinEmployees(int minEmployees) {
        this.minEmployees = minEmployees;
    }

    public int getMaxEmployees() {
        return maxEmployees;
    }

    public void setMaxEmployees(int maxEmployees) {
        this.maxEmployees = maxEmployees;
    }
}
