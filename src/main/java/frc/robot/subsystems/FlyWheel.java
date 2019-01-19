/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
//import frc.robot.Robot;

public class FlyWheel extends Subsystem {

  private final TalonSRX m_flywheel;

  private String m_filePath1 = "/media/sda1/logs/";
  private String m_filePath2 = "/home/lvuser/logs/";
  private File m_file;
  private FileWriter m_writer;
  private boolean writeException = false;
  private double m_logStartTime = 0;
  
  private double m_startTime = 0;

  public FlyWheel() {
    m_flywheel = new TalonSRX(1);
  }

  public void setPower(double power){
      m_flywheel.set(ControlMode.PercentOutput, power);
  }

  public void setLowPowerAuto5(int time){
    //10% for 5000 milliseconds
    
    m_startTime = Timer.getFPGATimestamp();
    double timeForAuto = Timer.getFPGATimestamp() - m_startTime;
    
    while(timeForAuto <= time){
      setPower(.1);
    }
    setPower(0);
  }


  public double getPosition(){
    return m_flywheel.getSelectedSensorPosition();
  }
  public double getVelocity(){
    return m_flywheel.getSelectedSensorVelocity();
  }
  public double getVoltage(){
    return m_flywheel.getMotorOutputVoltage();
  }
  public double getCurrent(){
    return m_flywheel.getOutputCurrent();
  }

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
    //method example
  }
  public void startLog() {
    // Check to see if flash drive is mounted.
    File logFolder1 = new File(m_filePath1);
    File logFolder2 = new File(m_filePath2);
    Path filePrefix = Paths.get("");
    if (logFolder1.exists() && logFolder1.isDirectory()) {
        filePrefix = Paths.get(logFolder1.toString(),
          "2018_03_10_" + "FlyWheel");
    } else if (logFolder2.exists() && logFolder2.isDirectory()) {
        filePrefix = Paths.get(logFolder2.toString(),
          "2018_03_10_" + "FlyWheel");
    } else {
        writeException = true;
    }
  
    if (!writeException) {
        int counter = 0;
        while (counter <= 99) {
      m_file = new File(filePrefix.toString() + String.format("%02d", counter) + ".csv");
      if (m_file.exists()) {
          counter++;
      } else {
          break;
      }
      if (counter == 99) {
          System.out.println("file creation counter at 99!");
      }
        }
        try {
          m_writer = new FileWriter(m_file);
          m_writer.append("Time,Position,Velocity,Voltage,Current\n");
          m_logStartTime = Timer.getFPGATimestamp();
        } catch (IOException e) {
        e.printStackTrace();
        writeException = true;
        }
    }
  }
  
      public void stopLog() {
    try {
        if (null != m_writer)
      m_writer.close();
    } catch (IOException e) {
        e.printStackTrace();
        writeException = true;
    }
      }
  
      public void logToCSV() {
    if (!writeException) {
        try {
      double timestamp = Timer.getFPGATimestamp() - m_logStartTime;
      
      m_writer.append(String.valueOf(timestamp) + "," 
      + String.valueOf(getPosition()) + ","
      + String.valueOf(getVelocity()) + ","
      + String.valueOf(getVoltage()) + ","
      + String.valueOf(getCurrent()) + "\n");
      
      m_writer.flush();
        } catch (IOException e) {
      e.printStackTrace();
      writeException = true;
        }
    }
  }
}
