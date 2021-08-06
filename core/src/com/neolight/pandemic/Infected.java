package com.neolight.pandemic;

import java.util.ArrayList;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;

public class Infected extends Person {
	int infectRadius = 75;
	int timeUntilHealthy = 60 * 7;

	Infected(float x, float y) {
		super(x, y, new Color(204, 0, 0, 100));
	}

	void display(ShapeRenderer shape) {
		shape.set(ShapeType.Filled);
		shape.setColor(this.color);
		shape.circle(this.x, this.y, 20);

		shape.set(ShapeType.Line);
		shape.setColor(Color.BLACK);
		shape.circle(this.x, this.y, infectRadius);
	}

	void update(ArrayList<Person> people) {
		// Infect other people
		for (Person person : people) {
			boolean isPersonInfected = !(person instanceof Healthy) && person instanceof Infected;
			if (person == this || isPersonInfected)
				continue;

			Healthy healthyPerson = (Healthy) person;
			float distance = Utils.distance(healthyPerson.x, healthyPerson.y, this.x, this.y);

			if (distance <= infectRadius) {
				healthyPerson.timeInInfectRadius += 1;
			}
		}

		// Recover
		timeUntilHealthy--;
		if (timeUntilHealthy <= 0) {
			Healthy healthy = new Healthy(this.x, this.y);
			people.set(people.indexOf(this), healthy);
		}
	}
}
