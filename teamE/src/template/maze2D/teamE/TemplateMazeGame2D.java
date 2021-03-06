
package template.maze2D.teamE;

import framework.RWT.RWTContainer;
import framework.RWT.RWTFrame3D;
import framework.RWT.RWTVirtualController;
import framework.audio.BGM3D;
import framework.audio.Sound3D;
import framework.game2D.Position2D;
import framework.game2D.Sprite;
import framework.gameMain.IGameState;
import framework.gameMain.SimpleMazeGame;
import framework.model3D.Universe;
import template.shooting2D.EndingContainer;
import template.shooting2D.StartGAMEN;

public class TemplateMazeGame2D extends SimpleMazeGame {
	private MazeSpritePlayer mazeSpritePlayer;
	private MazeStage mazeGround;
	private MazeSpriteEnemy mazeSpriteEnemy;
	private MazeSpriteEnemyB mazeSpriteEnemyB;
	private EnemyD EnemyD;
	private EnemyC EnemyC;
	private EnemyE EnemyE;
	private MazeSpriteItem mazeSpriteItem;
	private MazeSpriteItem2 mazeSpriteItem2;
	private MazeSpriteItem3 mazeSpriteItem3;
	private MazeSpriteItem4 mazeSpriteItem4;
	private MazeSpriteItem5 mazeSpriteItem5;
	private MazeSpriteItem6 mazeSpriteItem6;

	private Pacman1 pacman1;
	private Pacman2 pacman2;
	private Pacman3 pacman3;
	private Pacman4 pacman4;
	private Pacman5 pacman5;
	private Pacman6 pacman6;



	private Sound3D gameBGM = BGM3D.registerBGM("data\\Music\\BGM\\BGM1.wav");
	// 速度によって物体が動いている時にボタンを押せるかどうかを判定するフラグ
	private boolean disableControl = false;

	int score=0;
	int hp=6;
	int debg=0;
	Sprite cleargamen;
	private long lastTime;
	private IGameState initialGameState = null;
	private IGameState finalGameState = null;

	public TemplateMazeGame2D() {
		super();
		initialGameState = new IGameState() {
			@Override
			public void init(RWTFrame3D frame) {
				TemplateMazeGame2D.this.frame = frame;
				RWTContainer container = new StartGAMEN(TemplateMazeGame2D.this);
				changeContainer(container);
			}
			@Override
			public boolean useTimer() {
				return false;
			}
			@Override
			public void update(RWTVirtualController virtualController, long interval) {
			}
		};
		finalGameState = new IGameState() {
			@Override
			public void init(RWTFrame3D frame) {
				TemplateMazeGame2D.this.frame = frame;
				RWTContainer container = new EndingContainer(TemplateMazeGame2D.this);
				changeContainer(container);
			}
			@Override
			public boolean useTimer() {
				return false;
			}
			@Override
			public void update(RWTVirtualController virtualController, long interval) {
			}
		};
		setCurrentGameState(initialGameState);
	}
	public void restart() {
		stop();
		setCurrentGameState(initialGameState);
		start();
	}

	public void play() {
		stop();
		setCurrentGameState(this);
		start();
	}

