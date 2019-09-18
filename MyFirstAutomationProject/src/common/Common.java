package common;
/**
 * 
 * @author Shahruh-Mirzo
 *
 */
public class Common {

	public static void sleep(int second) {
		try {
			Thread.sleep(second*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
