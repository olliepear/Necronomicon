package frc.robot.commands;

import frc.robot.Constants;
import frc.robot.RobotContainer;
import frc.robot.AnimationConfig;

import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.spark.SparkMax;
import com.revrobotics.spark.SparkLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.Command;

public class BookControl extends Command{

    public static SparkMax bookController = new SparkMax(Constants.BookConstants.kBookMotor, MotorType.kBrushed);
    public static AbsoluteEncoder bookEncoder = bookController.getAbsoluteEncoder();
    public double angle = bookEncoder.getPosition();

    public AnimationConfig Animation = new AnimationConfig();

    public boolean done = false;

    public int status = 0; //0 means nothing, 1 is closed, 2 is closing, 3 is opening, 4 is open




    @Override
    public void initialize() {
		bookController.set(0);
        if (angle >= 180) {status = 4;}
        if (angle <= 0) {status = 1;}
    }

    @Override
    public void execute() {
        
        if (status == 4 & RobotContainer.controller.getAButton()) {
            status = 2;
        }
        else if (status == 1 & RobotContainer.controller.getAButton()) {
            status = 3;
        }

        if (status == 3) {
            if (angle >= 180) {
                status = 4;
                done = true;
            }
            else {
                bookController.set(Animation.OpenAnimation(angle));
            }
        }
        if (status == 2) {
            if (angle >= 0) {
                status = 1;
                done = true;
            }
            else {
                bookController.set(Animation.CloseAnimation(angle));
            }
        }
    }
}
