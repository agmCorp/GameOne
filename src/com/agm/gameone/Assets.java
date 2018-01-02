/*
 * AGM
 */
package com.agm.gameone;

import android.util.Log;

import com.badlogic.androidgames.framework.Music;
import com.badlogic.androidgames.framework.Sound;
import com.badlogic.androidgames.framework.gl.Animation;
import com.badlogic.androidgames.framework.gl.Font;
import com.badlogic.androidgames.framework.gl.Texture;
import com.badlogic.androidgames.framework.gl.TextureRegion;
import com.badlogic.androidgames.framework.impl.GLGame;

public class Assets {
	// Main background (user interface).
	public static Texture background;
	public static TextureRegion backgroundRegion;

	// Game backgroun.
	// It uses an animation to avoid memory leaks and gc.
	public static Texture backgroundGame;
	public static Animation backgroundScroll;
	public static final int BACKGROUNDGAME_MAX_FRAMES = 500;
	public static final float BACKGROUNDGAME_TEXTURE_HEIGHT = 512;

	// UI staff
	public static Texture items;
	public static TextureRegion mainMenu;
	public static TextureRegion pauseMenu;
	public static TextureRegion ready;
	public static TextureRegion gameOver;
	public static TextureRegion highScoresRegion;
	public static TextureRegion logo;
	public static TextureRegion soundOn;
	public static TextureRegion soundOff;
	public static TextureRegion accelOn;
	public static TextureRegion accelOff;
	public static TextureRegion arrow;
	public static TextureRegion pause;

	// Background and Characters
	public static Animation steroid;
	public static Animation goal;
	public static Animation coin;
	public static Animation hero;
	public static Animation heroHit;
	public static Animation heroOnRoids;
	public static Animation enemyOne;

	// FXs
	public static Font font;
	public static Music musicBackground;
	public static Sound hitSound;
	public static Sound coinSound;
	public static Sound goalSound;
	public static Sound roidsSound;
	public static Sound clickSound;

