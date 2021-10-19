package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.DriveTrainSubsystem;

public class ArcadeDriveCommand extends CommandBase {
    private final DriveTrainSubsystem subsystem;
    private double xSpeed;
    private double ySpeed;

    public ArcadeDriveCommand(DriveTrainSubsystem subsystem) {
        this.subsystem = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void initialize() {
        xSpeed = subsystem.getXSpeed();
        ySpeed = subsystem.getYSpeed();
    }

    @Override
    public void execute() {
        subsystem.differentialDrive.arcadeDrive(xSpeed, ySpeed);
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
