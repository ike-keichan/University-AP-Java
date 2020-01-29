package example;

import java.awt.Color;

/**
 * タートルグラフィックスの課題プログラム：オリジナルは森澪希さん（2016年度2年次生）の作で、青木淳が手入れをしました。
 */
public class LorenzAttractor extends Object
{
	/**
	 * ローレンツアトラクタのタートルグラフィックスを行います。
	 */
	public static void draw()
	{
		LorenzEquationSolver solver = new LorenzEquationSolver(0.01, 10.0, 2.0, 0.0, 4.0);
		Double halfGroundWidth = Ground.WIDTH / 2.0;
		Double halfGroundHeight = Ground.HEIGHT / 2.0;

		// 地面をきれいにする。
		Ground.singleton().clear(new Color(120, 120, 120));

		// Turtleの設定をする。
		Turtle aTurtle = new Turtle();
		aTurtle.up();
		Double[] value = solver.getNextValue();
		aTurtle.move(value[0] + halfGroundWidth, value[1] + halfGroundHeight);
		aTurtle.down();
		aTurtle.nib(2);

		// 描画スピードを"とても速い"に設定する。
		Ground.tick = Ground.TICK / 50;

		// 亀を動かす。
		for (Integer i = 0; i < 10000; i++)
		{
			value = solver.getNextValue();
			aTurtle.color(LorenzAttractor.color(value));
			value = LorenzAttractor.rotate(value, new Double[] {0.0, 1.0, 0.0}, Math.PI * 2.0); // 回転させる
			aTurtle.move(value[0] + halfGroundWidth, value[1] + halfGroundHeight);
		}
		aTurtle.up();
		aTurtle.move(30, Ground.HEIGHT - 30);

		return;
	}

	/**
	 * 座標に対応する色を返す。
	 * @param position 座標を表す要素数3の配列
	 * @return 座標に対応する色
	 */
	private static Color color(Double[] position)
	{
		Double hosei = 0.005;
		Float r = (float)Math.min(hosei * Math.abs(position[0]), 1.f);
		Float g = (float)Math.min(hosei * Math.abs(position[1]), 1.f);
		Float b = (float)Math.min(hosei * Math.abs(position[2]), 1.f);

		return new Color(r, g ,b, 0.5f);
	}

	/**
	 * 3次元空間上の点を軸に沿って回転させる
	 * @param vector 3次元空間上の点を表す要素数3の配列
	 * @param axis 回転軸を表す要素数3の配列
	 * @param angle 回転させる角度
	 * @return 回転後の座標を表す要素数3の配列
	 */
	private static Double[] rotate(Double[] vector, Double[] axis, Double angle)
	{
		Double sum = axis[0] + axis[1] + axis[2];
		Double[] normalizedAxis = new Double[] {axis[0] / sum, axis[1] / sum, axis[2] / sum};
		Double[] quaternion = new Double[]
		{
			normalizedAxis[0] * Math.sin(angle /2),
			normalizedAxis[1] * Math.sin(angle /2),
			normalizedAxis[2] * Math.sin(angle /2),
			Math.cos(angle/2)
		};
		Double[] quaternion2 = new Double[]
		{
			-quaternion[0],
			-quaternion[1],
			-quaternion[2],
			quaternion[3]
		};
		vector = new Double[] {vector[0], vector[1], vector[2], 0.0};
		vector = new Double[]
		{
			vector[3] * quaternion2[0] + vector[0] * quaternion2[3] + quaternion2[1] * vector[2] - quaternion2[2] * vector[1],
			vector[3] * quaternion2[1] + vector[1] * quaternion2[3] + quaternion2[2] * vector[0] - quaternion2[0] * vector[2],
			vector[3] * quaternion2[2] + vector[2] * quaternion2[3] + quaternion2[0] * vector[1] - quaternion2[1] * vector[2],
			quaternion2[3] * vector[3] - (quaternion2[0] * vector[0] + quaternion2[1] * vector[1] + quaternion2[2] * vector[2])
		};
		vector = new Double[]
		{
			quaternion[3] * vector[0] + quaternion[0] * vector[3] + vector[1] * quaternion[2] - vector[2] * quaternion[1],
			quaternion[3] * vector[1] + quaternion[1] * vector[3] + vector[2] * quaternion[0] - vector[0] * quaternion[2],
			quaternion[3] * vector[2] + quaternion[2] * vector[3] + vector[0] * quaternion[1] - vector[1] * quaternion[0],
			vector[3] * quaternion[3] - (quaternion[0] * vector[0] + quaternion[1] * vector[1] + quaternion[2] * vector[2])
		};
		return new Double[] {vector[0], vector[1], vector[2]};
	}
}

