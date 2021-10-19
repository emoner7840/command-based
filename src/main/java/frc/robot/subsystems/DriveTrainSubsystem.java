package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.SpeedControllerGroup;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.commands.ArcadeDriveCommand;

public class DriveTrainSubsystem extends SubsystemBase {
    public final DifferentialDrive differentialDrive;
    public final Joystick joystick;
    private int[] maxSpeedButtons = new int[] { 1, 5, 6 };
    private int[] rightMotorPorts = new int[] { 1, 2 };
    private int[] leftMotorPorts = new int[] { 1, 2 };
    private CommandScheduler scheduler = CommandScheduler.getInstance();

    public DriveTrainSubsystem() {
        joystick = new Joystick(0);

        var leftMotor1 = new PWMVictorSPX(leftMotorPorts[0]);
        var leftMotor2 = new PWMVictorSPX(leftMotorPorts[1]);
        var rightMotor1 = new PWMVictorSPX(rightMotorPorts[0]);
        var rightMotor2 = new PWMVictorSPX(rightMotorPorts[1]);

        var leftMotorController = new SpeedControllerGroup(leftMotor1, leftMotor2);
        var rightMotorController = new SpeedControllerGroup(rightMotor1, rightMotor2);
        differentialDrive = new DifferentialDrive(leftMotorController, rightMotorController);
    }

    // ters orantili
    private double speed = 1.75;

    // ters orantili
    private double maxSpeed = 1;

    private boolean maxSpeedPressed() {
        for (Integer button : maxSpeedButtons) {
            if (joystick.getRawButton(button))
                return true;
        }

        return false;
    }

    private double getSpeed() {
        return maxSpeedPressed() ? maxSpeed : speed;
    }

    public double getXSpeed() {
        var speed = getSpeed();
        return joystick.getRawAxis(1) / speed;
    }

    public double getYSpeed() {
        var speed = getSpeed();

        return joystick.getRawAxis(2) / speed;
    }

    @Override
    public void periodic() {
        scheduler.schedule(new ArcadeDriveCommand(this));
        scheduler.run();
    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run during simulation
    }
}
