package com.doga.game;


import com.badlogic.gdx.graphics.Color;

public class Text {
    private String text;

    private String value = "";

    private Color color;

    private double timeStart;

    private double timeCurrent;

    private float scale;

    private double duration;

    private int x;

    private int y;

    private int portraitX;

    private int portraitY;

    private int landscapeX;

    private int landscapeY;

    private boolean show = true;

    public Text(String text, Color color, float scale, int x, int y, double timeCurrent, double timeStart, double duration, boolean show) {
        this.text = text;
        this.value = value;
        this.color = color;
        this.scale = scale;
        this.timeCurrent = timeCurrent;
        this.timeStart = timeStart;
        this.duration = duration;
        this.x = x;
        this.y = y;
        this.show = show;
        this.landscapeX = x;
        this.landscapeY = y;
        this.portraitX = x;
        this.portraitY = y;
    }

    public Text(String text, Color color, float scale, int landscapeX, int landscapeY, int portraitX, int portraitY, double timeCurrent, double timeStart, double duration, boolean show) {
        this.text = text;
        this.value = value;
        this.color = color;
        this.scale = scale;
        this.timeCurrent = timeCurrent;
        this.timeStart = timeStart;
        this.duration = duration;
        this.landscapeX = landscapeX;
        this.landscapeY = landscapeY;
        this.x = landscapeX;
        this.y = landscapeY;
        this.show = show;
        this.portraitX = portraitX;
        this.portraitY = portraitY;
    }

    public boolean isShow() {
        return show;
    }

    public void setShow(boolean show) {
        this.show = show;
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

    public String getText() {
        return text;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public float getScale() {
        return scale;
    }

    public void setScale(float scale) {
        this.scale = scale;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setText(String text) {
        this.text = text;
    }

    public double getTimeStart() {
        return timeStart;
    }

    public void setTimeStart(double timeStart) {
        this.timeStart = timeStart;
    }

    public double getTimeCurrent() {
        return timeCurrent;
    }

    public void setTimeCurrent(double timeCurrent) {
        this.timeCurrent = timeCurrent;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setDuration(double duration) {
        this.duration = duration;
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

    public void setPortraitXY(int x, int y) {
        this.portraitX = x;
        this.portraitY = y;
    }

    public int getLandscapeY() {
        return landscapeY;
    }

    public void setLandscapeY(int landscapeY) {
        this.landscapeY = landscapeY;
    }

    public int getLandscapeX() {
        return landscapeX;
    }

    public void setLandscapeX(int landscapeX) {
        this.landscapeX = landscapeX;
    }

    public void setLandscapeXY(int x, int y){
        this.landscapeX = x;
        this.landscapeY = y;
    }
}
