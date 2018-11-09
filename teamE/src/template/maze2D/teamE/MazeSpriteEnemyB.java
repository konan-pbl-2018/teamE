package template.maze2D.teamE;
import framework.game2D.Map2D;
import framework.game2D.Sprite;


/**
 * –À˜HƒQ[ƒ€‚Å“oê‚·‚é“G
 *
 * @author T.Kuno
 *
 */
public class MazeSpriteEnemyB extends Sprite {
	private MazeSpriteEnemyB mazeSpriteEnemyB;
	int time;
	int Changetime=400;
	double VY,VX;
	public MazeSpriteEnemyB(String imageFile) {
		super(imageFile);
	}


	public void motion(long interval, Map2D mazeGround) {
time+=interval;
int rdm=(int) (4*(Math.random()));

if(time>Changetime) {

		if(rdm==0) {

			VX=0.0;
			VY=-4.5;
		}
		else if(rdm==1) {

			VX=4.5;
			VY=0.0;
		}
		else if(rdm==2) {

		VX=0.0;
		VY=4.5;
		}
		else if(rdm==3) {

			VX=-4.5;
			VY=0.0;
		}

		time=0;
}
setVelocity(VX,VY);
//Timer timer = new Timer();
//timer.schedule(new Rando(), 0, 3000);
super.motion(interval, mazeGround);;
	}

}

//}