	public static void load(GLGame game) {
		/*
		 * Textures are loaded by indicating a file.png's coordinate system,
		 * which start at the top-left point (pixels), and then its width and
		 * height.
		 */
		background = new Texture(game, "background.png");
		backgroundRegion = new TextureRegion(background, 0, 0, 320, 480);

		backgroundGame = new Texture(game, "backgroundGame.png");
		TextureRegion[] keyFrames = new TextureRegion[BACKGROUNDGAME_MAX_FRAMES];
		for (int i = BACKGROUNDGAME_MAX_FRAMES - 1; i >= 0; i--) {
			keyFrames[BACKGROUNDGAME_MAX_FRAMES - 1 - i] = new TextureRegion(
					backgroundGame, 0, BACKGROUNDGAME_TEXTURE_HEIGHT * i
							/ (float) BACKGROUNDGAME_MAX_FRAMES, 320, 480);
		}
		
		/*
		 * The first parameter points out the frame's duration, so this formula
		 * indicates the duration of each of the frames, depending on the
		 * velocity defined by BirdsEyeView and using the convention 32 pixels
		 * is equals to 1 meter.
		 */
		backgroundScroll = new Animation(
				BACKGROUNDGAME_TEXTURE_HEIGHT
						/ (32 * BirdsEyeView.BIRDSEYEVIEW_VELOCITY * BACKGROUNDGAME_MAX_FRAMES),
				keyFrames);
		
		items = new Texture(game, "items.png");
		mainMenu = new TextureRegion(items, 256, 256, 300, 110);
		pauseMenu = new TextureRegion(items, 256, 398, 192, 96);
		ready = new TextureRegion(items, 256, 366, 192, 32);
		gameOver = new TextureRegion(items, 384, 128, 160, 96);
		highScoresRegion = new TextureRegion(Assets.items, 256, 293, 300,
				110 / 3);
		logo = new TextureRegion(items, 256, 494, 274, 124);
		soundOn = new TextureRegion(items, 320, 128, 64, 64);
		soundOff = new TextureRegion(items, 256, 128, 64, 64);
		accelOn = new TextureRegion(items, 448, 398, 64, 64);
		accelOff = new TextureRegion(items, 512, 398, 64, 64);
		arrow = new TextureRegion(items, 256, 192, 64, 64);
		pause = new TextureRegion(items, 320, 192, 64, 64);

		steroid = new Animation(0.2f, new TextureRegion(items, 0, 256, 64, 64),
				new TextureRegion(items, 64, 256, 64, 64), new TextureRegion(
						items, 128, 256, 64, 64), new TextureRegion(items, 192,
						256, 64, 64));

		goal = new Animation(0.2f, new TextureRegion(items, 0, 384, 128, 128),
				new TextureRegion(items, 128, 384, 128, 128), new TextureRegion(
						items, 0, 512, 128, 128), new TextureRegion(items, 128,
						512, 128, 128));

		coin = new Animation(0.2f, new TextureRegion(items, 0, 320, 64, 64),
				new TextureRegion(items, 64, 320, 64, 64), new TextureRegion(
						items, 128, 320, 64, 64), new TextureRegion(items, 192,
						320, 64, 64));

		hero = new Animation(0.2f, new TextureRegion(items, 0, 0, 64, 64),
				new TextureRegion(items, 64, 0, 64, 64), new TextureRegion(
						items, 128, 0, 64, 64), new TextureRegion(items, 192,
						0, 64, 64));

		heroHit = new Animation(0.2f, new TextureRegion(items, 0, 64, 64, 64),
				new TextureRegion(items, 64, 64, 64, 64), new TextureRegion(
						items, 128, 64, 64, 64), new TextureRegion(items, 192,
						64, 64, 64));

		heroOnRoids = new Animation(0.2f, new TextureRegion(items, 0, 128, 64,
				64), new TextureRegion(items, 64, 128, 64, 64),
				new TextureRegion(items, 128, 128, 64, 64), new TextureRegion(
						items, 192, 128, 64, 64));

		enemyOne = new Animation(0.2f,
				new TextureRegion(items, 0, 192, 64, 64), new TextureRegion(
						items, 64, 192, 64, 64), new TextureRegion(items, 128,
						192, 64, 64),
				new TextureRegion(items, 192, 192, 64, 64));

		font = new Font(items, 256, 0, 16, 16, 20);

		musicBackground = game.getAudio().newMusic("musicBackground.mp3");
		musicBackground.setLooping(true);
		musicBackground.setVolume(0.5f);
		if (Settings.soundEnabled) {
			musicBackground.play();
		}
		goalSound = game.getAudio().newSound("goal.mp3");
		roidsSound = game.getAudio().newSound("steroids.ogg");
		hitSound = game.getAudio().newSound("hit.mp3");
		coinSound = game.getAudio().newSound("coin.mp3");
		clickSound = game.getAudio().newSound("click.mp3");
	}

	public static void reload() {
		background.reload();
		backgroundGame.reload();
		items.reload();
		if (Settings.soundEnabled) {
			musicBackground.play();
		}
	}

	public static void playSound(Sound sound) {
		if (Settings.soundEnabled) {
			sound.play(1);
		}
	}
	
	/*
	 * Actualiza el atributo frameDuration de la animación de acuerdo al parámetro.
	 * Se modificó el framework para soportar esto.
	 * Se hizo así para evitar hacer un nuevo new Animation evitando el gc. 
	 */
	public static void speedUpBackgroundAnimation(float velocity) {
		backgroundScroll.setFrameDuration(BACKGROUNDGAME_TEXTURE_HEIGHT / (32 * velocity * BACKGROUNDGAME_MAX_FRAMES));
		Log.i("speed", "velocidad fondo: " + (BACKGROUNDGAME_TEXTURE_HEIGHT / (32 * velocity * BACKGROUNDGAME_MAX_FRAMES)));
	}
}
