//package org.firstinspires.ftc.teamcode;
//
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
//import com.qualcomm.robotcore.hardware.DcMotor;
//import com.qualcomm.robotcore.hardware.Servo;
//import com.qualcomm.robotcore.hardware.CRServo;
//import com.qualcomm.robotcore.hardware.DcMotorSimple;
//
//@Autonomous
//public class Auto extends LinearOpMode {
//
//    int FORWARD = 1;
//    int BACKWARD = -1;
//    int LEFT = 1;
//    int RIGHT = -1;
//    String iteration = "a";
//    //a = blue close
//    //b = blue far
//    //c = red close
//    //d = red far
//
//    private DcMotor flyWheel0;
//    private DcMotor flyWheel1;
//    private DcMotor back_left_motor;
//    private DcMotor front_left_motor;
//    private DcMotor front_right_motor;
//    private DcMotor back_right_motor;
//
//    private int back_left_pos;
//    private int front_left_pos;
//    private int front_right_pos;
//    private int back_right_pos;
//    private DcMotor lift;
//    private Servo wobble;
//    private Servo launchAngle;
//    private Servo platform0;
//    private Servo platform1;
//    private Servo ringPush;
//    private CRServo conveyor;
//
//    @Override
//    public void runOpMode() {
//        flyWheel0 = hardwareMap.get(DcMotor.class, "flyWheel0");
//        flyWheel1 = hardwareMap.get(DcMotor.class, "flyWheel1");
//        back_left_motor = hardwareMap.dcMotor.get("back_left_motor");
//        front_left_motor = hardwareMap.dcMotor.get("front_left_motor");
//        front_right_motor = hardwareMap.dcMotor.get("front_right_motor");
//        back_right_motor = hardwareMap.dcMotor.get("back_right_motor");
//        lift = hardwareMap.get(DcMotor.class, "lift");
//
//
//        back_left_motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        front_left_motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        back_right_motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//        back_right_motor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
//
//
//        back_left_motor.setDirection(DCMotorSimple.Direction.REVERSE);
//        front_left_motor.setDirection(DCMotorSimple.Direction.REVERSE);
//
//        front_left_pos = 0;
//        front_right_pos = 0;
//        back_left_pos = 0;
//        front_right_pos = 0;
//
//        wobble = hardwareMap.servo.get("wobble");
//        launchAngle = hardwareMap.servo.get("launchAngle");
//        platform0 = hardwareMap.servo.get("platform0");
//        platform1 = hardwareMap.servo.get("platform1");
//        ringPush = hardwareMap.servo.get("ringPush");
//        conveyor = hardwareMap.crservo.get("conveyor");
//        //flyWheel1.setDirection(DcMotor.Direction.REVERSE);
//        //back_left_motor.setDirection(DcMotor.Direction.REVERSE);
//        //front_left_motor.setDirection(DcMotor.Direction.REVERSE);
//        //platform0.setDirection(Servo.Direction.REVERSE);
//        //wobble.setPosition(0.5);
//        //launchAngle.setPosition(0.4337);
//        //platform0.setPosition(0);
//        //platform1.setPosition(0);
//        //ringPush.setPosition(0);
//        //conveyor.setPower(0);
//        double launch = 0.4337;
//
//        telemetry.addData("Status", "Initialized");
//        telemetry.update();
//        // Wait for the game to start (driver presses PLAY)
//        waitForStart();
//        // run until the end of the match (driver presses STOP)
//        while (opModeIsActive()) {
//            if (iteration == "a") {
//                moveF();
//                turnL();
//                moveF();
//                //place token
//            } else if (iteration == "b") {
//                moveF();
//                moveF();
//                turnL();
//                moveF();
//                moveF();
//                turnL();
//                moveF();
//                turnR();
//                moveF();
//                //place token
//            } else if (iteration == "c") {
//                moveF();
//                turnR();
//                moveF();
//                //place token
//            } else if (iteration == "d") {
//                moveF();
//                moveF();
//                turnR();
//                moveF();
//                moveF();
//                turnR();
//                moveF();
//                turnL();
//                moveF();
//                //place token
//            }
//
//            telemetry.addData("Status", "Running");
//            telemetry.update();
//            break;
//        }
//    }
//
//    public void move(int direction, int distance) {
//        setPower(0, 1f * direction, 0);
//        sleep(68 * distance);
//        setPower(0, 0, 0);
//    }
//
//    public void drive(int)
//
//    public void moveF() {
//        move(FORWARD, 24);
//        sleep(500);
//    }
//
//    public void moveB() {
//        move(BACKWARD, 24);
//        sleep(500);
//    }
//
//    public void turnL() {
//        turn(LEFT, 1);
//        sleep(500);
//    }
//
//    public void turnR() {
//        turn(RIGHT, 1);
//        sleep(500);
//    }
//
//    public void moveSideways(int direction, int distance) {
//        setPower(1f * (-direction), 0, 0);
//        sleep(68 * distance);
//        setPower(0, 0, 0);
//    }
//
//    public void setPower(float px, float py, float pa) {
//        double p1 = -px + py - pa;
//        double p2 = px + py + -pa;
//        double p3 = -px + py + pa;
//        double p4 = px + py + pa;
//        double max = Math.max(1.0, Math.abs(p1));
//        max = Math.max(max, Math.abs(p2));
//        max = Math.max(max, Math.abs(p3));
//        max = Math.max(max, Math.abs(p4));
//        p1 /= max;
//        p2 /= max;
//        p3 /= max;
//        p4 /= max;
//        back_left_motor.setPower(p1 / 2);
//        front_left_motor.setPower(p2 / 2);
//        front_right_motor.setPower(p3 / 2);
//        back_right_motor.setPower(p4 / 2);
//    }
//
//    //IMPORTANT: each rotation is a quarter of 90 degrees
//    public void turn(int direction, int rotations) {
//        setPower(0, 0, 1f * direction);
//        //sleep(105 * rotations);
//        for (int r = rotations; r > 0; r--) {
//            sleep(1774);
//        }
//        setPower(0, 0, 0);
//    }
//
//}