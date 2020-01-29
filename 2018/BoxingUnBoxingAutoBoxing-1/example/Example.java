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
		Example.example1();
		Example.example2();
		Example.example3();
		Example.example4();
		Example.example5();

		return;
	}

	/**
	 * 例題プログラム（1）：オートボクシングの例。
	 */
	public static void example1()
	{
		String aString = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.print(aString + ": ");

		Double anDouble = 100.0; // auto boxing
		double an_double = 100.0;

		if (anDouble == an_double) // auto boxing
		{
			System.out.println("anDouble == an_double");
		}
		else
		{
			System.out.println("anDouble != an_double");
		}

		return;
	}

	/**
	 * 例題プログラム（2）：オートボクシングを明示的にボクシングとアンボクシングで。
	 */
	public static void example2()
	{
		String aString = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.print(aString + ": ");

		Double anDouble = Double.valueOf(100); // boxing
		double an_double = 100.0;

		if (anDouble.doubleValue() == an_double) // unboxing
		{
			System.out.println("anDouble == an_double");
		}
		else
		{
			System.out.println("anDouble != an_double");
		}

		return;
	}

	/**
	 * 例題プログラム（3）：ボクシングされたものがオブジェクトであること。
	 */
	public static void example3()
	{
		String aString = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.print(aString + ": ");

		Double anDouble = 200.0; // auto boxing
		Double anotherDouble = 200.0; // auto boxing

		if (anDouble == anotherDouble) // no boxing
		{
			System.out.println("anDouble == anotherDouble");
		}
		else
		{
			System.out.println("anDouble != anotherDouble");
		}

		return;
	}

	/**
	 * 例題プログラム（4）：ボクシングされたものがオブジェクトであることを明示的に。
	 */
	public static void example4()
	{
		String aString = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.print(aString + ": ");

		Double anDouble = Double.valueOf(200); // boxing
		Double anotherDouble = Double.valueOf(200); //boxing

		if (anDouble == anotherDouble) // no boxing
		{
			System.out.println("anDouble == anotherDouble");
		}
		else
		{
			System.out.println("anDouble != anotherDouble");
		}

		return;
	}

	/**
	 * 例題プログラム（5）：ボクシングされたものがキャッシュの中にあり、オブジェクトのアドレスが同じになる例：隘路＝間違いを誘ってしまう例。
	 */
	public static void example5()
	{
		String aString = Thread.currentThread().getStackTrace()[1].getMethodName();
		System.out.print(aString + ": ");

		Double anDouble = Double.valueOf(100); // boxing
		Double anotherDouble = Double.valueOf(100); // boxing

		if (anDouble == anotherDouble) // no boxing
		{
			System.out.println("anDouble == anotherDouble");
		}
		else
		{
			System.out.println("anDouble != anotherDouble");
		}

		return;
	}

}
