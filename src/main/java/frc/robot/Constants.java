/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018-2019 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants.  This class should not be used for any other purpose.  All constants should be
 * declared globally (i.e. public static).  Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static final class PWM {
    public static final int ELEVATOR_MOTOR = 0;
  }

  // If your encoder is analog, you would use the analog inputs, instead.
  public static final class DIGITAL_INPUT {
    public static final int ELEVATOR_A = 0;
    public static final int ELEVATOR_B = 1;
  }

  public static final class USB {
    public static final int MECHANISM_JOYSTICK = 0;
  }

  public static final class MECHANISM_JOYSTICK_BUTTON {
    public static final int RAISE_ELEVATOR = 1;
    public static final int LOWER_ELEVATOR = 2;
  }


  public static final class ELEVATOR_UNITS { 
    // This value depends on your encoder. Read the info sheet for it.
    public static final int PULSES_PER_REV = 20;

    // This value depends on how far the elevator actually moves in one revolution. Check your gear ratios.
    // It's important for this value to be a double, not an int!!!
    public static final double INCHES_PER_REV = 12.0;

    // These values depend on what you want the max and min to be.
    public static final double MAX_INCHES = 36.0;
    public static final double MIN_INCHES = -36.0;
  }
}
