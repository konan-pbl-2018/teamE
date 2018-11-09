package template.shooting2D;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GraphicsConfiguration;

import framework.RWT.RWTContainer;
import framework.RWT.RWTFrame3D;
import framework.RWT.RWTLabel;
import framework.RWT.RWTVirtualController;
import framework.RWT.RWTVirtualKey;



public class StartGAMEN extends RWTContainer {
	private TemplateShooting2DMultiStates game;
	private RWTFrame3D frame;

	public StartGAMEN() {
		this.game = game;
	}

	public RWTFrame3D createFrame3D() {
		frame = new RWTFrame3D();
		frame.setSize(1000, 800);
		frame.setTitle("Test");
		frame.setBackground(Color.BLACK);
		return frame;
	}

	private Component getContentPane() {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}

	@Override
	public void build(GraphicsConfiguration gc) {

		Font f = new Font("", Font.PLAIN, 60);

		RWTLabel Title = new RWTLabel();
		Title.setString("なんぼー!");
		Title.setRelativePosition(0.3f, 0.5f);
		Title.setFont(f);
		addWidget(Title);

		RWTLabel startLabel = new RWTLabel();
		startLabel.setString("start!");
		startLabel.setRelativePosition(0.5f, 0.9f);
		startLabel.setFont(f);
		addWidget(startLabel);

		RWTLabel design = new RWTLabel();
		design.setString("☆☆☆☆☆☆☆☆");
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
