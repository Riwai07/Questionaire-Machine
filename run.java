import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.time.LocalTime;
import java.util.concurrent.TimeUnit;

public class run {
	static int queue = 1;
	static long queueTime = 0;
	static String set = "";
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
					a = new QuestionGUI(s.importedSet);
					pause = a.pause;
					queue--;
				}
				if(pause) {
					pause = a.pause;
				}
				if(a.newQuestion) {
					queue++;
					pause = false;
				}
				if(queue < 0) {
					queue = 0;
				}
				LocalTime newTime = a.time.plusHours(s.hours).plusMinutes(s.minutes).plusSeconds(s.seconds).plusNanos(TimeUnit.MILLISECONDS.toNanos(s.millisec));
				if(LocalTime.now().isAfter(newTime) && !pause){
					queue++;
				}
//				System.out.print(LocalTime.now().isAfter(newTime) + " ");
//				System.out.print(LocalTime.now() + " " + newTime);
//				System.out.println(" " + queue);
			}else{
				queue = 1;
			}
			Thread.sleep(1);
		}
	}
}
