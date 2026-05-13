import java.awt.AWTException;
import java.io.FileNotFoundException;

public class run {
	static int queue = 0;
	public static void main(String[] args) throws InterruptedException, FileNotFoundException, AWTException {
		// TODO Auto-generated method stub
		boolean pauseQuestioning = false;
		StarterGUI a = new StarterGUI();
		Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                work(a, pauseQuestioning);
            }
        });
        thread.start();
	}
	public static void work(StarterGUI s, boolean pause) {
		while(true) {
			if(s.questioning) {
				if(!pause) {
					
				}
				//Load Queue
				//Load Questions
				//Make sure it dies whenever s.questioning = false
			}
		}
	}
}
