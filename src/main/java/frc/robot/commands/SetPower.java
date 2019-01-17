/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
//import frc.robot.subsystems.FlyWheel;

public class SetPower extends Command {

  private double m_power;
  public SetPower(double power) {
    m_power = power;
    requires(Robot.flyWheel);
  }

  @Override
  protected void initialize() {
  }

  @Override
  protected void execute() {
    Robot.flyWheel.setPower(m_power);
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
