
package org.usfirst.frc.team2144.robot.subsystems;

import edu.wpi.first.wpilibj.RobotDrive;
import org.usfirst.frc.team2144.robot.RobotMap;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ni.vision.NIVision;
import com.ni.vision.NIVision.DrawMode;
import com.ni.vision.NIVision.Image;
import com.ni.vision.NIVision.ShapeMode;

import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.vision.AxisCamera;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.I2C;
import edu.wpi.first.wpilibj.Relay;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.Compressor;

/**
 *
 */
public class Drivetrain extends Subsystem {

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public RobotDrive robit;
	public Talon fLeft, fRight, bLeft, bRight;

	public Drivetrain() {
		fLeft = new Talon(RobotMap.fLeftPort);
		fRight = new Talon(RobotMap.fRightPort);
		bLeft = new Talon(RobotMap.bLeftPort);
		bRight = new Talon(RobotMap.bRightPort);
		robit = new RobotDrive(fLeft, bLeft, fRight, bRight);
	}
	
	public void gatorDrive(boolean isPrecise, boolean b4, boolean b5, double stickX, double stickY) {
		if (isPrecise) {
			speedMultiplier = 0.5;
			mecanumMultiplier = 0.4;
		} else {
			if (speedMultiplier < 1) {
				speedMultiplier += 0.05;
			}
			if (mecanumMultiplier < 1) {
				mecanumMultiplier += 0.1;
			}
		}

		if (b4 && isPrecise) {// drive code
			robit.mecanumDrive_Polar(0.3, 90, -1 * stickX);
		} else if (b5 && isPrecise) {
			robit.mecanumDrive_Polar(0.3, 270, -1 * stickX);
		} else if (b4) {// drive code
			robit.mecanumDrive_Polar(mecanumMultiplier, 90, -1 * stickX);
		} else if (b5) {
			robit.mecanumDrive_Polar(mecanumMultiplier, 270,
					-1 * stickX);
		}

		else {
			if (isPrecise) {
				robit.arcadeDrive(stickX * -0.5, stickY * -0.5);
			} else {
				robit.arcadeDrive(stickX * -speedMultiplier,
						stickY * -speedMultiplier);
			}
		}
	}

	public void initDefaultCommand() {
		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
}
