package utils;

public class RandomUtil {

	public int usernameAffix() {
		return (int) (Math.random() * (100 - (-100)) + (-100));
	}
}
