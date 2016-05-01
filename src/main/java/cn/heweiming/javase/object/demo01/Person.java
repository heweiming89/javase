package cn.heweiming.javase.object.demo01;

import java.io.Serializable;

public class Person implements Serializable {

	public static class Home {

		private String address;

		private String tel;

		public Home(String address, String tel) {
			this.address = address;
			this.tel = tel;
		}

		public String getAddress() {
			return address;
		}

		public String getTel() {
			return tel;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public void setTel(String tel) {
			this.tel = tel;
		}

		@Override
		public String toString() {
			return "Home [address=" + address + ", tel=" + tel + "]";
		}

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		Person p = new Person("张三");
		p.setHome(new Person.Home("上海", "021"));
	}

	private String name;

	private Home home;

	public Person(String name) {
		super();
		this.name = name;
	}

	public Home getHome() {
		return home;
	}

	public String getName() {
		return name;
	}

	public void setHome(Home home) {
		this.home = home;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", home=" + home + "]";
	}

}
