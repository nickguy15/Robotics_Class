package org.firstinspires.ftc.teamcode.Teleop;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import android.provider.Settings;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.Classes.Hardware;
@TeleOp (name = "Teleop")
public class Teleop extends OpMode {
    Hardware drive = new Hardware();
    public void init() {
        drive.Getmotors();
    }
    // TODO automatically engage the locking mech that unlocks when trying to strafe and locks when going straight or turning
    // use a servo to engage the locking mech

    public void loop() {
        drive.Drive();

    }
}