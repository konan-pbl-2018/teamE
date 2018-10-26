package template.maze2D.teamE;

import framework.game2D.Map2D;
import framework.game2D.Sprite;

/**
 * ���H�Q�[���œo�ꂷ��G
 *
 * @author T.Kuno
 *
 */
public class MazeSpriteEnemy extends Sprite {

	public MazeSpriteEnemy(String imageFile) {
		super(imageFile);
	}

	public void motion(long interval, Map2D mazeGround) {

		setVelocity(0.0,4.5);

		super.motion(interval, mazeGround);;
	}

}