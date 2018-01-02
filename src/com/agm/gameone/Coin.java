package com.agm.gameone;

import com.badlogic.androidgames.framework.GameObject;

/*
 * El dinero no se mueve y es animado.
 * Aporta puntos al score.
 * Sus dimensiones están en metros, como todos los objetos del mundo MVC.
 * Los valores de sus dimensiones salen haciendo una estimación de como quiero
 * que se vean en la pantalla. El mundo mide 3.20 por 4.80, con esa idea puedo 
 * imaginar cuan grandes quiero mis personajes en las colisiones.
 * Estas dimensiones se utilizan para definir el rectángulo de colisiones.
 */
public class Coin extends GameObject {
	public static float COIN_WIDTH = 1.2f;
	public static float COIN_HEIGHT = 1.2f;
	public static final int COIN_SCORE = 30;
	float stateTime;

	public Coin(float x, float y) {
		super(x, y, COIN_WIDTH, COIN_HEIGHT);
		stateTime = 0;
	}
	
	public void update(float deltaTime) {
        stateTime += deltaTime;
	}
}
