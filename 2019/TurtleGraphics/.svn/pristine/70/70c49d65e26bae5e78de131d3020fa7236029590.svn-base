package example;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

/**
 * 亀を表します。すなわち、タートルグラフィックスのペンになります。
 */
public class Turtle extends Object
{
	/**
	 * 亀の身大の半径を記憶するフィールド（クラス定数）である。
	 */
	protected static final Double BODY_RADIUS = 6.0d;
	/**
	 * 亀の歩幅を記憶するフィールド（クラス定数）である。
	 */
	protected static final Double STRIDE = 5.0d;
	/**
	 * 度数が1度分に相当するラジアン値を記憶するフィールド（クラス定数）である。
	 */
	protected static final Double RADIANS_PER_DEGREE = Math.PI / 180.0d;

	/**
	 * 地面を束縛するフィールドである。
	 */
	private Ground ground;
	/**
	 * 地面のグラフィックスコンテキストを束縛するフィールドである。
	 */
	private Graphics2D pen;
	/**
	 * 亀のx座標を束縛するフィールドである。
	 */
	private Double xPosition;
	/**
	 * 亀のy座標を束縛するフィールドである。
	 */
	private Double yPosition;
	/**
	 * 亀の方向（度数）を束縛するフィールドである。
	 */
	private Double direction;
	/**
	 * 亀のペンが上がっているのか下がっているのかを束縛するフィールドである。
	 */
	private Boolean down;
	/**
	 * 亀のペンの色を束縛するフィールドである。
	 */
	private Color color;
	/**
	 * 亀のペンの太さを束縛するフィールドである。
	 */
	private BasicStroke nib;

	/**
	 * 亀のコンストラクタである。
	 */
	public Turtle()
	{
		this.ground = Ground.singleton();
		this.ground.addTurtle(this);
		this.pen = this.ground.pen();
		this.xPosition = 0.0d;
		this.yPosition = 0.0d;
		this.direction = 0.0d;
		this.down = true;
		this.color = Color.black;
		this.nib = new BasicStroke(1.0f);

		return;
	}

	/**
	 * 亀のペンの色を応答する。
	 * @return 色のインスタンス
	 */
	public Color color()
	{
		return this.color;
	}

	/**
	 * 亀のペンの色を設定する。
	 * @param aColor 色のインスタンス
	 * @return 亀のペンの以前の色
	 */
	public Color color(Color aColor)
	{
		Color previous = this.color();
		this.color = aColor;

		return previous;
	}

	/**
	 * 亀の現在方向を応答する。
	 * @return 亀の現在方向
	 */
	public Double direction()
	{
		return this.direction;
	}

	/**
	 * 亀の方向を設定する。
	 * @param degrees 亀の方向（整数）
	 * @return 亀の以前の方向
	 */
	public Integer direction(Integer degrees)
	{
		Integer previous = this.direction().intValue();
		this.direction(degrees.doubleValue());

		return previous;
	}

	/**
	 * 亀の方向を設定する。
	 * @param degrees 亀の方向（倍精度浮動小数点数）
	 * @return 亀の以前の方向
	 */
	public Double direction(Double degrees)
	{
		Double previous = this.direction;
		this.direction = degrees % 360.0d;

		return previous;
	}

	/**
	 * 亀のペンを下げて、動いた軌跡が残るようにする。
	 */
	public void down()
	{
		this.down = true;

		return;
	}

	/**
	 * 亀の現在の位置から現在の方向へ指定された分だけ移動する。
	 * @param distance 移動量（整数）
	 */
	public void go(Integer distance)
	{
		this.go(distance.doubleValue());

		return;
	}

	/**
	 * 亀の現在の位置から現在の方向へ指定された分だけ移動する。
	 * @param distance 移動量（倍精度浮動小数点数）
	 */
	public void go(Double distance)
	{
		// 移動量から移動先の座標（最終地点）を求める。
		Double x = this.xPosition;
		Double y = this.yPosition;
		Double theta = this.direction * Turtle.RADIANS_PER_DEGREE;
		x = x + distance * Math.cos(theta);
		y = y + distance * Math.sin(theta);

		// 実際に最終地点へと移動する。
		this.move(x, y);

		return;
	}

