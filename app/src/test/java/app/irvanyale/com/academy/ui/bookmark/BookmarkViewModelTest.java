package app.irvanyale.com.academy.ui.bookmark;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import app.irvanyale.com.academy.data.CourseEntity;
import app.irvanyale.com.academy.data.source.AcademyRepository;
import app.irvanyale.com.academy.utils.DataDummy;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class BookmarkViewModelTest {

    private BookmarkViewModel viewModel;

    @Mock
    private AcademyRepository academyRepository;

    @Before
    public void setUp() {
        viewModel = new BookmarkViewModel(academyRepository);
    }

    @Test
    public void getBookmark() {
        when(academyRepository.getBookmarkedCourses()).thenReturn(DataDummy.generateDummyCourses());
        List<CourseEntity> courseEntities = viewModel.getBookmarks();
        verify(academyRepository).getBookmarkedCourses();
        assertNotNull(courseEntities);
        assertEquals(5, courseEntities.size());
    }

}