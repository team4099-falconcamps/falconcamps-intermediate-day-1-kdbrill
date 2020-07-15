package com.team4099.falconcamps.subsystems;

import com.revrobotics.*;

import edu.wpi.first.wpilibj.controller.PIDController;
import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterPIDSubsystem extends PIDSubsystem {
    private final CANSparkMax shooterLeader = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);
    private final CANSparkMax shooterFollower = new CANSparkMax(14, CANSparkMaxLowLevel.MotorType.kBrushless);
    private final CANEncoder shooterEncoder = shooterLeader.getEncoder();

    public ShooterPIDSubsystem() {
        super (new PIDController(1.7 / 300, 0.0, 5.5 * 14000));
        shooterFollower.follow (shooterLeader, true);
    }

    @Override
    public void periodic() {}

    @Override
    protected void useOutput(double output, double setpoint) {
shooterLeader.set (output);

    }

    @Override
    protected double getMeasurement() {
        
        return shooterEncoder.getVelocity();
    }
}
