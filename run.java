import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.time.LocalTime;

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
		QuestionGUI a = null;
		queueTime = s.getTime();
		while(true) {
			if(s.questioning) {
				if(!pause && queue != 0) {
					a = new QuestionGUI();
					pause = a.pause;
					queue--;
				}
				if(pause) {
					pause = a.pause;
				}
				LocalTime newTime = a.time.plusHours(s.hours).plusMinutes(s.minutes).plusSeconds(s.seconds).plusNanos(s.millisec);
				if(LocalTime.now().isAfter(newTime)){
					queue++;
				}
				System.out.println(LocalTime.now().isAfter(newTime));
				System.out.println(LocalTime.now() + " " + newTime);
			}else{
				queue = 1;
			}
			Thread.sleep(1);
		}
	}
}
