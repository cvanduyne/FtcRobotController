package org.firstinspires.ftc.teamcode.ftc10650.Auto;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.Calculators.*;
import org.firstinspires.ftc.teamcode.Calculators.Interfaces.MoveData;
import org.firstinspires.ftc.teamcode.Hardware.Sensors.StackDeterminationPipeline;
import org.firstinspires.ftc.teamcode.Op.ComplexOp;
import org.firstinspires.ftc.teamcode.Utilities.Vector2D;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvInternalCamera;

@Autonomous(name = "DonutAuto", group = "ftc10650")
public class AutoAuto extends ComplexOp {

    @Override
    public MoveData.StartData startPositionAndOrientation() {
        /**
         * @see StartPositionAndOrientation is used at the beginning of every game code
         * this includes tele-op and autonomous
         */
        return new MoveData.StartData(new Vector2D(0,0), 0);
    }

    @Override
    public void body() throws InterruptedException {
        ComplexMove(null, null, null, OtherCalcs.GetDonutStack());
        ComplexMove(null,null,null, OtherCalcs.Shoot());

        if(MoveData.stackHeight == 0){



            ComplexMove(
                    SpeedCalcs.SetSpeed(0.2),
                    MotionCalcs.PointMotion(5, new Vector2D(-10, 5)),
                    OrientationCalcs.holdHeading());


            ComplexMove(
                    SpeedCalcs.SetSpeed(0.2),
                    MotionCalcs.PointMotion(5,
                            new Vector2D(10, 55)),
                    OrientationCalcs.lookToOrientation(180));


            ComplexMove(null, null, null,
                    OtherCalcs.SetWobblePosition(60),
                    OtherCalcs.TimeProgress(2000));


            ComplexMove(null, null,
                    OrientationCalcs.lookToOrientation(0),
                    OtherCalcs.TimeProgress(5000));



        } else if (MoveData.stackHeight == 1) {



            ComplexMove(
                    SpeedCalcs.SetSpeed(0.2),//.SetProgressSpeed(
                            //new SpeedCalcs.ProgressSpeed(0.2, 0, SpeedCalcs.ProgressSpeed.timeOrProg.PROG),
                            //new SpeedCalcs.ProgressSpeed(0.3, 1, SpeedCalcs.ProgressSpeed.timeOrProg.PROG)),
                    MotionCalcs.PointMotion(5,
                            new Vector2D(-30, 30),
                            new Vector2D(-30, 55),
                            new Vector2D(-10, 70)),
                    OrientationCalcs.spinToProgress(
                            new OrientationCalcs.spinProgress(0, 0.5, 0),
                            new OrientationCalcs.spinProgress(0.5, 0.9, 180)));


            ComplexMove(null, null, null,
                    OtherCalcs.SetWobblePosition(60),
                    OtherCalcs.TimeProgress(2000));


            ComplexMove(null, null, null,
                    OtherCalcs.SetWobblePosition(0),
                    OtherCalcs.TimeProgress(2000));


            ComplexMove(
                    SpeedCalcs.SetSpeed(0.3),
                    MotionCalcs.PointMotion(5,
                            new Vector2D(-15, 55)),
                    OrientationCalcs.holdHeading());


            ComplexMove(null, null,
                    OrientationCalcs.lookToOrientation(0),
                    OtherCalcs.TimeProgress(5000));



        } else if (MoveData.stackHeight == 4) {



            ComplexMove(
                    SpeedCalcs.SetSpeed(0.6),//.SetProgressSpeed(
                    //new SpeedCalcs.ProgressSpeed(0.2, 0, SpeedCalcs.ProgressSpeed.timeOrProg.PROG),
                    //new SpeedCalcs.ProgressSpeed(0.3, 1, SpeedCalcs.ProgressSpeed.timeOrProg.PROG)),
                    MotionCalcs.PointMotion(5,
                            new Vector2D(-30, 30),
                            new Vector2D(-30, 55),
                            new Vector2D(10, 95)),
                    OrientationCalcs.spinToProgress(
                            new OrientationCalcs.spinProgress(0, 0.5, 0),
                            new OrientationCalcs.spinProgress(0.5, 0.9, 180)));
            ComplexMove(null, null, null,
                    OtherCalcs.SetWobblePosition(60),
                    OtherCalcs.TimeProgress(2000));


            ComplexMove(null, null, null,
                    OtherCalcs.SetWobblePosition(0), OtherCalcs.TimeProgress(2000));


            ComplexMove(
                    SpeedCalcs.SetSpeed(0.6),
                    MotionCalcs.PointMotion(5,
                            new Vector2D(-30, 20)),
                    OrientationCalcs.holdHeading());


            ComplexMove(null, null,
                    OrientationCalcs.lookToOrientation(0),
                    OtherCalcs.TimeProgress(5000));



        }
    }
}
