package utils;

public class RandomUtil {

	public int usernameAffix() {
		return (int) (Math.random() * (100 - (-100)) + (-100));
	}
}
//TODO
// There are existing solutions for randomization, f.e. http://commons.apache.org/proper/commons-lang/apidocs/org/apache/commons/lang3/RandomUtils.html