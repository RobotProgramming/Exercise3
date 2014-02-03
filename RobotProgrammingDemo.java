import lejos.nxt.ButtonListener;
import lejos.nxt.Button;

/**
 * A class that can be extended by any other classes in order to use the
 * variable m_run without having to create a button listener each time.
 * 
 * Creates a value m_run as protected so that it can be used by a subclass.
 * 
 * @author rxs331
 * 
 */
public class RobotProgrammingDemo implements Runnable {

	protected boolean m_run = true;

	/**
	 * Adds a button listener onto the Escape button, when the button is pressed
	 * it does nothing and when the button is released, the value of m_run is
	 * changed to false.
	 * 
	 */
	public RobotProgrammingDemo() {

		Button.ESCAPE.addButtonListener(new ButtonListener() {

			@Override
			public void buttonReleased(Button _b) {
				m_run = false;
			}

			@Override
			public void buttonPressed(Button _b) {

			}

		});

	}

	/**
	 * Blank run class to be implemented by classes that extend this class.
	 */
	public void run() {
		// TODO Auto-generated method stub

	}

}
