package solver.commun;

public class Expo {

	public static double exp1(double x) {
		x = 1.0 + x / 256.0;
		x *= x;
		x *= x;
		x *= x;
		x *= x;
		x *= x;
		x *= x;
		x *= x;
		x *= x;
		return x;
	}
	
	public static double exp2(double val) {
		final long tmp = (long) (1512775 * val + 1072632447);
		return Double.longBitsToDouble(tmp << 32);
	}

	public static double expf(double val) {
		if (val >= 0)
			return 1;
		if (val > -2.5)
			return exp1(val);
		if (val > -700)
			return exp2(val);
		else
			return 0;
	}
	
}
