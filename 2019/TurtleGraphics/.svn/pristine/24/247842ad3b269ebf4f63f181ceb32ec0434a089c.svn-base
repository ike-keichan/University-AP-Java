package example;

import java.awt.Color;

/**
 * タートルグラフィックスの課題プログラム：オリジナルは森澪希さん（2016年度2年次生）の作で、青木淳が手入れをしました。
 */
public class Planets extends Object
{
	/**
	 * 惑星のようなもの描くタートルグラフィックスを行います。
	 */
	public static void draw()
	{
		Double halfGroundWidth = Ground.WIDTH / 2.0;
		Double halfGroundHeight = Ground.HEIGHT / 2.0;

		// 地面をきれいにする。
		Ground.singleton().clear(new Color(0, 0, 0));

		// 亀の生成と設定をする。
		Turtle aTurtle = new Turtle();
		aTurtle.up();
		aTurtle.move(halfGroundWidth, halfGroundHeight);
		aTurtle.down();
		aTurtle.color(Color.white);
		aTurtle.nib(2);

		// 描画スピードを設定する。（亀の速度：描画スピードによって描画結果が異なる。）
		Ground.tick = 1;

		// 亀を動かす。
		DrawPlanet drawPlanet1 = new DrawPlanet(halfGroundWidth - 120, halfGroundHeight - 40, 30.0, new Color(100, 200, 255));
		drawPlanet1.setAtmosphereColor(new Color(50, 100, 255));
		DrawPlanet drawPlanet2 = new DrawPlanet(halfGroundWidth + 40, halfGroundHeight + 20, 140.0, new Color(190, 50, 10));
		drawPlanet2.setAtmosphereColor(new Color(230, 100, 50));
		drawPlanet1.draw(aTurtle);
		drawPlanet2.draw(aTurtle);
		aTurtle.up();
		aTurtle.move(30, Ground.HEIGHT - 30);

		return;
	}
}

/**
 * ガス惑星のようなものを描きます。
 */
class DrawPlanet extends Object
{
	/**
	 * 中心のx座標
	 */
	private Double x;

	/**
	 * 中心のy座標
	 */
	private Double y;

	/**
	 * 半径
	 */
	private Double radius;

	/**
	 * 雲の色1
	 */
	private Color color1;

	/**
	 * 雲の色2
	 */
	private Color color2;

	/**
	 * 大気の色。これに透明度を設定しても反映されない
	 */
	private Color atmosphereColor;

	/**
	 * 大気の高さ
	 */
	private Double atmosphereHeight;

	/**
	 * 大気の不透明度
	 */
	private Float atmosphereAlpha;

	//模様を決めるパラメータ
	private Double cloudParameter1;
	private Double cloudParameter2;
	private Double cloudParameter3;
	private Double cloudParameter4;
	private Double cloudParameter5;

	/**
	 * コンストラクタ
	 * @param x 中心のx座標
	 * @param y 中心のy座標
	 * @param radius 半径
	 * @param color1 基本的な色
	 */
	public DrawPlanet(Double x, Double y, Double radius, Color color1)
	{
		this.x = x;
		this.y = y;
		this.radius = Math.abs(radius);
		this.color1 = color1;
		this.color2 = Color.white;
		this.atmosphereColor = color1;
		this.atmosphereHeight = 10.0;
		this.atmosphereAlpha = 0.3f;
		this.cloudParameter1 = Math.random() * 20.0;
		this.cloudParameter2 = Math.random() * 20.0;
		this.cloudParameter3 = Math.random() * 3.0;
		this.cloudParameter4 = Math.random() * Math.PI * 2;
		this.cloudParameter5 = Math.random() * Math.PI * 2;

		return;
	}

	/**
	 * color1を設定する。
	 * @param color1 設定する色
	 */
	public void setColor1(Color color1)
	{
		this.color1 = color1;

		return;
	}

	/**
	 * color2を設定する。
	 * @param color2 設定する色
	 */
	public void setColor2(Color color2)
	{
		this.color2 = color2;

		return;
	}

	/**
	 * atmosphereColorを設定する。
	 * @param atmosphereColor 設定する色
	 */
	public void setAtmosphereColor(Color atmosphereColor)
	{
		this.atmosphereColor = atmosphereColor;

		return;
	}

	/**
	 * 惑星のようなものを描画する。
	 * @param aTurtle 描画を担当する亀
	 */
	public void draw(Turtle aTurtle)
	{
		//---輪郭---//
		aTurtle.color(this.color1);
		aTurtle.nib(2);
		DrawFigure.drawCircle(aTurtle, x, y, this.radius, 100);

		//---模様---//
		aTurtle.nib(1);
		for (Integer i=-(int)Math.floor(this.radius); i < this.radius; i++)
		{
			aTurtle.color(this.getCloudColor(i.doubleValue()));

			DrawFigure.drawLine(aTurtle,
								this.x - Math.sqrt( this.radius*this.radius - i*i ), this.y + i,
								this.x + Math.sqrt( this.radius*this.radius - i*i ), this.y + i);
		}

		//---大気---//
		aTurtle.nib(2);
		for (Integer i = (int)(Math.ceil(this.radius) + this.atmosphereHeight); i > 0; i--)
		{
			aTurtle.color(this.getAtmosphereColor(i.doubleValue()));
			DrawFigure.drawCircle(aTurtle, x, y, i.doubleValue(), i * 5);
		}

		//---陰---//
		//薄めに塗る
		aTurtle.nib(3);
		aTurtle.color(new Color(0, 0, 0, 100));
		for (Integer i = -(int)Math.floor(this.radius); i < this.radius; i++)
		{
			DrawFigure.drawLine(aTurtle,
								this.x + 0.5 * Math.sqrt(this.radius * this.radius - i * i), this.y + i,
								this.x + Math.sqrt(this.radius * this.radius - i * i), this.y + i);
		}

		//濃く塗る
		aTurtle.nib(1);
		aTurtle.color(Color.black);
		for (Integer i = -(int)Math.floor(this.radius); i < this.radius; i++)
		{
			DrawFigure.drawLine(aTurtle,
								this.x + 0.6 * Math.sqrt(this.radius * this.radius - i * i), this.y + i,
								this.x + Math.sqrt(this.radius * this.radius - i * i), this.y + i);
		}

		return;
	}

