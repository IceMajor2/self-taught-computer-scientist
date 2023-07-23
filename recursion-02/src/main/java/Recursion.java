
public class Recursion {

	public static void main(String[] args) {
		betterRecursion(10);
		recursion(10);
	}

	public static int recursion(int times) {
		if (times == 1) {
			System.out.println(1);
			return 1;
		}
		int current = 1 + recursion(times - 1);
		System.out.println(current);
		return current;
	}

	public static void betterRecursion(int times) {
		if (times > 0) {
			betterRecursion(times - 1);
			System.out.println(times);
		}
	}
}
