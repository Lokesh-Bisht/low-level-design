/**
 * Author: Lokesh Bisht
 */

package dev.lokeshbisht.CourseScheduling;

import dev.lokeshbisht.CourseScheduling.enums.Errors;
import dev.lokeshbisht.CourseScheduling.models.Course;
import dev.lokeshbisht.CourseScheduling.service.CourseService;
import dev.lokeshbisht.CourseScheduling.service.impl.CourseServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CourseServiceImplTest {

    private final CourseService courseService;

    public CourseServiceImplTest() {
        courseService = CourseServiceImpl.getInstance();
    }

    @Test
    public void testInputValidation() {
        Course course = new Course("JAVA", "", "", 0, 0);
        Assertions.assertEquals(Errors.INPUT_DATA_ERROR.toString(), courseService.addCourse(course));
        course = new Course("JAVA", "JAMES", "", 0, 0);
        assertEquals(Errors.INPUT_DATA_ERROR.toString(), courseService.addCourse(course));
    }

    @Test
    public void testCreateCourse() {
        Course course = new Course("PHP", "JOHN", "15062022", 1, 2);
        assertEquals("OFFERING-PHP-JOHN", courseService.addCourse(course));
    }

    @Test
    public void testCreateMultipleCourses() {
        Course course = new Course("PYTHON", "LOKESH", "15062022", 1, 2);
        assertEquals("OFFERING-PYTHON-LOKESH", courseService.addCourse(course));
        course = new Course("CPP", "BISHT", "15062022", 2, 4);
        assertEquals("OFFERING-CPP-BISHT", courseService.addCourse(course));
    }
}