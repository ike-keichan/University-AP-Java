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

		Character anCharacter = 'A'; // auto boxing
		char anChar = 'A';

		if (anCharacter == anChar) // auto boxing
		{
			System.out.println("anCharacter == anchar");
		}
		else
		{
			System.out.println("anCharacter != anchar");
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

		Character anCharacter = Character.valueOf('A'); // boxing
		char anChar = 'A';

		if (anCharacter.charValue() == anChar) // unboxing
		{
			System.out.println("anCharacter == anChar");
		}
		else
		{
			System.out.println("anCharacter != anChar");
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

		Character anCharacter = 'B'; // auto boxing
		Character anotherCharacter = 'B'; // auto boxing

		if (anCharacter == anotherCharacter) // no boxing
		{
			System.out.println("anCharacter == anotherCharacter");
		}
		else
		{
			System.out.println("anCharacter != anotherCharacter");
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

		Character anCharacter = Character.valueOf('B'); // boxing
		Character anotherCharacter = Character.valueOf('B'); //boxing

		if (anCharacter == anotherCharacter) // no boxing
		{
			System.out.println("anCharacter == anotherCharacter");
		}
		else
		{
			System.out.println("anCharacter != anotherCharacter");
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

		Character anCharacter = Character.valueOf('A'); // boxing
		Character anotherCharacter = Character.valueOf('A'); // boxing

		if (anCharacter == anotherCharacter) // no boxing
		{
			System.out.println("anCharacter == anotherCharacter");
		}
		else
		{
			System.out.println("anCharacter != anotherCharacter");
		}

		return;
	}
}
