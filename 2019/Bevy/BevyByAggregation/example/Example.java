package example;

import java.util.Iterator;

/**
 * 例題プログラム：群れオブジェクト（Bevy）のテストを行う。
 */
public class Example extends Object
{
	/**
	 * 例題のメインプログラム。
	 * @param arguments コマンドの引数列（引数文字列の配列）
	 */
	public static void main(String[] arguments)
	{
		// 整数オブジェクトの配列を作る。
		Integer anArrayOfIntegers[] = { 8, 3, 5, 9, 1 };

		// 整数オブジェクトの配列から群れオブジェクトを作る。
		Bevy<Integer> aBevy = new Bevy<Integer>(anArrayOfIntegers);

		// 当該の群れオブジェクトを標準出力にプリントする。
		System.out.println(aBevy);

		// 当該の群れオブジェクトをバブルソートで並び換えをする。
		Example.bubbleSort(aBevy);

		// 当該の群れオブジェクトを拡張for文（for-each）で列挙する。
		Example.enumerationByForEach(aBevy);

		// 当該の群れオブジェクトをイテレータで列挙する。
		Example.enumerationByIterator(aBevy);

		// 当該の群れオブジェクトを選択ソートで並び換えをする。
		Example.selectionSort(aBevy);

		return;
	}

	/**
	 * 群れオブジェクトをバブルソートのアルゴリズムを用いて並び換える。
	 * @param theBevy 並び換えたい群れオブジェクト
	 * @return 並び換えられた群れオブジェクト
	 */
	public static Bevy<Integer> bubbleSort(Bevy<Integer> theBevy)
	{
		Bevy<Integer> aBevy = theBevy.copy();

		System.out.printf("bubble sort: %s%n", aBevy.toString());
		Integer n = aBevy.numberOfElements();
		Integer i = 1;
		while (i < n)
		{
			Integer a = aBevy.at(i);
			Integer b = aBevy.at(i + 1);
			if (a.compareTo(b) > 0)
			{
				aBevy.atPut(i, b);
				aBevy.atPut(i + 1, a);
				System.out.printf("bubble sort: %s%n", aBevy.toString());
				i = 1;
			}
			else
			{
				i = i + 1;
			}
		}

		return aBevy;
	}

	/**
	 * 群れオブジェクトが拡張for文（for-each）による列挙ができるかどうかを確かめる。
	 * @param aBevy 並び換えたい群れオブジェクト
	 */
	public static void enumerationByForEach(Bevy<Integer> aBevy)
	{
		System.out.printf("enumeration by for-each: [");
		boolean firstTime = true;
		for (Integer anInteger : aBevy)
		{
			if (firstTime) { firstTime = false; }
			else { System.out.printf(", "); }
			System.out.printf("%d", anInteger);
		}
		System.out.printf("]%n");

		return;
	}

	/**
	 * 群れオブジェクトがイテレータによる列挙ができるかどうかを確かめる。
	 * @param aBevy 並び換えたい群れオブジェクト
	 */
	public static void enumerationByIterator(Bevy<Integer> aBevy)
	{
		System.out.printf("enumeration by iterator: [");
		boolean firstTime = true;
		Iterator<Integer> anIterator = aBevy.iterator();
		while (anIterator.hasNext())
		{
			Integer anInteger = anIterator.next();
			if (firstTime) { firstTime = false; }
			else { System.out.printf(", "); }
			System.out.printf("%d", anInteger);
		}
		System.out.printf("]%n");

		return;
	}

	/**
	 * 群れオブジェクトを選択ソートのアルゴリズムを用いて並び換える。
	 * @param theBevy 並び換えたい群れオブジェクト
	 * @return 並び換えられた群れオブジェクト
	 */
	public static Bevy<Integer> selectionSort(Bevy<Integer> theBevy)
	{
		Bevy<Integer> aBevy = theBevy.copy();
		Bevy<Integer> sortedBevy = new Bevy<Integer>(aBevy.numberOfElements());

		System.out.printf("selection sort: %s %s%n", aBevy.toString(), sortedBevy.toString());
		while (!aBevy.isEmpty())
		{
			Integer minimumInteger = aBevy.at(1);
			Integer indexOfMinimumInteger = 1;
			Integer anIndex = 1;
			for (Integer anInteger : aBevy)
			{
				if (anInteger.compareTo(minimumInteger) < 0)
				{
					minimumInteger = anInteger;
					indexOfMinimumInteger = anIndex;
				}
				anIndex++;
			}
			aBevy.removeAt(indexOfMinimumInteger);
			sortedBevy.addElement(minimumInteger);
			System.out.printf("selection sort: %s %s%n", aBevy.toString(), sortedBevy.toString());
		}

		return sortedBevy;
	}
}
