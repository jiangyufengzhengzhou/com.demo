package thread.demo.wn;

public class Gun {
	private Integer bulletsNum;

	public static int BOX_SIZE = 10;
	/*
	 * private List<String> bullets = new ArrayList<>();
	 * 
	 * public List<String> getBullets() { return bullets; }
	 * 
	 * public void setBullets(List<String> bullets) { this.bullets = bullets; }
	 */

	public Integer getBulletsNum() {
		return bulletsNum;
	}

	public void setBulletsNum(Integer bulletsNum) {
		this.bulletsNum = bulletsNum;
	}

	public void shoot() {
		synchronized (this) {
			while (bulletsNum < 1) {
				System.out.println("子弹不足，还有" + bulletsNum + "发子弹，停止射击");
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			bulletsNum = bulletsNum - 1;
			System.out.println("射出1颗子弹还有" + bulletsNum + "颗");
			notifyAll();
		}
	}

	public void reload() {
		synchronized (this) {
			while (bulletsNum >= BOX_SIZE) {
				System.out.println("子弹充足，还有" + bulletsNum + "发，停止装弹");
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			bulletsNum = bulletsNum + 1;
			System.out.println("装填1发，还有" + bulletsNum + "发");
			try {
				Thread.sleep(50);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			notifyAll();
		}
	}

}
