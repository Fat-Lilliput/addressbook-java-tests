package com.example.fw;

import org.netbeans.jemmy.operators.JMenuBarOperator;
public class MenuHelper extends BaseHelper{

	public MenuHelper(ApplicationManager manager) {
		super(manager);
	}

	public void clickNewFolder() {
		JMenuBarOperator menu = new JMenuBarOperator(mainFrame);
		menu.pushMenuNoBlock("File|New folder...");
		
	}

	public void clickDeleteFolder() {
		JMenuBarOperator menu = new JMenuBarOperator(mainFrame);
		menu.pushMenuNoBlock("File|Delete");
	}

}
