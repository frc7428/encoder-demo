/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.LowerElevatorCommand;
import frc.robot.commands.RaiseElevatorCommand;
import frc.robot.commands.StopElevatorCommand;
import frc.robot.subsystems.ElevatorSubsystem;

/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  private final ElevatorSubsystem mElevator = new ElevatorSubsystem();

  private final StopElevatorCommand mStopElevator = new StopElevatorCommand(mElevator);
  private final RaiseElevatorCommand mRaiseElevator = new RaiseElevatorCommand(mElevator);
  private final LowerElevatorCommand mLowerElevator = new LowerElevatorCommand(mElevator);

  private final Joystick mJoystick = new Joystick(Constants.USB.MECHANISM_JOYSTICK);

  /**
   * The container for the robot.  Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  // It's important that we have a way to reset the subsystems.
  // Adding this method and calling it in Robot.java is helpful!
  // Make sure to look at everywhere it's used in Robot.java.
  public void resetSubsystems() {
    mElevator.reset();
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    JoystickButton raise = new JoystickButton(mJoystick, Constants.MECHANISM_JOYSTICK_BUTTON.RAISE_ELEVATOR);
    raise.whileHeld(mRaiseElevator).whenReleased(mStopElevator);

    JoystickButton lower = new JoystickButton(mJoystick, Constants.MECHANISM_JOYSTICK_BUTTON.LOWER_ELEVATOR);
    lower.whileHeld(mLowerElevator).whenReleased(mStopElevator);
  }


  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // An ExampleCommand will run in autonomous
    return null;
  }
}
