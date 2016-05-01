package cn.heweiming.javase.object.demo01;

public abstract class Server {
	public final static int DEFAULT_PORT = 40000;

	public Server() {
		int port = getPort();
		System.out.println("端口号：" + port);
	}

	protected abstract int getPort();

}
