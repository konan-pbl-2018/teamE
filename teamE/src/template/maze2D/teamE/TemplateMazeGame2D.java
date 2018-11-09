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

	// ���x�ɂ���ĕ��̂������Ă��鎞�Ƀ{�^���������邩�ǂ����𔻒肷��t���O
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
		// ���H�Q�[���X�e�[�W���\������I�u�W�F�N�g�̈ʒu�ƃv���C���[�̈ʒu�����Ƃɑ��x��0�ɂ��邩�ǂ����𒲂ׂ�B
		Position2D gridPoint = mazeGround.getNeighborGridPoint(mazeSpritePlayer);
		Position2D gridPointEB = mazeGround.getNeighborGridPoint(mazeSpriteEnemyB);

		// ���x��0�ɂ���t���O�������Ă���΁A���x��0�ɂ���
		if (gridPoint != null) {
			mazeSpritePlayer.setPosition(gridPoint);
			mazeSpritePlayer.setVelocity(0.0, 0.0);
			disableControl = false;
		}
	
		// �L�������ړ����Ă��Ȃ���΁A�L�[����̏������s����B
		if(!disableControl){
			// �L�[����̏���
			// ��
			if (virtualController.isKeyDown(0, RWTVirtualController.LEFT)) {
				mazeSpritePlayer.setVelocity(-4.0, 0.0);
				disableControl = true;
			}
			// �E
			else if (virtualController.isKeyDown(0, RWTVirtualController.RIGHT)) {
				mazeSpritePlayer.setVelocity(4.0, 0.0);
				disableControl = true;

			}
			// ��
			else if (virtualController.isKeyDown(0, RWTVirtualController.UP)) {
				mazeSpritePlayer.setVelocity(0.0, 4.0);
				disableControl = true;
			}
			// ��
			else if (virtualController.isKeyDown(0, RWTVirtualController.DOWN)) {
				mazeSpritePlayer.setVelocity(0.0, -4.0);
				disableControl = true;
			}
		}
		mazeSpriteEnemyB.setVelocity(0.0, 0.0);
		mazeSpritePlayer.motion(interval, mazeGround);
		mazeSpriteEnemy.motion(interval, mazeGround);
		mazeSpriteEnemyB.motion(interval, mazeGround);

		if(mazeSpritePlayer.checkCollision(mazeSpriteEnemy)) {//�G�i�Ȃ�ځ[����j�ƐڐG������
			System.out.println("�G�ƐڐG");
			mazeSpritePlayer.setPosition(2.0, 2.0);
		}


		if(mazeSpritePlayer.checkCollision(mazeSpriteEnemyB)) {//�GB�ƐڐG�����Ƃ�
		System.out.println("�G�ƐڐG");
		mazeSpritePlayer.setPosition(2.0, 2.0);
	}
		
}


	// public void progress(RWTVirtualController virtualController, long
	// interval) {
	// velocityFlg = mazeGround.checkVelocityZero(mazeSpritePlayer);
	// if (velocityFlg) {
	// mazeSpritePlayer.setVelocity(0.0, 0.0);
	// }
	// // �L�[����̏���
	// // ��
	// if (!bMove) {
	// if (virtualController.isKeyDown(0, RWTVirtualController.LEFT)) {
	// // mazeSpritePlayer.setVelocity(-2.0, 0.0);
	// mazeSpritePlayer.setPosition(mazeSpritePlayer.getPosition()
	// .getX() - 2.0, mazeSpritePlayer.getPosition().getY());
	// // ��
	// if (virtualController.isKeyDown(0, RWTVirtualController.UP)) {
	// mazeSpritePlayer.addVelocity(0.0, 2.0);
	// }
	// // ��
	// else if (virtualController.isKeyDown(0,
	// RWTVirtualController.DOWN)) {
	// mazeSpritePlayer.addVelocity(0.0, -2.0);
	// }
	// bMove = true;
	// }
	// // �E
	// else if (virtualController.isKeyDown(0, RWTVirtualController.RIGHT)) {
	// // mazeSpritePlayer.setVelocity(2.0, 0.0);
	// mazeSpritePlayer.setPosition(mazeSpritePlayer.getPosition()
	// .getX() + 2.0, mazeSpritePlayer.getPosition().getY());
	//
	// // ��
	// if (virtualController.isKeyDown(0, RWTVirtualController.UP)) {
	// mazeSpritePlayer.addVelocity(0.0, 2.0);
	// }
	// // ��
	// else if (virtualController.isKeyDown(0,
	// RWTVirtualController.DOWN)) {
	// mazeSpritePlayer.addVelocity(0.0, -2.0);
	// }
	// bMove = true;
	// }
	// // ��
	// else if (virtualController.isKeyDown(0, RWTVirtualController.UP)) {
	// // mazeSpritePlayer.setVelocity(0.0, 2.0);
	// mazeSpritePlayer.setPosition(mazeSpritePlayer.getPosition()
	// .getX(), mazeSpritePlayer.getPosition().getY() + 2.0);
	//
	// // ��
	// if (virtualController.isKeyDown(0, RWTVirtualController.LEFT)) {
	// mazeSpritePlayer.addVelocity(-2.0, 0.0);
	// }
	// // �E
	// else if (virtualController.isKeyDown(0,
	// RWTVirtualController.RIGHT)) {
	// mazeSpritePlayer.addVelocity(2.0, 0.0);
	// }
	// bMove = true;
	// }
	// // ��
	// else if (virtualController.isKeyDown(0, RWTVirtualController.DOWN)) {
	// // mazeSpritePlayer.setVelocity(0.0, -2.0);
	// mazeSpritePlayer.setPosition(mazeSpritePlayer.getPosition()
	// .getX(), mazeSpritePlayer.getPosition().getY() - 2.0);
	//
	// // ��
	// if (virtualController.isKeyDown(0, RWTVirtualController.LEFT)) {
	// mazeSpritePlayer.addVelocity(-2.0, 0.0);
	// }
	// // �E
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
	 * �Q�[���̃��C��
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		TemplateMazeGame2D game = new TemplateMazeGame2D();
		game.setFramePolicy(12, 33, false);
		game.start();
	}

}
