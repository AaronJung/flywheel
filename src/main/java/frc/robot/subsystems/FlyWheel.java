/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
//import java.util.Timer;

import edu.wpi.first.wpilibj.command.Subsystem;

public class FlyWheel extends Subsystem {

  private final TalonSRX m_flywheel;

  public FlyWheel() {
    //constructor, only runs once
    m_flywheel = new TalonSRX(1);
  }

  public void setPower(double power){
      m_flywheel.set(ControlMode.PercentOutput, power);
     //needs controlMode.percentOutput or TalonSRX, sets % of maximum voltage to motor
  }

  public void setLowPowerAuto5(){
    //10% for 5000 milliseconds
    long startTime = System.currentTimeMillis();
    long elapsedTime = System.currentTimeMillis() - startTime;
    while(elapsedTime <= 5000){
      setPower(.1);
      elapsedTime = System.currentTimeMillis() - startTime;
    }
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    //method example
  }
}
