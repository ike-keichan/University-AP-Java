package example;

/**
 * スタック（積み上げ）：シーケンス（順序のある集まり）example.Sequenceを継承し、スタック（積み上げ）の機能（プッシュやポップ）を実現する。
 */
public class Stack<Element> extends Sequence<Element> implements Iterable<Element>
{
	/**
	 * 自分自身（積み上げ）に指定された要素をプッシュ(追加）する。
	 * @param anElement 追加したい要素
	 */
	public void push(Element anElement)
	{
		return;
	}

	/**
	 * 自分自身（積み上げ）の最初の要素をポップ（削除）し、ポップ（削除）した要素を応答する。
	 * @return 削除された要素
	 */
	public Element pop()
	{
		return null;
	}
}
