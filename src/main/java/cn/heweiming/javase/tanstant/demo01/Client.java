package cn.heweiming.javase.tanstant.demo01;

public class Client {

	public static void main(String[] args) {
		System.out.println("人类寿命极限是:" + Constant.MAX_AGE);
	}
	/*
	 * 开发人员修改一个final类型共的值(基本类型),考虑到重新发布风险较大，或者是时间较长，或者是审批流程
	 * 国语繁琐，反正是为了偷懒，于是直接采用替换class类文件的方式发布。替换完毕后应用服务器自动重启
	 * 然后简单测试一下（比如本类引用final类型的常量）,一切OK。可运行几天后发现业务数据对不上，有的类
	 * （引用关系的类）使用了旧值，有的类（继承关系的类）使用的是新值
	 * 	
	 */

}
