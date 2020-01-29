package example;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

import java.io.File;
import java.io.IOException;

import java.lang.ProcessBuilder;

import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Date;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.imageio.ImageIO;

/**
 * 亀が歩く地面を表します。すなわち、タートルグラフィックスの（亀が描画に用いる）画板になります。
 */
@SuppressWarnings("serial")
public class Ground extends JPanel
{
	/**
	 * 地面の幅を記憶するフィールド（クラス定数）である。
	 */
	public static final Integer WIDTH = 500;

	/**
	 * 地面の高さを記憶するフィールド（クラス定数）である。
	 */
	public static final Integer HEIGHT = 500;

	/**
	 * 描画スピードを記憶するフィールド（クラス定数）である。
	 */
	public static final Integer TICK = 100;

	/**
	 * 地面の中央座標（x成分）を記憶するフィールド（クラス定数）である。
	 */
	public static final Integer centerX = Ground.WIDTH / 2;

	/**
	 * 地面の中央座標（y成分）を記憶するフィールド（クラス定数）である。
	 */
	public static final Integer centerY = Ground.HEIGHT / 2;

	/**
	 * 描画スピードを記憶するフィールド（クラス変数）である。値が小さいほど亀たちはスムーズに動く。
	 */
	public static Integer tick = Ground.TICK;

	/**
	 * 地面のシングルトン（唯一のインスタンス）を束縛するフィールド（クラス変数）である。
	 */
	private static Ground singleton = null;

	/**
	 * 亀たちが動いた軌跡を描画して記憶している画像を束縛するフィールドである。
	 */
	private BufferedImage picture = null;

	/**
	 * 上記picture画像のグラッフィクスコンテキストを束縛するフィールドである。
	 */
	private Graphics2D pen = null;

	/**
	 * 亀たちを束縛するフィールドである。
	 */
	private ArrayList<Turtle> turtles = null;

	/**
	 * 地面のコンストラクタである。
	 * ただし、地面はシングルトン（唯一のインスタンス）なので、privateで宣言で、他からnewできないようにしている。
	 * 地面の唯一のインスタンス（シングルトン）を得たい場合には「Ground.singleton()」とすること。
	 */
	private Ground()
	{
		// 亀たちが動いた軌跡を描画して記憶する画像を作り、初期化（きれいに）する。
		this.picture = new BufferedImage(Ground.WIDTH, Ground.HEIGHT, BufferedImage.TYPE_INT_RGB);
		this.clear();

		// ウィンドウを作り、メニューバーを登録し、地面をパネルとして加える。
		JFrame aFrame = new JFrame("タートルグラフィックス");
		JMenuBar aMenuBar = this.menuBar();
		aFrame.setJMenuBar(aMenuBar);
		aFrame.getContentPane().add(this);

		// ウィンドウのタイトルバーとメニューバーの高さを算出して、ウィンドウの大きさを決める。
		aFrame.addNotify(); // コンポーネントのサイズを決めるように促す。
		aFrame.pack(); // それらのサイズによりフレーム内の配置を決めるように促す。
		Integer topOffset = aFrame.getInsets().top + aMenuBar.getHeight();
		aFrame.setSize(Ground.WIDTH, Ground.HEIGHT + topOffset);

		// ウィンドウの各種設定を行って、ウィンドウを開く。
		aFrame.setResizable(false);
		aFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		aFrame.setLocation(100, 100);
		aFrame.setVisible(true);
		aFrame.setAlwaysOnTop(true);
		// aFrame.toFront();

		return;
	}

	/**
	 * 地面に亀を増やす。
	 * @param aTurtle 亀のインスタンス
	 */
	public void addTurtle(Turtle aTurtle)
	{
		this.turtles.add(aTurtle);

		return;
	}

	/**
	 * 地面にクリア（きれいに）する。
	 */
	public void clear()
	{
		Color aColor = new Color(234, 234, 234); // very light gray
		this.clear(aColor);

		return;
	}

	/**
	 * 色を指定して地面にクリア（きれいに）する。
	 * @param aColor 色のインスタンス
	 */
	public void clear(Color aColor)
	{
		// 地面をきれいにする。
		this.pen().setColor(aColor);
		this.pen().fillRect(0, 0, Ground.WIDTH, Ground.HEIGHT);

		// 亀たちを皆無にする。
		this.turtles = new ArrayList<Turtle>();

		// きれいな地面を描画する。
		this.display();

		return;
	}

	/**
	 * 地面を描画する。
	 */
	public void display()
	{
		this.repaint(0, 0, this.getWidth(), this.getHeight());
		// this.paint(this.getGraphics());
		// this.update(this.getGraphics());

		return;
	}

