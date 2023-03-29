import org.eclipse.swt.SWT;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.wb.swt.SWTResourceManager;
import java.util.Scanner;
import java.io.*;

public class GUIAddDevice {

	protected Shell shell;
	Button btnDevice1;
	Button btnDevice2;
	Button btnDevice3;
	
	public GUIAddDevice() 
	{
		createContents();
	}

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
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		shell.setSize(402, 547);
		shell.setText("Health App");
		File buttonStatuses;
		Scanner fileScan;
		
		Label lblAvailableDevices = new Label(shell, SWT.NONE);
		lblAvailableDevices.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblAvailableDevices.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblAvailableDevices.setFont(SWTResourceManager.getFont("Times New Roman CE", 12, SWT.BOLD));
		lblAvailableDevices.setBounds(26, 35, 198, 34);
		lblAvailableDevices.setText("Available devices to add");
		
		// Available slot device 1
		btnDevice1 = new Button(shell, SWT.WRAP);
		btnDevice1.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnDevice1.setBackground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		btnDevice1.setFont(SWTResourceManager.getFont("Times New Roman CE", 9, SWT.NORMAL));
		btnDevice1.setBounds(55, 111, 244, 84);
		btnDevice1.setText("Device 1");
		
		// Available slot device 2
		btnDevice2 = new Button(shell, SWT.NONE);
		btnDevice2.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnDevice2.setBackground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		btnDevice2.setFont(SWTResourceManager.getFont("Times New Roman CE", 9, SWT.NORMAL));
		btnDevice2.setBounds(55, 243, 244, 84);
		btnDevice2.setText("Device 2");
		
		// Available slot device 3
		btnDevice3 = new Button(shell, SWT.NONE);
		btnDevice3.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnDevice3.setBackground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		btnDevice3.setFont(SWTResourceManager.getFont("Times New Roman CE", 9, SWT.NORMAL));
		btnDevice3.setBounds(55, 371, 244, 84);
		btnDevice3.setText("Device 3");
		
		// File-handling to update status of added devices (added/not added, enabled/disabled)
		try 
		{
			buttonStatuses = new File("AllDeviceStatus.txt");
			fileScan = new Scanner(buttonStatuses).useDelimiter(", ");
			
			// file composed of 3 words (true/false true/false true/false) representing the
			// status of devices 1, 2 and 3 respectively. Added devices will be disabled (false)
			btnDevice1.setEnabled(Boolean.parseBoolean(fileScan.next()));
			btnDevice2.setEnabled(Boolean.parseBoolean(fileScan.next()));
			btnDevice3.setEnabled(Boolean.parseBoolean(fileScan.next()));
			
			fileScan.close();
		}
		catch(Exception e)
		{ e.printStackTrace(); }
		
		// on click, overwrite file to change device 1's added status from true to false.
		btnDevice1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				//FIXME: Add Device
				try {
					String[] arr = new String[3]; // references the status of 3 devices
					File buttonStatuses = new File("AllDeviceStatus.txt");
					Scanner fileScan = new Scanner(buttonStatuses).useDelimiter(", "); // handle CSV
					
					for(int i = 0; i < 3; i++)
					{
						arr[i] = fileScan.next(); // store device statuses from file in array
					}
					fileScan.close();
					
					FileWriter fileWrite = new FileWriter("AllDeviceStatus.txt");
					fileWrite.write("false" + ", " + arr[1] + ", " + arr[2]); // rewrite using old statuses and 'false' pertaining to device added
					fileWrite.close();
					
				}
				catch(Exception f)
				{ f.printStackTrace(); }
				shell.dispose();
				
				// close window and return to menu
				GUIHealthApp g = new GUIHealthApp();
				g.open();
			}
		});
		
		// on click, overwrite file to change device 2's added status from true to false.
		btnDevice2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				try {
					String[] arr = new String[3]; // references the status of 3 devices
					File buttonStatuses = new File("AllDeviceStatus.txt");
					Scanner fileScan = new Scanner(buttonStatuses).useDelimiter(", "); // handle CSV
					
					for(int i = 0; i < 3; i++)
					{
						arr[i] = fileScan.next();  // rewrite using old statuses and 'false' pertaining to device added
					}
					fileScan.close();
					
					FileWriter fileWrite = new FileWriter("AllDeviceStatus.txt");
					fileWrite.write(arr[0] + ", " + "false" + ", " + arr[2]); // rewrite using old statuses and 'false' pertaining to device added
					fileWrite.close();
					
				}
				catch(Exception f)
				{
					f.printStackTrace();
				}
				shell.dispose();
				
				// close window and return to menu
				GUIHealthApp g = new GUIHealthApp();
				g.open();
			}
		});
		
		// on click, overwrite file to change device 3's added status from true to false.
		btnDevice3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				try {
					String[] arr = new String[3]; // references the status of 3 devices
					File buttonStatuses = new File("AllDeviceStatus.txt");
					Scanner fileScan = new Scanner(buttonStatuses).useDelimiter(", "); // handle CSV
					
					for(int i = 0; i < 3; i++)
					{
						arr[i] = fileScan.next();
					}
					fileScan.close();
					
					FileWriter fileWrite = new FileWriter("AllDeviceStatus.txt");
					fileWrite.write(arr[0] + ", " + arr[1] + ", " + "false"); // rewrite using old statuses and 'false' pertaining to device added
					fileWrite.close();
					
				}
				catch(Exception f)
				{
					f.printStackTrace();
				}
				shell.dispose();
				
				// close window and return to menu
				GUIHealthApp g = new GUIHealthApp();
				g.open();
			}
		});
	}

}
