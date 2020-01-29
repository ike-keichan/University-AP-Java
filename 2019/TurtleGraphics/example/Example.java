package example;

import java.awt.Color;

/**
 * タートルグラフィックスの例題プログラム：この例題を改変して大きなプログラムを作る足がかりにしてください。
 */
public class Example extends Object
{
	/**
	 * ここに面白いタートルグラフィックスを作ってください。
	 */
	public static void draw()
	{
		// 地面をきれいにする。
		Ground.singleton().clear();

		Turtle aTurtle = new Turtle();
		aTurtle.position(Ground.centerX - 150, Ground.centerY);
		aTurtle.down();
		aTurtle.color(Color.red);
		aTurtle.print("ここに面白いタートルグラフィックスを作ってください。");

		return;
	}

	/**
	 * 例題のメインプログラム。
	 * @param arguments コマンドの引数列（文字列の配列）
	 */
	public static void main(String[] arguments)
	{
		FivePointedStar.draw1();
		Ground.save();

		Ground.sleep(5000);

		FivePointedStar.draw2();
		Ground.save();

		Ground.sleep(5000);

		Example.draw();
		Ground.save();

		/*****
		Ground.sleep(5000);

		IceCrystal.draw();
		Ground.save();

		Ground.sleep(5000);

		LorenzAttractor.draw();
		Ground.save();

		Ground.sleep(5000);

		Planets.draw();
		Ground.save();
		*****/

		return;
	}
}
