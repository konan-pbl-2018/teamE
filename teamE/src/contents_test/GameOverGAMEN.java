package contents_test;

import java.awt.Font;
import java.awt.GraphicsConfiguration;

import framework.RWT.RWTContainer;
import framework.RWT.RWTLabel;
import framework.RWT.RWTVirtualController;
import framework.RWT.RWTVirtualKey;



public class GameOverGAMEN extends RWTContainer {
	private TemplateShooting2DMultiStates game;

	public GameOverGAMEN(TemplateShooting2DMultiStates game) {
		this.game = game;
	}



	@Override
	public void build(GraphicsConfiguration gc) {

		Font f = new Font("", Font.PLAIN, 60);

		RWTLabel Title = new RWTLabel();
		Title.setString("�Ȃ�ځ[!");
		Title.setRelativePosition(0.3f, 0.5f);
		Title.setFont(f);
		addWidget(Title);

		RWTLabel startLabel = new RWTLabel();
		startLabel.setString("start!");
		startLabel.setRelativePosition(0.5f, 0.9f);
		startLabel.setFont(f);
		addWidget(startLabel);

		RWTLabel design = new RWTLabel();
		design.setString("����������������");
		design.setRelativePosition(0.0f, 0.1f);
		design.setFont(f);
		addWidget(design);


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
