//Dkit's robot
package Dkit;

import java.awt.Color;
import robocode.Robot;
import robocode.ScannedRobotEvent;

public class FruitSalad extends Robot {

	int RandomAngle = 0, Range, LeftOrRight;
	int MIN = 60, MAX = 105;//min and max for number generator
	boolean sentryInit = false; // set initialization for looking for Sentry the
								// first time

	public void run() {
		setBulletColor(Color.cyan);
		setBodyColor(Color.yellow);
		setGunColor(Color.pink);
		setRadarColor(Color.blue);

		// Release the Radar and spin to scan for Sentry while not moving too
		// much
		setAdjustGunForRobotTurn(true);
		while (!sentryInit) {
			turnGunRight(90);
			// keep Scanning till Sentry flag turn true
		}
		turnGunRight(getHeading() - getGunHeading()); // Set the Gun and Body to the same heading
		setAdjustGunForRobotTurn(false);
		//

		while (true) {
			Range = MAX - MIN;
			RandomAngle = (int) Math.floor(Math.random() * Range + MIN);
			LeftOrRight = (int) Math.floor(Math.random() * 2 + 1);
			turnGunRight(360);
			if (LeftOrRight == 1) {
				turnRight(RandomAngle);
			}
			if (LeftOrRight == 2) {
				turnLeft(RandomAngle);
			}//turn at a random angle in a random direction
			ahead(160);
		}
	}

	public void onScannedRobot(ScannedRobotEvent e) {
		// turn the head back and run away
		if (e.isSentryRobot() && !sentryInit) {
			sentryInit = true;
			if (e.getBearing() > 0) {
				turnLeft(160 - e.getBearing());
			} else {
				turnRight(160 - Math.abs(e.getBearing())); // avoid 180, flip the heading totally
			}
			ahead(400);
		} //
		if (!e.isSentryRobot()) {
			if (e.getDistance() <= 60) {
				fire(3);
				fire(3);
			} else if (e.getDistance() <= 150) {
				fire(3);
			} else if (e.getDistance() <= 400) {
				fire(2);
			} else {
				fire(1);
			}
			scan();//fire a different bullet depending on how close you are to the robot
		} 
		
	}

}