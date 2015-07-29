package com.example.fw;

import javax.swing.JDialog;

import org.netbeans.jemmy.operators.JDialogOperator;
import org.netbeans.jemmy.operators.JFrameOperator;
import org.netbeans.jemmy.operators.JLabelOperator;

public class BaseHelper {
	
	protected final ApplicationManager manager;
	protected final JFrameOperator mainFrame;

	public BaseHelper(ApplicationManager manager) {
		this.manager = manager;
		this.mainFrame = manager.getApplication();
	}

	protected String waitMessageDialog(String message, int timeout) {
		long start = System.currentTimeMillis();
		long currantTime = start;
		while (currantTime < start + timeout) {
			JDialog dialog = JDialogOperator.findJDialog(mainFrame.getOwner(), message, false, false);
			if (dialog != null) {
				JDialogOperator dialogOp = new JDialogOperator(dialog);
				String warning = new JLabelOperator(dialogOp).getText();
				dialogOp.requestClose();
				return warning;
			}
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			currantTime = System.currentTimeMillis();
		}
		return null;
	}

}
