package StarCS;

/*
 * 定义一个抽象类，用abstract关键词
 * abstract可以和public, private, protected等关键词共同修饰一个类，但不能和final一起修饰
 */
public abstract class AbstractClassAndInterface {
	/*
	 * 抽象类有构造方法，但是不能被实例化，也就是说，不能被
	 * 
	 * AbstractClassAndInterface abb = new AbstractClassAndInterface();
	 * 
	 * 但是可以在实例化时重写方法，见main函数中的代码。
	 * 也可以在子类继承时,在子类的构造方法中通过super关键字继承到
	 */
	public AbstractClassAndInterface() {
		System.out.println("welcome user!");
	}
	//当然，抽象类中也可以放置常规的方法（不需要被重写）
	public static void printNumber() {
		System.out.println(1+2);
	}
	//注意，抽象方法没有方法体，以；结尾。
	public abstract void printString();
	
	public static void main(String [] args) {
		
		AbstractClassAndInterface abb = new AbstractClassAndInterface() {
			
			@Override
			public void printString() {
				// TODO Auto-generated method stub
				System.out.println("hello world!");
			}
		};
		
		abb.printString();
	}
	
}
/*
 * 下面的class继承自抽象类，必须要implement抽象类中的抽象方法
 */
class offspringClass extends AbstractClassAndInterface {
	/*
	 * 子类的构造方法可以用super关键字调用父类的构造方法
	 */
	public offspringClass() {
		super();
		System.out.println("welcome, my father");
	}
	/*
	 * 重写printString方法以达到多态的目的--面向对象编程的重要元素
	 */
	@Override
	public void printString() {
		// TODO Auto-generated method stub
		System.out.println("hello, moon!");
	}
	
}

/*
 * 下面是接口interface的讲解。大体上类似抽象类，但比抽象类更加“严格”
 * 使用interface关键词定义接口
 */
interface fatherInterface {
	/*
	 * 接口没有构造函数
	 * 接口可以有抽象方法也可以有常规方法，但都要在实现接口的类中重写
	 */
	
	public int doubleNumber(int number);
	
	public abstract void printDouble();
	
	public float getFloat();
}

/*
 * 类通过implements关键词实现接口中的方法，必须全部实现
 */
class sonInterface implements fatherInterface {

	@Override
	public int doubleNumber(int number) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void printDouble() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public float getFloat() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

/*
 * 最后，Java语言采用单继承，多接口的方式。也就是说一个类只可以有一个父类，但是可以有多个接口。
 */


