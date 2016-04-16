package cn.heweiming.javase.reflect.demo01;

import java.util.Date;

public class Person {

	@FieldIndex(index = 0)
	private String name;
	@FieldIndex(index = 1)
	private Character sex;
	@FieldIndex(index = 2)
	private Integer age;
	@FieldIndex(index = 3)
	private Double income;
	@FieldIndex(index = 4)
	private Date birthday;

	private String password;

	public Integer getAge() {
		return age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public Double getIncome() {
		return income;
	}

	public String getName() {
		return name;
	}

	public String getPassword() {
		return password;
	}

	public Character getSex() {
		return sex;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public void setIncome(Double income) {
		this.income = income;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setSex(Character sex) {
		this.sex = sex;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", sex=" + sex + ", age=" + age
				+ ", income=" + income + ", birthday=" + birthday
				+ ", password=" + password + "]";
	}

}
