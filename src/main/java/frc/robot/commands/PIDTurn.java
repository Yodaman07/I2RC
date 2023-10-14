package frc.robot.commands;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrain;


public class PIDTurn extends CommandBase {
    public DriveTrain dt;
    public double setPointAngle;
    public int motorSign;
    public PIDController pidController = new PIDController((0.3/90),0,0);
    //(0.3/90)
    //P constant: divide power of motor by max error
    //Max error is the setpoint from 0

    public PIDTurn(DriveTrain dt, float setPointAngle) {
        this.dt = dt;
        this.setPointAngle = setPointAngle;

        if (motorSign == 1){
            //counter-clockwise rotation
        }else{
            //clockwise rotation
        }

        // each subsystem used by the command must be passed into the
        // addRequirements() method (which takes a vararg of Subsystem)
        addRequirements(dt);
    }


    @Override
    public void initialize() {
        dt.resetNavx();
        //Navx is a sensor that gets the angle of the robot

    }

    @Override
    public void execute() {

    }

    @Override
    public boolean isFinished() {
        // TODO: Make this return true when this Command no longer needs to run execute()
        return false;
    }

    @Override
    public void end(boolean interrupted) {

    }
}
