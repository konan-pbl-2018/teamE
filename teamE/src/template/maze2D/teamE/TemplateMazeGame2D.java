package template.maze2D.teamE;

import framework.RWT.RWTFrame3D;
import framework.RWT.RWTVirtualController;
import framework.game2D.Position2D;
import framework.gameMain.SimpleMazeGame;
import framework.model3D.Universe;

public class TemplateMazeGame2D extends SimpleMazeGame {
	private MazeSpritePlayer mazeSpritePlayer;
	private MazeStage mazeGround;
	private MazeSpriteEnemy mazeSpriteEnemy;
	private MazeSpriteEnemyB mazeSpriteEnemyB;

	// 速度によって物体が動いている時にボタンを押せるかどうかを判定するフラグ
	private boolean disableControl = false;

	private long lastTime;

	@Override
	public void init(Universe universe) {
		mazeGround = new MazeStage("data\\images\\E_images\\block.png", "data\\images\\E_images\\midori.png");
		universe.place(mazeGround);
		camera.addTarget(mazeGround);

		mazeSpritePlayer = new MazeSpritePlayer("data\\images\\E_images\\character\\pacman_yellow.gif");
		mazeSpritePlayer.setPosition(6.0, 2.0);
		mazeSpritePlayer.setCollisionRadius(0.5);
		universe.place(mazeSpritePlayer);

		mazeSpriteEnemy= new MazeSpriteEnemy("data\\images\\E_images\\character\\nambo.gif");
		mazeSpriteEnemy.setPosition(6.0,6.0);
		mazeSpriteEnemy.setCollisionRadius(0.5);
		universe.place(mazeSpriteEnemy);

		mazeSpriteEnemyB= new MazeSpriteEnemyB("data\\images\\E_images\\character\\pacman_teki.png");
		mazeSpriteEnemyB.setPosition(4.0,2.0);
		mazeSpriteEnemyB.setCollisionRadius(0.5);
		universe.place(mazeSpriteEnemyB);

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

		if(mazeSpritePlayer.checkCollision(mazeSpriteEnemy)) {//敵（なんぼーくん）と接触した時
			System.out.println("敵と接触");
			mazeSpritePlayer.setPosition(2.0, 2.0);
		}


		if(mazeSpritePlayer.checkCollision(mazeSpriteEnemyB)) {//敵Bと接触したとき
		System.out.println("敵と接触");
		mazeSpritePlayer.setPosition(2.0, 2.0);
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
