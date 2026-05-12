
public class run {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		int queue = 0;
		StarterGUI a = new StarterGUI();
		if(a.questioning) {
			queue++;
			Thread.sleep(a.time);
		}
	}

}
