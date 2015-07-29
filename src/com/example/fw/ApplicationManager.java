package com.example.fw;

import java.util.Properties;
import org.netbeans.jemmy.ClassReference;
import org.netbeans.jemmy.operators.JFrameOperator;
public class ApplicationManager {
	
	private Properties properties;
	private FolderHelper folderHelper;
	private JFrameOperator mainframe;
	private MenuHelper menuHelper;
	private ToolbarHelper toolbarHelper;
	private static ApplicationManager singleton;
	private String[] path;
	public String clearDb;
	public static String currentDb;
	public String fullDb;
	private HotKeyesHelper hotKeyesHelper;

	public static ApplicationManager getInstance() {
		if (singleton == null) {
			singleton = new ApplicationManager();
		}
		return singleton;
	}
	
	public void setProperties (Properties properties) {
		this.properties = properties;
		path = new String [] {properties.getProperty("path")};
		clearDb = properties.getProperty("clearDb");
		fullDb = properties.getProperty("fullDb");
		currentDb = properties.getProperty("currentDb");
	}
	
	public ApplicationManager() {
	}
	
	public void stop() {
		getApplication().requestClose();
//		mainframe = null;
		
	}
	
	public FolderHelper getFoldersHelper() {
		if (folderHelper == null) {
			folderHelper = new FolderHelper(this);
		}
		return folderHelper;
	}

	public JFrameOperator getApplication() {
		if (mainframe == null) {
			try {
				new ClassReference("addressbook.AddressBookFrame").startApplication(path);
				mainframe = new JFrameOperator("jAddressBook");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return mainframe;
	}

	public MenuHelper getMenuHelper() {
		if (menuHelper == null) {
			menuHelper = new MenuHelper(this);
		}
		return menuHelper;
	}

	public ToolbarHelper getToolbarHelper() {
		if (toolbarHelper == null) {
			toolbarHelper = new ToolbarHelper(this);
		}
		return toolbarHelper;
	}

	public HotKeyesHelper getHotKeyesHelper() {
		if (hotKeyesHelper == null) {
			hotKeyesHelper = new HotKeyesHelper(this);
		}
		return hotKeyesHelper;
	}
}
