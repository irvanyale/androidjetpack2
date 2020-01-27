package app.irvanyale.com.academy.ui.reader;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import app.irvanyale.com.academy.data.ContentEntity;
import app.irvanyale.com.academy.data.CourseEntity;
import app.irvanyale.com.academy.data.ModuleEntity;
import app.irvanyale.com.academy.utils.DataDummy;

import static org.junit.Assert.*;

public class CourseReaderViewModelTest {

    private CourseReaderViewModel viewModel;

    private CourseEntity dummyCourse = DataDummy.generateDummyCourses().get(0);
    private String courseId = dummyCourse.getCourseId();
    private List<ModuleEntity> dummyModules = DataDummy.generateDummyModules(courseId);
    private String moduleId = dummyModules.get(0).getModuleId();

    @Before
    public void setUp() {
        viewModel = new CourseReaderViewModel();
        viewModel.setSelectedCourse(courseId);
        viewModel.setSelectedModule(moduleId);

        ModuleEntity dummyModule = dummyModules.get(0);
        dummyModule.contentEntity = new ContentEntity("<h3 class=\\\"fr-text-bordered\\\">" + dummyModule.getTitle() + "</h3><p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>");
    }

    @Test
    public void getModules() {
        List<ModuleEntity> moduleEntities = viewModel.getModules();
        assertNotNull(moduleEntities);
        assertEquals(7, moduleEntities.size());
    }

    @Test
    public void getSelectedModule() {
        ModuleEntity moduleEntity = viewModel.getSelectedModule();
        assertNotNull(moduleEntity);
        ContentEntity contentEntity = moduleEntity.contentEntity;
        assertNotNull(contentEntity);
        String content = contentEntity.getContent();
        assertNotNull(content);
        assertEquals(content, dummyModules.get(0).contentEntity.getContent());
    }

}