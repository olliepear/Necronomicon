package frc.robot;

public class AnimationConfig {

    public class OpenFrames {

        public final int keyFrameCount = 2;

        public double OpenFrame(int keyFrame) {
           
            if (keyFrame == 0) {return -1.0;}
            else if (keyFrame == 1) {return 0;}
 

            else return 0;
        }
    }

    public class CloseFrames {

        public final int keyFrameCount = 2;

        public double CloseFrame(int keyFrame) {
            
            if (keyFrame == 0) {return 1.0;}
            else if (keyFrame == 1) {return 0;}


            else return 0;
        }
    }



    public double OpenAnimation(double angle) {

        OpenFrames Animation = new OpenFrames();
        
        double frame = (Animation.keyFrameCount-1)*angle/180;

        double keyFrameNextD = Math.ceil(frame);
        double keyFrameLastD = Math.floor(frame);

        int keyFrameNextI = (int) keyFrameNextD;
        int keyFrameLastI = (int) keyFrameLastD;

        double distanceThroughFrame = frame - keyFrameLastD;

        double output = Animation.OpenFrame((keyFrameLastI))*(1-distanceThroughFrame) + Animation.OpenFrame(keyFrameNextI)*(distanceThroughFrame);

        return output;
    }
        public double CloseAnimation(double angle) {

        CloseFrames Animation = new CloseFrames();
        
        double frame = (Animation.keyFrameCount-1)*angle/180;

        double keyFrameNextD = Math.ceil(frame);
        double keyFrameLastD = Math.floor(frame);

        int keyFrameNextI = (int) keyFrameNextD;
        int keyFrameLastI = (int) keyFrameLastD;

        double distanceThroughFrame = frame - keyFrameLastD;

        double output = Animation.CloseFrame((keyFrameLastI))*(1-distanceThroughFrame) + Animation.CloseFrame(keyFrameNextI)*(distanceThroughFrame);

        return output;
    }


}
