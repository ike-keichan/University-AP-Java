package example;

/**
 * キュー（待ち行列）：シーケンス（順序のある集まり）example.Sequenceを継承し、キュー（待ち行列）の機能（エンキューやデキュー）を実現する。
 */
public class Queue<Element> extends Sequence<Element>  implements Iterable<Element>
{
	/**
	 * 自分自身（待ち行列）から要素を取り出して応答する。
	 * @return 取り出した要素
	 */
	public Element dequeue()
	{
		return null;
	}

	/**
	 * 自分自身（待ち行列）に指定された要素を入れる。
	 * @param anElement 追加したい要素
	 */
	public void enqueue(Element anElement)
	{
		return;
	}
}
