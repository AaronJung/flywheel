/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.SetLowPowerAuto5;
import frc.robot.commands.SetPower;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {

  public OI(){
    SmartDashboard.putData("10%", new SetPower(10));
//     SmartDashboard.putData("10% 5sec", new SetLowPowerAuto5());
    SmartDashboard.putData("50%", new SetPower(50));
    SmartDashboard.putData("STOP", new SetPower(0));
    SmartDashboard.putData("reverse", new SetPower(-10));
  }
}
