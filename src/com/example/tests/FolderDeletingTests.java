package com.example.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static com.example.fw.DataHelper.applyData;
import com.example.fw.Folders;
import static com.example.fw.FolderHelper.VIA_MENU;
import static com.example.fw.FolderHelper.VIA_BUTTONS;
import static com.example.fw.FolderHelper.REMOVE;
import static com.example.fw.FolderHelper.NOT_REMOVE;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class FolderDeletingTests extends TestBase {
	
	@BeforeClass
	public void setUp() throws Exception {
		new TestBase().setUp();
		applyData(app.fullDb);
	}
	
	@Test
	public void testFolderRemovingViaMenu () {
		Folders oldFoldersList = app.getFoldersHelper().getFoldersList();
		int index = app.getFoldersHelper().chooseFolder(oldFoldersList.size());
		app.getFoldersHelper().deleteFolder(index, VIA_MENU, REMOVE);
		Folders newFoldersList = app.getFoldersHelper().getFoldersList();
		assertThat(newFoldersList, equalTo(oldFoldersList.without(index)));
	}
	
	@Test
	public void testFolderNotRemovingViaMenu () {
		Folders oldFoldersList = app.getFoldersHelper().getFoldersList();
		int index = app.getFoldersHelper().chooseFolder(oldFoldersList.size());
		app.getFoldersHelper().deleteFolder(index, VIA_MENU, NOT_REMOVE);
		Folders newFoldersList = app.getFoldersHelper().getFoldersList();
		assertThat(newFoldersList, equalTo(oldFoldersList));
	}
	
	@Test
	public void testFolderRemovingViaToolBar () {
		Folders oldFoldersList = app.getFoldersHelper().getFoldersList();
		int index = app.getFoldersHelper().chooseFolder(oldFoldersList.size());
		app.getFoldersHelper().deleteFolder(index, VIA_BUTTONS, REMOVE);
		Folders newFoldersList = app.getFoldersHelper().getFoldersList();
		assertThat(newFoldersList, equalTo(oldFoldersList.without(index)));
	}
	
}
