package template.maze2D.teamE;

import framework.RWT.RWTFrame3D;
import framework.RWT.RWTVirtualController;
import framework.audio.BGM3D;
import framework.audio.Sound3D;
import framework.game2D.Position2D;
import framework.gameMain.SimpleMazeGame;
import framework.model3D.Universe;

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


	private Sound3D gameBGM = BGM3D.registerBGM("data\\Music\\BGM\\BGM1.wav");
	// 速度によって物体が動いている時にボタンを押せるかどうかを判定するフラグ
	private boolean disableControl = false;


	private long lastTime;

	@Override
	public void init(Universe universe) {
		BGM3D.playBGM(gameBGM);
		mazeGround = new MazeStage("data\\images\\E_images\\block.png", "data\\images\\E_images\\midori.png");
		universe.place(mazeGround);
		camera.addTarget(mazeGround);

		mazeSpritePlayer = new MazeSpritePlayer("data\\images\\E_images\\character\\pacman_yellow.gif");
		mazeSpritePlayer.setPosition(6.0, 2.0);
		mazeSpritePlayer.setCollisionRadius(0.5);
		universe.place(mazeSpritePlayer);

		mazeSpriteEnemy= new MazeSpriteEnemy("data\\images\\E_images\\character\\nambo.gif");
		mazeSpriteEnemy.setPosition(8.0,14.0);
		mazeSpriteEnemy.setCollisionRadius(0.5);
		universe.place(mazeSpriteEnemy);

		mazeSpriteEnemyB= new MazeSpriteEnemyB("data\\images\\E_images\\character\\pacman_teki.png");
		mazeSpriteEnemyB.setPosition(4.0,2.0);
		mazeSpriteEnemyB.setCollisionRadius(0.5);
		universe.place(mazeSpriteEnemyB);

		EnemyD= new EnemyD("data\\images\\E_images\\character\\pacman_teki.png");
		EnemyD.setPosition(20.0,2.0);
		EnemyD.setCollisionRadius(0.5);
		universe.place(EnemyD);


		EnemyC= new EnemyC("data\\images\\E_images\\character\\pacman_teki.png");
		EnemyC.setPosition(4.0,15.0);
		EnemyC.setCollisionRadius(0.5);
		universe.place(EnemyC);


		EnemyE= new EnemyE("data\\images\\E_images\\character\\pacman_teki.png");
		EnemyE.setPosition(15.0,15.0);
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



		setViewRange(65, 65);	}
	int score=0;


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
		if(mazeSpritePlayer.checkCollision(mazeSpriteEnemy)) {//敵（なんぼーくん）と接触した時
		//	System.out.println("敵と接触");
			mazeSpritePlayer.setPosition(2.0, 2.0);
		}


		if(mazeSpritePlayer.checkCollision(mazeSpriteEnemyB)) {//敵Bと接触したとき
	//	System.out.println("敵と接触");
		mazeSpritePlayer.setPosition(2.0, 2.0);
	}
		if(mazeSpritePlayer.checkCollision(EnemyD)) {//敵Bと接触したとき
			System.out.println("敵と接触");
			mazeSpritePlayer.setPosition(2.0, 2.0);
		}

		if(mazeSpritePlayer.checkCollision(EnemyC)) {//敵Bと接触したとき
			System.out.println("敵と接触");
			mazeSpritePlayer.setPosition(2.0, 2.0);
		}

		if(mazeSpritePlayer.checkCollision(EnemyE)) {//敵Bと接触したとき
			System.out.println("敵と接触");
			mazeSpritePlayer.setPosition(2.0, 2.0);
		}

		if(mazeSpritePlayer.checkCollision(mazeSpriteItem)) {//itemと接触したとき
			universe.displace(mazeSpriteItem);
			score ++;
			System.out.println("ポイント獲得");
			System.out.println(score);
	//	System.out.println("アイテム獲得");

	}
		if(mazeSpritePlayer.checkCollision(mazeSpriteItem2)) {//itemと接触したとき
			universe.displace(mazeSpriteItem2);
			score ++;
			System.out.println("ポイント獲得");
			System.out.println(score);
	//	System.out.println("アイテム獲得");

	}
		if(mazeSpritePlayer.checkCollision(mazeSpriteItem3)) {//itemと接触したとき
			universe.displace(mazeSpriteItem3);
			score ++;
			System.out.println("ポイント獲得");
			System.out.println(score);
	//	System.out.println("アイテム獲得");

	}
		if(mazeSpritePlayer.checkCollision(mazeSpriteItem4)) {//itemと接触したとき
			universe.displace(mazeSpriteItem4);
			score ++;
			System.out.println("ポイント獲得");
			System.out.println(score);
	//	System.out.println("アイテム獲得");

	}
		if(mazeSpritePlayer.checkCollision(mazeSpriteItem5)) {//itemと接触したとき
			universe.displace(mazeSpriteItem5);
			score ++;
			System.out.println("ポイント獲得");
			System.out.println(score);
	//	System.out.println("アイテム獲得");

	}
		if(mazeSpritePlayer.checkCollision(mazeSpriteItem6)) {//itemと接触したとき
			universe.displace(mazeSpriteItem6);
			score ++;
			System.out.println("ポイント獲得");
			System.out.println(score);
	//	System.out.println("アイテム獲得");

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
