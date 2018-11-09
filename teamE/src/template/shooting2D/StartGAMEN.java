package template.shooting2D;

import java.awt.Font;
import java.awt.GraphicsConfiguration;

import framework.RWT.RWTContainer;
import framework.RWT.RWTLabel;
import framework.RWT.RWTVirtualController;
import framework.RWT.RWTVirtualKey;



public class StartGAMEN extends RWTContainer {
	private TemplateShooting2DMultiStates game;

	public StartGAMEN(TemplateShooting2DMultiStates game) {
		this.game = game;
	}



	@Override
	public void build(GraphicsConfiguration gc) {

		Font f = new Font("", Font.PLAIN, 60);

		RWTLabel Title = new RWTLabel();
		Title.setString("Ç»ÇÒÇ⁄Å[!");
		Title.setRelativePosition(0.3f, 0.5f);
		Title.setFont(f);
		addWidget(Title);

		RWTLabel startLabel = new RWTLabel();
		startLabel.setString("start!");
		startLabel.setRelativePosition(0.5f, 0.9f);
		startLabel.setFont(f);
		addWidget(startLabel);


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
