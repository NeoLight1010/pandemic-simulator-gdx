package com.neolight.pandemic;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class PandemicSimulator extends ApplicationAdapter {
	public final static float WIDTH = 800f;
	public final static float HEIGHT = WIDTH * (500f / 800f);

	OrthographicCamera camera;
	ShapeRenderer shape;

	@Override
	public void create() {
		camera = new OrthographicCamera();
		shape = new ShapeRenderer();

		camera.setToOrtho(false, WIDTH, HEIGHT);
	}

	@Override
	public void render() {
		ScreenUtils.clear(Color.WHITE);

		camera.update();

		shape.setProjectionMatrix(camera.combined);

		shape.begin(ShapeType.Filled);
		shape.setColor(Color.BLACK);
		shape.circle(50, 50, 50);
		shape.end();
	}

	@Override
	public void dispose() {
		shape.dispose();
	}
}
