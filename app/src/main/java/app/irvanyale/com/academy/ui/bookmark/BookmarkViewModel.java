package app.irvanyale.com.academy.ui.bookmark;

import androidx.lifecycle.ViewModel;

import java.util.List;

import app.irvanyale.com.academy.data.CourseEntity;
import app.irvanyale.com.academy.data.source.AcademyRepository;
import app.irvanyale.com.academy.utils.DataDummy;

/**
 * Created by irvan on 1/24/2020.
 */
public class BookmarkViewModel extends ViewModel {

    private AcademyRepository academyRepository;

    public BookmarkViewModel(AcademyRepository mAcademyRepository) {
        this.academyRepository = mAcademyRepository;
    }

    List<CourseEntity> getBookmarks() {
        return academyRepository.getBookmarkedCourses();
    }
}
