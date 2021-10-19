// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide
 * numerical or boolean constants. This class should not be used for any other
 * purpose. All constants should be declared globally (i.e. public static). Do
 * not put anything functional in this class.
 *
 * <p>
 * It is advised to statically import this class (or one of its inner classes)
 * wherever the constants are needed, to reduce verbosity.
 */
public final class Constants {
    // hizlanma buttonlari
    public static int[] maxSpeedButtons = new int[] { 1, 5, 6 };
    // sag motor portlar
    public static int[] rightMotorPorts = new int[] { 1, 2 };
    // sol motor portlar
    public static int[] leftMotorPorts = new int[] { 1, 2 };
    // ileri gitme axisi
    public static int xAxis = 1;
    // yatay gitme axisi
    public static int yAxis = 1;
    // spark portu
    public static int sparkPort = 0;
    // top atma axisi
    public static int ballAxis = 1;
    // hiz (ters orantili)
    public static double speed = 1.75;
    // hizlanildiginda cikilacka hiz (ters orantili)
    public static double maxSpeed = 1;
    // kapak portu
    public static int coverPort = 1;
    // kapak kapatma buttonu
    public static int coverButton = 1;
    // kapak acma buttonu
    public static int uncoverButton = 1;
}
