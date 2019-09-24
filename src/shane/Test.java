package shane;

public class Test{
	public static void main(String[] args){
		OrderedIntegers2 oi2 = new OrderedIntegers2(6);
		
		oi2.addValue(2);
		printArray(oi2);
		System.out.println();
		
		oi2.addValue(4);
		printArray(oi2);
		System.out.println();
		
		oi2.addValue(127);
		printArray(oi2);
		System.out.println();
		
		
		oi2.addValue(8);
		printArray(oi2);
		System.out.println();
		
		oi2.addValue(3);
		
		oi2.addValue(7);
		
		//should read 2, 3, 4, 8, 127 by the end of this
		
		int[] i = {12, 88, 44, 32, 19};
		
		i[2] = 7;

		//int[] test = new int[3];
		//System.out.println(test[2]);

		System.out.println();
		System.out.println(oi2.getSize());
		System.out.println();
		printArray(oi2);
		
		System.out.println();
		oi2.removeValue(2);
		printArray(oi2);
	}
	
	public static void printArray(OrderedIntegers2 o) {
		for(int i = 0; i < (o.getSize()); i++)
			System.out.print(o.getValue(i) + " ");
		System.out.println();
	}
}