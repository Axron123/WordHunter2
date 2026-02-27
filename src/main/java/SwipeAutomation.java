import java.awt.*;
import java.awt.event.InputEvent;
import java.util.List;

public class SwipeAutomation {

    private int startX;
    private int startY;
    private int cellWidth;
    private int cellHeight;


    private Robot robot;

    public SwipeAutomation(int startX, int startY, int cellWidth, int cellHeight) throws AWTException {
        this.startX = startX;
        this.startY = startY;
        this.cellWidth = cellWidth;
        this.cellHeight = cellHeight;
        this.robot = new Robot();

    }

    public void startAutomation(List<WordAndPath> wordAndPathList) throws InterruptedException {

        for (WordAndPath word : wordAndPathList) {

            List<int[]> path = word.getPath();
            if (path.isEmpty()) {
                continue;
            }
            int[] firstCell = path.get(0);
            int startMouseX = startX + firstCell[1] * cellWidth;
            int startMouseY = startY + firstCell[0] * cellHeight;

            robot.mouseMove(startMouseX, startMouseY);
            Thread.sleep(20);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);

            robot.mouseMove(startMouseX + 1, startMouseY + 1);
            Thread.sleep(20);
            robot.mouseMove(startMouseX, startMouseY);
            Thread.sleep(20);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);

            Thread.sleep(20);

            for (int i = 1; i < path.size(); i++) {
                int[] cell = path.get(i);
                int x = startX + cell[1] * cellWidth;
                int y = startY + cell[0] * cellHeight;

                //smooth movement
                robot.mouseMove(x, y);

                Thread.sleep(25); //small delay for smooth swipe
            }

            // 4. Release the mouse at the end of the path
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);

            Thread.sleep(25); // small pause between swipes
        }


    }


}