	/**
	 * 亀の現在位置を地面の中央に配置して現在方向をX軸の正方向に設定する。
	 */
	public void home()
	{
		this.position(Ground.centerX, Ground.centerY);
		this.direction(0.0d);
		this.ground.display();

		return;
	}

	/**
	 * 亀のペンが下がっているか否かを応答する。
	 * @return ペンが下がっている場合には真、上がっている場合には偽
	 */
	public Boolean isDown()
	{
		return this.down;
	}

	/**
	 * 亀の位置を指定された座標(x,y)へ移動する。
	 * @param x 亀の移動先のx座標（整数）
	 * @param y 亀の移動先のy座標（整数）
	 */
	public void move(Integer x, Integer y)
	{
		this.move(x.doubleValue(), y.doubleValue());

		return;
	}

	/**
	 * 亀の位置を指定された座標(x,y)へ移動する。
	 * @param x 亀の移動先のx座標（倍精度浮動小数点数）
	 * @param y 亀の移動先のy座標（倍精度浮動小数点数）
	 */
	public void move(Double x, Double y)
	{
		// ペンの色とペン先の太さを設定する。
		this.pen.setColor(this.color);
		this.pen.setStroke(this.nib);

		// ペンが下がっているときだけ描く。
		if (this.down)
		{
			// 移動距離を計算して、それを歩幅で割り、何歩でゆけるかを割り出す。
			Double deltaX = this.xPosition - x;
			Double deltaY = this.yPosition - y;
			Integer step = 1;
			if (Ground.tick > 0)
			{
				Double distance = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
				step = Double.valueOf(distance / Turtle.STRIDE).intValue();
				if (step < 2) { step = 2; }
			}

			// 定数となるx軸方向の歩幅とy軸方向の歩幅を計算しておく。
			Double xStride = deltaX / Double.valueOf(step);
			Double yStride = deltaY / Double.valueOf(step);

			// 割り出した歩数だけ進む。ただし、地面のチックタック分だけ休みながら。
			// この歩数を割り出して前に進む方式は、走り幅跳びのアスリートの助走の方式である。
			// 踏切ラインで正確に跳躍するために、踏切ラインから逆にたどって歩幅調整する。
			// 歩数を記憶している変数stepは整数、したがっって、歩幅で量子化されている。
			// 移動距離を歩幅で割ってピッタリに割り切れることは稀である。
			// そのため、ほとんどの場合、歩幅調整が必要になる。
			// その歩幅調整を、踏切ラインから逆にたどって、第1歩目で行うようにする。
			// 踏切ラインが迫った直前で歩幅調整するのは理にかなわないゆえに。
			for (Integer n = step - 1; n >= 0; n--)
			{
				Double toX = x + xStride * Double.valueOf(n);
				Double toY = y + yStride * Double.valueOf(n);
				Integer xStart = this.xPosition.intValue();
				Integer yStart = this.yPosition.intValue();
				Integer xEnd = toX.intValue();
				Integer yEnd = toY.intValue();
				this.pen.drawLine(xStart, yStart, xEnd, yEnd);
				this.ground.display();

				// 1歩の歩幅の分だけ進んだことになる。
				this.xPosition = toX;
				this.yPosition = toY;

				// チックタック分だけ休む。
				if (Ground.tick > 0) { Ground.sleep(Ground.tick); }
			}
		}

		// これで目的の場所に移動したことになる。ペンが上がっていたとしても。
		this.xPosition = x;
		this.yPosition = y;

		return;
	}

	/**
	 * 亀のペンの太さを応答する。
	 * @return 亀のペンの太さ
	 */
	public Integer nib()
	{
		return Float.valueOf(this.nib.getLineWidth()).intValue();
	}

