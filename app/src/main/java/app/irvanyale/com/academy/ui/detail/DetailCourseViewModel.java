package app.irvanyale.com.academy.ui.detail;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import app.irvanyale.com.academy.data.CourseEntity;
import app.irvanyale.com.academy.data.ModuleEntity;
import app.irvanyale.com.academy.data.source.AcademyRepository;
import app.irvanyale.com.academy.utils.DataDummy;

/**
 * Created by irvan on 1/24/2020.
 */
public class DetailCourseViewModel extends ViewModel {
    private String courseId;
    private AcademyRepository academyRepository;

    public DetailCourseViewModel(AcademyRepository mAcademyRepository) {
        this.academyRepository = mAcademyRepository;
    }

    public void setSelectedCourse(String courseId) {
        this.courseId = courseId;
    }

    public CourseEntity getCourse() {
        return academyRepository.getCourseWithModules(courseId);
    }

    public List<ModuleEntity> getModules() {
        return academyRepository.getAllModulesByCourse(courseId);
    }
}
