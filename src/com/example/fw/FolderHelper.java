package com.example.fw;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.netbeans.jemmy.operators.JDialogOperator;
import org.netbeans.jemmy.operators.JTextFieldOperator;
import org.netbeans.jemmy.operators.JTreeOperator;
import org.netbeans.jemmy.operators.JButtonOperator;

public class FolderHelper extends BaseHelper{
	public final static String VIA_MENU = "MENU";
	public final static String VIA_BUTTONS = "BUTTONS";
	public final static String VIA_HOTKEYES = "HOTKEYES";
	public static Boolean REMOVE = true;
	public static Boolean NOT_REMOVE = !REMOVE;
	public FolderHelper(ApplicationManager manager) {
		super(manager);
	}

	public Folders getFoldersList() {
		List<String> folders = new ArrayList<String>();
		JTreeOperator tree = new JTreeOperator(mainFrame);
		Object[] children = tree.getChildren(tree.getRoot());
		for (Object child : children) {
			folders.add("" + child);
		}
		return new Folders(folders);
	}

	public String addFolder(String folder, String addMethod) {
		switch(addMethod) {
			case VIA_MENU     : 
				manager.getMenuHelper().clickNewFolder();
				break;
			case VIA_BUTTONS  : 
				manager.getToolbarHelper().clickNewFolder();
				break;
			case VIA_HOTKEYES : 
				manager.getHotKeyesHelper().typeNewFolder();
				break;
		}
		JDialogOperator dialog = new JDialogOperator (mainFrame);
		new JTextFieldOperator(dialog).setText(folder);
		new JButtonOperator(dialog, "OK").push();
		return waitMessageDialog("Warning", 3000);
	}

	public int chooseFolder(int size) {
		Random rnd = new Random();
		return rnd.nextInt(size);
	}

	public void deleteFolder(int index, String addMethod, boolean confirm) {
		selectFolder(index);
		switch(addMethod) {
			case VIA_MENU     : manager.getMenuHelper().clickDeleteFolder();
			case VIA_BUTTONS  : manager.getToolbarHelper().clickDeleteFolder();
		}
		
		JDialogOperator dialog = new JDialogOperator (mainFrame);
		if (confirm == REMOVE) {
			new JButtonOperator(dialog, "Yes").push();
		} else {
			new JButtonOperator(dialog, "No").push();
		}
	}

	private void selectFolder(int index) {
		JTreeOperator tree = new JTreeOperator(mainFrame);
		tree.selectRow(index);
	}

}
