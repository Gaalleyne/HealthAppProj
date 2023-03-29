import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;

import java.util.ArrayList;
import java.util.List;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;

public class GUIDeviceContents {
	ArrayList<Integer> deviceInfo; // ArrayList class attribute that will hold info of device passed in
	
	public GUIDeviceContents(ArrayList<Integer> devNum)
	{
		this.deviceInfo = devNum; // stores data into the ArrayList
	}
	
	public String toStr(ArrayList<Integer> devNum) // outputs ArrayList as actual text.
	{
		String str = "";
		
		for(Integer i: devNum)
		{ str = str + " " + i; }
		
		return str;
	}
	
	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 */

	/**
	 * Open the window.
	 * @wbp.parser.entryPoint
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(402, 547);
		shell.setText("Health App");
		
		// label for unidentified user
		Label lblMyDevices = new Label(shell, SWT.WRAP | SWT.CENTER);
		lblMyDevices.setFont(SWTResourceManager.getFont("Times New Roman CE", 12, SWT.BOLD));
		lblMyDevices.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblMyDevices.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblMyDevices.setBounds(26, 20, 310, 56);
		lblMyDevices.setText("Welcome, xyz! Your device information is:");
		
		// Button(?) holds info of device. Can be changed to label.
		// Added using the toStr method with device info ArrayList as parameter
		Button btnDeviceInfo = new Button(shell, SWT.WRAP);
		btnDeviceInfo.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnDeviceInfo.setBackground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		btnDeviceInfo.setFont(SWTResourceManager.getFont("Times New Roman CE", 9, SWT.NORMAL));
		btnDeviceInfo.setText(toStr(deviceInfo));
		btnDeviceInfo.setBounds(78, 114, 197, 104);
		
		// Sends info to cloud
		Button btn_toCloud = new Button(shell, SWT.NONE);
		btn_toCloud.setText("Upload to Cloud");
		btn_toCloud.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btn_toCloud.setBackground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		btn_toCloud.setFont(SWTResourceManager.getFont("Times New Roman CE", 9, SWT.NORMAL));
		btn_toCloud.setBounds(78, 254, 197, 68);
		
		// reads incoming data
		Button btnReadData = new Button(shell, SWT.NONE);
		btnReadData.setText("Read data");
		btnReadData.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnReadData.setBackground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		btnReadData.setFont(SWTResourceManager.getFont("Times New Roman CE", 9, SWT.NORMAL));
		btnReadData.setBounds(78, 354, 197, 68);
	}

}
