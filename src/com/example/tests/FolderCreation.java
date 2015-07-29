package com.example.tests;

import org.testng.annotations.Test;
import com.example.fw.Folders;
import static com.example.fw.FolderHelper.VIA_MENU;
import static com.example.fw.FolderHelper.VIA_HOTKEYES;
import static com.example.fw.FolderHelper.VIA_BUTTONS;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

public class FolderCreation extends TestBase {
	private static String FOLDER_ORIGIN = "newfolder1M";
	private static String FOLDER_ORIGIN2 = "newfolder1TB";
	private static String FOLDER_ORIGIN3 = "newfolder1HK";
	private static String FOLDER_1 = "newfolder2";
	private static String FOLDER_2 = "newfolder3";
	private static String FOLDER_SAME = "newfolderN";
	
	@Test
	public void testValidFolderCreationViaMenu () {
		Folders oldFoldersList = app.getFoldersHelper().getFoldersList();
		assertThat(app.getFoldersHelper().addFolder(FOLDER_ORIGIN, VIA_MENU), is(nullValue()));
		Folders newFoldersList = app.getFoldersHelper().getFoldersList();
		assertThat(newFoldersList, equalTo(oldFoldersList.withAdded(FOLDER_ORIGIN)));
	}
	
	@Test
	public void testValidFolderCreationViaHotKeys() {
		Folders oldFoldersList = app.getFoldersHelper().getFoldersList();
		assertThat(app.getFoldersHelper().addFolder(FOLDER_ORIGIN3, VIA_HOTKEYES), is(nullValue()));
		Folders newFoldersList = app.getFoldersHelper().getFoldersList();
		assertThat(newFoldersList, equalTo(oldFoldersList.withAdded(FOLDER_ORIGIN3)));
	}
	
	@Test
	public void testValidFolderCreationViaToolbar () {
		Folders oldFoldersList = app.getFoldersHelper().getFoldersList();
		assertThat(app.getFoldersHelper().addFolder(FOLDER_ORIGIN2, VIA_BUTTONS), is(nullValue()));
		Folders newFoldersList = app.getFoldersHelper().getFoldersList();
		assertThat(newFoldersList, equalTo(oldFoldersList.withAdded(FOLDER_ORIGIN2)));
	}
	
	@Test
	public void testValidSeveralFolderCreation () {
		Folders oldFoldersList = app.getFoldersHelper().getFoldersList();
		assertThat(app.getFoldersHelper().addFolder(FOLDER_1, VIA_MENU), is(nullValue()));
		Folders newFoldersList = app.getFoldersHelper().getFoldersList();
		assertThat(newFoldersList, equalTo(oldFoldersList.withAdded(FOLDER_1)));
		oldFoldersList = app.getFoldersHelper().getFoldersList();
		assertThat(app.getFoldersHelper().addFolder(FOLDER_2, VIA_MENU), is(nullValue()));
		newFoldersList = app.getFoldersHelper().getFoldersList();
		assertThat(newFoldersList, equalTo(oldFoldersList.withAdded(FOLDER_2)));
	}
	
	@Test
	public void testEqualSeveralFolderCreation () {
		Folders oldFoldersList = app.getFoldersHelper().getFoldersList();
		assertThat(app.getFoldersHelper().addFolder(FOLDER_SAME, VIA_MENU), is(nullValue()));
		Folders newFoldersList = app.getFoldersHelper().getFoldersList();
		assertThat(newFoldersList, equalTo(oldFoldersList.withAdded(FOLDER_SAME)));
		oldFoldersList = app.getFoldersHelper().getFoldersList();
		assertThat(app.getFoldersHelper().addFolder(FOLDER_SAME, VIA_MENU), containsString("Duplicated folder name"));
		newFoldersList = app.getFoldersHelper().getFoldersList();
		assertThat(newFoldersList, equalTo(oldFoldersList));
	}
}
