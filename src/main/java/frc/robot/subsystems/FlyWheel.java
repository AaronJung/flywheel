/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRX;
//import java.util.Timer;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class FlyWheel extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

private final TalonSRX m_flywheel;

  public FlyWheel() {
//constructor, only runs once
m_flywheel = new TalonSRX(0);

}



public void setPower(/*parameter called power*/double power){
/*setPower is a method*/
//m_flywheel.set(speed);
  m_flywheel.set(null, power);
//needs controlMode.percentOutput or TalonSRX, sets % of maximum voltage to motor
}

public void setLowPower(/*No parameter*/){
//command used to set motor to 10% or .1 power
    setPower(.1);
}

public void setMedPower(/*No parameter*/){
  //command used to set motor to 50% or .5 power
      setPower(.5);
  }

public void stopPower(){
  //safety measure to stop power
  setPower(0);
}

public void setLowPowerAuto5(/*No parameter*/){
  //10% for 5000 milliseconds
  long startTime = System.currentTimeMillis();
  long elapsedTime = System.currentTimeMillis() - startTime;
  while(elapsedTime <= 5000){
    setPower(.1);
    elapsedTime = System.currentTimeMillis() - startTime;
  }
//    Timer timer = new Timer();
}

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    //method example
  }
}
