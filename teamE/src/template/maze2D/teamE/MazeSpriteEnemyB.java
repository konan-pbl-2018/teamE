package template.maze2D.teamE;
import java.util.Timer;
import java.util.TimerTask;

import framework.game2D.Map2D;
import framework.game2D.Sprite;


/**
 * ñ¿òHÉQÅ[ÉÄÇ≈ìoèÍÇ∑ÇÈìG
 *
 * @author T.Kuno
 *
 */
public class MazeSpriteEnemyB extends Sprite {
	private MazeSpriteEnemyB mazeSpriteEnemyB;
	public MazeSpriteEnemyB(String imageFile) {
		super(imageFile);
	}

	public class Rando extends TimerTask{
		public void run() {
			System.out.println("hhh");
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
		}
	}

	//public class timer{
	public void motion(long interval, Map2D mazeGround) {



		//Timer timer = new Timer();
		//timer.schedule(new MazeSpriteEnemyB(), 1000,3000);

		//setVelocity(0.0,4.5);
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
		Timer timer = new Timer();
		timer.schedule(new Rando(), 0, 3000);
		super.motion(interval, mazeGround);;


	}

}

//}