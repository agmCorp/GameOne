package com.agm.gameone;

import com.badlogic.androidgames.framework.DynamicGameObject;

public class Hero extends DynamicGameObject {
	public static final int HERO_STATE_ONROIDS = 0;
	public static final int HERO_STATE_HIT = 1;
	public static final int HERO_STATE_HAPPY = 2;
	public static final float HERO_ONROIDS_MAX_TIME = 4.0f;
	public static final float HERO_DYING_TIME = 0.8f;
	public static final float HERO_MOVE_VELOCITY = 30.0f;
	// Definimos medidas menores que las reales para que su rect�ngulo de colisiones sea m�s chico.
	public static final float HERO_WIDTH = 1.3f;
	public static final float HERO_HEIGHT = 1.3f;

	int state;
	float stateTime;
	float roidsTime;
	float dyingTime;

	public Hero(float x, float y) {
		super(x, y, HERO_WIDTH, HERO_HEIGHT);
		state = HERO_STATE_HAPPY;
		stateTime = 0;
		roidsTime = 0;
		dyingTime = 0;
	}

	public void update(float deltaTime) {
		position.add(velocity.x * deltaTime, velocity.y * deltaTime);
		bounds.lowerLeft.set(position).sub(bounds.width / 2, bounds.height / 2);
		
		stateTime += deltaTime;
		if (state == HERO_STATE_ONROIDS) {
			roidsTime += deltaTime;
		}
		if (state == HERO_STATE_HIT) {
			dyingTime += deltaTime;
		}
		
		// Evita que el H�roe se vaya del mundo.
		if (position.x - HERO_WIDTH / 2 < 0) {
			position.x = HERO_WIDTH / 2;
		}
		if (position.x + HERO_WIDTH / 2 > World.WORLD_WIDTH) {
			position.x = World.WORLD_WIDTH - HERO_WIDTH / 2;
		}		
		
		if (position.y - HERO_HEIGHT / 2 < 0 && state != HERO_STATE_HIT) {
			position.y = HERO_HEIGHT / 2;
		}
		if (position.y + HERO_HEIGHT / 2 > World.WORLD_HEIGHT) {
			position.y = World.WORLD_HEIGHT - HERO_HEIGHT / 2;
		}
	}

	public void hitEnemyOne() {
		velocity.set(0, -20);
		state = HERO_STATE_HIT;
		stateTime = 0;
		dyingTime = 0;
	}

	public void pickSteroids() {
		state = HERO_STATE_ONROIDS;
		stateTime = 0;
		roidsTime = 0;
	}

	public void steroidsOut() {
		state = HERO_STATE_HAPPY;
		stateTime = 0;
		roidsTime = 0;
	}
}