	/**
	 * 雲の色を返す。三角関数を組み合わせ雲の模様を生成
	 * @param height 中心を0としたときのy座標
	 * @return 雲の色
	 */
	private Color getCloudColor(Double height)
	{
		Double angle = Math.asin( height/this.radius );
		Double alpha = (Math.cos(angle * this.cloudParameter1 + this.cloudParameter3 * Math.sin(angle * this.cloudParameter2 + this.cloudParameter5) + this.cloudParameter4) + 1) * 0.5;

		Float r = DrawPlanet.alphaBlend(this.color2.getRed()   / 255.0, this.color1.getRed()   / 255.0, alpha).floatValue();
		Float g = DrawPlanet.alphaBlend(this.color2.getGreen() / 255.0, this.color1.getGreen() / 255.0, alpha).floatValue();
		Float b = DrawPlanet.alphaBlend(this.color2.getBlue()  / 255.0, this.color1.getBlue()  / 255.0, alpha).floatValue();

		return new Color(r, g, b);
	}

	/**
	 * 大気の色を返す。端のほうが色が濃くなるようになっている。
	 * @param distance 中心からの距離
	 * @return 大気の色
	 */
	private Color getAtmosphereColor(Double distance)
	{
		Double alpha = 0.0;
		if (distance <= this.radius)
		{
			//alpha = (Math.sqrt((this.radius + this.atmosphereHeight) * (this.radius+this.atmosphereHeight) - distance * distance) - Math.sqrt(this.radius * this.radius - distance * distance ) );
			alpha = (distance / this.radius) * (distance / this.radius) * (distance / this.radius) * (distance / this.radius);
			alpha = DrawPlanet.alphaBlend(alpha, 1.0, 0.9);
		}
		else
		{
			//alpha = 2 * (float)Math.sqrt((this.radius + this.atmosphereHeight) * (this.radius + this.atmosphereHeight) - distance * distance);
			//alpha = 2 * Math.sqrt((this.radius+this.atmosphereHeight) * (this.radius + this.atmosphereHeight) - this.radius * this.radius);
			//alpha *= (1.0 - (distance - this.radius) / this.atmosphereHeight);
			alpha = (1 - ((distance - this.radius) / this.atmosphereHeight));
			alpha = alpha*alpha*alpha;
		}
		alpha = Math.max(0.f, Math.min(1.f, alpha * this.atmosphereAlpha));
		//alpha = (1.0 - Math.exp(-alpha * this.atmosphereAlpha));

		return new Color(this.atmosphereColor.getRed()   /255.f,
						 this.atmosphereColor.getGreen() /255.f,
						 this.atmosphereColor.getBlue()  /255.f,
						 alpha.floatValue());
	}

	/**
	 * 二つの色成分とアルファ値からブレンドした色成分を応答する。
	 * @param value1 一番目の色成分
	 * @param value2 二番目の色成分
	 * @param alpha アルファ値
	 * @return ブレンドした色成分
	 */
	static Double alphaBlend(Double value1, Double value2, Double alpha)
	{
		return alpha * value1 + (1 - alpha) * value2;
	}
}

/**
 * 図形を描きます。
 */
class DrawFigure extends Object
{
	/**
	 * 円を描く。
	 * @param aTurtle 描画を担当する亀
	 * @param x 円の中心のx座標
	 * @param y 円の中心のy座標
	 * @param radius 円の半径
	 * @param numberOfPoint 精度
	 */
	static void drawCircle(Turtle aTurtle, Double x, Double y, Double radius, Integer numberOfPoint)
	{
		aTurtle.up();
		aTurtle.move(x + radius, y);
		aTurtle.down();
		for (Integer i = 1; i <= numberOfPoint; i++)
		{
			Double angle = 2 * i * Math.PI / numberOfPoint;
			aTurtle.move(x + radius * Math.cos(angle), y + radius * Math.sin(angle));
		}

		return;
	}

	/**
	 * 線を引く。
	 * @param aTurtle 描画を担当する亀
	 * @param x1 始点のx座標
	 * @param y1 始点のy座標
	 * @param x2 終点のx座標
	 * @param y2 終点のy座標
	 */
	static void drawLine(Turtle aTurtle, Double x1, Double y1, Double x2, Double y2)
	{
		aTurtle.up();
		aTurtle.move(x1, y1);
		aTurtle.down();
		aTurtle.move(x2, y2);

		return;
	}
}
