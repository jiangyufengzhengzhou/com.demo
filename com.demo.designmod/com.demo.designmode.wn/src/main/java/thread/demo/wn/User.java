package thread.demo.wn;

public class User {
	public static void main(String[] args) {
		Gun gun = new Gun();
		gun.setBulletsNum(10);
		Producer producer = new Producer(gun);

		Shooter shooter = new Shooter(gun);
		for (int i = 0; i < 3; i++) {
			Thread t = new Thread(shooter);
			t.start();
		}
		for (int i = 0; i < 3; i++) {
			Thread t2 = new Thread(producer);
			t2.start();
		}
	}
}
