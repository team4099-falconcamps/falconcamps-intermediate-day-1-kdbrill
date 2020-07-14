package com.team4099.falconcamps.subsystems;

import com.revrobotics.*;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterSparkPID extends SubsystemBase {
    private final CANSparkMax shooterLeader = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);
    private final CANSparkMax shooterFollower = new CANSparkMax(14, CANSparkMaxLowLevel.MotorType.kBrushless);
    private final CANEncoder shooterEncoder = shooterLeader.getEncoder();
    private final CANPIDController pidController = shooterFollower.getPIDController();

    public void setSetpoint(double setpoint) {
        pidController.setReference(setpoint, ControlType.kVelocity);
    }

    public ShooterSparkPID() {
        shooterFollower.follow (shooterLeader, true);
        pidController.setP (1.7 / 300);
        pidController.setI (0.0);
        pidController.setD (5.5 * 14000);

    }

    @Override
    public void periodic() {}
}
