package thread.demo.wn;

public class Shooter implements Runnable {
	private Gun gun;

	public Shooter(Gun gun) {
		this.gun = gun;
	}

	@Override
	public void run() {
		while (true) {
			gun.shoot();
		}
	}

}
