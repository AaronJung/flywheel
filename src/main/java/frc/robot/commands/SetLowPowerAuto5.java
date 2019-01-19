/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class SetLowPowerAuto5 extends Command {

  int m_time;
  public SetLowPowerAuto5(int time) {
    m_time = time;
    requires(Robot.flyWheel);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Robot.flyWheel.setLowPowerAuto5(m_time);
  }

  @Override
  protected boolean isFinished() {
    return false;
  }

  @Override
  protected void end() {
  }

  @Override
  protected void interrupted() {
  }
}
