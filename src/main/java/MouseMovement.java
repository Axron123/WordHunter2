import java.awt.*;
public class MouseMovement {

   private Robot robot;

   public MouseMovement(Robot robot) {
       this.robot = robot;
   }

    public void moveToCenter() {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int centerX = screenSize.width / 2;
        int centerY = screenSize.height / 2;
        robot.mouseMove(centerX, centerY);
        System.out.println("Mouse moved to center: (" + centerX + ", " + centerY + ")");
    }

    public void moveToPosition() {
       int xPosition = 1400;
       int yPosition = 800;
       robot.mouseMove(xPosition, yPosition);
       System.out.printf("Mouse moved to position: (%d, %d)\n", xPosition, yPosition);
    }


}
