package org.firstinspires.ftc.teamcode.Teleop;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
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
        drive.getHW(hardwareMap);
        drive.setZero();
    }
    // TODO automatically engage the locking mech that unlocks when trying to strafe and locks when going straight or turning
    // use a servo to engage the locking mech

    public void loop() {
        double y = -gamepad1.left_stick_y; // Remember, Y stick value is reversed
        double x = gamepad1.left_stick_x * 1.1; // Counteract imperfect strafing
        double rx = gamepad1.right_stick_x;

        boolean A = gamepad1.a;
        boolean B = gamepad1.b;

        drive.Drive(y, x, rx);
        drive.LockingMechServos(A, B);

    }
}