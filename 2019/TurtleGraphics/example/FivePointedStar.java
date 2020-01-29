package example;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * タートルグラフィックスの例題プログラム：この例題を改変して大きなプログラムを作る足がかりにしてください。
 */
public class FivePointedStar extends Object
{
	/**
	 * 1つの亀で五芒星を描く。
	 */
	public static void draw1()
	{
		// 地面をきれいにする。
		Ground.singleton().clear();

		// 亀を作り、中央座標-(100,50)に配置して、赤色にする。
		Turtle aTurtle = new Turtle();
		aTurtle.position(Ground.centerX - 100, Ground.centerY - 50);
		aTurtle.down();
		aTurtle.color(Color.red);
		aTurtle.nib(3);

		// 描画スピードを"遅い"に設定する。
		Ground.tick = Ground.TICK;

		// 200歩進んで、144度回転する。
		aTurtle.go(200);
		aTurtle.turn(144);
		aTurtle.print("1番目の点", Color.green);

		// さらに、200歩進んで、144度回転する。
		aTurtle.go(200);
		aTurtle.turn(144);
		aTurtle.print("2番目の点", Color.blue);

		// さらに、さらに、200歩進んで、144度回転する。
		aTurtle.go(200);
		aTurtle.turn(144);
		aTurtle.print("3番目の点", Color.cyan);

		// さらに、さらに、さらに、200歩進んで、144度回転する。
		aTurtle.go(200);
		aTurtle.turn(144);
		aTurtle.print("4番目の点", Color.magenta);

		// さらに、さらに、さらに、さらに、200歩進んで、144度回転する。
		aTurtle.go(200);
		aTurtle.turn(144);
		aTurtle.print("5番目の点", Color.yellow);

		return;
	}

	/**
	 * 複数の亀で色とりどりの五芒星を描く。
	 */
	public static void draw2()
	{
		// 地面をきれいにする。
		Ground.singleton().clear();

		// 複数の亀たちを束縛するリストを作る。
		List<Turtle> aList = new ArrayList<Turtle>();

		// 色とりどりの亀をいくつも作りながらリストに追加する。
		for (Integer angle = 0; angle < 360; angle += 8)
		{
			// 色相・彩度・明度を用いて角度に応じた色のインスタンスを作る。
			Float hue = Float.valueOf(angle) / 360.0f;
			Float saturation = 1.0f;
			Float brightness = 1.0f;
			Color color = Color.getHSBColor(hue, saturation, brightness);

			// 亀を作り、中央座標に配置して、角度に応じた色にし、その角度だけ回転しておく。
			Turtle aTurtle = new Turtle();
			aTurtle.home();
			aTurtle.down();
			aTurtle.color(color);
			aTurtle.nib(2);
			aTurtle.turn(angle);
			aList.add(aTurtle);
		}

		// 描画スピードを"とても速い"に設定する。
		Ground.tick = Ground.TICK / 50;

		// 複数の亀たちに五芒星を描かせる。
		for (Integer n = 0; n < 5; n++)
		{
			for (Turtle aTurtle : aList)
			{
				aTurtle.go(200);
				aTurtle.turn(144);
			}
		}

		return;
	}
}
