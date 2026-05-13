import java.awt.AWTException;
import java.io.FileNotFoundException;

public class run {
	static int queue = 1;
	static long queueTime = 0;
	public static void main(String[] args) throws InterruptedException, FileNotFoundException, AWTException {
		// TODO Auto-generated method stub
		boolean pauseQuestioning = false;
		StarterGUI a = new StarterGUI();
		Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
					work(a, pauseQuestioning);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (AWTException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
        });
        thread.start();
	}
	public static void work(StarterGUI s, boolean pause) throws FileNotFoundException, InterruptedException, AWTException {
		queueTime = s.getTime();
		while(true) {
			if(s.questioning) {
				if(!pause && queue != 0) {
					QuestionGUI a = new QuestionGUI();
					pause = true;
					queue--;
				}
				//Load Queue
				//Load Questions
				//Make sure it dies whenever s.questioning = false
			}else {
				//queueTime = s.getTime();
				pause = false;
			}
			Thread.sleep(1);
		}
	}
}