	public void ending() {
		stop();
		setCurrentGameState(finalGameState);
		start();
	}
	@Override
	public void init(Universe universe) {
		BGM3D.playBGM(gameBGM);
		mazeGround = new MazeStage("data\\images\\E_images\\block.png", "data\\images\\E_images\\midori.png");
		universe.place(mazeGround);
		camera.addTarget(mazeGround);

		mazeSpritePlayer = new MazeSpritePlayer("data\\images\\E_images\\character\\pacman_yellow.gif");
		mazeSpritePlayer.setPosition(2.0, 2.0);
		mazeSpritePlayer.setCollisionRadius(0.5);
		universe.place(mazeSpritePlayer);

		mazeSpriteEnemy= new MazeSpriteEnemy("data\\images\\E_images\\character\\nambo.gif");
		mazeSpriteEnemy.setPosition(32.0,32.0);
		mazeSpriteEnemy.setCollisionRadius(0.5);
		universe.place(mazeSpriteEnemy);

		mazeSpriteEnemyB= new MazeSpriteEnemyB("data\\images\\E_images\\character\\nambo.gif");
		mazeSpriteEnemyB.setPosition(26.0,46.0);
		mazeSpriteEnemyB.setCollisionRadius(0.5);
		universe.place(mazeSpriteEnemyB);

		EnemyD= new EnemyD("data\\images\\E_images\\character\\nambo.gif");
		EnemyD.setPosition(8.0,16.0);
		EnemyD.setCollisionRadius(0.5);
		universe.place(EnemyD);


		EnemyC= new EnemyC("data\\images\\E_images\\character\\nambo.gif");
		EnemyC.setPosition(34.0,15.0);
		EnemyC.setCollisionRadius(0.5);
		universe.place(EnemyC);


		EnemyE= new EnemyE("data\\images\\E_images\\character\\nambo.gif");
		EnemyE.setPosition(4.0,34.0);
		EnemyE.setCollisionRadius(0.5);
		universe.place(EnemyE);

		mazeSpriteItem= new MazeSpriteItem("data\\images\\E_images\\item\\ball_blue_big.gif");
		mazeSpriteItem.setPosition(38.0,44.0);
		mazeSpriteItem.setCollisionRadius(0.5);
		universe.place(mazeSpriteItem);

		mazeSpriteItem2= new MazeSpriteItem2("data\\images\\E_images\\item\\ball_blue_big.gif");
		mazeSpriteItem2.setPosition(6.0,42.0);
		mazeSpriteItem2.setCollisionRadius(0.5);
		universe.place(mazeSpriteItem2);

		mazeSpriteItem3= new MazeSpriteItem3("data\\images\\E_images\\item\\ball_blue_big.gif");
		mazeSpriteItem3.setPosition(42.0,4.0);
		mazeSpriteItem3.setCollisionRadius(0.5);
		universe.place(mazeSpriteItem3);

		mazeSpriteItem4= new MazeSpriteItem4("data\\images\\E_images\\item\\ball_blue_big.gif");
		mazeSpriteItem4.setPosition(30.0,30.0);
		mazeSpriteItem4.setCollisionRadius(0.5);
		universe.place(mazeSpriteItem4);

		mazeSpriteItem5= new MazeSpriteItem5("data\\images\\E_images\\item\\ball_blue_big.gif");
		mazeSpriteItem5.setPosition(34.0,18.0);
		mazeSpriteItem5.setCollisionRadius(0.5);
		universe.place(mazeSpriteItem5);

		mazeSpriteItem6= new MazeSpriteItem6("data\\images\\E_images\\item\\ball_blue_big.gif");
		mazeSpriteItem6.setPosition(6.0,12.0);
		mazeSpriteItem6.setCollisionRadius(0.5);
		universe.place(mazeSpriteItem6);



		pacman1 = new Pacman1("data\\images\\E_images\\character\\pacman_yellow.gif");
		pacman1.setPosition(18.0,20.0);
		pacman1.setCollisionRadius(0.5);
		universe.place(pacman1);

		pacman2 = new Pacman2("data\\images\\E_images\\character\\pacman_yellow.gif");
		pacman2.setPosition(20.0,20.0);
		pacman2.setCollisionRadius(0.5);
		universe.place(pacman2);

		pacman3 = new Pacman3("data\\images\\E_images\\character\\pacman_yellow.gif");
		pacman3.setPosition(22.0,20.0);
		pacman3.setCollisionRadius(0.5);
		universe.place(pacman3);

		pacman4 = new Pacman4("data\\images\\E_images\\character\\pacman_yellow.gif");
		pacman4.setPosition(24.0,20.0);
		pacman4.setCollisionRadius(0.5);
		universe.place(pacman4);

		pacman5 = new Pacman5("data\\images\\E_images\\character\\pacman_yellow.gif");
		pacman5.setPosition(26.0,20.0);
		pacman5.setCollisionRadius(0.5);
		universe.place(pacman5);

		pacman6 = new Pacman6("data\\images\\E_images\\character\\pacman_yellow.gif");
		pacman6.setPosition(28.0,20.0);
		pacman6.setCollisionRadius(0.5);
		universe.place(pacman6);


		setViewRange(65, 65);
		}



