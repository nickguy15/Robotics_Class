package org.firstinspires.ftc.teamcode.Classes;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.gamepad1;
import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

public class Hardware {
    DcMotor frontLeftMotor;
    DcMotor backLeftMotor;
    DcMotor frontRightMotor;
    DcMotor backRightMotor;
    Servo lockingMechServo;


    public void getHW(HardwareMap hardwaremap) {
        frontLeftMotor = hardwaremap.get(DcMotor.class, "frontLeftMotor");
        backLeftMotor = hardwaremap.get(DcMotor.class, "frontRightMotor");
        frontRightMotor = hardwaremap.get(DcMotor.class, "backLeftMotor");
        backRightMotor = hardwaremap.get(DcMotor.class, "backRightMotor");

        lockingMechServo = hardwaremap.get(Servo.class, "lockingMechServo");
    }

    public void Drive(double y, double x, double rx) {
        frontRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        backRightMotor.setDirection(DcMotorSimple.Direction.REVERSE);

        double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(rx), 1);
        double frontLeftPower = (y + x + rx);
        double backLeftPower = (y - x + rx);
        double frontRightPower = (y - x - rx);
        double backRightPower = (y + x - rx);

        frontLeftMotor.setPower(frontLeftPower);
        backLeftMotor.setPower(backLeftPower);
        frontRightMotor.setPower(frontRightPower);
        backRightMotor.setPower(backRightPower);
    }
    public void setZero() {
        lockingMechServo.setPosition(0.5);

    }
    public void LockingMechServos(boolean x, boolean y) {
        if (x){
            lockingMechServo.setPosition(1);
        } else if (y) {
            lockingMechServo.setPosition(0);
        }
        else {
            lockingMechServo.setPosition(0.5);
        }
    }
}
