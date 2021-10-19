package frc.robot.commands;

import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class UncoverStorageCommand extends CommandBase {
    private PWMVictorSPX motor;

    public UncoverStorageCommand(PWMVictorSPX motor) {
        this.motor = motor;
    }

    @Override
    public void execute() {
        motor.set(-1);
    }

    @Override
    public boolean isFinished() {
        return true;
    }
}
