package shane;

public class Test2{
	public static void main(String[] args){
		OrderedIntegers2 oi2 = new OrderedIntegers2(5);

		oi2.addValue(0);
		printArray(oi2);

		System.out.println();
		oi2.addValue(2);
		printArray(oi2);

		System.out.println();
		oi2.addValue(1);
		printArray(oi2);
	}
	
	public static void printArray(OrderedIntegers2 oi2m) {
		for(int i = 0; i < 5; i++)
			System.out.print(oi2m.getValue(i) + " ");
		System.out.println();
	}
}