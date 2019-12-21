public class A {
	public static void main(String[] args) {
		m1(new B());
	}

	private static void m1(B b) {
		b.add(8);
		b.print();
	}
}


class B extends Base {
	B() {
		add(2);
	}

	void add(int v) { i += v*2;}
}

class Base{
	int i;

	Base() {
		add(i);
	}

	void add(int v) {
		i += v;
	}

	void print() {
		System.out.println(i);
	}

}