	/**
	 * 亀のペンの太さを設定する。
	 * @param anInteger ペンの太さ
	 * @return 亀のペンの以前の太さ
	 */
	public Integer nib(Integer anInteger)
	{
		Integer previous = this.nib();
		this.nib = new BasicStroke(Float.valueOf(anInteger));

		return previous;
	}

	/**
	 * 亀の現在位置と現在方向がわかるように矢印を描画する。
	 * @param theGraphics グラフィックスコンテキスト
	 */
	protected void paint(Graphics theGraphics)
	{
		Graphics2D aGraphics = (Graphics2D)theGraphics;
		Double x0, y0, x1, y1, x2, y2, x3, y3, radius, theta;

		// 現在位置を(x0,y0)とする。
		x0 = this.xPosition;
		y0 = this.yPosition;
		radius = Turtle.BODY_RADIUS;

		// 現在方向を示す矢印の先端(x1,y1)を求める。
		theta = (this.direction         ) * Turtle.RADIANS_PER_DEGREE;
		x1 = x0 + radius * Math.cos(theta);
		y1 = y0 + radius * Math.sin(theta);

		// 現在方向を示す矢印の右翼(x2,y2)を求める。
		theta = (this.direction + 128.0d) * Turtle.RADIANS_PER_DEGREE;
		x2 = x0 + radius * Math.cos(theta);
		y2 = y0 + radius * Math.sin(theta);

		// 現在方向を示す矢印の左翼(x3,y3)を求める。
		theta = (this.direction - 128.0d) * Turtle.RADIANS_PER_DEGREE;
		x3 = x0 + radius * Math.cos(theta);
		y3 = y0 + radius * Math.sin(theta);

		// 亀の現在位置と現在方向がわかるように白で縁取りをして黒の矢印を描く。
		for (Integer index = 0; index < 2; index++)
		{
			if (index == 0)
			{
				aGraphics.setColor(Color.white);
				aGraphics.setStroke(new BasicStroke(2.7f));
			}
			else
			{
				aGraphics.setColor(Color.black);
				aGraphics.setStroke(new BasicStroke(0.9f));
			}

			// 始点と終点の座標を一時的に記憶する変数を定義する。
			Integer xStart, yStart, xEnd, yEnd;

			// 矢印の右翼を描く。(x1,y1)から(x2,y2)まで、(x0,y0)から(x2,y2)まで。
			xStart = x1.intValue();
			yStart = y1.intValue();
			xEnd = x2.intValue();
			yEnd = y2.intValue();
			aGraphics.drawLine(xStart, yStart, xEnd, yEnd);
			xStart = x0.intValue();
			yStart = y0.intValue();
			aGraphics.drawLine(xStart, yStart, xEnd, yEnd);

			// 矢印の左翼を描く。(x1,y1)から(x3,y3)まで、(x0,y0)から(x3,y3)まで。
			xStart = x1.intValue();
			yStart = y1.intValue();
			xEnd = x3.intValue();
			yEnd = y3.intValue();
			aGraphics.drawLine(xStart, yStart, xEnd, yEnd);
			xStart = x0.intValue();
			yStart = y0.intValue();
			aGraphics.drawLine(xStart, yStart, xEnd, yEnd);
		}

		return;
	}

	/**
	 * 亀の現在位置の座標を応答する。
	 * @return 亀の現在位置の座標（倍精度浮動小数点数の配列）
	 */
	public Double[] position()
	{
		return new Double[] {this.xPosition(), this.yPosition()};
	}

	/**
	 * 亀の現在位置の座標を設定する。
	 * @param x 亀のx座標（整数）
	 * @param y 亀のy座標（整数）
	 * @return 亀の以前の位置の座標（整数の配列）
	 */
	public Integer[] position(Integer x, Integer y)
	{
		Integer[] previous = new Integer[] {this.xPosition().intValue(), this.yPosition().intValue()};
		this.xPosition(x.doubleValue());
		this.yPosition(y.doubleValue());

		return previous;
	}

