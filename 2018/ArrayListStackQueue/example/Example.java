package example;

/**
 * 例題プログラム：この例題を改変して大きなプログラムを作る足がかりにしてください。
 */
public class Example extends Object
{
	/**
	 * 例題のメインプログラム。
	 * @param arguments コマンドの引数列（文字列の配列）
	 */
	public static void main(String[] arguments)
	{
		Example.example1(); // Sequenceの例題プログラム
		Example.example2(); // Stackの例題プログラム
		Example.example3(); // Queueの例題プログラム

		return;
	}

	/**
	 * Sequenceの例題プログラム。
	 */
	public static void example1()
	{
		String aString = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.printf("%s: ", aString );

		Sequence<Integer> aSequence = new Sequence<Integer>();
		aSequence.addFirst(100);
		aSequence.addLast(200);
		aSequence.addLast(300);
		System.out.printf("%s%n", aSequence.getClass().getName());
		System.out.printf("%s%n", aSequence);

		Integer anInteger = null;
		anInteger = aSequence.removeFirst();
		System.out.printf("%s, removed: %s%n", aSequence, anInteger);
		anInteger = aSequence.removeLast();
		System.out.printf("%s, removed: %s%n", aSequence, anInteger);

		return;
	}

	/**
	 * Stackの例題プログラム。
	 */
	public static void example2()
	{
		String aString = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.printf("%s: ", aString );

		Stack<Integer> aStack = new Stack<Integer>();
		aStack.push(100);
		aStack.push(200);
		aStack.push(300);
		System.out.printf("%s%n", aStack.getClass().getName());
		System.out.printf("%s%n", aStack);

		Integer anInteger = null;
		anInteger = aStack.pop();
		System.out.printf("%s, popped: %s%n", aStack, anInteger);
		anInteger = aStack.pop();
		System.out.printf("%s, popped: %s%n", aStack, anInteger);

		return;
	}

	/**
	 * Queueの例題プログラム。
	 */
	public static void example3()
	{
		String aString = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.printf("%s: ", aString );

		Queue<Integer> aQueue = new Queue<Integer>();
		aQueue.enqueue(100);
		aQueue.enqueue(200);
		aQueue.enqueue(300);
		System.out.printf("%s%n", aQueue.getClass().getName());
		System.out.printf("%s%n", aQueue);

		Integer anInteger = null;
		anInteger = aQueue.dequeue();
		System.out.printf("%s, dequeued: %s%n", aQueue, anInteger);
		anInteger = aQueue.dequeue();
		System.out.printf("%s, dequeued: %s%n", aQueue, anInteger);

		return;
	}
}
