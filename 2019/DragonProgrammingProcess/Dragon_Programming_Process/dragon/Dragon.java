package dragon;

import com.jogamp.opengl.GL;
import com.jogamp.opengl.GL2;
import com.jogamp.opengl.glu.GLU;
import com.jogamp.opengl.util.gl2.GLUT;

import java.util.Iterator;

import java.nio.DoubleBuffer;

import utility.StringUtility;

/**
 * ドラゴンをレンダリング（描画）する。<br>
 * XYZ軸に加えてドラゴンを描画する。<br>
 * 視界（視点・注視点・上方向ベクトル・視界角・近・遠）もドラゴンが応答する。<br>
 */
public class Dragon extends Object
{
	/**
	 * 三角形群を記憶するフィールドである。<br>
	 */
	protected double[][][] triangles; // [numberOfTriangles][numberOfVertexes][numberOfDoubles]の三次元配列

	/**
	 * ドラゴンのコンストラクタである。<br>
	 * <a href="http://www.cc.kyoto-su.ac.jp/~atsushi/Programs/VisualWorks/Dragon/dragon.txt">dragon.txt</a>からデータを読み取って三角形群を生成する。
	 */
	public Dragon()
	{
		System.out.println("Dragon");

		return;
	}

	/**
	 * 視点を応答する。<br>
	 * @return 視点座標（x,y,zの配列）
	 */
	public double[] eyePoint()
	{
		return new double[] { -5.5852450791872d, 3.07847342734d, 15.794105252496d };
	}

	/**
	 * 注視点を応答する。<br>
	 * @return 注視点座標（x,y,zの配列）
	 */
	public double[] sightPoint()
	{
		return new double[] { 0.27455347776413d, 0.20096999406815d, -0.11261999607086d };
	}

	/**
	 * 上方向ベクトルを応答する。<br>
	 * @return 上方向ベクトル（x,y,zの配列）
	 */
	public double[] upVector()
	{
		return new double[] { 0.1018574904194d, 0.98480906061847d, -0.14062775604137d };
	}

	/**
	 * 視野角を応答する。<br>
	 * @return 視野角
	 */
	public double fovy()
	{
		return 12.642721790235d;
	}

	/**
	 * 近を応答する。<br>
	 * @return 近
	 */
	public double near()
	{
		return 0.01d;
	}

	/**
	 * 遠を応答する。<br>
	 * @return 遠
	 */
	public double far()
	{
		return 100.0d;
	}

	/**
	 * レンダリング（描画）する。<br>
	 * @param gl グラフィックライブラリ
	 * @param glu グラフィックライブラリユーテリティ
	 * @param glut グラフィックライブラリユーテリティツールキット
	 */
	public void rendering(GL2 gl, GLU glu, GLUT glut)
	{
		double scale = 1.0d;

		gl.glBegin(GL2.GL_LINES);

		// X軸（赤）を描画する。
		gl.glColor4d(1.0d, 0.0d, 0.0d, 1.0d);
		gl.glVertex3d(-1.000d * scale, 0.0d, 0.0d);
		gl.glVertex3d( 1.618d * scale, 0.0d, 0.0d);

		// Y軸（緑）を描画する。
		gl.glColor4d(0.0d, 1.0d, 0.0d, 1.0d);
		gl.glVertex3d(0.0d, -1.000d * scale, 0.0d);
		gl.glVertex3d(0.0d,  1.618d * scale, 0.0d);

		// Z軸（青）を描画する。
		gl.glColor4d(0.0d, 0.0d, 1.0d, 1.0d);
		gl.glVertex3d(0.0d, 0.0d, -1.000d * scale);
		gl.glVertex3d(0.0d, 0.0d,  1.618d * scale);

		gl.glEnd();

		gl.glFlush();

		return;
	}

	/**
	 * double配列をDoubleバッファに変換する。<br>
	 * @param array double配列
	 * @return doubleバッファ
	 */
	public DoubleBuffer asDoubleBuffer(double[] array)
	{
		DoubleBuffer buffer = DoubleBuffer.allocate(array.length);
		for (int i = 0; i < array.length; i++)
		{
			buffer.put(array[i]);
		}
		buffer.rewind();

		return buffer;
	}

	/**
	 * ウィンドウのタイトル（ラベル）を応答する。<br>
	 * @return タイトル文字列
	 */
	public String windowTitle()
	{
		return "Dragon";
	}
}
