package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
@TeleOp
public class MecanumDrive extends LinearOpMode {
    @Override
    public void runOpMode() {
        DcMotor m3 = hardwareMap.get(DcMotor.class, "frontRight");
        DcMotor m2 = hardwareMap.get(DcMotor.class, "frontLeft");
        DcMotor m4 = hardwareMap.get(DcMotor.class, "backRight");
        DcMotor m1 = hardwareMap.get(DcMotor.class, "backLeft");

        m1.setDirection(DcMotor.Direction.REVERSE);
        m2.setDirection(DcMotor.Direction.REVERSE);

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

            }


        }
    }


