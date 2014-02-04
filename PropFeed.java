package Ex3Part1;

import lejos.nxt.Button;
import lejos.nxt.LightSensor;
import lejos.nxt.Motor;
import lejos.nxt.SensorPort;
import lejos.nxt.UltrasonicSensor;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.Delay;

public class PropFeed extends RobotProgrammingDemo {

	private final SensorPort ultrasonic;
	private final SensorPort lightSensorLeft;
	private final SensorPort lightSensorRight;

	private final DifferentialPilot pilot = new DifferentialPilot(2.1f, 4.4f,
			Motor.A, Motor.C, true); // parameters in inches

	public PropFeed(SensorPort _port, SensorPort _port2, SensorPort _port3) {
		super();
		ultrasonic = _port;
		lightSensorRight = _port2;
		lightSensorLeft = _port3;
	}

	public void run() {
		UltrasonicSensor Sensor = new UltrasonicSensor(ultrasonic);
		LightSensor leftLight = new LightSensor(lightSensorLeft);
		LightSensor rightLight = new LightSensor(lightSensorRight);

		while (m_run) {
			pilot.setTravelSpeed(5);
			pilot.backward();
			while (pilot.isMoving()) {
				if (leftLight.readValue() < 33) {
					pilot.rotate(-10);
				}
				if (rightLight.readValue() < 33) {
					pilot.rotate(10);
				}
			}

		}

		/**
		 * Sensor.continuous();
		 * 
		 * while (m_run) { pilot.backward(); float distance =
		 * Sensor.getDistance(); pilot.setTravelSpeed(distance / 5);
		 * Delay.msDelay(100); }
		 **/
	}

	public static void main(String[] args) {
		Button.waitForAnyPress();
		PropFeed PF = new PropFeed(SensorPort.S1, SensorPort.S2, SensorPort.S3);
		PF.run();

	}

}
