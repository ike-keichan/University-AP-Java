package example;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * タートルグラフィックスの課題プログラム：オリジナルは森澪希さん（2016年度2年次生）の作で、青木淳が手入れをしました。
 */
public class IceCrystal extends Object
{
	/**
	 * 雪の結晶のようなタートルグラフィックスを行います。
	 */
	public static void draw()
	{
		//亀の数。実際はこの数の2倍の亀が生成される。
		Integer numberOfTurtles = 6;

		Double halfGroundWidth = Ground.WIDTH / 2.0;
		Double halfGroundHeight = Ground.HEIGHT / 2.0;

		// 地面を暗い灰色にする。
		Ground.singleton().clear(new Color(50, 50, 50));

		// 亀たちを保持するリストを作る。
		List<Turtle> turtles = new ArrayList<Turtle>();

		// 亀たちをリストに登録して描く準備を整える。
		for(Integer i = 0; i < numberOfTurtles * 2; i++)
		{
			Double angle = i.doubleValue()/numberOfTurtles;

			// 白い線を引く亀と青い線を引く亀をそれぞれnumberOfTurtlesずつ作る。
			if (i < numberOfTurtles)
			{
				// 青い線を引く亀を作り、中央座標に配置して、回転しておく。
				Turtle aTurtle = new Turtle();
				aTurtle.up();
				aTurtle.move(halfGroundWidth, halfGroundHeight);
				aTurtle.down();
				aTurtle.color(new Color(100, 150, 255, 30));
				aTurtle.nib(7);
				aTurtle.turn(angle * 360);
				turtles.add(aTurtle);
			}
			else
			{
				// 白い線を引く亀を作り、中央座標に配置して、回転しておく。
				Turtle aTurtle = new Turtle();
				aTurtle.up();
				aTurtle.move(halfGroundWidth, halfGroundHeight);
				aTurtle.down();
				aTurtle.color(new Color(200, 220, 255));
				aTurtle.nib(1);
				aTurtle.turn(angle * 360);
				turtles.add(aTurtle);
			}
		}

		// 描画スピードを"とても速い"に設定する。
		Ground.tick = Ground.TICK / 50;

		// 結晶を描く。
		Double size = 70.0;       // 結晶の大きさ
		Double branchSize = 30.0; // 枝の大きさ
		Double moveSize = 1.0;    // 移動距離の調整に使用
		for(Integer i = 5; i > 0; i--)
		{
			for (Turtle aTurtle : turtles)
			{
				makeBranch(aTurtle, branchSize * moveSize, Math.min(4, i));
				aTurtle.go(size * moveSize);
			}
			moveSize *= 0.8;
		}
		return;
	}

	/**
	 * 枝分かれする結晶を描く。
	 * @param aTurtle 描画を担当する亀
	 * @param branchSize 枝の長さ
	 * @param number 枝分かれの回数
	 */
	private static void makeBranch(Turtle aTurtle, Double branchSize, Integer number)
	{
		if (number <= 0) { return; }

		// まっすぐ伸びる枝を描く。
		aTurtle.go(branchSize);
		makeBranch(aTurtle, branchSize * 0.8, number - 1);
		aTurtle.turn(180);
		aTurtle.go(branchSize);

		// 右に伸びる枝を描く。
		aTurtle.turn(240);
		aTurtle.go(branchSize);
		makeBranch(aTurtle, branchSize * 0.5, number - 1);
		aTurtle.turn(180);
		aTurtle.go(branchSize * 1.5);
		aTurtle.turn(180);
		aTurtle.go(branchSize * 0.5);

		// 左に伸びる枝を描く。
		aTurtle.turn(240);
		aTurtle.go(branchSize);
		makeBranch(aTurtle, branchSize * 0.5, number - 1);
		aTurtle.turn(180);
		aTurtle.go(branchSize * 1.5);
		aTurtle.turn(180);
		aTurtle.go(branchSize * 0.5);

		// もとの向きに戻す。
		aTurtle.turn(60);

		return;
	}
}
