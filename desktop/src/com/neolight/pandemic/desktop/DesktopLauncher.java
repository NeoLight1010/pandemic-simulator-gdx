package com.neolight.pandemic.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.neolight.pandemic.PandemicSimulator;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.title = "Pandemic Simulator";
		config.width = 800;
		config.height = 500;

		new LwjglApplication(new PandemicSimulator(), config);
	}
}
