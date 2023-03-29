import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.SWT;
import org.eclipse.wb.swt.SWTResourceManager;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.swt.events.MouseAdapter;
import org.eclipse.swt.events.MouseEvent;

public class GUIHealthApp {

	protected Shell shell;
	/**
	 * Launch the application.
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			GUIHealthApp window = new GUIHealthApp();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
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
		shell.setBackground(SWTResourceManager.getColor(SWT.COLOR_WHITE)); // default backdrop
		shell.setSize(402, 547);
		shell.setText("Health App"); // default name
		
		// Greetings label at top of screen
		Label lblGreetingsUser = new Label(shell, SWT.NONE);
		lblGreetingsUser.setFont(SWTResourceManager.getFont("Times New Roman CE", 12, SWT.BOLD));
		lblGreetingsUser.setForeground(SWTResourceManager.getColor(SWT.COLOR_BLACK));
		lblGreetingsUser.setBackground(SWTResourceManager.getColor(SWT.COLOR_TRANSPARENT));
		lblGreetingsUser.setBounds(26, 35, 198, 34);
		lblGreetingsUser.setText("Greetings, user");
		
		// Unclear whether to make button or label. If a button, this would
		// ideally create a new window where such health recommendations
		// can be shown.
		Button btnHealthRecs = new Button(shell, SWT.WRAP);
		btnHealthRecs.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnHealthRecs.setBackground(SWTResourceManager.getColor(SWT.COLOR_DARK_GREEN));
		btnHealthRecs.setFont(SWTResourceManager.getFont("Times New Roman CE", 9, SWT.NORMAL));
		btnHealthRecs.setBounds(55, 111, 244, 84);
		btnHealthRecs.setText("Any smart health recommendations");
		
		// Button that acts as a gateway to the device selection window
		Button btnGetDeviceList = new Button(shell, SWT.NONE);
		btnGetDeviceList.setText("Show my device list");
		btnGetDeviceList.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnGetDeviceList.setBackground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		btnGetDeviceList.setFont(SWTResourceManager.getFont("Times New Roman CE", 9, SWT.NORMAL));
		btnGetDeviceList.setBounds(55, 243, 244, 84);
		
		// Button that acts as a gateway to the add device window
		Button btnAddDevice = new Button(shell, SWT.NONE);
		btnAddDevice.setText("Add a new device");
		btnAddDevice.setForeground(SWTResourceManager.getColor(SWT.COLOR_WHITE));
		btnAddDevice.setBackground(SWTResourceManager.getColor(SWT.COLOR_LINK_FOREGROUND));
		btnAddDevice.setFont(SWTResourceManager.getFont("Times New Roman CE", 9, SWT.NORMAL));
		btnAddDevice.setBounds(55, 371, 244, 84);
		
		//Is this intended to do something when clicked on?
		btnHealthRecs.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				//FIXME: Add Screen
			}
		});
		
		// Calls GUIDeviceList Class to open the window that shows all the user's
		// current devices.
		btnGetDeviceList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseDown(MouseEvent e) {
				shell.dispose();
				GUIDeviceList gList = new GUIDeviceList();
				gList.open();
			}
		});
		
		// Calls GUIAddDevice Class to open the window that enables the user to
		// add new devices to the health app.
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
