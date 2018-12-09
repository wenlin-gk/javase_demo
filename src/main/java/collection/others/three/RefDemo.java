package collection.others.three;

import java.lang.ref.WeakReference;

/**
 * 引用分类:强、软、弱、虚
 * 强与弱引用
 * @author Administrator
 *
 */
public class RefDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//字符串常量池 
		String str =new String("bjsxt is very good");
		//弱引用 管理 对象
		WeakReference<String> wr =new WeakReference<String>(str);
		System.out.println("gc运行前:"+wr.get());
		//断开引用
		str =null;
		//通知回收
		System.gc();
		System.runFinalization();
		//对象被回收
		System.out.println("gc运行后:"+wr.get()); 
	}
	public static void testStrong(){
		//字符串常量池  共享(不能回收)
		String str ="bjsxt is very good";
		//弱引用 管理 对象
		WeakReference<String> wr =new WeakReference<String>(str);
		System.out.println("gc运行前:"+wr.get());
		//断开引用
		str =null;
		//通知回收
		System.gc();
		System.runFinalization();
		System.out.println("gc运行后:"+wr.get());
	}

}
