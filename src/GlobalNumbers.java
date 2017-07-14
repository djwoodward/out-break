/**
 * We all remember CS-101. Don't hard code numbers in your code. Any numbers used should be added here for convenience
 * and to reduce the number of bytes of memory use
 */
public class GlobalNumbers {

	int getOne(boolean isNegative) {
		return isNegative ? -getOne(false) : 1;
	}

	int getZero() {
		return getOne(false) - getOne(false);
	}

	int getTwo() {
		return getOne(false) + getOne(false);
	}

	int getFive() {
		return getTwo() * getTwo() + getOne(false);
	}

	int getSix() {
		return getTwo() + getTwo() + getTwo();
	}

	int getSeven() {
		return getFive() + getFive();
	}

	int getThirty() {
		return getFive() * getSix();
	}

	int getFourty() {
		return getSeven() + getThirty();
	}

	int getFifty() {
		return getThirty() + getThirty() + getSeven();
	}
}