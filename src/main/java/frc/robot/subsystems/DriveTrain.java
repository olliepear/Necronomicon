// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import frc.robot.Constants;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import edu.wpi.first.wpilibj.motorcontrol.Spark;

public class DriveTrain extends SubsystemBase {

	Spark frontRightMotor = new Spark(Constants.driveConstants.kTankMotorFR);
	Spark frontLeftMotor = new Spark(Constants.driveConstants.kTankMotorFL); 
	Spark backRightMotor = new Spark(Constants.driveConstants.kTankMotorBR);
	Spark backLeftMotor = new Spark(Constants.driveConstants.kTankMotorBL);


	public DriveTrain() {
        backLeftMotor.setInverted(false);
		backRightMotor.setInverted(true);
		frontLeftMotor.setInverted(false);
		frontRightMotor.setInverted(true);
    }

	@Override
	public void periodic() {}

	@Override
	public void simulationPeriodic() {}


	public void FLMset(double speed) {
		if (speed >= -1 && speed <= 1) {frontLeftMotor.set(speed);}
		else {frontLeftMotor.set(0);}
	}

	public void FRMset(double speed) {
		if (speed >= -1 && speed <= 1) {frontRightMotor.set(speed);}
		else {frontRightMotor.set(0);}
	}

	public void BRMset(double speed) {
		if (speed >= -1 && speed <= 1) {backRightMotor.set(speed);}
		else {backRightMotor.set(0);}
	}
	public void BLMset(double speed) {
		if (speed >= -1 && speed <= 1) {backLeftMotor.set(speed);}
		else {backLeftMotor.set(0);}
	}	
}