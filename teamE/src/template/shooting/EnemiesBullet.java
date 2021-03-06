package template.shooting;

import framework.AI.GeometryGraph;
import framework.animation.Animation3D;
import framework.gameMain.Actor;
import framework.model3D.CollisionResult;
import framework.model3D.Object3D;
import framework.physics.Force3D;
import framework.physics.Ground;

/**
 * 敵の弾
 * @author 新田直也
 *
 */
public class EnemiesBullet extends Actor {
	private boolean bAlive = true;
	private long left = 0;
	
	// 定数
	public static final long LIFE_TIME = 2000L;		// 弾の寿命
	
	public EnemiesBullet(Object3D body, Animation3D animation) {
		super(body, animation);
		left = LIFE_TIME;
	}
	
	public void motion(long interval, Ground ground) {
		left -= interval;
		if (left < 0L) {
			bAlive = false;
		}
		super.motion(interval, ground);
	}

	@Override
	public void onEndFall() {
	}

	@Override
	public void onIntersect(CollisionResult normal, long interval) {
		bAlive = false;
	}

	@Override
	public void onEndAnimation() {
	}

	@Override
	public Force3D getGravity() {
		// 弾は落下しないので重力をゼロとする
		return Force3D.ZERO;
	}
	
	public boolean isAlive() {
		return bAlive;
	}
}
