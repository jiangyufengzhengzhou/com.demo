package thread.demo.wn;

public class Producer implements Runnable {
	private Gun gun;

	public Producer(Gun gun) {
		this.gun = gun;
	}

	@Override
	public void run() {
		while (true) {
			gun.reload();
		}
	}

}
