
package org.usfirst.frc.team2144.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import org.usfirst.frc.team2144.robot.OI;
import org.usfirst.frc.team2144.robot.Robot;
import org.usfirst.frc.team2144.robot.subsystems.Drivetrain;
import org.usfirst.frc.team2144.robot.commands.CommandBase;

/**
 *
 */
public class GatorDrive extends CommandBase {

    public GatorDrive() {
        // Use requires() here to declare subsystem dependencies
        requires(drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	drivetrain.gatorDrive(oi.getPrecise(), oi.getb4(), oi.getb5(), oi.getStickX(), oi.getStickY()); 
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
