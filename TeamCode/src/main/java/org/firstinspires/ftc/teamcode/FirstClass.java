package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

@TeleOp(name="Android Studio Test Class")
public class FirstClass extends LinearOpMode{
    @Override


    public void runOpMode() {
        waitForStart();
        telemetry.addData("Status", "Running");
        telemetry.update();
    }
}
