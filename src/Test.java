public class Test {
	public static void main(String[] args) {
		new Main(new X()).start();
		new Main().start();
		new Thread(new X()).start();

	}
}

class X implements Runnable{
	@Override
	public void run() {
		System.out.println("test2");
	}
}

class Main extends Thread{
	Main() {}
	Main(Runnable r) {super(r);}
	public void run() {
		System.out.println("Test");
	}
}
