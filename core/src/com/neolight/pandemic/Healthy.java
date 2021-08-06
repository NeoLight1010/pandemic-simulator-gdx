package com.neolight.pandemic;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Healthy extends Person {
	int timeInInfectRadius = 0;
	int infectThreshold = 200;

	Healthy(float x, float y) {
		super(x, y, new Color (0, 255, 153, 100));
	}

	void display(ShapeRenderer shape) {
		shape.set(ShapeType.Filled);
		shape.setColor(this.color);
		shape.circle(this.x, this.y, 20);
	}

	void update(ArrayList<Person> people) {
		if (timeInInfectRadius > infectThreshold) {
			Infected infected = new Infected(this.x, this.y);

			people.set(people.indexOf(this), infected);
		}
	}
}
