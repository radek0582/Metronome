package com.doga.game;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.utils.Array;

/**
 * Created by brentaureli on 7/28/15.
 */
public class Animation {
    private Array<TextureRegion> frames;
    private float maxFrameTime;
    private float currentFrameTime;
    private int frameCount;
    private int currentFrame;

    private int finishFrame = 0;
    private int startFrame = 0;
    private int frameShift = 0;
    private boolean playBackwards = false;
    private boolean playingBack = false;
    private boolean playOnlyOnce = false;

    public Animation (TextureRegion region, int frameCountX, int frameCountY, float frameTime){
        frames = new Array<TextureRegion>();
        frameCount = frameCountX * frameCountY;

        int frameWidth = region.getRegionWidth() / frameCountX;
        int frameHeight = region.getRegionHeight() / frameCountY;

        for (int y = 0; y < frameCountY; y++){
            for (int x = 0; x < frameCountX; x++)
                frames.add (new TextureRegion (region, x * frameWidth, y * frameHeight, frameWidth, frameHeight));
        }

//        this.frameCount = frameCount;
        maxFrameTime = frameTime;
        currentFrame = 0;
    }

    public Array<TextureRegion> getFrames() {
        return frames;
    }



    public void setFrames(Array<TextureRegion> frames) {
        this.frames = frames;
    }

    public int getFinishFrame() {
        return finishFrame;
    }

    public void setFinishFrame(int finishFrame) {
        this.finishFrame = finishFrame;
    }

    public int getStartFrame() {
        return startFrame;
    }

    public void setStartFrame(int startFrame) {
        this.startFrame = startFrame;
    }

    public int getCurrentFrame() {
        return currentFrame;
    }

    public void setCurrentFrame(int currentFrame) {
        this.currentFrame = currentFrame;
    }

    public int getFrameShift() {
        return frameShift;
    }

    public void setFrameShift(int frameShift) {
        this.frameShift = frameShift;
    }

    public boolean isPlayBackwards() {
        return playBackwards;
    }

    public void setPlayBackwards(boolean playBackwards) {
        this.playBackwards = playBackwards;
    }

    public boolean isPlayingBack() {
        return playingBack;
    }

    public void setPlayingBack(boolean playingBack) {
        this.playingBack = playingBack;
    }

    public boolean isPlayOnlyOnce() {
        return playOnlyOnce;
    }

    public void setPlayOnlyOnce(boolean playOnlyOnce) {
        this.playOnlyOnce = playOnlyOnce;
    }

    public float getMaxFrameTime() {
        return maxFrameTime;
    }

    public void setMaxFrameTime(float maxFrameTime) {
        this.maxFrameTime = maxFrameTime;
    }

    public void update(float dt){
        currentFrameTime += dt;

//        if (currentFrameTime > maxFrameTime){
//            currentFrame++;
//            currentFrameTime = 0;
//        }
//        if (currentFrame >= frameCount)
//            currentFrame = 0;

        if (this.frames.size > 1 && startFrame != finishFrame) {
            if (currentFrameTime > maxFrameTime) {
                if (playBackwards == false)
                    currentFrame++;
                else {
                    if (playingBack == false)
                        currentFrame++;
                    else
                        currentFrame--;
                }
//                startTime = System.nanoTime();
                currentFrameTime = 0;

                if (playBackwards == false) {
                    if (currentFrame == finishFrame + 1) {
                        if (playOnlyOnce == false) {
                            currentFrame = startFrame;
                        } else {
                            currentFrame = finishFrame;
                        }
                    }
                } else {
                    if (playingBack == false) {
                        if (currentFrame == finishFrame + 1) {
                            currentFrame -= 2;
                            playingBack = true;
                        }
                    } else {
                        if (currentFrame == startFrame) {
                            playingBack = false;
                        }
                    }
                }
//                System.out.println("current frame: " + currentFrame);
            }
        }
    }

    public TextureRegion getFrame(){
        return frames.get (currentFrame);
    }

    public TextureRegion getFrame (int frameNumber){
        return frames.get(frameNumber);
    }
}
