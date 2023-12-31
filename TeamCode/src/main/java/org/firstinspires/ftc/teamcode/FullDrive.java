package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
@TeleOp
public class FullDrive extends LinearOpMode {
    private Servo claw;
    private Servo launcher;
    private Servo elbow;
    private double servoPosition = 0;
    @Override
    public void runOpMode() {

        DcMotor m3 = hardwareMap.get(DcMotor.class, "frontRight");
        DcMotor m2 = hardwareMap.get(DcMotor.class, "frontLeft");
        DcMotor m4 = hardwareMap.get(DcMotor.class, "backRight");
        DcMotor m1 = hardwareMap.get(DcMotor.class, "backLeft");

        DcMotor armLeft = hardwareMap.get(DcMotor.class, "armLeft");
        DcMotor armRight = hardwareMap.get(DcMotor.class, "armRight");

        m1.setDirection(DcMotor.Direction.REVERSE);
        m2.setDirection(DcMotor.Direction.REVERSE);

        claw = hardwareMap.get(Servo.class, "claw");
        elbow = hardwareMap.get(Servo.class, "elbow");

        armRight.setDirection(DcMotor.Direction.REVERSE);


        double speed = 1;

        telemetry.addData("Status", "Initialized");
        waitForStart();
        telemetry.update();
        // Wait for the game to start (driver presses PLAY)
        // run until the end of the match (driver presses STOP)
        while (opModeIsActive()) {

            double px = gamepad1.right_stick_x * 2;
            double py = -gamepad1.right_stick_y;
            double pa = gamepad1.left_stick_x;

            double p1 = px + py + pa;
            double p2 = -px + py + pa;
            double p3 = -px + py - pa;
            double p4 = px + py - pa;

            if (Math.abs(p2) > 1 || Math.abs(p1) > 1 || Math.abs(p3) > 1 || Math.abs(p4) > 1) {
                // Find the largest power
                double max = 0;

                max = Math.max(Math.abs(p2), Math.abs(p1));
                max = Math.max(Math.abs(p3), max);
                max = Math.max(Math.abs(p4), max);

                // Divide everything by max (it's positive so we don't need to worry
                // about signs)
                p2 /= max;
                p1 /= max;
                p3 /= max;
                p4 /= max;
            }

            m1.setPower((p1 * speed) / 2);
            m2.setPower((p2 * speed) / 2);
            m3.setPower((p3 * speed) / 2);
            m4.setPower((p4 * speed) / 2);

            telemetry.addData("Front Left", m2.getPower());
            telemetry.addData("Front Right", m3.getPower());
            telemetry.addData("Back Left", m1.getPower());
            telemetry.addData("Back Right", m4.getPower());

            telemetry.addData("Status", "Running");
            telemetry.update();

            //elbow.setPosition(elbow.MAX_POSITION);


            if (gamepad1.y) {
                claw.setPosition(1);
            } else if (gamepad1.a) {
                claw.setPosition(0);
            }

//            if (gamepad1.x) {
//                launcher.setPosition(1);
//            }

//            if (gamepad1.dpad_up) {
//                elbow.setPosition(0);
//            } else if (gamepad1.dpad_down) {
//                elbow.setPosition(1);
//            }

            elbow.setPosition(0.5);
            

            if (gamepad1.left_bumper) {
                armLeft.setPower(-1);
                armRight.setPower(-1);
            } else if (gamepad1.right_bumper) {
                armLeft.setPower(1);
                armRight.setPower(1);
            } else {
                armLeft.setPower(0);
                armRight.setPower(0);
            }

            elbow.setPosition(servoPosition);

            telemetry.addData("Status", "Running");
            telemetry.addData("Claw", claw.getPosition());
            telemetry.addData("Elbow", elbow.getPosition());
            telemetry.update();

        }
    }
}


