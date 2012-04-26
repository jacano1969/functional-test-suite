package com.moodle.testmanager.pageObjectModel;

import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.openqa.selenium.remote.RemoteWebDriver;

import com.moodle.seleniumutils.Navigation;
import com.moodle.seleniumutils.PassFailCriteria;
/**
 * This is the page object model for the Settings Block. All interaction with the settings block is contained in here.
 * @author Tim Barker 
 * @see <a href="http://www.gnu.org/copyleft/gpl.html">License: GNU GPL v3 or later</a>
 */
public class BlockSettings {
	//Internationalization file location
	public static String blockSettingsData = "properties/data/static/blockSettings.properties";
	private Map<String, String> properties = new HashMap<String, String>();
	private RemoteWebDriver driver;
/**
 * Constructor for the page object.	
 * @param driver The driver that is used for the test. There is no need to specify the value for the driver here as the driver
 * is instantiated in the test using one of the com.moodle.seleniumutils.SeleniumManager constructors.
 * loadObjectData constructs internationalization layer in the context of this page object.
 */
	public BlockSettings(RemoteWebDriver driver) {
		this.driver = driver;
		this.loadObjectData();
	}
/**
 * Loads data for the page object from the internationalization layer /properties/data/static/blockNavigation.properties
 * where a selector requires a text string visible through the user interface e.g. value=button text, or link text.
 */
	public void loadObjectData() {
		Properties blockSettings = new Properties();
		try {
			blockSettings.load(new FileInputStream(blockSettingsData));
		} catch (Exception e) {}
		//put values from the properties file into hashmap
		this.properties.put("siteAdmin", blockSettings.getProperty("treeSiteAdmin"));
		this.properties.put("addNewUser", blockSettings.getProperty("treeAddNewUser"));
		this.properties.put("treeUsers", blockSettings.getProperty("treeUsers"));
		this.properties.put("treeAccounts", blockSettings.getProperty("treeAccounts"));
		this.properties.put("treeFrontPage", blockSettings.getProperty("treeFrontPage"));
		this.properties.put("treeFrontPageRoles", blockSettings.getProperty("treeFrontPageRoles"));
		this.properties.put("treeEnrolledUsers", blockSettings.getProperty("treeEnrolledUsers"));
		this.properties.put("treeEditSettings", blockSettings.getProperty("treeEditSettings"));
		this.properties.put("treeCourseAdministration", blockSettings.getProperty("treeCourseAdministration"));
		this.properties.put("treeMyProfileSettings", blockSettings.getProperty("treeMyProfileSettings"));
		this.properties.put("treeEditProfile", blockSettings.getProperty("treeEditProfile"));
		this.properties.put("treeForumAdmin", blockSettings.getProperty("treeForumAdmin"));
		this.properties.put("treeDontTrack", blockSettings.getProperty("treeDontTrack"));
		this.properties.put("treeAssignmentAdministration", blockSettings.getProperty("treeAssignmentAdministration"));
		this.properties.put("exceptionTrackingCanBeEnabled", blockSettings.getProperty("exceptionTrackingCanBeEnabled"));
		this.properties.put("exceptionTrackingCanBeDisabled", blockSettings.getProperty("exceptionTrackingCanBeDisabled"));
	}
/**
 * Intelligently navigate through the tree menu to 'Add New User'
 * i.e. if 'Add New User' option is available then click it, if not then navigate through the tree to find it.
 */
	public void navigateTreeMenuToAddNewUserPage() {
		Navigation navigate = new Navigation(driver);
		navigate.navigateTree4DeepByXpath(".//span[contains(.,'" +
				this.properties.get("siteAdmin") +
				"')]",
				".//li[contains(.,'" +
				this.properties.get("siteAdmin") +
				"')]/ul//span[contains(.,'" +
				this.properties.get("treeUsers") +
				"')]",
				".//li[contains(.,'" +
				this.properties.get("siteAdmin") +
				"')]/ul//span[contains(.,'" +
				this.properties.get("treeAccounts") +
				"')]",
				"//a[@title='" +
				this.properties.get("addNewUser") +
				"']");
	}
/**
* Intelligently navigate through the tree menu to 'Front Page Roles'
* i.e. if 'Front Page Roles' option is available then click it, if not then navigate through the tree to find it.
*/
	public void navigateTreeMenuToFrontPageRoles() {
		Navigation navigate = new Navigation(driver);
		navigate.navigateTree3DeepByXpath(".//span[contains(.,'" +
				this.properties.get("siteAdmin") +
				"')]", ".//li[contains(.,'" +
				this.properties.get("siteAdmin") +
				"')]/ul//span[contains(.,'" +
				this.properties.get("treeFrontPage") +
				"')]", "//a[@title='" +
				this.properties.get("treeFrontPageRoles") +
				"']");
	}
/**
 * Intelligently navigate through the tree menu to 'Enrolled Users'
 * i.e. if 'Enrolled Users' option is available then click it, if not then navigate through the tree to find it.
 */
	public void navigateEnrolledUsers() {
		Navigation navigate = new Navigation(driver);
		navigate.navigateTree2DeepByXpath(
				"//span[contains(.,'" +
				this.properties.get("treeUsers") +
				"')]", "//a[@title='" +
				this.properties.get("treeEnrolledUsers") +
				"']");
	}
/**
 * Intelligently navigate through the tree menu to 'Edit course settings'
 * i.e. if 'Edit course settings' option is available then click it, if not then navigate through the tree to find it.
 */
	public void navigateEditCourseSettings() {
		Navigation navigate = new Navigation(driver);
		navigate.navigateTree2DeepByXpath("//span[contains(.,'" +
				this.properties.get("treeCourseAdministration") +
				"')]", ".//li[contains(.,'" +
				this.properties.get("treeCourseAdministration") +
				"')]/ul/li/*/a[contains(.,'" +
				this.properties.get("treeEditSettings") +
				"')]");
	}
/**
 * Intelligently navigate through the tree menu to 'Edit profile'
 * i.e. if 'Edit profile' option is available then click it, if not then navigate through the tree to find it.
 */
	public void navigateEditProfile() {
		Navigation navigate = new Navigation(driver);
		navigate.navigateTree2DeepByXpath("//span[contains(.,'" +
				this.properties.get("treeMyProfileSettings") +
				"')]", ".//li[contains(.,'" +
				this.properties.get("treeMyProfileSettings") +
				"')]/ul/li/*/a[contains(.,'" +
				this.properties.get("treeEditProfile") +
				"')]");		
	}
/**
 * Intelligently navigate through the tree menu to 'Don't track unread posts'
 * i.e. if 'Don't track unread posts' option is available then click it, if not then navigate through the tree to find it.
 */
	public void navigateDontTrackUnread() {
		Navigation navigate = new Navigation(driver);
		navigate.navigateTree2DeepByXpath("//span[contains(.,'" +
				this.properties.get("treeForumAdmin") +
				"')]", ".//li[contains(.,'" +
				this.properties.get("treeForumAdmin") +
				"')]/ul/li/*/a[contains(.,'" +
				this.properties.get("treeDontTrack") +
				"')]");
	}
/**
 * Asserts that tracking cannot be enabled by the user.
 * @throws Exception An exception is thrown if tracking can be enabled.
 */
	public void assertTrackingCannotBeEnabled() throws Exception {
		PassFailCriteria passFail = new PassFailCriteria(driver);
		passFail.assertElementIsNotPresentByXpath(".//li[contains(.,'" +
				this.properties.get("treeForumAdmin") +
				"')]/ul/li/*/a[contains(.,'" +
				this.properties.get("treeDontTrack") +
				"')]", this.properties.get("exceptionTrackingCanBeEnabled"), 0);
	}
/**
 * Asserts that tracking cannot be disabled by the user.
 * @throws Exception An exception is thrown if tracking can be disabled.
 */
	public void assertTrackingCannotBeDisabled() throws Exception {
		PassFailCriteria passFail = new PassFailCriteria(driver);
		passFail.assertElementIsNotPresentByXpath(".//li[contains(.,'" +
				this.properties.get("treeForumAdmin") +
				"')]/ul/li/*/a[contains(.,'" +
				this.properties.get("treeDontTrack") +
				"')]", this.properties.get("exceptionTrackingCanBeDisabled"), 0);
	}
/**
 * Navigates to the Edit assignment settngs page via the tree view whether it's expanded or collapsed.
 */
	public void navigateEditSettings() {
		Navigation navigate = new Navigation(driver);
		navigate.navigateTree2DeepByXpath(".//li[contains(.,'" 
		+ this.properties.get("treeAssignmentAdministration") + "')]", 
		"//a[@title='" + this.properties.get("treeEditSettings") + "']");
	}
}