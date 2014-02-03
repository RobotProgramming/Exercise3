package Ex3Part1;

import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.Sound;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.Delay;


public class PropFeed extends RobotProgrammingDemo {

	private final SensorPort m_port;
	private final DifferentialPilot pilot = new DifferentialPilot(2.1f, 4.4f,
			Motor.A, Motor.C, true); // parameters in inches


	public PropFeed(SensorPort _port) {
		super();
		m_port = _port;
	}

	public void run() {
		//pilot.backward();
		UltrasonicSensor Sensor = new UltrasonicSensor(SensorPort.S1);
		Sensor.continuous();
		Sound.setVolume(100000000);
		while( m_run)
		{
			pilot.backward();
			float distance = Sensor.getDistance();
			int freq = (int) (distance/5);
			pilot.setTravelSpeed(freq);
			Delay.msDelay(1);
		}
	}

	public static void main(String[] args) {
		Button.waitForAnyPress();
		PropFeed PF = new PropFeed(SensorPort.S1);
		PF.run();

	}

}
