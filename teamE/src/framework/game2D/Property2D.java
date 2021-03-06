package framework.game2D;

import javax.vecmath.Vector2d;
import javax.vecmath.Vector3d;

import framework.model3D.Object3D;
import framework.model3D.Position3D;
import framework.model3D.Property3D;

/**
 * 2次元の物理情報を表す
 * 
 * @author T.Kuno
 * 
 */
public abstract class Property2D {
	Property3D property3D;

	public abstract Property2D clone();

}
