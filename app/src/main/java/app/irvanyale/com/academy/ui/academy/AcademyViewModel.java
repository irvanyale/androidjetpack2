package app.irvanyale.com.academy.ui.academy;

import androidx.lifecycle.ViewModel;

import java.util.List;

import app.irvanyale.com.academy.data.CourseEntity;
import app.irvanyale.com.academy.data.source.AcademyRepository;
import app.irvanyale.com.academy.utils.DataDummy;

/**
 * Created by irvan on 1/24/2020.
 */
public class AcademyViewModel extends ViewModel {

    private AcademyRepository academyRepository;

    public AcademyViewModel(AcademyRepository mAcademyRepository) {
        this.academyRepository = mAcademyRepository;
    }

    public List<CourseEntity> getCourses() {
        return academyRepository.getAllCourses();
    }
}