	/**
	 * 亀の現在位置の座標を設定する。
	 * @param x 亀のx座標（倍精度浮動小数点数）
	 * @param y 亀のy座標（倍精度浮動小数点数）
	 * @return 亀の以前の位置の座標（倍精度浮動小数点数の配列）
	 */
	public Double[] position(Double x, Double y)
	{
		Double[] previous = this.position();
		this.xPosition(x);
		this.xPosition(y);

		return previous;
	}

	/**
	 * 亀の現在位置に現在の色で文字列を描画する。
	 * @param aString 描画したい文字列
	 */
	public void print(String aString)
	{
		this.print(aString, this.color);

		return;
	}

	/**
	 * 亀の現在位置に指定された色で文字列を描画する。
	 * @param aString 描画したい文字列
	 * @param aColor 色のインスタンス
	 */
	public void print(String aString, Color aColor)
	{
		try
		{
			this.pen.setColor(aColor);
			this.pen.setStroke(new BasicStroke(1.0f));

			Integer x = this.xPosition.intValue();
			Integer y = this.yPosition.intValue();
			this.pen.drawString(aString, x, y);
		}
		finally
		{
			this.pen.setColor(this.color);
			this.pen.setStroke(this.nib);
		}
		this.ground.display();

		return;
	}

	/**
	 * 亀の方向を回転させる。時計回りが正の回転である。
	 * （x軸の正方向が画面の右方向、y軸の正方向が画面の下方向だから。）
	 * @param degrees 回転する度数（整数）
	 */
	public void turn(Integer degrees)
	{
		this.turn(degrees.doubleValue());

		return;
	}

	/**
	 * 亀の方向を回転させる。時計回りが正の回転である。
	 * （x軸の正方向が画面の右方向、y軸の正方向が画面の下方向だから。）
	 * @param degrees 回転する度数（倍精度浮動小数点数）
	 */
	public void turn(Double degrees)
	{
		this.direction(this.direction + degrees);

		return;
	}

	/**
	 * 亀のペンを上げて、動いた軌跡が残らないようにする。
	 */
	public void up()
	{
		this.down = false;

		return;
	}

	/**
	 * 亀の現在位置のx座標を応答する。
	 * @return 亀の現在位置のx座標
	 */
	public Double xPosition()
	{
		return this.xPosition;
	}

	/**
	 * 亀の現在位置のx座標を設定する。
	 * @param x 亀のx座標（整数）
	 * @return 亀の以前の位置のx座標
	 */
	public Integer xPosition(Integer x)
	{
		Integer previous = this.xPosition().intValue();
		this.xPosition(x.doubleValue());

		return previous;
	}

	/**
	 * 亀の現在位置のx座標を設定する。
	 * @param x 亀のx座標（倍精度浮動小数点数）
	 * @return 亀の以前の位置のx座標
	 */
	public Double xPosition(Double x)
	{
		Double previous = this.xPosition();
		this.xPosition = x;

		return previous;
	}

	/**
	 * 亀の現在位置のy座標を応答する。
	 * @return 亀の現在位置のy座標
	 */
	public Double yPosition()
	{
		return this.yPosition;
	}

	/**
	 * 亀の現在位置のy座標を設定する。
	 * @param y 亀のy座標（整数）
	 * @return 亀の以前の位置のy座標
	 */
	public Integer yPosition(Integer y)
	{
		Integer previous = this.yPosition().intValue();
		this.yPosition(y.doubleValue());

		return previous;
	}

	/**
	 * 亀の現在位置のy座標を設定する。
	 * @param y 亀のy座標（倍精度浮動小数点数）
	 * @return 亀の以前の位置のy座標
	 */
	public Double yPosition(Double y)
	{
		Double previous = this.yPosition();
		this.yPosition = y;

		return previous;
	}
	}
