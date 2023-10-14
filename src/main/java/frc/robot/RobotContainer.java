// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...

  
  // Replace with CommandPS4Controller or CommandJoystick if needed
  private final Joystick joy1 = new Joystick(Constants.USBOrder.Zero);

  private final DriveTrain dt = new DriveTrain();
  private final PIDTurn pid = new PIDTurn(dt, 90.0f);

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer() {
    dt.setDefaultCommand(pid);
    // Configure the trigger bindings
    configureBindings();
  }

  private void configureBindings() {
 
  }

  public Command getAutonomousCommand() {
    // An example command will be run in autonomous
    return pid;
  }
}
