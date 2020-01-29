package example;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 集約(aggregation)を利用した「0オリジンではなく、1オリジン」でアクセスする群れオブジェクト（Bevy：べヴィ）。
 */
public class Bevy<Element> extends Object implements Iterable<Element>
{
	/**
	 * 群れの要素を記憶するフィールド。
	 */
	private ArrayList<Element> arrayList;

	/**
	 * コンストラクタ：初期容量が10の群れオブジェクトを作る。
	 */
	public Bevy()
	{
		this.arrayList = new ArrayList<Element>(10);

		return;
	}

	/**
	 * コンストラクタ：指定された要素配列から群れオブジェクトを作る。
	 * @param aCollection 要素配列
	 */
	public Bevy(Element[] aCollection)
	{
		this.arrayList = new ArrayList<Element>(aCollection.length);
		for (Element anElement : aCollection)
		{
			this.addElement(anElement);
		}

		return;
	}

	/**
	 * コンストラクタ：指定された初期容量で空の群れオブジェクトを作る。
	 * @param initialCapacity 初期容量
	 */
	public Bevy(Integer initialCapacity)
	{
		this.arrayList = new ArrayList<Element>(initialCapacity);

		return;
	}

	/**
	 * 自分自身の内の指定された位置(1オリジン、0オリジンではない)にある要素を応答する。
	 * @param anIndex 指定位置（インデックス：1オリジンであることに注意）
	 * @return 指定された位置にある要素
	 */
	public Element at(Integer anIndex)
	{
		this.examineIndex(anIndex);

		return null; // ちゃんと実装してください。
	}

	/**
	 * 自分自身の内の指定された位置(1オリジン、0オリジンではない)にある要素を、指定された要素で置き換える。
	 * @param anIndex 指定位置（インデックス：1オリジンであることに注意）
	 * @param anElement 置き換える要素
	 * @return 指定された位置に以前（置き換える前に）あった（元々の）要素
	 */
	public Element atPut(Integer anIndex, Element anElement)
	{
		this.examineIndex(anIndex);

		return null; // ちゃんと実装してください。
	}

	/**
	 * 自分自身の最後に指定された要素を追加する。
	 * @param anElement 追加したい要素
	 * @return 要素を追加できたか否かの真偽
	 */
	public boolean addElement(Element anElement)
	{
		return false; // ちゃんと実装してください。
	}

	/**
	 * 自分自身のコピーを作って応答する。
	 * @return コピーされた群れオブジェクト
	 */
	public Bevy<Element> copy()
	{
		Bevy<Element> aBevy = new Bevy<Element>(this.numberOfElements());
		for (Element anElement : this) { aBevy.addElement(anElement); }

		return aBevy;
	}

	/**
	 * 指定された位置(1オリジン、0オリジンではない)が有効でない場合に例外を発生させる。
	 * @param anIndex 指定位置（インデックス：1オリジンであることに注意）
	 * @throws IndexOutOfBoundsException 指定位置（インデックス）が不正の場合
	 */
	private void examineIndex(Integer anIndex)
	{
		if ((anIndex < 1) || (anIndex > this.numberOfElements()))
		{
			String aString = "Index: {0}, Size: {1}";
			aString = MessageFormat.format(aString, anIndex, this.numberOfElements());
			throw new IndexOutOfBoundsException(aString);
		}

		return;
	}

	/**
	 * 自分自身が空かどうかを応答する。
	 * @return 空かどうかの真偽
	 */
	public boolean isEmpty()
	{
		return true; // ちゃんと実装してください。
	}

	/**
	 * 自分自身のイテレータを応答する。
	 * @return 群れオブジェクトのイテレータ
	 */
	public Iterator<Element> iterator()
	{
		return this.arrayList.iterator();
	}

	/**
	 * 自分自身の要素数を応答する。
	 * @return 群れオブジェクトの要素数
	 */
	public Integer numberOfElements()
	{
		return Integer.valueOf(0); // ちゃんと実装してください。
	}

	/**
	 * 自分自身の内の指定された位置（1オリジン、0オリジンではない）にある要素を削除して応答する。
	 * @param anIndex 指定位置（インデックス：1オリジンであることに注意）
	 * @return 指定された位置に以前（削除する前に）あった（元々の）要素
	 */
	public Element removeAt(Integer anIndex)
	{
		this.examineIndex(anIndex);

		return null; // ちゃんと実装してください。
	}

	/**
	* 自分自身を文字列にして応答する。
	* @return 群れオブジェクトの要素を列挙した文字列
	*/
	@Override
	public String toString()
	{
		StringBuffer aBuffer = new StringBuffer();
		Class<?> aClass = this.getClass();
		aBuffer.append(aClass.getName());
		aBuffer.append("[");
		boolean firstTime = true;
		for (Element anElement : this)
		{
			if (firstTime)
			{
				firstTime = false;
			}
			else
			{
				aBuffer.append(", ");
			}
			aBuffer.append(anElement.toString());
		}
		aBuffer.append("]");

		return aBuffer.toString();
	}
}
