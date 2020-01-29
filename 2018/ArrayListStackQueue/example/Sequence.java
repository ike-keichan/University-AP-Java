package example;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * シーケンス（順序のある集まり）：配列リストjava.util.ArrayListのインスタンスを1つ集約（aggregation）して、インスタンス変数contents（私的フィールドcontents）に保持し、シーケンス（順序のある集まり）の機能（たとえば、要素の追加や削除や列挙など）をcontentsへ委譲（delegation）を用いて実現する。
 */
public class Sequence<Element> extends Object implements Iterable<Element>
{
	/**
	 * シーケンス（順序のある集まり）の要素を記憶するフィールド。要素はジェネリクス（Generics）を用いて型変数Elementで表現する。
	 */
	protected ArrayList<Element> contents;

	/**
	 * シーケンス（順序のある集まり）のコンストラクタ。
	 */
	public Sequence()
	{
		this.contents = new ArrayList<Element>();

		return;
	}

	/**
	 * 自分自身の最初に指定された要素を追加する。
	 * @param anElement 追加したい要素
	 */
	public void addFirst(Element anElement)
	{
		this.contents.add(0, anElement);// ちゃんと実装してください。

		return;
	}

	/**
	 * 自分自身の最後に指定された要素を追加する。
	 * @param anElement 追加したい要素
	 */
	public void addLast(Element anElement)
	{
		this.contents.add(this.size() - 1, anElement);// ちゃんと実装してください。

		return;
	}

	/**
	 * 自分自身の最初の要素を応答する。
	 * @return 最初の要素
	 */
	public Element first()
	{
		// ちゃんと実装してください。

		return this.contents.get(0);
	}

	/**
	 * 0オリジンの添字indexで指定された要素を応答する。
	 * @param index 0オリジンの添字
	 * @return 0オリジンの添字indexで指定された要素
	 */
	public Element get(Integer index)
	{
		// ちゃんと実装してください。

		return this.contents.get(index);
	}

	/**
	 * 自分自身が空かどうかを応答する。
	 * @return 空かどうかの真偽
	 */
	public boolean isEmpty()
	{
		// ちゃんと実装してください。

		return true;
	}

	/**
	 * 自分自身のイテレータを応答する。
	 * @return ArrayListのインスタンスのイテレータ
	 */
	public Iterator<Element> iterator()
	{
		return this.contents.iterator();
	}

	/**
	 * 自分自身の最後の要素を応答する。
	 * @return 最後の要素
	 */
	public Element last()
	{
		// ちゃんと実装してください。

		return  this.contents.get(this.size() - 1);
	}

	/**
	 * 自分自身の最初の要素を削除し、削除した要素を応答する。
	 * @return 削除された要素
	 */
	public Element removeFirst()
	{
		// ちゃんと実装してください。

		return  this.contents.remove(0);
	}

	/**
	 * 自分自身の最後の要素を削除し、削除した要素を応答する。
	 * @return 削除された要素
	 */
	public Element removeLast()
	{
		// ちゃんと実装してください。

		return this.contents.remove(this.size() - 1);
	}
	/**
	 * 自分自身の要素数を応答する。
	 * @return 群れオブジェクトの要素数
	 */
	public Integer size()
	{
		// ちゃんと実装してください。

		return Integer.valueOf(this.contents.size());
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
			if (firstTime) { firstTime = false; } else { aBuffer.append(", "); }
			aBuffer.append(anElement.toString());
		}
		aBuffer.append("]");

		return aBuffer.toString();
	}
}