	@Override
	public void progress(RWTVirtualController virtualController, long interval) {
		// 迷路ゲームステージを構成するオブジェクトの位置とプレイヤーの位置をもとに速度を0にするかどうかを調べる。
		Position2D gridPoint = mazeGround.getNeighborGridPoint(mazeSpritePlayer);
		Position2D gridPointEB = mazeGround.getNeighborGridPoint(mazeSpriteEnemyB);

		// 速度が0にするフラグが立っていれば、速度を0にする
		if (gridPoint != null) {
			mazeSpritePlayer.setPosition(gridPoint);
			mazeSpritePlayer.setVelocity(0.0, 0.0);
			disableControl = false;
		}

		// キャラが移動していなければ、キー操作の処理を行える。
		if(!disableControl){
			// キー操作の処理
			// 左
			if (virtualController.isKeyDown(0, RWTVirtualController.LEFT)) {
				mazeSpritePlayer.setVelocity(-4.0, 0.0);
				disableControl = true;
			}
			// 右
			else if (virtualController.isKeyDown(0, RWTVirtualController.RIGHT)) {
				mazeSpritePlayer.setVelocity(4.0, 0.0);
				disableControl = true;

			}
			// 上
			else if (virtualController.isKeyDown(0, RWTVirtualController.UP)) {
				mazeSpritePlayer.setVelocity(0.0, 4.0);
				disableControl = true;
			}
			// 下
			else if (virtualController.isKeyDown(0, RWTVirtualController.DOWN)) {
				mazeSpritePlayer.setVelocity(0.0, -4.0);
				disableControl = true;
			}
		}
		mazeSpriteEnemyB.setVelocity(0.0, 0.0);
		mazeSpritePlayer.motion(interval, mazeGround);
		mazeSpriteEnemy.motion(interval, mazeGround);
		mazeSpriteEnemyB.motion(interval, mazeGround);
		EnemyD.motion(interval, mazeGround);
		EnemyC.motion(interval, mazeGround);
		EnemyE.motion(interval, mazeGround);

		if(debg==0) {
			if(mazeSpritePlayer.checkCollision(mazeSpriteEnemy)) {//敵（なんぼーくん）と接触した時
				//	System.out.println("敵と接触");
				mazeSpriteEnemy.setPosition(32.0,32.0);
				mazeSpritePlayer.setPosition(2.0, 2.0);
				hp--;
				System.out.println(hp);
			}


			if(mazeSpritePlayer.checkCollision(mazeSpriteEnemyB)) {//敵Bと接触したとき
				//	System.out.println("敵と接触");
				mazeSpritePlayer.setPosition(2.0, 2.0);
				hp--;
				System.out.println(hp);
			}
			if(mazeSpritePlayer.checkCollision(EnemyD)) {//敵Bと接触したとき
				System.out.println("敵と接触 ");
				EnemyD.setPosition(8.0,16.0);
				hp--;
				System.out.println(hp);
				mazeSpritePlayer.setPosition(2.0, 2.0);
			}

			if(mazeSpritePlayer.checkCollision(EnemyC)) {//敵Bと接触したとき
				System.out.println("敵と接触");
				hp--;
				mazeSpritePlayer.setPosition(2.0, 2.0);
				System.out.println(hp);
			}

			if(mazeSpritePlayer.checkCollision(EnemyE)) {//敵Bと接触したとき
				System.out.println("敵と接触");
				hp--;
				mazeSpritePlayer.setPosition(2.0, 2.0);
				System.out.println(hp);
			}
		}

		if(mazeSpritePlayer.checkCollision(mazeSpriteItem)) {//itemと接触したとき
			mazeSpriteItem.setPosition(22.0,22.0);
			score ++;
			System.out.println("ポイント獲得");
			System.out.println(score);
	//	System.out.println("アイテム獲得");

	}
		if(mazeSpritePlayer.checkCollision(mazeSpriteItem2)) {//itemと接触したとき
			//universe.displace(mazeSpriteItem2);
			mazeSpriteItem2.setPosition(28.0,22.0);
			score ++;
			System.out.println("ポイント獲得");
			System.out.println(score);
	//	System.out.println("アイテム獲得");

	}
		if(mazeSpritePlayer.checkCollision(mazeSpriteItem3)) {//itemと接触したとき
			//universe.displace(mazeSpriteItem3);
			mazeSpriteItem3.setPosition(26.0,22.0);
			score ++;
			System.out.println("ポイント獲得");
			System.out.println(score);
	//	System.out.println("アイテム獲得");

	}
		if(mazeSpritePlayer.checkCollision(mazeSpriteItem4)) {//itemと接触したとき
			//universe.displace(mazeSpriteItem4);
			mazeSpriteItem4.setPosition(24.0,22.0);
			score ++;
			System.out.println("ポイント獲得");
			System.out.println(score);
	//	System.out.println("アイテム獲得");

	}
		if(mazeSpritePlayer.checkCollision(mazeSpriteItem5)) {//itemと接触したとき
			//universe.displace(mazeSpriteItem5);
			mazeSpriteItem5.setPosition(20.0,22.0);
			score ++;
			System.out.println("ポイント獲得");
			System.out.println(score);
	//	System.out.println("アイテム獲得");

	}
		if(mazeSpritePlayer.checkCollision(mazeSpriteItem6)) {//itemと接触したとき
			mazeSpriteItem6.setPosition(18.0,22.0);
			score ++;
			System.out.println("ポイント獲得");
			System.out.println(score);
	//	System.out.println("アイテム獲得");

	}
		if(score==3) {
			cleargamen = new Sprite("data\\images\\E_images\\screen\\CREARgamen2.png", 30.0f);
			cleargamen.setPosition(24.0,24.0);
			universe.place(cleargamen);
			score++;
		}

			if(hp==5) {
				universe.displace(pacman6);
			}

			if(hp==4) {
				universe.displace(pacman5);
			}

			if(hp==3) {
				universe.displace(pacman4);
			}

			if(hp==2) {
				universe.displace(pacman3);

			}

			if(hp==1) {
				universe.displace(pacman2);
			}

			if(hp==0) {
				universe.displace(pacman1);
			}
}





