package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;


@TeleOp(name="Claw and Launcher")
public class ClawAndLauncher extends LinearOpMode{

    private Servo claw;
    private Servo launcher;
    private Servo elbow;
    private double servoPosition = 0;

    @Override
    public void runOpMode() {

        claw = hardwareMap.get(Servo.class, "claw");
        launcher = hardwareMap.get(Servo.class, "launcher");
        elbow = hardwareMap.get(Servo.class, "elbow");

        waitForStart();

        while(opModeIsActive()) {

            elbow.setPosition(servoPosition);

            if (gamepad1.y) {
                claw.setPosition(1);
            } else if (gamepad1.a) {
                claw.setPosition(0);
            }

            if (gamepad1.x) {
                launcher.setPosition(1);
            }

            if (gamepad1.dpad_up) {
                servoPosition += 0.05;

            } else if (gamepad1.dpad_down) {
                servoPosition -= 0.05;

            }

            }

            telemetry.addData("Status", "Running");
            telemetry.addData("Claw", claw.getPosition());
            telemetry.addData("Elbow", elbow.getPosition());
            telemetry.update();
        }
    }
