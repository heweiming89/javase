package cn.heweiming.javase.object.demo01;

public class SimpleServer extends Server {

	private int port = 100;

	public SimpleServer(int port) {
		this.port = port;
	}

	@Override
	protected int getPort() {
		return Math.random() > 0.5 ? port : DEFAULT_PORT;
	}

}
