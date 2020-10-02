/*----------------------------------------------------------------------------*/
/* Copyright (c) 2019 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ElevatorSubsystem extends SubsystemBase {
  private final SpeedController mElevatorMotor = new PWMVictorSPX(Constants.PWM.ELEVATOR_MOTOR);

  // False means we don't want the encoder reversed.
  // If you find that lowering the elevator makes the distance positive, you should make this true.
  private final Encoder mEncoder = new Encoder(Constants.DIGITAL_INPUT.ELEVATOR_A, Constants.DIGITAL_INPUT.ELEVATOR_B, false);
  /**
   * Creates a new ElevatorSubsystem.
   */
  public ElevatorSubsystem() {
    mEncoder.setDistancePerPulse(Constants.ELEVATOR_UNITS.INCHES_PER_REV / Constants.ELEVATOR_UNITS.PULSES_PER_REV);
  }

  /**
   * Giving the subsystem a reset method is important
   * because the encoder will need to be reset to 0 sometimes.
   */
  public void reset() {
    mEncoder.reset();
  }

  /**
   * In the raise method, we only want to raise if we are below the max!
   */
  public void raise() {
    if (mEncoder.getDistance() >= Constants.ELEVATOR_UNITS.MAX_INCHES) {
      stop();
    } else {
      mElevatorMotor.set(1);
    }

  }

  /**
   * In the lower method, we only want to lower if we are above the min!
  */
  public void lower() {
    if (mEncoder.getDistance() <= Constants.ELEVATOR_UNITS.MIN_INCHES) {
      stop();
    } else {
      mElevatorMotor.set(-1);
    }
  }

  public void stop() {
    mElevatorMotor.stopMotor();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }
}
