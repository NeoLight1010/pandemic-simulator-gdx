package com.neolight.pandemic;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class PandemicSimulator extends ApplicationAdapter {
	public final static float WIDTH = 800f;
	public final static float HEIGHT = WIDTH * (500f / 800f);

	final static int initialPopulation = 40;
	final static float initialInfectedRate = 0.4f;

	OrthographicCamera camera;
	ShapeRenderer shape;

	ArrayList<Person> people;

	@Override
	public void create() {
		Random random = new Random();

		camera = new OrthographicCamera();
		shape = new ShapeRenderer();

		camera.setToOrtho(false, WIDTH, HEIGHT);

		people = new ArrayList<Person>();
		for (int i = 0; i < initialPopulation; i++) {
			boolean isInfected = random.nextFloat() < initialInfectedRate;
			float randomX = random.nextFloat() * WIDTH;
			float randomY = random.nextFloat() * HEIGHT;

			if (isInfected) {
				Infected infected = new Infected(randomX, randomY);
				people.add(infected);
			} else {
				Healthy healthy = new Healthy(randomX, randomY);
				people.add(healthy);
			}
		}
	}

	@Override
	public void render() {
		ScreenUtils.clear(Color.WHITE);

		camera.update();

		shape.setProjectionMatrix(camera.combined);
		shape.setAutoShapeType(true);

		shape.begin();
		for (Person person : people) {
			person.display(shape);
			person.move();
			person.update(people);
		}
		shape.end();
	}

	@Override
	public void dispose() {
		shape.dispose();
	}
}
