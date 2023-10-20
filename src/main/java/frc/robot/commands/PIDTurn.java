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
        pidController.setTolerance(5.0);

        if (setPointAngle > 0){
            //counter-clockwise rotation
            motorSign = 1;
        }else{
            //clockwise rotation
            motorSign = -1;
        }

        // each subsystem used by the command must be passed into the
        // addRequirements() method (which takes a vararg of Subsystem)
        addRequirements(dt);
    }


    @Override
    public void initialize() {
        dt.resetNavx();
        dt.tankDrive(0,0);
        //Navx is a sensor that gets the angle of the robot

    }

    @Override
    public void execute() {
        double output = pidController.calculate(dt.getAngle(), setPointAngle);
        //current angle and desired angle of robot are params of pidController.calculate
        dt.tankDrive(-output*motorSign,output*motorSign);
    }

    @Override
    public boolean isFinished() {
        return pidController.atSetpoint();
    }

    @Override
    public void end(boolean interrupted) {
        dt.tankDrive(0,0);
    }
}
