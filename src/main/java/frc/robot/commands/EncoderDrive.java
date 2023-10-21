package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.DriveTrain;


public class EncoderDrive extends CommandBase {
    private final DriveTrain dt;
    private int metersDriven;
    private final int setpointDistance;
    public final int EncoderTicksPerRev = Constants.MiscConstants.EncoderTicksPerRev;
    public final double Diameter = Constants.MiscConstants.WheelDiameter;
    public EncoderDrive(DriveTrain dt, int setpointDistance) {
        this.dt = dt;
        this.setpointDistance = setpointDistance;

        addRequirements(this.dt);
    }
    @Override
    public void initialize() {
        dt.resetEncoders();
        dt.tankDrive(0,0);
    }

    @Override
    public void execute() {
        double ticksPerRev = Diameter * 3.14 / EncoderTicksPerRev;
        double ticks = dt.getTicks();
        metersDriven = (int) (ticksPerRev/ticks);
        SmartDashboard.putNumber("Distance Traveled", metersDriven);
        dt.tankDrive(0.3, 0.3);
    }

    @Override
    public boolean isFinished() {
        return metersDriven >= setpointDistance;
    }
    @Override
    public void end(boolean interrupted) {
        dt.tankDrive(0,0);
    }
}
