// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.GenericHID;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.PWMVictorSPX;
import edu.wpi.first.wpilibj.XboxController;
import frc.robot.commands.CoverStorageCommand;
import frc.robot.commands.UncoverStorageCommand;
import frc.robot.subsystems.BallShooterSubsystem;
import frc.robot.subsystems.DriveTrainSubsystem;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a "declarative" paradigm, very little robot logic should
 * actually be handled in the {@link Robot} periodic methods (other than the
 * scheduler calls). Instead, the structure of the robot (including subsystems,
 * commands, and button mappings) should be declared here.
 */
public class RobotContainer {
  // The robot's subsystems and commands are defined here...
  public final DriveTrainSubsystem driveTrainSubsystem = new DriveTrainSubsystem();
  public final BallShooterSubsystem ballShooterSubsystem = new BallShooterSubsystem();

  private Joystick joystick = new Joystick(1);
  private PWMVictorSPX coverMotor = new PWMVictorSPX(Constants.coverPort);
  private JoystickButton coverButton = new JoystickButton(joystick, Constants.coverButton);
  private JoystickButton uncoverButton = new JoystickButton(joystick, Constants.uncoverButton);

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    // Configure the button bindings
    configureButtonBindings();
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by instantiating a {@link GenericHID} or one of its subclasses
   * ({@link edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then
   * passing it to a {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    coverButton.whenPressed(new CoverStorageCommand(coverMotor));
    uncoverButton.whenPressed(new UncoverStorageCommand(coverMotor));
  }

}
