// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

  public static class driveConstants {
    public static final int kTankMotorFL = 0;
    public static final int kTankMotorFR = 1;
    public static final int kTankMotorBL = 2;
    public static final int kTankMotorBR = 3;

    public static final boolean kIsInvertedFL = false; //check these 4
    public static final boolean kIsInvertedFR = false;
    public static final boolean kIsInvertedBL = false;
    public static final boolean kIsInvertedBR = false;

    //Note we are calling the side with the battery and switch the front

    public static final double CONTROLLER_DEADZONE = 0; //this needs adjusting
    public static final double CONTROLLER_Z_AXIS_DEADZONE = 0; //same
    public static final double FORWARD_SPEED_MULTIPLIER = 1; //check

    public static final double ROTATION_SPEED_MULTIPLIER = 1; //check again

  }

  public static class BookConstants {
    public static final int kBookMotor = 1;
    public static final double kEncoderDeadzone = 0;
  }
}
