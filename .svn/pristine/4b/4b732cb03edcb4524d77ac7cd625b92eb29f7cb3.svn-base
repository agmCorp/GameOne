package com.badlogic.androidgames.framework.gl;

/* Modificada AGM
 * Se agrega el método setFrameDuration y se quita final en la declaración de frameDuration.
 */
public class Animation {
    public static final int ANIMATION_LOOPING = 0;
    public static final int ANIMATION_NONLOOPING = 1;
    
    final TextureRegion[] keyFrames;
    float frameDuration;
    
    public Animation(float frameDuration, TextureRegion ... keyFrames) {
        this.frameDuration = frameDuration;
        this.keyFrames = keyFrames;
    }
    
    public TextureRegion getKeyFrame(float stateTime, int mode) {
        int frameNumber = (int)(stateTime / frameDuration);
        
        if(mode == ANIMATION_NONLOOPING) {
            frameNumber = Math.min(keyFrames.length-1, frameNumber);            
        } else {
            frameNumber = frameNumber % keyFrames.length;
        }
        return keyFrames[frameNumber];
    }
    
    public void setFrameDuration(float frameDuration) {
    	this.frameDuration = frameDuration;
    }
}
