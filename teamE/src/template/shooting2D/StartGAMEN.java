package template.shooting2D;

import java.awt.Font;
import java.awt.GraphicsConfiguration;

import framework.RWT.RWTContainer;
import framework.RWT.RWTLabel;
import framework.RWT.RWTVirtualController;
import framework.RWT.RWTVirtualKey;
import framework.game2D.Sprite;
import framework.model3D.Universe;



public class StartGAMEN extends RWTContainer {
	private TemplateShooting2DMultiStates game;

	public StartGAMEN(TemplateShooting2DMultiStates game) {
		this.game = game;
	}

	public void init(Universe universe) {
		Sprite wall = new Sprite("data\\images\\E_images\\block.png");
		Sprite.setPosition(0.0, -10.0);
		universe.place(wall);
	}



	@Override
	public void build(GraphicsConfiguration gc) {

		RWTLabel startLabel = new RWTLabel();
		RWTLabel startLabel2 = new RWTLabel();
		startLabel.setString("STARRRT!!");
		startLabel2.setString("sakanaction!");;
		startLabel.setRelativePosition(0.3f, 0.5f);
		startLabel2.setRelativePosition(0.2f, 0.9f);
		Font f = new Font("", Font.PLAIN, 60);
		startLabel.setFont(f);
		startLabel2.setFont(f);
		addWidget(startLabel);
		addWidget(startLabel2);
	}

	@Override
	public void keyPressed(RWTVirtualKey key) {
		if (key.getVirtualKey() == RWTVirtualController.BUTTON_A) {
			game.play();
		}
	}

	@Override
	public void keyReleased(RWTVirtualKey key) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(RWTVirtualKey key) {
		// TODO Auto-generated method stub

	}

}
