package com.doga.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector3;

import java.util.ArrayList;

public class Element {
    private String desc;
    private Animation animation;
    private Texture texture;
    private Vector3 position;
    private ArrayList <Variable> variables;
    private int x;
    private int y;
    private double parallaxFactorX = 1;
    private double parallaxFactorY = 1;
    private boolean cameraShift = true;
    private boolean toDraw = true;
    private float alpha;
    private boolean isTransformable = true;
    private int landscapeX;
    private int landscapeY;
    private int portraitX;
    private int portraitY;
    private int frameCountX;
    private int frameCountY;

    public Element(String desc, String texture, int x, int y, int frameCountX, int frameCountY, float frameTime) {
        this.desc = desc;
        this.texture = new Texture(texture);
        this.animation = new Animation(new TextureRegion(this.texture), frameCountX, frameCountY, frameTime);
        this.position = new Vector3 (x, y, 0);
        this.x = x;
        this.y = y;
        this.variables = new ArrayList<>();
        this.toDraw = true;
        this.alpha = 1;
        this.frameCountX = frameCountX;
        this.frameCountY = frameCountY;
    }

    public Element(String desc, String texture, int landscapeX, int landscapeY, int portraitX, int portraitY, boolean isTransformable, int frameCountX, int frameCountY, float frameTime) {
        this.desc = desc;
        this.texture = new Texture(texture);
        this.animation = new Animation(new TextureRegion(this.texture), frameCountX, frameCountY, frameTime);
        this.position = new Vector3 (x, y, 0);
        this.landscapeX = landscapeX;
        this.landscapeY = landscapeY;
        this.portraitX = portraitX;
        this.portraitY = portraitY;
        this.x = landscapeX;
        this.y = landscapeY;
        this.variables = new ArrayList<>();
        this.toDraw = true;
        this.alpha = 1;
        this.isTransformable = isTransformable;
        this.frameCountX = frameCountX;
        this.frameCountY = frameCountY;
    }

    public int getFrameCountX() {
        return frameCountX;
    }

    public void setFrameCountX(int frameCountX) {
        this.frameCountX = frameCountX;
    }

    public int getFrameCountY() {
        return frameCountY;
    }

    public void setFrameCountY(int frameCountY) {
        this.frameCountY = frameCountY;
    }

    public float getAlpha() {
        return alpha;
    }

    public void setAlpha(float alpha) {
        this.alpha = alpha;
    }

    public boolean isToDraw() {
        return toDraw;
    }

    public void setToDraw(boolean toDraw) {
        this.toDraw = toDraw;
    }

    public void setParallaxFactorXY (double x, double y){
        this.parallaxFactorX = x;
        this.parallaxFactorY = y;
    }

    public double getParallaxFactorX() {
        return parallaxFactorX;
    }

    public double getParallaxFactorY() {
        return parallaxFactorY;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void addNumericalVariable(String desc, double val) {
        Variable var = new Variable(desc, val);
        this.variables.add(var);
    }

    public void addStringVariable(String desc, String valString) {
        Variable var = new Variable(desc, valString);
        this.variables.add(var);
    }

    public void setNumericalVariableValue(String desc, double val) {
        for (Variable var : variables)
            if (var.getDesc().equals(desc)) {
                var.setValue(val);
                break;
            }
    }

    public double getNumericalVariableValue(String desc) {
        double value = -1000000;

        for (Variable var : variables)
            if (var.getDesc().equals(desc)) {
                value = var.getValue();
                break;
            }

        return value;
    }

    public void setStringVariableValue(String desc, String val) {
        for (Variable var : variables)
            if (var.getDesc().equals(desc)) {
                var.setValueString(val);
                break;
            }
    }

    public String getStringVariableValue(String desc) {
        String value = null;

        for (Variable var : variables)
            if (var.getDesc().equals(desc)) {
                value = var.getValueString();
                break;
            }

        return value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Animation getAnimation() {
        return animation;
    }

    public void setAnimation(Animation animation) {
        this.animation = animation;
    }

    public void setTexture(Texture texture) {
        this.texture = texture;
    }

    public void setPosition(Vector3 position) {
        this.position = position;
    }

    public void update(float dt){
        animation.update(dt);
    }

    public Vector3 getPosition() {
        return position;
    }

    public TextureRegion getTexture() {
        return animation.getFrame();
    }

    public TextureRegion getTexture(int frameNumber) {
        return animation.getFrame(frameNumber);
    }

    public boolean isCameraShift() {
        return cameraShift;
    }

    public void setCameraShift(boolean cameraShift) {
        this.cameraShift = cameraShift;
    }

    public void dispose(){
        texture.dispose();
    }

    public boolean isTransformable() {
        return isTransformable;
    }

    public void setTransformable(boolean transformable) {
        isTransformable = transformable;
    }

    public int getPortraitX() {
        return portraitX;
    }

    public void setPortraitX(int portraitX) {
        this.portraitX = portraitX;
    }

    public int getPortraitY() {
        return portraitY;
    }

    public void setPortraitY(int portraitY) {
        this.portraitY = portraitY;
    }

    public int getLandscapeX() {
        return landscapeX;
    }

    public void setLandscapeX(int landscapeX) {
        this.landscapeX = landscapeX;
    }

    public int getLandscapeY() {
        return landscapeY;
    }

    public void setLandscapeY(int landscapeY) {
        this.landscapeY = landscapeY;
    }
}
