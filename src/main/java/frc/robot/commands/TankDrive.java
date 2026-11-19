package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.RobotContainer;
import edu.wpi.first.wpilibj2.command.Command;

public class TankDrive extends Command{
    
	public TankDrive() {
		addRequirements(RobotContainer.driveTrain);
  	}

	@Override
	public void initialize() {
		RobotContainer.driveTrain.FLMset(0);
		RobotContainer.driveTrain.FRMset(0);
		RobotContainer.driveTrain.BLMset(0);
		RobotContainer.driveTrain.BRMset(0);
    }

	@Override
	public void execute() {

		double driverAxisX = RobotContainer.controller.getRawAxis(0);
		double driverAxisY = -RobotContainer.controller.getRawAxis(1);
		double driverAxisZ = RobotContainer.controller.getRawAxis(2);
		
		double rotationLeftMotors = 0;
		double rotationRightMotors = 0;
		double motorSpeed = 0;
		
		if (Math.abs(driverAxisY) < Constants.driveConstants.CONTROLLER_DEADZONE) {
			driverAxisY = 0;
		}

		if (Math.abs(driverAxisX) < Constants.driveConstants.CONTROLLER_Z_AXIS_DEADZONE)
		{
			driverAxisX = 0;
		}


		motorSpeed = driverAxisY * Constants.driveConstants.FORWARD_SPEED_MULTIPLIER;
		
		rotationLeftMotors = driverAxisZ * Constants.driveConstants.ROTATION_SPEED_MULTIPLIER;
		rotationRightMotors = driverAxisZ * -Constants.driveConstants.ROTATION_SPEED_MULTIPLIER;
		

		RobotContainer.driveTrain.FRMset((rotationRightMotors+motorSpeed));
		RobotContainer.driveTrain.FLMset((rotationLeftMotors+motorSpeed));
		RobotContainer.driveTrain.BRMset((rotationRightMotors+motorSpeed));
		RobotContainer.driveTrain.BLMset((rotationLeftMotors+motorSpeed));
  	}

	// Called once the command ends or is interrupted.
	@Override
	public void end(boolean interrupted) 
	{
		initialize();
	}

	// Returns true when the command should end.
	@Override
	public boolean isFinished()
	{
		return false;
	}
}