	// public void progress(RWTVirtualController virtualController, long
	// interval) {
	// velocityFlg = mazeGround.checkVelocityZero(mazeSpritePlayer);
	// if (velocityFlg) {
	// mazeSpritePlayer.setVelocity(0.0, 0.0);
	// }
	// // キー操作の処理
	// // 左
	// if (!bMove) {
	// if (virtualController.isKeyDown(0, RWTVirtualController.LEFT)) {
	// // mazeSpritePlayer.setVelocity(-2.0, 0.0);
	// mazeSpritePlayer.setPosition(mazeSpritePlayer.getPosition()
	// .getX() - 2.0, mazeSpritePlayer.getPosition().getY());
	// // 上
	// if (virtualController.isKeyDown(0, RWTVirtualController.UP)) {
	// mazeSpritePlayer.addVelocity(0.0, 2.0);
	// }
	// // 下
	// else if (virtualController.isKeyDown(0,
	// RWTVirtualController.DOWN)) {
	// mazeSpritePlayer.addVelocity(0.0, -2.0);
	// }
	// bMove = true;
	// }
	// // 右
	// else if (virtualController.isKeyDown(0, RWTVirtualController.RIGHT)) {
	// // mazeSpritePlayer.setVelocity(2.0, 0.0);
	// mazeSpritePlayer.setPosition(mazeSpritePlayer.getPosition()
	// .getX() + 2.0, mazeSpritePlayer.getPosition().getY());
	//
	// // 上
	// if (virtualController.isKeyDown(0, RWTVirtualController.UP)) {
	// mazeSpritePlayer.addVelocity(0.0, 2.0);
	// }
	// // 下
	// else if (virtualController.isKeyDown(0,
	// RWTVirtualController.DOWN)) {
	// mazeSpritePlayer.addVelocity(0.0, -2.0);
	// }
	// bMove = true;
	// }
	// // 上
	// else if (virtualController.isKeyDown(0, RWTVirtualController.UP)) {
	// // mazeSpritePlayer.setVelocity(0.0, 2.0);
	// mazeSpritePlayer.setPosition(mazeSpritePlayer.getPosition()
	// .getX(), mazeSpritePlayer.getPosition().getY() + 2.0);
	//
	// // 左
	// if (virtualController.isKeyDown(0, RWTVirtualController.LEFT)) {
	// mazeSpritePlayer.addVelocity(-2.0, 0.0);
	// }
	// // 右
	// else if (virtualController.isKeyDown(0,
	// RWTVirtualController.RIGHT)) {
	// mazeSpritePlayer.addVelocity(2.0, 0.0);
	// }
	// bMove = true;
	// }
	// // 下
	// else if (virtualController.isKeyDown(0, RWTVirtualController.DOWN)) {
	// // mazeSpritePlayer.setVelocity(0.0, -2.0);
	// mazeSpritePlayer.setPosition(mazeSpritePlayer.getPosition()
	// .getX(), mazeSpritePlayer.getPosition().getY() - 2.0);
	//
	// // 左
	// if (virtualController.isKeyDown(0, RWTVirtualController.LEFT)) {
	// mazeSpritePlayer.addVelocity(-2.0, 0.0);
	// }
	// // 右
	// else if (virtualController.isKeyDown(0,
	// RWTVirtualController.RIGHT)) {
	// mazeSpritePlayer.addVelocity(2.0, 0.0);
	// }
	// bMove = true;
	// }
	// lastTime = System.currentTimeMillis();
	// }
	//
	// if (System.currentTimeMillis() - lastTime > 250) {
	// bMove = false;
	// }
	// mazeSpritePlayer.motion(interval, mazeGround);
	// }

	@Override
	public RWTFrame3D createFrame3D() {
		RWTFrame3D f = new RWTFrame3D();
		f.setSize(1200, 1200);
		f.setTitle("Template for Mage 2DGame");
		return f;
	}

	/**
	 * ゲームのメイン
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		TemplateMazeGame2D game = new TemplateMazeGame2D();
		game.setFramePolicy(12, 33, false);
		game.start();
	}

}
