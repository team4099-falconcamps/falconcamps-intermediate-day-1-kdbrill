package com.team4099.falconcamps.subsystems;

import com.revrobotics.*;

import edu.wpi.first.wpilibj2.command.PIDSubsystem;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ShooterPIDSubsystem extends PIDSubsystem {
    private final CANSparkMax shooterLeader = new CANSparkMax(1, CANSparkMaxLowLevel.MotorType.kBrushless);
    private final CANSparkMax shooterFollower = new CANSparkMax(14, CANSparkMaxLowLevel.MotorType.kBrushless);
    private final CANEncoder shooterEncoder = shooterLeader.getEncoder();

    public ShooterPIDSubsystem() {
        double shooterP = 1.7 / 300;
        double shooterI = 0.0;
        double shooterD = 5.5 * 14000;
        super (new PIDController(shooterP, shooterI, shooterD));
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
