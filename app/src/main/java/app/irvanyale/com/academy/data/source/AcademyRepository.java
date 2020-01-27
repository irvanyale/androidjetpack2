package app.irvanyale.com.academy.data.source;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

import app.irvanyale.com.academy.data.ContentEntity;
import app.irvanyale.com.academy.data.CourseEntity;
import app.irvanyale.com.academy.data.ModuleEntity;
import app.irvanyale.com.academy.data.source.remote.RemoteDataSource;
import app.irvanyale.com.academy.data.source.remote.response.CourseResponse;
import app.irvanyale.com.academy.data.source.remote.response.ModuleResponse;

public class AcademyRepository implements AcademyDataSource {

    private volatile static AcademyRepository INSTANCE = null;
    private final RemoteDataSource remoteDataSource;

    private AcademyRepository(@NonNull RemoteDataSource remoteDataSource) {
        this.remoteDataSource = remoteDataSource;
    }
    public static AcademyRepository getInstance(RemoteDataSource remoteData) {
        if (INSTANCE == null) {
            synchronized (AcademyRepository.class) {
                if (INSTANCE == null) {
                    INSTANCE = new AcademyRepository(remoteData);
                }
            }
        }
        return INSTANCE;
    }

    @Override
    public List<CourseEntity> getAllCourses() {
        List<CourseResponse> courseResponses = remoteDataSource.getAllCourses();
        ArrayList<CourseEntity> courseList = new ArrayList<>();
        for (CourseResponse response : courseResponses) {
            CourseEntity course = new CourseEntity(response.getId(),
                    response.getTitle(),
                    response.getDescription(),
                    response.getDate(),
                    false,
                    response.getImagePath());
            courseList.add(course);
        }
        return courseList;
    }

    @Override
    public CourseEntity getCourseWithModules(String courseId) {
        List<CourseResponse> courseResponses = remoteDataSource.getAllCourses();
        CourseEntity course = null;
        for (CourseResponse response : courseResponses) {
            if (response.getId().equals(courseId)) {
                course = new CourseEntity(response.getId(),
                        response.getTitle(),
                        response.getDescription(),
                        response.getDate(),
                        false,
                        response.getImagePath());
            }
        }
        return course;
    }

    @Override
    public List<ModuleEntity> getAllModulesByCourse(String courseId) {
        List<ModuleResponse> moduleResponses = remoteDataSource.getModules(courseId);
        ArrayList<ModuleEntity> moduleList = new ArrayList<>();

        for (ModuleResponse response : moduleResponses) {
            ModuleEntity course = new ModuleEntity(response.getModuleId(),
                    response.getCourseId(),
                    response.getTitle(),
                    response.getPosition(),
                    false);
            moduleList.add(course);
        }
        return moduleList;
    }

    @Override
    public List<CourseEntity> getBookmarkedCourses() {
        List<CourseResponse> courseResponses = remoteDataSource.getAllCourses();
        ArrayList<CourseEntity> courseList = new ArrayList<>();
        for (CourseResponse response : courseResponses) {
            CourseEntity course = new CourseEntity(response.getId(),
                    response.getTitle(),
                    response.getDescription(),
                    response.getDate(),
                    false,
                    response.getImagePath());
            courseList.add(course);
        }
        return courseList;
    }

    @Override
    public ModuleEntity getContent(String courseId, String moduleId) {
        List<ModuleResponse> moduleResponses = remoteDataSource.getModules(courseId);
        ModuleEntity module = null;
        for (ModuleResponse response : moduleResponses) {
            if (response.getModuleId().equals(moduleId)) {
                module = new ModuleEntity(response.getModuleId(),
                        response.getCourseId(),
                        response.getTitle(),
                        response.getPosition(),
                        false);
                module.contentEntity = new ContentEntity(remoteDataSource.getContent(moduleId).getContent());
                break;
            }
        }
        return module;
    }
}
