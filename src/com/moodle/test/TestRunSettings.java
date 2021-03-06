package com.moodle.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.remote.RemoteWebDriver;

import com.moodle.testmanager.pageObjectModel.*;

public class TestRunSettings {
	//Load test data from properties file
	public TestRunSettings() {
		super();
	}
	protected static RemoteWebDriver driver;
	static SeleniumManager sm;
	public static String runParameters = "properties/runParameters.properties";
	protected Assignment assignment = new Assignment(driver);
	protected AssignmentAddAssignmentForm addAssignment = new AssignmentAddAssignmentForm(driver);
	protected AssignmentAddSubmission submitAssignment = new AssignmentAddSubmission(driver);
	protected AssignmentAdminUpgradeAssignments upgradeAssignment = new AssignmentAdminUpgradeAssignments(driver);
	protected AssignmentAssertions assignmentAssertions = new AssignmentAssertions(driver);
	protected AssignmentGrading grading = new AssignmentGrading(driver);
	protected AssignmentPluginManageFeedback manageFeedbackPlugin = new AssignmentPluginManageFeedback(driver);
	protected AssignmentPluginManageSubmission manageSubmissionPlugin = new AssignmentPluginManageSubmission(driver);
	protected AssignmentSubmissionComments submissionComments = new AssignmentSubmissionComments(driver);
	protected BlockNavigation navigationBlock = new BlockNavigation(driver);
	protected BlockAssertions blockAssertions = new BlockAssertions(driver);
	protected BlockSettings settingsBlock = new BlockSettings(driver);
	protected BookAddForm addBook = new BookAddForm(driver);
	protected ChatAddForm addChat = new ChatAddForm(driver);
	protected ChoiceAddForm addChoice = new ChoiceAddForm(driver);
	protected Courses course = new Courses(driver);
	protected CoursesAddActivityResource addActivity = new CoursesAddActivityResource(driver);
	protected CoursesEditCourseSettings editCourseSettings = new CoursesEditCourseSettings(driver);
	protected CourseAssertions courseAssertions = new CourseAssertions(driver);
	protected Databases databases = new Databases(driver);
	protected DatabasesAddDatabase addDatabase = new DatabasesAddDatabase(driver);
	protected DatabasesFields databaseFields = new DatabasesFields(driver);
	protected FolderAddForm addFolder = new FolderAddForm(driver);
	protected Forum forum = new Forum(driver);
	protected ForumAddForm addForum = new ForumAddForm(driver);
	protected ForumAssertions forumAssertions = new ForumAssertions(driver);
	protected ForumPosts forumPosts = new ForumPosts(driver);
	protected ForumSplit splitForum = new ForumSplit(driver);
	protected FrontPageRoles frontPageRoles = new FrontPageRoles(driver);
	protected GlossaryAddForm addGlossary = new GlossaryAddForm(driver);
	protected LabelAddForm addLabel = new LabelAddForm(driver);
	protected LessonAddForm addLesson = new LessonAddForm(driver);
	protected Installation installation = new Installation(driver);
	protected SurveyAddForm addSurvey = new SurveyAddForm(driver);
	protected PluginsManageEditors manageEditors = new PluginsManageEditors(driver);
	protected ProfileEdit editProfile = new ProfileEdit(driver);
	protected QuizAddForm addQuiz = new QuizAddForm(driver);
	protected ReportActivityCompletionAssertions activityCompletionReport = new ReportActivityCompletionAssertions(driver);
	protected SiteAdministration siteAdmin = new SiteAdministration(driver);
	protected Users user = new Users(driver);
	protected UsersAddNewUser addNewUser = new UsersAddNewUser(driver);
	protected UsersEnrolled enrolledUsers = new UsersEnrolled(driver);
	protected Toolkit frameworkTools = new Toolkit(driver);
	protected WikiAddForm addWiki = new WikiAddForm(driver);
	protected WorkshopAddForm addWorkshop = new WorkshopAddForm(driver);
	
	@BeforeClass
	public static void automateTestSetup() throws FileNotFoundException, IOException {
		//Load properties required for test run
			Properties startupConfig = new Properties();
			startupConfig.load(new FileInputStream(runParameters));
			String gridHubURL = startupConfig.getProperty("gridHubURL");
			String browserType = startupConfig.getProperty("browserType");
			String moodleHomePage = startupConfig.getProperty("moodleHomePage");
			String chromeDriverLocation = startupConfig.getProperty("chromeDriverLocation");
		//Call setup method
			sm = new SeleniumManager();
			sm.startRemotes(gridHubURL, browserType);
			//sm.startChromeDriver(chromeDriverLocation);
			//sm.startFirefoxDriver();
			driver = sm.getRemoteDriver();
			//driver = sm.getChromeDriver();
			//driver = sm.getFirefoxDriver();
			driver.get(moodleHomePage);
	}
	@AfterClass
	public static void Quit() {
	//End Webdriver Session by calling teardown method
		sm.teardown();
		//sm.teardownFirefox();
		//sm.teardownChrome();
	}
}