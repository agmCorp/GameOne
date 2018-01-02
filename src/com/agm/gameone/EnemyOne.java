package com.agm.gameone;

import android.util.Log;

import com.badlogic.androidgames.framework.DynamicGameObject;

public class EnemyOne extends DynamicGameObject {
    public static final float ENEMYONE_WIDTH = 1.4f;
    public static final float ENEMYONE_HEIGHT = 2f;
    public static final float ENEMYONE_VELOCITY = -2.0f; // metros por segundo
    
    float stateTime;
    
    public EnemyOne(float x, float y, float speedBoost) {
        super(x, y, ENEMYONE_WIDTH, ENEMYONE_HEIGHT);
        // Solo tiene velocidad en el eje y.
        if (speedBoost > 0) {
        	speedBoost = -speedBoost;
        }
        
        velocity.set(0, ENEMYONE_VELOCITY + speedBoost);
		stateTime = 0;
    }
    
    public void update(float deltaTime) {
    	// Posicion del centro del objeto
        position.add(velocity.x * deltaTime, velocity.y * deltaTime);
        
        // Movemos su rect�ngulo de colisiones.
        // Posici�n del vertice izquierdo inferior, pues el rect�ngulo se construye
        // utilizando ese v�rtice y el ancho y altura del objeto.
        bounds.lowerLeft.set(position).sub(ENEMYONE_WIDTH / 2, ENEMYONE_HEIGHT / 2);
        
        // Circular
        if (position.y < 0) {
            position.y = World.WORLD_HEIGHT;
        }
        stateTime += deltaTime;
		Log.i("carga", "enemyOne velocidad: " + velocity.y);
    }
    
    /*
     * Se podr�a agregar un m�todo "destruir" an�logo el "pulverize" de las plataformas.
     * Se invoca a ese m�tido si el heroe consumi� esteroides y toca al enemigo.
     */
}
