package app.irvanyale.com.academy.ui.reader;

import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import app.irvanyale.com.academy.data.ContentEntity;
import app.irvanyale.com.academy.data.ModuleEntity;
import app.irvanyale.com.academy.data.source.AcademyRepository;
import app.irvanyale.com.academy.utils.DataDummy;

/**
 * Created by irvan on 1/24/2020.
 */
public class CourseReaderViewModel extends ViewModel {

    private String courseId;
    private String moduleId;

    private AcademyRepository academyRepository;

    public CourseReaderViewModel(AcademyRepository mAcademyRepository) {
        this.academyRepository = mAcademyRepository;
    }

    public void setSelectedCourse(String courseId) {
        this.courseId = courseId;
    }

    public void setSelectedModule(String moduleId) {
        this.moduleId = moduleId;
    }

    public List<ModuleEntity> getModules() {
        return academyRepository.getAllModulesByCourse(courseId);
    }

    public ModuleEntity getSelectedModule() {
        return academyRepository.getContent(courseId, moduleId);
    }
}
