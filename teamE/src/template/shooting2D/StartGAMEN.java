package template.shooting2D;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GraphicsConfiguration;

import framework.RWT.RWTContainer;
import framework.RWT.RWTFrame3D;
import framework.RWT.RWTImage;
import framework.RWT.RWTVirtualController;
import framework.RWT.RWTVirtualKey;
import template.maze2D.teamE.TemplateMazeGame2D;



public class StartGAMEN extends RWTContainer {
	private TemplateMazeGame2D game;
	private RWTFrame3D frame;

	public StartGAMEN(TemplateMazeGame2D game) {
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

		RWTImage Title = new RWTImage("data\\images\\E_images\\screen\\Start.jpg");
		addWidget(Title);

		//RWTImage startLabel = new RWTImage();
//		startLabel.setString("start!");
//		startLabel.setRelativePosition(0.5f, 0.9f);
//		startLabel.setFont(f);
//		addWidget(startLabel);

		//RWTImage design = new RWTImage();
//		design.setString("☆☆☆☆☆☆☆☆");
//		design.setRelativePosition(0.0f, 0.1f);
//		design.setFont(f);
//		addWidget(design);

		repaint();
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