	/**
	 * メニューバーを作成して応答する。
	 * @return メニューバーのインスタンス
	 */
	private JMenuBar menuBar()
	{
		// メニューバーを作成する。
		JMenuBar aMenuBar = new JMenuBar();

		// メニューバーに加えるプルダウンメニューとリスナーを束縛する一時変数である。
		JMenu aMenu = null;
		ActionListener aListener = null;

		// "ファイル"プルダウンメニューを作成してメニューバーに加える。
		aMenu = new JMenu("ファイル");
		aListener = new ActionListener()
		{
			public void actionPerformed(ActionEvent anEvent)
			{
				try
				{
					String aCommand = anEvent.getActionCommand();
					if (aCommand.equals("保存"))
					{
						Ground.save();
					}
					if (aCommand.equals("終了"))
					{
						System.exit(0);
					}
				}
				catch (ConcurrentModificationException anException) { ; }
				return;
			}
		};
		aMenu.add("保存").addActionListener(aListener);
		aMenu.add("終了").addActionListener(aListener);
		aMenuBar.add(aMenu);

		// "スピード"プルダウンメニューを作成してメニューバーに加える。
		aMenu = new JMenu("スピード");
		aListener = new ActionListener()
		{
			public void actionPerformed(ActionEvent anEvent)
			{
				try
				{
					String aCommand = anEvent.getActionCommand();
					if (aCommand.equals("ちょぉー速い"))
					{
						Ground.tick = 0;
					}
					if (aCommand.equals("とても速い"))
					{
						Ground.tick = Ground.TICK / 50;
					}
					if (aCommand.equals("速い"))
					{
						Ground.tick = Ground.TICK / 10;
					}
					if (aCommand.equals("遅い"))
					{
						Ground.tick = Ground.TICK;
					}
				}
				catch (ConcurrentModificationException anException) { ; }
				return;
			}
		};
		aMenu.add("遅い").addActionListener(aListener);
		aMenu.add("速い").addActionListener(aListener);
		aMenu.add("とても速い").addActionListener(aListener);
		aMenu.add("ちょぉー速い").addActionListener(aListener);
		aMenuBar.add(aMenu);

		return aMenuBar;
	}

	/**
	 * 地面を描画する。すなわち、亀たちが動いた軌跡と亀たちの現在位置を描画する。
	 * @param aGraphics グラフィックスコンテキスト
	 */
	protected void paintComponent(Graphics aGraphics)
	{
		try
		{
			// まずスーパークラスのメソッドを実行する。
			super.paintComponent(aGraphics);

			// 亀たちが動いた軌跡を描画して記憶している画像を描画する。
			aGraphics.drawImage(this.picture, 0, 0, null);

			// 亀たちの現在位置を描画する。
			Iterator<Turtle> anIterator = this.turtles.iterator();
			while (anIterator.hasNext())
			{
				Turtle aTurtle = anIterator.next();
				aTurtle.paint(aGraphics);
			}
		}
		catch (ConcurrentModificationException anException) { ; }

		return;
	}

	/**
	 * 地面を画板に見立てたときのグラフィックスコンテキストを応答する。
	 * @return グラフィックスコンテキスト
	 */
	protected Graphics2D pen()
	{
		if (this.pen == null)
		{
			this.pen = this.picture.createGraphics();
		}

		return this.pen;
	}

	/**
	 * 地面（画板）に亀が描いている現在の軌跡を画像としてファイル（TurtleGraphics_yyyyMMddHHmmss.png）に書き込む。
	 */
	public static void save()
	{
		BufferedImage anImage = Ground.singleton.picture;

		// メモリ内に読み込んだ画像を保存するローカルなファイル名（fileString）を求める。
		String currentDirectory = System.getProperty("user.dir");
		String imageDirectory = currentDirectory + File.separator + "ImagesOfTurtleGraphics";
		File aDirectory = new File(imageDirectory);
		if (!aDirectory.exists()) { aDirectory.mkdir(); }
		String fileString = new SimpleDateFormat("yyyyMMddHHmmssSSS").format(new Date()) + ".jpg";
		fileString = imageDirectory + File.separator + fileString;
		System.out.printf("画像ファイル「%s」に保存しました。%n", fileString);

		// メモリ内に読み込んだ画像をローカルディスクのファイルに書き込む。
		File aFile = new File(fileString);
		String kindString = fileString.substring(fileString.lastIndexOf(".") + 1); // 画像ファイルの拡張子を求めます。
		try { ImageIO.write(anImage, kindString, aFile); }
		catch (IOException anException) { anException.printStackTrace(); }
		finally { Ground.sleep(100); }

		// ローカルディスクにダウンロードした画像ファイルをプレビューにかけて表示する。
		try
		{
			ProcessBuilder aProcessBuilder = new ProcessBuilder("open", "-a", "PreView", fileString);
			aProcessBuilder.start();
		}
		catch (Exception anException) { anException.printStackTrace(); }

		return;
	}

	/**
	 * 地面のシングルトン（唯一のインスタンス）を応答する。
	 * @return 地面のシングルトン（唯一のインスタンス）
	 */
	protected static Ground singleton()
	{
		if (Ground.singleton == null)
		{
			Ground.singleton = new Ground();
		}

		return Ground.singleton;
	}

	/**
	 * 指定された時間（ミリ秒）だけスリープする。
	 * @param milliseconds ミリ秒
	 */
	public static void sleep(Integer milliseconds)
	{
		try
		{
			Thread.sleep((long)milliseconds);
		}
		catch (InterruptedException anException)
		{
			anException.printStackTrace();
		}

		return;
	}
}
