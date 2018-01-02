/*
 * AGM
 */
package com.agm.gameone;

import android.util.Log;

import com.badlogic.androidgames.framework.DynamicGameObject;

public class BirdsEyeView extends DynamicGameObject {
	public static final float BIRDSEYEVIEW_WIDTH = 10.0f;
	public static final float BIRDSEYEVIEW_HEIGHT = 15.0f;
	public static final float BIRDSEYEVIEW_VELOCITY = 8.0f;
	boolean stateMoving;
	float stateTime;

	public BirdsEyeView(float x, float y, float speedBoost) {
		super(x, y, 0, 0);
		if (speedBoost < 0 ) {
			speedBoost = -speedBoost;
		}
		velocity.set(0, BIRDSEYEVIEW_VELOCITY + speedBoost);
		stateMoving = true;
		stateTime = 0;
	}

	public void update(float deltaTime) {
		if (stateMoving) {
			// Object's center position
			position.add(velocity.x * deltaTime, velocity.y * deltaTime);
			stateTime += deltaTime;

			// Checking World's limits
			if (position.x - BIRDSEYEVIEW_WIDTH / 2 < 0) {
				position.x = BIRDSEYEVIEW_WIDTH / 2;
			}
			
			if (position.x + BIRDSEYEVIEW_WIDTH / 2 > World.WORLD_WIDTH) {
				position.x = World.WORLD_WIDTH - BIRDSEYEVIEW_WIDTH / 2;
			}

			if (position.y - BIRDSEYEVIEW_HEIGHT / 2 < 0) {
				position.y = BIRDSEYEVIEW_HEIGHT / 2;
			}

			// Stop moving
			if (position.y + BIRDSEYEVIEW_HEIGHT / 2 > World.WORLD_HEIGHT) {
				position.y = World.WORLD_HEIGHT - BIRDSEYEVIEW_HEIGHT / 2;
				stateMoving = false;
				stateTime = 0;
			}
		}
		Log.i("carga", "background velocidad: " + velocity.y);
	}
}
