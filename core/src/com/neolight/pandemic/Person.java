package com.neolight.pandemic;

import java.util.ArrayList;
import java.util.Random;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public abstract class Person {
	public float x;
	public float y;

	protected Color color;
	protected int stepsCountdown = 20;
	protected float angle;

	Person(float x, float y, Color color) {
		this.x = x;
		this.y = y;
		this.color = color;
	}

	abstract void display(ShapeRenderer shape);

	abstract void update(ArrayList<Person> people);

	void move() {
		Random random = new Random();

		if (this.stepsCountdown <= 0) {
			this.angle = (float) (random.nextDouble() * 2 * Math.PI);
			this.stepsCountdown = 20;
		}

		this.x += Math.round(Math.cos(this.angle));
		this.y += Math.round(Math.sin(this.angle));

		this.stepsCountdown--;
	}
}