/**
 * ローレンツ方程式を数値計算で解く。
 */
class LorenzEquationSolver extends Object
{
	/**
	 * ルンゲ・クッタ法でのステップ幅
	 */
	private Double deltaTime;

	/**
	 * 出力値に掛ける値
	 */
	private Double scale;

	/**
	 * 計算結果
	 */
	private Double x, y, z;

	/**
	 * 方程式内の定数
	 */
	private static final Double p = 10.0;

	/**
	 * 方程式内の定数
	 */
	private static final Double r = 28.0;

	/**
	 * 方程式内の定数
	 */
	private static final Double b = 8.0 / 3.0;

	/**
	 * コンストラクタ
	 * @param deltaTime ステップ幅
	 * @param scale 大きさの調整に使用
	 * @param x xの初期値
	 * @param y yの初期値
	 * @param z zの初期値
	 */
	public LorenzEquationSolver(double deltaTime, double scale, double x, double y, double z)
	{
		this.deltaTime = deltaTime;
		this.scale = scale;
		this.x = x;
		this.y = y;
		this.z = z;

		return;
	}

	/**
	 * x、y、z、の値を更新し、返す。
	 * @return 更新後のx, y, zをscale倍した値の配列
	 */
	public Double[] getNextValue()
	{
		this.update();

		return new Double[] {this.x * this.scale, this.y * this.scale, this.z * this.scale};
	}

	/**
	 * ルンゲ・クッタ法で、x、y、z、の値を更新する。
	 */
	private void update()
	{
		Double kx1 = this.deltaTime * this.getDeltaX(this.x, this.y, this.z);
		Double ky1 = this.deltaTime * this.getDeltaY(this.x, this.y, this.z);
		Double kz1 = this.deltaTime * this.getDeltaZ(this.x, this.y, this.z);
		Double kx2 = this.deltaTime * this.getDeltaX(this.x + kx1 / 2, this.y + ky1 / 2, this.z + kz1 /2);
		Double ky2 = this.deltaTime * this.getDeltaY(this.x + kx1 / 2, this.y + ky1 / 2, this.z + kz1 /2);
		Double kz2 = this.deltaTime * this.getDeltaZ(this.x + kx1 / 2, this.y + ky1 / 2, this.z + kz1 /2);
		Double kx3 = this.deltaTime * this.getDeltaX(this.x + kx2 / 2, this.y + ky2 / 2, this.z + kz2 /2);
		Double ky3 = this.deltaTime * this.getDeltaY(this.x + kx2 / 2, this.y + ky2 / 2, this.z + kz2 /2);
		Double kz3 = this.deltaTime * this.getDeltaZ(this.x + kx2 / 2, this.y + ky2 / 2, this.z + kz2 /2);
		Double kx4 = this.deltaTime * this.getDeltaX(this.x + kx3, this.y + ky3, this.z + kz3 );
		Double ky4 = this.deltaTime * this.getDeltaY(this.x + kx3, this.y + ky3, this.z + kz3 );
		Double kz4 = this.deltaTime * this.getDeltaZ(this.x + kx3, this.y + ky3, this.z + kz3 );
		this.x += (kx1 + 2 * kx2 + 2 * kx3 + kx4) / 6;
		this.y += (ky1 + 2 * ky2 + 2 * ky3 + ky4) / 6;
		this.z += (kz1 + 2 * kz2 + 2 * kz3 + kz4) / 6;

		return;
	}

	/**
	 * ローレンツ方程式：x成分を計算する。
	 * @param x 座標のx成分
	 * @param y 座標のy成分
	 * @param z 座標のz成分
	 * @return x成分
	 */
	private Double getDeltaX(Double x, Double y, Double z)
	{
		return -(LorenzEquationSolver.p) * x + LorenzEquationSolver.p * y;
	}

	/**
	 * ローレンツ方程式：y成分を計算する。
	 * @param x 座標のx成分
	 * @param y 座標のy成分
	 * @param z 座標のz成分
	 * @return y成分
	 */
	private Double getDeltaY(Double x, Double y, Double z)
	{
		return -x * z + LorenzEquationSolver.r * x - y;
	}

	/**
	 * ローレンツ方程式：z成分を計算する。
	 * @param x 座標のx成分
	 * @param y 座標のy成分
	 * @param z 座標のz成分
	 * @return z成分
	 */
	private Double getDeltaZ(Double x, Double y, Double z)
	{
		return x * y - LorenzEquationSolver.b * z;
	}
}
