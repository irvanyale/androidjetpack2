package app.irvanyale.com.academy.data.source;

import java.util.List;

import app.irvanyale.com.academy.data.CourseEntity;
import app.irvanyale.com.academy.data.ModuleEntity;

public interface AcademyDataSource {

    List<CourseEntity> getAllCourses();

    CourseEntity getCourseWithModules(String courseId);

    List<ModuleEntity> getAllModulesByCourse(String courseId);

    List<CourseEntity> getBookmarkedCourses();

    ModuleEntity getContent(String courseId, String moduleId);
}
