# Command Based Code
Our robot code that written with a programming methodology called "command-based" programming. There is a [blog post](https://docs.wpilib.org/en/stable/docs/software/commandbased/what-is-command-based.html) that explains command based programming implementation in WPILIB.

## Structure
Our code has 3 abstract parts. Ball shooter, drivetrain and storage cover

### Drivetrain
Drivetrain has a subsystem of its own. It runs `ArcadeDriveCommand` which runs the differential-drived motors.

### Ball Shooter
Ball Shooter has a subsystem of its own. And it calls `ThrowBallsCommand` or `CollectBallsCommand` balls.

### Storage Cover
Storage Cover doesn't have a subsystem. It directly runs by `RobotContainer.configureButtonBindings`.