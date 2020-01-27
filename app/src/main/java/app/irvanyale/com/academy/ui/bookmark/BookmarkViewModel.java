package app.irvanyale.com.academy.ui.bookmark;

import androidx.lifecycle.ViewModel;

import java.util.List;

import app.irvanyale.com.academy.data.CourseEntity;
import app.irvanyale.com.academy.utils.DataDummy;

/**
 * Created by irvan on 1/24/2020.
 */
public class BookmarkViewModel extends ViewModel {
    List<CourseEntity> getBookmarks() {
        return DataDummy.generateDummyCourses();
    }
}
