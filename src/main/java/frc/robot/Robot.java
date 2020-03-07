package frc.robot;

import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.TimedRobot;

public class Robot extends TimedRobot {
  private final CANSparkMax shooterLeftMasterMotor = new CANSparkMax(8, MotorType.kBrushless);
  private final CANSparkMax shooterRightSlaveMotor = new CANSparkMax(7, MotorType.kBrushless);
  
  private CANPIDController shooterPIDController;

  @Override
  public void robotInit() {
    shooterLeftMasterMotor.restoreFactoryDefaults();
    shooterLeftMasterMotor.setSmartCurrentLimit(38);
    shooterLeftMasterMotor.setInverted(true);
    shooterLeftMasterMotor.setIdleMode(IdleMode.kCoast);
    shooterLeftMasterMotor.burnFlash();

    shooterRightSlaveMotor.restoreFactoryDefaults();
    shooterRightSlaveMotor.setSmartCurrentLimit(38);
    shooterRightSlaveMotor.setIdleMode(IdleMode.kCoast);
    shooterRightSlaveMotor.follow(shooterLeftMasterMotor, true);
    shooterRightSlaveMotor.burnFlash();

    shooterPIDController = shooterLeftMasterMotor.getPIDController();
    shooterPIDController.setP(0);
    shooterPIDController.setI(0);
    shooterPIDController.setD(0);
    shooterPIDController.setIZone(0);
    shooterPIDController.setFF(0);
    shooterPIDController.setOutputRange(0, 1);
  }

  @Override
  public void robotPeriodic() {
  }

  @Override
  public void autonomousInit() {
  }

  @Override
  public void autonomousPeriodic() {
  }

  @Override
  public void teleopPeriodic() {    
    shooterPIDController.setReference(5000, ControlType.kVelocity);
  }

  @Override
  public void testPeriodic() {
  }
}
