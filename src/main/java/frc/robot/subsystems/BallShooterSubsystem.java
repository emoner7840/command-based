package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.CollectBallsCommand;
import frc.robot.commands.ThrowBallsCommand;

public class BallShooterSubsystem extends SubsystemBase {
    public Spark spark;
    public final Joystick joystick;
    private CommandScheduler scheduler = CommandScheduler.getInstance();

    public BallShooterSubsystem() {
        joystick = new Joystick(0);

        spark = new Spark(Constants.sparkPort);
    }

    @Override
    public void periodic() {
        var axisValue = joystick.getRawAxis(Constants.ballAxis);
        if (axisValue > 0) {
            scheduler.schedule(new ThrowBallsCommand(this));
        }

        if (axisValue < 0) {
            scheduler.schedule(new CollectBallsCommand(this));
        }
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
    }
}
