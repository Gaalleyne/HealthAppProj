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

public class GUIDeviceList {

	protected Shell shell;
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
		GUIAddDevice addedDevList = new GUIAddDevice(); // object used to later call the add device window
		
		// Displays the devices user currently has registered
		Label lblRegisteredDevices = new Label(shell, SWT.NONE);
		lblRegisteredDevices.setFont(SWTResourceManager.getFont("Times New Roman CE", 12, SWT.BOLD));
		lblRegisteredDevices.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblRegisteredDevices.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblRegisteredDevices.setBounds(26, 35, 310, 34);
		lblRegisteredDevices.setText("User\'s registered devices:");
		
		// Gateway button to device contents. Will pass in device 1's information.
		Button btnDevice1 = new Button(shell, SWT.WRAP);
		btnDevice1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnDevice1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		btnDevice1.setFont(SWTResourceManager.getFont("Times New Roman CE", 9, SWT.NORMAL));
		btnDevice1.setBounds(78, 94, 197, 56);
		btnDevice1.setText("Device 1");
		
		// Check to see if device 1 is actually connected.Checking the button from 
		// the GUIAddDevice window. If it is disabled, then that means the button
		// has already been added and thus can be used. Otherwise, this cannot be accessed.
		if(addedDevList.btnDevice1.isEnabled() == false)
		{   btnDevice1.setEnabled(true); }
		else
		{ btnDevice1.setEnabled(false); }
		
		// Gateway button to device contents. Will pass in device 2's information.
		Button btnDevice2 = new Button(shell, SWT.NONE);
		btnDevice2.setText("Device 2");
		btnDevice2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnDevice2.setBackground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		btnDevice2.setFont(SWTResourceManager.getFont("Times New Roman CE", 9, SWT.NORMAL));
		btnDevice2.setBounds(78, 187, 197, 56);
		
		// Check to see if device 2 is actually connected.Checking the button from 
		// the GUIAddDevice window. If it is disabled, then that means the button
		// has already been added and thus can be used. Otherwise, this cannot be accessed.
		if(addedDevList.btnDevice2.isEnabled() == false)
		{   btnDevice2.setEnabled(true); }
		else
		{ btnDevice2.setEnabled(false); }
		
		// Gateway button to device contents. Will pass in device 2's information.
		Button btnDevice3 = new Button(shell, SWT.NONE);
		btnDevice3.setText("Device 3");
		btnDevice3.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnDevice3.setBackground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		btnDevice3.setFont(SWTResourceManager.getFont("Times New Roman CE", 9, SWT.NORMAL));
		btnDevice3.setBounds(78, 283, 197, 56);
		
		// Check to see if device 1 is actually connected.Checking the button from 
		// the GUIAddDevice window. If it is disabled, then that means the button
		// has already been added and thus can be used. Otherwise, this cannot be accessed.
		if(addedDevList.btnDevice3.isEnabled() == false)
		{   btnDevice3.setEnabled(true); }
		else
		{ btnDevice3.setEnabled(false); }
		
		// Gateway button to GUIAddDevice window.
		Button btnAddDevice = new Button(shell, SWT.NONE);
		btnAddDevice.setText("Add a new device");
		btnAddDevice.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnAddDevice.setBackground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		btnAddDevice.setFont(SWTResourceManager.getFont("Times New Roman CE", 9, SWT.NORMAL));
		btnAddDevice.setBounds(55, 374, 244, 84);
		
		// on click, information will be sent to GUIDeviceContents and the window will be opened.
		btnDevice1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shell.dispose();
				// default ArrayList of placeholder information. Ideally will be replaced with
				// actual information.
				ArrayList<Integer> aL = new ArrayList<Integer>(List.of(1, 2, 4, 5, 6, 123));
				GUIDeviceContents gContents = new GUIDeviceContents(aL);
				gContents.open();
			}
		});
		
		// on click, information will be sent to GUIDeviceContents and the window will be opened.
		btnDevice2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shell.dispose();
				// default ArrayList of placeholder information. Ideally will be replaced with
				// actual information.
				ArrayList<Integer> aL = new ArrayList<Integer>(List.of(2, 4, 75, 6, 6892, 1));
				GUIDeviceContents gContents = new GUIDeviceContents(aL);
				gContents.open();
			}
		});
		
		// on click, information will be sent to GUIDeviceContents and the window will be opened.
		btnDevice3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shell.dispose();
				// default ArrayList of placeholder information. Ideally will be replaced with
				// actual information.
				ArrayList<Integer> aL = new ArrayList<Integer>(List.of(6, 4, 9, 23, 14342, 1533));
				GUIDeviceContents gContents = new GUIDeviceContents(aL);
				gContents.open();
			}
		});
		
		// on click, the GUIAddDevice window will be opened.
		btnAddDevice.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shell.dispose();
				GUIAddDevice gAdd = new GUIAddDevice();
				gAdd.open();
			}
		});
	}

}
