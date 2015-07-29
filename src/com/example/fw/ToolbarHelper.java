package com.example.fw;

import org.netbeans.jemmy.operators.JMenuItemOperator;
import org.netbeans.jemmy.operators.JButtonOperator;
public class ToolbarHelper extends BaseHelper {

	public ToolbarHelper(ApplicationManager manager) {
		super(manager);
	}

	public void clickNewFolder() {
		JButtonOperator buttonOperator = new JButtonOperator(mainFrame, 0);
		buttonOperator.push();
		new JMenuItemOperator(mainFrame, "New folder...").push();
	}

	public void clickDeleteFolder() {
		JButtonOperator buttonOperator = new JButtonOperator(mainFrame, 2);
		buttonOperator.push();
	}

}
