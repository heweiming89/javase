package cn.heweiming.javase.enumeration.demo01;

public enum Color {
	RED, ORANGE, YELLOW, GREEN, INDIGO, BLUE, VIOLET;

	@Override
	public String toString() {
		return this.name();
	}

	public static void main(String[] args) {
		System.out.println(Color.BLUE.equals("BLUE"));
	}
}
