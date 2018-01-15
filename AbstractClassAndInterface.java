package StarCS;

/*
 * ����һ�������࣬��abstract�ؼ���
 * abstract���Ժ�public, private, protected�ȹؼ��ʹ�ͬ����һ���࣬�����ܺ�finalһ������
 */
public abstract class AbstractClassAndInterface {
	/*
	 * �������й��췽�������ǲ��ܱ�ʵ������Ҳ����˵�����ܱ�
	 * 
	 * AbstractClassAndInterface abb = new AbstractClassAndInterface();
	 * 
	 * ���ǿ�����ʵ����ʱ��д��������main�����еĴ��롣
	 * Ҳ����������̳�ʱ,������Ĺ��췽����ͨ��super�ؼ��ּ̳е�
	 */
	public AbstractClassAndInterface() {
		System.out.println("welcome user!");
	}
	//��Ȼ����������Ҳ���Է��ó���ķ���������Ҫ����д��
	public static void printNumber() {
		System.out.println(1+2);
	}
	//ע�⣬���󷽷�û�з����壬�ԣ���β��
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
 * �����class�̳��Գ����࣬����Ҫimplement�������еĳ��󷽷�
 */
class offspringClass extends AbstractClassAndInterface {
	/*
	 * ����Ĺ��췽��������super�ؼ��ֵ��ø���Ĺ��췽��
	 */
	public offspringClass() {
		super();
		System.out.println("welcome, my father");
	}
	/*
	 * ��дprintString�����Դﵽ��̬��Ŀ��--��������̵���ҪԪ��
	 */
	@Override
	public void printString() {
		// TODO Auto-generated method stub
		System.out.println("hello, moon!");
	}
	
}

/*
 * �����ǽӿ�interface�Ľ��⡣���������Ƴ����࣬���ȳ�������ӡ��ϸ�
 * ʹ��interface�ؼ��ʶ���ӿ�
 */
interface fatherInterface {
	/*
	 * �ӿ�û�й��캯��
	 * �ӿڿ����г��󷽷�Ҳ�����г��淽��������Ҫ��ʵ�ֽӿڵ�������д
	 */
	
	public int doubleNumber(int number);
	
	public abstract void printDouble();
	
	public float getFloat();
}

/*
 * ��ͨ��implements�ؼ���ʵ�ֽӿ��еķ���������ȫ��ʵ��
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
 * ���Java���Բ��õ��̳У���ӿڵķ�ʽ��Ҳ����˵һ����ֻ������һ�����࣬���ǿ����ж���ӿڡ�
 */


