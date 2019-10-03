
class Demo{
	int data;
	Demo(int data){
		this.data = data;
	}
}
public class Test {

	Demo demo;
	public void m1(Demo d) {
		if(d == null)
			d = new Demo(200);
		System.out.println(d);
	}
	
	public static void main(String[] args) {
		Test t = new Test();
		t.m1(t.demo);
		System.out.println("demo: "+t.demo);

	}

}
