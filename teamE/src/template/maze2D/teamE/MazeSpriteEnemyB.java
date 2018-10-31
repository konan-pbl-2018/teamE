package template.maze2D.teamE;

import framework.game2D.Map2D;
import framework.game2D.Sprite;


/**
 * ���H�Q�[���œo�ꂷ��G
 *
 * @author T.Kuno
 *
 */
public class MazeSpriteEnemyB extends Sprite {
	private MazeSpriteEnemyB mazeSpriteEnemyB;
	

	public MazeSpriteEnemyB(String imageFile) {
		super(imageFile);
	}


	public void motion(long interval, Map2D mazeGround) {

		setVelocity(0.0,4.5);
	
		if((int)(5*(Math.random()))==0){
			setVelocity(0.0,0.0);
		}
		else if((int)(5*(Math.random()))==1) {
			setVelocity(0,-4.5);
		}
		else if((int)(5*(Math.random()))==2) {
			setVelocity(4.5,0);
		}
		else if((int)(5*(Math.random()))==3) {
			setVelocity(0.0,4.5);
		}

		else if((int)(5*(Math.random()))==4) {
			setVelocity(-4.5,0);
		}


		super.motion(interval, mazeGround);;
	}

}