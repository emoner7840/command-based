package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.BallShooterSubsystem;

public class CollectBallsCommand extends CommandBase {
    private double speed = -1;
    private BallShooterSubsystem subsystem;

    public CollectBallsCommand(BallShooterSubsystem subsystem) {
        this.subsystem = subsystem;
        addRequirements(subsystem);
    }

    @Override
    public void execute() {
        subsystem.spark.set(speed);
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
