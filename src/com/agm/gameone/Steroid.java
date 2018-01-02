package com.agm.gameone;

import com.badlogic.androidgames.framework.GameObject;

/*
 * El esteroide no se mueve y es animado.
 * Aporta puntos al score.
 * Sus dimensiones están en metros, como todos los objetos del mundo MVC.
 * Los valores de sus dimensiones salen haciendo una estimación de como quiero
 * que se vean en la pantalla. El mundo mide 3.20 por 4.80, con esa idea puedo 
 * imaginar cuan grandes quiero mis personajes.
 * Estas dimensiones se utilizan para definir el rectángulo de colisiones.
 */
public class Steroid extends GameObject {
	public static float STEROID_WIDTH = 0.9f;
	public static float STEROID_HEIGHT = 0.3f;
	public static final int STEROID_SCORE = 20;
	float stateTime;

	public Steroid(float x, float y) {
		super(x, y, STEROID_WIDTH, STEROID_HEIGHT);
		stateTime = 0;
	}
	
	public void update(float deltaTime) {
        stateTime += deltaTime;
	}
}
