package com.doga.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureData;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.Map;
import java.util.Random;

public class ElementsManager {
    static void elementsManager(ArrowGame arrowGame) {
        ArrayList<Element> elements = arrowGame.elements;
        Map<String, Text> texts = arrowGame.texts;

        elements.add(new Element("refreshLandscape", "guardian.png", 100, 100, 1, 1, 0.05f));
        elements.add(new Element("refreshPortrait", "archer.png", 200, 100, 1, 1, 0.05f));
//        elements.add(new Element("whiteBkg", "whiteBkg3000x1200.png", 0, 0, 1, 1, 0.05f));
        elements.add(new Element("spider", "spider1.png", 1500, 700, 1, 1, 0.05f));
        elements.add(new Element("spider2", "spider1.png", 1500, 1000, 1, 1, 0.05f));
        elements.add(new Element("spider3", "spider1.png", 500, 400, 1, 1, 0.05f));
        elements.add(new Element("energyBox", "energyBox.png", 55, 650, 1, 1, 0.05f));
        elements.add(new Element("energyBar", "energyBar.png", 50, 200, 1, 1, 0.05f));
        elements.add(new Element("metronome", "metronom.png", 450, 150, 1, 1, 0.05f));
        elements.add(new Element("slider", "suwak.png", 940, 300, 1, 1, 0.05f));
        getLastEl(elements).addNumericalVariable("actAngle", -45);
        getLastEl(elements).addNumericalVariable("externalAngle", 0);
        getLastEl(elements).setX(2200);
        getLastEl(elements).setY(400);
        getLastEl(elements).addStringVariable("direction", "left");

        elements.add(new Element("wheelPoint", "testPoint.png", 990, 250, 1, 1, 0.15f));
        getLastEl(elements).addNumericalVariable("actAngle", 0);
        getLastEl(elements).addNumericalVariable("externalAngle", 1);

        elements.add(new Element("pendulum", "wskazowka.png", 500, 200, 1, 1, 0.05f));
        getLastEl(elements).addNumericalVariable("actAngle", -45);
        getLastEl(elements).addNumericalVariable("externalAngle", 0);
        getLastEl(elements).setX(2200);
        getLastEl(elements).setY(400);
        getLastEl(elements).addStringVariable("direction", "left");
//        elements.add(new Element("firefly", "firefly1.png", 790, 470, 1, 1, 0.05f));

//        elements.add(new Element("firefly", "fireflyAll.png", 176, 176, 5, 3, 0.05f));
//        getLastEl(elements).getAnimation().setPlayBackwards(true);
//        getLastEl(elements).getAnimation().setCurrentFrame(0);
//        getLastEl(elements).getAnimation().setFinishFrame(14);
//        getLastEl(elements).getAnimation().setStartFrame(0);

//        elements.add(new Element("firefly", "firefly3.png", 176, 176, 5, 5, 0.07f));
//        getLastEl(elements).getAnimation().setStartFrame(0);
//        getLastEl(elements).getAnimation().setFinishFrame(13);
//        getLastEl(elements).getAnimation().setPlayBackwards(true);
//        getLastEl(elements).setX(2000);
//        getLastEl(elements).setY(500);
//        getLastEl(elements).addNumericalVariable("actAngle", -90);
//        arrowGame.cameraShiftX += 1000;

        elements.add(new Element("firefly", "testFirefly2.png", 10, 10, 1, 1, 0.07f));
        getLastEl(elements).getAnimation().setStartFrame(0);
        getLastEl(elements).getAnimation().setFinishFrame(0);
        getLastEl(elements).getAnimation().setPlayBackwards(true);
        getLastEl(elements).setX(2000);
        getLastEl(elements).setY(500);
        getLastEl(elements).addNumericalVariable("actAngle", -90);
        arrowGame.cameraShiftX += 1000;

        elements.add(new Element("webMove", "webMove2.png", 676, 675, 3, 2, 0.15f));
        getLastEl(elements).getAnimation().setStartFrame(0);
        getLastEl(elements).getAnimation().setFinishFrame(4);
        getLastEl(elements).getAnimation().setPlayBackwards(false);
        getLastEl(elements).setX(3800);
        getLastEl(elements).setY(500);

//        arrowGame.elementsMap.put("blade", new Element("blade", "blade.png", 2000, 500, 1, 1, 0.15f));
        elements.add(new Element("testPoint", "testPoint.png", 1900, 400, 1, 1, 0.15f));
        getLastEl(elements).addNumericalVariable("actAngle", 0);
        getLastEl(elements).addNumericalVariable("externalAngle", 1);


//        elements.add(new Element("blade2", "blade2.png", 1900, 400, 1, 1, 0.15f));
        elements.add(new Element("blade2", "testPoint.png", 1900, 400, 1, 1, 0.15f));
        getLastEl(elements).addNumericalVariable("actAngle", 0);
        getLastEl(elements).addNumericalVariable("externalAngle", 0);

        elements.add(new Element("wheel", "wheel4.png", 2000, 500, 2, 1, 1f));
        getLastEl(elements).getAnimation().setStartFrame(1);
        getLastEl(elements).getAnimation().setFinishFrame(1);
        getLastEl(elements).getAnimation().setCurrentFrame(1);
        getLastEl(elements).addNumericalVariable("actAngle", 180);
        getLastEl(elements).addNumericalVariable("externalAngle", 0);
//        makeCollisionMatrix(getLastEl(elements), "wheel", arrowGame);




//        elements.add(new Element("webs", "webs3.png", 1417, 1417, 4, 4, 0.15f));
//        getLastEl(elements).getAnimation().setStartFrame(0);
//        getLastEl(elements).getAnimation().setFinishFrame(15);
//        getLastEl(elements).getAnimation().setPlayBackwards(true);
//        getLastEl(elements).setX(2800);
//        getLastEl(elements).setY(400 + randomNumber(-100, 200));
//        makeCollisionMatrix(getLastEl(elements), "webs", arrowGame);

//        elements.add(new Element("webs", "testAngle.png", 1000, 1000, 1, 1, 0.15f));
//        getLastEl(elements).getAnimation().setStartFrame(0);
//        getLastEl(elements).getAnimation().setFinishFrame(0);
//        getLastEl(elements).getAnimation().setPlayBackwards(true);
//        getLastEl(elements).setX(2200);
//        getLastEl(elements).setY(400);
//        getLastEl(elements).addNumericalVariable("actAngle", 45);
//        makeCollisionMatrix(getLastEl(elements), "webs", arrowGame);

//        elements.add(new Element("webTest", "webTest3.png", 1417, 1471, 4, 4, 0.15f));
//        getLastEl(elements).getAnimation().setStartFrame(0);
//        getLastEl(elements).getAnimation().setFinishFrame(15);
//        getLastEl(elements).getAnimation().setPlayBackwards(true);
//        getLastEl(elements).setX(2800);
//        getLastEl(elements).setY(500);
//        makeCollisionMatrix(getLastEl(elements), "webTest", arrowGame);

        elements.add(new Element("webs", "testCollision6multi4.png", 200, 100, 5, 4, 5.0f));
        getLastEl(elements).getAnimation().setStartFrame(0);
        getLastEl(elements).getAnimation().setFinishFrame(19);
//        getLastEl(elements).getAnimation().setCurrentFrame(8);
//        getLastEl(elements).getAnimation().setPlayBackwards(false);
        getLastEl(elements).addNumericalVariable("actAngle", 45);
        getLastEl(elements).addNumericalVariable("externalAngle", 0);
        getLastEl(elements).setX(2200);
        getLastEl(elements).setY(400);
        makeCollisionMatrix(getLastEl(elements), "webs", arrowGame);



//        elements.add(new Element("websApla", "websApla.png", 1417, 1417, 4, 4, 0.1f));
//        getLastEl(elements).getAnimation().setStartFrame(0);
//        getLastEl(elements).getAnimation().setFinishFrame(15);
//        getLastEl(elements).getAnimation().setPlayBackwards(true);
//        getLastEl(elements).setX(2800);
//        getLastEl(elements).setY(500);

        elements.add(new Element("bigSpider", "spiderBig4.png", 293, 295, 4, 1, 0.5f));
        getLastEl(elements).getAnimation().setStartFrame(0);
        getLastEl(elements).getAnimation().setFinishFrame(3);
        getLastEl(elements).getAnimation().setPlayBackwards(false);
        getLastEl(elements).setX(3500);
        getLastEl(elements).setY(800);

        elements.add(new Element("torch", "bulb5.png", 5000, 500, 1, 1, 0.05f));
        elements.add(new Element("torch2", "bulb6.png", 200, 300, 1, 1, 0.05f));

        elements.add(new Element("text_Host", "text_Host.png", 500, 500, 1, 1, 0.05f));

        elements.add(new Element("win1", "win1.png", 500, 50, 1, 1, 0.05f));
        elements.add(new Element("win2", "win2.png", 500, 50, 1, 1, 0.05f));
        elements.add(new Element("win3", "win3.png", 500, 50, 1, 1, 0.05f));
//        elements.add(new Element("clouds", "clouds.png", 3000, -100, 1, 1, 0.05f));
//        getLastEl(elements).setAlpha(0.5f);

        elements.add(new Element("square1", "square1.png", 1000, 500, 1, 1, 0.05f));
        getLastEl(elements).setParallaxFactorXY(0.5, 0.5);

        elements.add(new Element("dragger0", "field.png", -100, -100, 1, 1, 0.05f));
        getLastEl(elements).addNumericalVariable("pointer", -1);
        getLastEl(elements).addNumericalVariable("prevX", 0);
        getLastEl(elements).addNumericalVariable("prevY", 0);
        getLastEl(elements).addNumericalVariable("deltaX", 0);
        getLastEl(elements).addNumericalVariable("deltaY", 0);
        getLastEl(elements).addNumericalVariable("distanceX", 0);
        getLastEl(elements).addNumericalVariable("distanceY", 0);
//        getLastEl(elements).addStringVariable("draggingMove", "false");
        elements.add(new Element("dragger1", "field.png", -100, -100, 1, 1, 0.05f));
        getLastEl(elements).addNumericalVariable("pointer", -1);
        getLastEl(elements).addNumericalVariable("prevX", 0);
        getLastEl(elements).addNumericalVariable("prevY", 0);
        getLastEl(elements).addNumericalVariable("deltaX", 0);
        getLastEl(elements).addNumericalVariable("deltaY", 0);
        getLastEl(elements).addNumericalVariable("distanceX", 0);
        getLastEl(elements).addNumericalVariable("distanceY", 0);
//        getLastEl(elements).addStringVariable("draggingMove", "false");

        elements.add(new Element("oneTouch", "field.png", -500, -500, 1, 1, 0.05f));
        getLastEl(elements).addNumericalVariable("pointer", -1);
        elements.add(new Element("secondTouch", "field.png", -500, -500, 1, 1, 0.05f));
        getLastEl(elements).addNumericalVariable("pointer", -1);

        elements.add(new Element("blinkyBkg", "tloZZiarnem5.jpg", 0, -1024, 1, 1, 0.05f));
        elements.add(new Element("blinkyBkg2", "tloZZiarnem5.jpg", 4096, -1024, 1, 1, 0.05f));
        elements.add(new Element("blinkyBkg3", "tloZZiarnem5.jpg", -4096, -1024, 1, 1, 0.05f));
//        elements.add(new Element("blinkyBkg3", "tloZZiarnem8.jpg", 0, -2048, 1, 1, 0.05f));
//        elements.add(new Element("blinkyBkg4", "tloZZiarnem8.jpg", 2048, -2048, 1, 1, 0.05f));
//        elements.add(new Element("blinkyBkg5", "tloZZiarnem8.jpg", 4096, 0, 1, 1, 0.05f));
//        elements.add(new Element("blinkyBkg6", "tloZZiarnem8.jpg", 4096, -2048, 1, 1, 0.05f));
//        elements.add(new Element("bkg", "bkg.gif", -0, 0, 1, 1, 0.05f));
//        getLastEl(elements).setParallaxFactorXY(0.5, 0.5);
//        elements.add(new Element("bkg2", "bkg.gif", 1048, 1024, 1, 1, 0.05f));
//        getLastEl(elements).setParallaxFactorXY(0.5, 0.5);
//        elements.add(new Element("bkg3", "bkg.gif", -1000, -1024, 1, 1, 0.05f));
//        getLastEl(elements).setParallaxFactorXY(0.5, 0.5);
//        elements.add(new Element("bkg4", "bkg.gif", 1048, -1024, 1, 1, 0.05f));
//        getLastEl(elements).setParallaxFactorXY(0.5, 0.5);

        elements.add(new Element("logo", "logo.png", 600, 100, 200, arrowGame.portraitHeight - 900, false, 1, 1, 0.05f));

        elements.add(new Element("blackCover", "blackCoverSmall3.png", -500, -500, 200, arrowGame.portraitHeight - 900, false, 1, 1, 0.05f));


//        elements.add(new Element("doga", "doga1000p2.png", 500, 50, 1, 1, 0.05f));
//        getLastEl(elements).setAlpha(0.5f);
        elements.add(new Element("circle2", "circle2.png", 500, 500, 1, 1, 0.05f));
        elements.add(new Element("zoomIN", "zoomIn.png", 1600, 800, 1, 1, 0.05f));
        elements.add(new Element("zoomOUT", "zoomOut.png", 1600, 700, 1, 1, 0.05f));
        elements.add(new Element("highlight", "highlight2.png", -100, -100, 3, 1, 0.05f));
        getLastEl(elements).getAnimation().setStartFrame(0);
        getLastEl(elements).getAnimation().setFinishFrame(2);
//        getLastEl(elements).setX((int) (Constants.SCREEN_WIDTH * arrowGame.factor / 2) - getLastEl(elements).getTexture().getRegionWidth() / 2);
//        getLastEl(elements).setY(1080 / 2 - getLastEl(elements).getTexture().getRegionHeight() / 2);

//        elements.add(new Element("sky", "sky2.jpg", -150, 0, 1, 1, 0.05f));
//        getLastEl(elements).setParallaxFactorXY(0.2, 0.2);
//
//        elements.add(new Element("mountains", "mountains500.png", -150, 100, 1, 1, 0.05f));
//        getLastEl(elements).setParallaxFactorXY(0.5, 0.5);
//
//        elements.add(new Element("ground", "ground.gif", -150, 0, 1, 1, 0.05f));

        elements.add(new Element("guardian1", "guardian.png", 500 + 576 - 20, 50 + 500 - 20, 1, 1, 0.05f));
        getLastEl(elements).addStringVariable("currentField", "field5");

        elements.add(new Element("guardian2", "guardian.png", 500 + 468 - 20, 50 + 315 - 20, 1, 1, 0.05f));
        getLastEl(elements).addStringVariable("currentField", "field9");

        elements.add(new Element("guardian3", "guardian.png", 500 + 685 - 20, 50 + 315 - 20, 1, 1, 0.05f));
        getLastEl(elements).addStringVariable("currentField", "field10");



//        elements.add(new Element("tree", "tree5.png", randomNumber(1000, 500), 100, 1, 1, 0.05f));

//        elements.add(new Element("eye", "eye.png", 2000, 180, 5, 1, 0.2f));
//        getLastEl(elements).setX(searchObj("tree", arrowGame).getX() + randomNumber(150, 400));
//        getLastEl(elements).setY(searchObj("tree", arrowGame).getY() + randomNumber(550, 200));
//        getLastEl(elements).getAnimation().setPlayBackwards(true);
//        getLastEl(elements).getAnimation().setCurrentFrame(0);
//        getLastEl(elements).getAnimation().setFinishFrame(2);
//        getLastEl(elements).getAnimation().setStartFrame(0);
//        getLastEl(elements).addNumericalVariable("isHit", 0);

//        elements.add(new Element("archer", "archer.gif", 50, 150, 5, 5, 0.05f));
//        getLastEl(elements).getAnimation().setStartFrame(0);
//        getLastEl(elements).getAnimation().setFinishFrame(23);
//        getLastEl(elements).addNumericalVariable("actualArrowID", 0);
//        getLastEl(elements).addNumericalVariable("timePassed", 0);
//        getLastEl(elements).addNumericalVariable("position", 1);
//        getLastEl(elements).addNumericalVariable("playerId", -1);
//        getLastEl(elements).addStringVariable("direction", "right");

//        elements.add(new Element("archer3", "archer11.gif", 200, 100, 5, 5, 0.05f));
//        getLastEl(elements).getAnimation().setStartFrame(0);
//        getLastEl(elements).getAnimation().setFinishFrame(23);
//        getLastEl(elements).addNumericalVariable("actualArrowID", 0);
//        getLastEl(elements).addNumericalVariable("timePassed", 0);
//        getLastEl(elements).addNumericalVariable("position", 1);
//        getLastEl(elements).setToDraw(false);
//
//        elements.add(new Element("archer10", "archer10.gif", 2000, 100, 5, 5, 0.05f));
//        getLastEl(elements).getAnimation().setStartFrame(0);
//        getLastEl(elements).getAnimation().setFinishFrame(23);
//        getLastEl(elements).addNumericalVariable("actualArrowID", 0);
//        getLastEl(elements).addNumericalVariable("timePassed", 0);
//        getLastEl(elements).addNumericalVariable("position", 1);
//        getLastEl(elements).addNumericalVariable("playerId", -1);
//        getLastEl(elements).addStringVariable("direction", "left");
//        getLastEl(elements).setToDraw(false);

        elements.add(new Element("powerBlock", "powerblock.png", 100, 100, 1, 1, 0.05f));
        getLastEl(elements).addNumericalVariable("pointer", -1);
//        getLastEl(elements).setTransformable(false);
        getLastEl(elements).setCameraShift(false);

//        elements.add(new Element("angleblock", "angleblock.png", (int) ((float) Constants.SCREEN_WIDTH * arrowGame.factor - 300), 100, 1, 1, 0.05f));
//        getLastEl(elements).addNumericalVariable("pointer", -1);
//        getLastEl(elements).setCameraShift(false);

//        elements.add(new Element("shoot", "shoot.png", 400, 900, 1, 1, 0.05f));
//        getLastEl(elements).setCameraShift(false);
//
//        elements.add(new Element("return", "return.png", 1800, 900, 1, 1, 0.05f));
//        getLastEl(elements).setCameraShift(false);

//        elements.add(new Element("circle", "circle.png", 1200, 100, 1, 1, 0.05f));
//        elements.add(new Element("circle2", "circle2.png", 1000, 100, 1, 1, 0.05f));
//

        elements.add(new Element("square", "square.png", 0, 0, 1, 1, 0.05f));
        getLastEl(elements).addNumericalVariable("arrowPaired", 0);
        getLastEl(elements).addNumericalVariable("prevX", -10000);
        getLastEl(elements).addNumericalVariable("prevY", -10000);
        getLastEl(elements).setToDraw(false);

//        elements.add(new Element("key1", "key1.png", 500, 350, 40, 350, false, 1, 1, 0.05f));
//        elements.add(new Element("key2", "key2.png", 600, 350, 140, 350, false, 1, 1, 0.05f));
//        elements.add(new Element("key3", "key3.png", 700, 350, 240, 350, false, 1, 1, 0.05f));
//        elements.add(new Element("key4", "key4.png", 800, 350, 340, 350, false, 1, 1, 0.05f));
//        elements.add(new Element("key5", "key5.png", 900, 350, 440, 350, false, 1, 1, 0.05f));
//        elements.add(new Element("key6", "key6.png", 1000, 350, 540, 350, false, 1, 1, 0.05f));
//        elements.add(new Element("key7", "key7.png", 1100, 350, 640, 350, false, 1, 1, 0.05f));
//        elements.add(new Element("key8", "key8.png", 1200, 350, 740, 350, false, 1, 1, 0.05f));
//        elements.add(new Element("key9", "key9.png", 1300, 350, 840, 350, false, 1, 1, 0.05f));
//        elements.add(new Element("key0", "key0.png", 1400, 350, 940, 350, false, 1, 1, 0.05f));
//
//        elements.add(new Element("keyq", "keyq.png", 500, 250, 40, 250, false, 1, 1, 0.05f));
//        elements.add(new Element("keyw", "keyw.png", 600, 250, 140, 250, false, 1, 1, 0.05f));
//        elements.add(new Element("keye", "keye.png", 700, 250, 240, 250, false, 1, 1, 0.05f));
//        elements.add(new Element("keyr", "keyr.png", 800, 250, 340, 250, false, 1, 1, 0.05f));
//        elements.add(new Element("keyt", "keyt.png", 900, 250, 440, 250, false, 1, 1, 0.05f));
//        elements.add(new Element("keyy", "keyy.png", 1000, 250, 540, 250, false, 1, 1, 0.05f));
//        elements.add(new Element("keyu", "keyu.png", 1100, 250, 640, 250, false, 1, 1, 0.05f));
//        elements.add(new Element("keyi", "keyi.png", 1200, 250, 740, 250, false, 1, 1, 0.05f));
//        elements.add(new Element("keyo", "keyo.png", 1300, 250, 840, 250, false, 1, 1, 0.05f));
//        elements.add(new Element("keyp", "keyp.png", 1400, 250, 940, 250, false, 1, 1, 0.05f));
//
//        elements.add(new Element("keya", "keya.png", 500, 150, 40, 150, false, 1, 1, 0.05f));
//        elements.add(new Element("keys", "keys.png", 600, 150, 140, 150, false, 1, 1, 0.05f));
//        elements.add(new Element("keyd", "keyd.png", 700, 150, 240, 150, false, 1, 1, 0.05f));
//        elements.add(new Element("keyf", "keyf.png", 800, 150, 340, 150, false, 1, 1, 0.05f));
//        elements.add(new Element("keyg", "keyg.png", 900, 150, 440, 150, false, 1, 1, 0.05f));
//        elements.add(new Element("keyh", "keyh.png", 1000, 150, 540, 150, false, 1, 1, 0.05f));
//        elements.add(new Element("keyj", "keyj.png", 1100, 150, 640, 150, false, 1, 1, 0.05f));
//        elements.add(new Element("keyk", "keyk.png", 1200, 150, 740, 150, false, 1, 1, 0.05f));
//        elements.add(new Element("keyl", "keyl.png", 1300, 150, 840, 150, false, 1, 1, 0.05f));
//        elements.add(new Element("keyup", "keyup.png", 1400, 150, 940, 150, false, 1, 1, 0.05f));
//
//        elements.add(new Element("keyz", "keyz.png", 500, 50, 40, 50, false, 1, 1, 0.05f));
//        elements.add(new Element("keyx", "keyx.png", 600, 50, 140, 50, false, 1, 1, 0.05f));
//        elements.add(new Element("keyc", "keyc.png", 700, 50, 240, 50, false, 1, 1, 0.05f));
//        elements.add(new Element("keyv", "keyv.png", 800, 50, 340, 50, false, 1, 1, 0.05f));
//        elements.add(new Element("keyb", "keyb.png", 900, 50, 440, 50, false, 1, 1, 0.05f));
//        elements.add(new Element("keyn", "keyn.png", 1000, 50, 540, 50, false, 1, 1, 0.05f));
//        elements.add(new Element("keym", "keym.png", 1100, 50, 640, 50, false, 1, 1, 0.05f));
//        elements.add(new Element("keyback", "keydelete.png", 1200, 50, 740, 50, false, 1, 1, 0.05f));
//        elements.add(new Element("keyenter", "keyenter.png", 1300, 50, 840, 50, false, 1, 1, 0.05f));
//        elements.add(new Element("keycancel", "keycancel.png", 1400, 50, 940, 50, false, 1, 1, 0.05f));
//        elements.add(new Element("writingField", "writingfield.png", 500, 450, 40, 450, false, 1, 1, 0.05f));


        // 1st row
        elements.add(new Element("keyq", "keyq.png", (int) (arrowGame.landscapeWidth * arrowGame.factor / 2) - 500, 500, 0, 500, false, 1, 1, 0.05f));
        elements.add(new Element("keyw", "keyw.png", (int) (arrowGame.landscapeWidth * arrowGame.factor / 2) - 380, 500, 120, 500, false, 1, 1, 0.05f));
        elements.add(new Element("keye", "keye.png", (int) (arrowGame.landscapeWidth * arrowGame.factor / 2) - 260, 500, 240, 500, false, 1, 1, 0.05f));
        elements.add(new Element("keyr", "keyr.png", (int) (arrowGame.landscapeWidth * arrowGame.factor / 2) - 140, 500, 360, 500, false, 1, 1, 0.05f));
        elements.add(new Element("keyt", "keyt.png", (int) (arrowGame.landscapeWidth * arrowGame.factor / 2) - 20, 500, 480, 500, false, 1, 1, 0.05f));
        elements.add(new Element("keyy", "keyy.png", (int) (arrowGame.landscapeWidth * arrowGame.factor / 2) + 100, 500, 600, 500, false, 1, 1, 0.05f));
        elements.add(new Element("key7", "key7.png", (int) (arrowGame.landscapeWidth * arrowGame.factor / 2) + 220, 500, 720, 500, false, 1, 1, 0.05f));
        elements.add(new Element("key8", "key8.png", (int) (arrowGame.landscapeWidth * arrowGame.factor / 2) + 340, 500, 840, 500, false, 1, 1, 0.05f));
        elements.add(new Element("key9", "key9.png", (int) (arrowGame.landscapeWidth * arrowGame.factor / 2) + 460, 500, 960, 500, false, 1, 1, 0.05f));

        // 2nd row
        elements.add(new Element("keyu", "keyu.png", (int) (arrowGame.landscapeWidth * arrowGame.factor / 2) - 500, 380, 0, 380, false, 1, 1, 0.05f));
        elements.add(new Element("keyi", "keyi.png", (int) (arrowGame.landscapeWidth * arrowGame.factor / 2) - 380, 380, 120, 380, false, 1, 1, 0.05f));
        elements.add(new Element("keyo", "keyo.png", (int) (arrowGame.landscapeWidth * arrowGame.factor / 2) - 260, 380, 240, 380, false, 1, 1, 0.05f));
        elements.add(new Element("keyp", "keyp.png", (int) (arrowGame.landscapeWidth * arrowGame.factor / 2) - 140, 380, 360, 380, false, 1, 1, 0.05f));
        elements.add(new Element("key4", "key4.png", (int) (arrowGame.landscapeWidth * arrowGame.factor / 2) + 220, 380, 720, 380, false, 1, 1, 0.05f));
        elements.add(new Element("key5", "key5.png", (int) (arrowGame.landscapeWidth * arrowGame.factor / 2) + 340, 380, 840, 380, false, 1, 1, 0.05f));
        elements.add(new Element("key6", "key6.png", (int) (arrowGame.landscapeWidth * arrowGame.factor / 2) + 460, 380, 960, 380, false, 1, 1, 0.05f));

        // 3rd row
        elements.add(new Element("keya", "keya.png", (int) (arrowGame.landscapeWidth * arrowGame.factor / 2) - 500, 260, 0, 260, false, 1, 1, 0.05f));
        elements.add(new Element("keys", "keys.png", (int) (arrowGame.landscapeWidth * arrowGame.factor / 2) - 380, 260, 120, 260, false, 1, 1, 0.05f));
        elements.add(new Element("keyd", "keyd.png", (int) (arrowGame.landscapeWidth * arrowGame.factor / 2) - 260, 260, 240, 260, false, 1, 1, 0.05f));
        elements.add(new Element("keyf", "keyf.png", (int) (arrowGame.landscapeWidth * arrowGame.factor / 2) - 140, 260, 360, 260, false, 1, 1, 0.05f));
        elements.add(new Element("key1", "key1.png", (int) (arrowGame.landscapeWidth * arrowGame.factor / 2) + 220, 260, 720, 260, false, 1, 1, 0.05f));
        elements.add(new Element("key2", "key2.png", (int) (arrowGame.landscapeWidth * arrowGame.factor / 2) + 340, 260, 840, 260, false, 1, 1, 0.05f));
        elements.add(new Element("key3", "key3.png", (int) (arrowGame.landscapeWidth * arrowGame.factor / 2) + 460, 260, 960, 260, false, 1, 1, 0.05f));

        //4th row
        elements.add(new Element("keyg", "keyg.png", (int) (arrowGame.landscapeWidth * arrowGame.factor / 2) - 500, 140, 0, 140, false, 1, 1, 0.05f));
        elements.add(new Element("keyh", "keyh.png", (int) (arrowGame.landscapeWidth * arrowGame.factor / 2) - 380, 140, 120, 140, false, 1, 1, 0.05f));
        elements.add(new Element("keyj", "keyj.png", (int) (arrowGame.landscapeWidth * arrowGame.factor / 2) - 260, 140, 240, 140, false, 1, 1, 0.05f));
        elements.add(new Element("keyk", "keyk.png", (int) (arrowGame.landscapeWidth * arrowGame.factor / 2) - 140, 140, 360, 140, false, 1, 1, 0.05f));
        elements.add(new Element("keyl", "keyl.png", (int) (arrowGame.landscapeWidth * arrowGame.factor / 2) - 20, 140, 480, 140, false, 1, 1, 0.05f));
        elements.add(new Element("key0", "key0.png", (int) (arrowGame.landscapeWidth * arrowGame.factor / 2) + 220, 140, 720, 140, false, 1, 1, 0.05f));
        elements.add(new Element("keyback", "keydelete.png", (int) (arrowGame.landscapeWidth * arrowGame.factor / 2) + 340, 140, 840, 140, false, 1, 1, 0.05f));
        elements.add(new Element("keyup", "keyup.png", (int) (arrowGame.landscapeWidth * arrowGame.factor / 2) + 460, 140, 960, 140, false, 1, 1, 0.05f));

        // 5th row
        elements.add(new Element("keyz", "keyz.png", (int) (arrowGame.landscapeWidth * arrowGame.factor / 2) - 500, 20, 0, 20, false, 1, 1, 0.05f));
        elements.add(new Element("keyx", "keyx.png", (int) (arrowGame.landscapeWidth * arrowGame.factor / 2) - 380, 20, 120, 20, false, 1, 1, 0.05f));
        elements.add(new Element("keyc", "keyc.png", (int) (arrowGame.landscapeWidth * arrowGame.factor / 2) - 260, 20, 240, 20, false, 1, 1, 0.05f));
        elements.add(new Element("keyv", "keyv.png", (int) (arrowGame.landscapeWidth * arrowGame.factor / 2) - 140, 20, 360, 20, false, 1, 1, 0.05f));
        elements.add(new Element("keyb", "keyb.png", (int) (arrowGame.landscapeWidth * arrowGame.factor / 2) - 20, 20, 480, 20, false, 1, 1, 0.05f));
        elements.add(new Element("keyn", "keyn.png", (int) (arrowGame.landscapeWidth * arrowGame.factor / 2) + 100, 20, 600, 20, false, 1, 1, 0.05f));
        elements.add(new Element("keym", "keym.png", (int) (arrowGame.landscapeWidth * arrowGame.factor / 2) + 220, 20, 720, 20, false, 1, 1, 0.05f));
        elements.add(new Element("keyenter", "keyenter.png", (int) (arrowGame.landscapeWidth * arrowGame.factor / 2) + 340, 20, 840, 20, false, 1, 1, 0.05f));
        elements.add(new Element("keycancel", "keycancel.png", (int) (arrowGame.landscapeWidth * arrowGame.factor / 2) + 460, 20, 960, 20, false, 1, 1, 0.05f));

        elements.add(new Element("writingField", "writingfield2.png", (int) (arrowGame.landscapeWidth * arrowGame.factor / 2) - 500, 620, 0, 620, false, 1, 1, 0.05f));

        elements.add(new Element("keyClicked", "keyClicked.png", (int) (arrowGame.landscapeWidth * arrowGame.factor / 2) - 500, 20, 0, 20, false, 1, 1, 0.05f));


        for (int i = 0; i < Constants.ARROWS_AMOUNT; i++) {
            elements.add(new Element("arrow", "arrow6.png", 200, 200, 1, 10, 0.05f));
            getLastEl(elements).setToDraw(false);
//        gamePanel.images.add(new Screen("arrow", BitmapFactory.decodeResource(gamePanel.getResources(), R.drawable.apple, gamePanel.options), -1, 1, randomNumber(200, 10), 200, 50, 50, -1, 1, 200, 1, 160));
            getLastEl(elements).addNumericalVariable("inMove", 0);
            getLastEl(elements).addNumericalVariable("actAngle", 0);
            getLastEl(elements).addNumericalVariable("inApple", 0);
            getLastEl(elements).addNumericalVariable("inEye", 0);
            getLastEl(elements).addNumericalVariable("place", 0);
            // 0 - quiver, 1- shoot, 2- in eye, 3-in tree, 4 - in ground, 5 - disappearing
            getLastEl(elements).addNumericalVariable("vX", -10000.0d);
            getLastEl(elements).addNumericalVariable("vY", -10000.0d);
            getLastEl(elements).addNumericalVariable("initialX", -10000);
            getLastEl(elements).addNumericalVariable("initialY", -10000);
            getLastEl(elements).addNumericalVariable("elapsedTime", 0.0d);
            getLastEl(elements).addNumericalVariable("isShoot", -1);
            getLastEl(elements).addNumericalVariable("flyingDuration", 0);
            getLastEl(elements).addNumericalVariable("prevX", -10000);
            getLastEl(elements).addNumericalVariable("prevY", -10000);
            getLastEl(elements).addNumericalVariable("startShoot", 0);
            getLastEl(elements).addNumericalVariable("ID", i);
            getLastEl(elements).addNumericalVariable("startPower", 0);
            getLastEl(elements).addNumericalVariable("startAngle", -10000);
            getLastEl(elements).addNumericalVariable("angleArrowCalcTime", 0);
        }

        elements.add(new Element("keyboard", "keyboard3.gif", 0, 50, 1, 1, 0.05f));
        getLastEl(elements).setX((int) (Constants.SCREEN_WIDTH * arrowGame.factor / 2) - getLastEl(elements).getTexture().getRegionWidth() / 2);
        getLastEl(elements).setToDraw(false);

//        elements.add(new Element("writingField", "writingfield.png", 0, 50, 1, 1, 0.05f));
//        getLastEl(elements).setToDraw(false);
        elements.add(new Element("writingFieldUpper", "writingfield.png", 0, 50, 1, 1, 0.05f));
        getLastEl(elements).setToDraw(false);

//        texts.put("START", new Text("START", Color.BLACK, 3.0f, (int) (Constants.SCREEN_WIDTH * arrowGame.factor / 2), (int) (Constants.SCREEN_HEIGHT * arrowGame.factor / 2) - 100, 0, System.nanoTime(), 10000, true));
//        texts.put("Power", new Text("Power: ", Color.RED, 3.0f, 100, 1000, 0, System.nanoTime(), 10000, true));
//        texts.put("Angle", new Text("Angle: ", Color.YELLOW, 3.0f, (int) ((float) Constants.SCREEN_WIDTH * arrowGame.factor - 400), 1000, 0, System.nanoTime(), 10000, true));
//        texts.put("singlePlayer", new Text("Single player mode", Color.BLACK, 2.0f, 400, 700, 0, System.nanoTime(), 10000, true));
//        texts.put("versus", new Text("Versus mode", Color.BLACK, 3.0f, 400, 600, 0, System.nanoTime(), 10000, true));
        texts.put("gameName", new Text("Game Id: ", Color.BLACK, 3.0f, 400, 700, 0, System.nanoTime(), 10000, true));
        texts.put("playersAmount", new Text("Players amount: ", Color.BLACK, 3.0f, 400, 600, 0, System.nanoTime(), 10000, true));
//        texts.put("friendId", new Text("Fiend online Id: ", Color.YELLOW, 2.0f, 400, 500, 0, System.nanoTime(),  10000, true));

        texts.put("tap to", new Text("Tap to start", Color.BLACK, 3.0f, 900, 550, 300, 1000, 0, System.nanoTime(), 10000, true));
        texts.put("yourTurn", new Text("Your turn", Color.RED, 2.5f, arrowGame.landscapeWidth / 2 - 200, (int) ((float) arrowGame.landscapeHeight * arrowGame.factor - 100), arrowGame.portraitWidth / 2 - 100, (int) ((float) arrowGame.portraitHeight * arrowGame.factor - 100), 0, System.nanoTime(), 5000, true));

        texts.put("newGame", new Text("Host", Color.BLACK, 3.0f, (int) (arrowGame.landscapeWidth * arrowGame.factor / 5), (int) ((float) arrowGame.landscapeHeight * arrowGame.factor * 2 / 3), (int) (arrowGame.portraitWidth * arrowGame.factor / 5), (int) ((float) arrowGame.portraitHeight * arrowGame.factor * 2 / 3), 0, System.nanoTime(), 10000, true));
        texts.put("joinGame", new Text("Guest", Color.BLACK, 3.0f, arrowGame.landscapeWidth * 2 / 3, (int) ((float) arrowGame.landscapeHeight * arrowGame.factor * 2 / 3), arrowGame.portraitWidth * 2 / 3, (int) ((float) arrowGame.portraitHeight * arrowGame.factor * 2 / 3), 0, System.nanoTime(), 10000, true));
        texts.put("enterGameName", new Text("Prepare the game", Color.BLACK, 3.0f, 500, 1000, 100, 1900, 0, System.nanoTime(), 10000, true));
        texts.put("enterFriendId", new Text("Host Id:", Color.BLACK, 3.0f, 500, 800, 100, 1500, 0, System.nanoTime(), 10000, true));
        texts.put("playerName", new Text("Player name: ", Color.BLACK, 3.0f, 600, 600, 100, 1500, 0, System.nanoTime(), 10000, true));
        texts.put("yourName", new Text("Your name: ", Color.BLACK, 3.0f, 500, 700, 100, 1400, 0, System.nanoTime(), 10000, true));
        texts.put("onlineId", new Text("Online Id: ", Color.BLACK, 3.0f, 600, 700, 100, 1400, 0, System.nanoTime(), 10000, true));
        texts.put("password", new Text("Password: ", Color.BLACK, 3.0f, 600, 500, 100, 1300, 0, System.nanoTime(), 10000, true));
        texts.put("lookingForGames", new Text("Looking for games...", Color.BLACK, 3.0f, 400, 700, 200, 700, 0, System.nanoTime(), 10000, true));
        texts.put("waitingForOpponents", new Text("Connecting...", Color.BLACK, 3.0f, 400, 700, 100, 1000, 0, System.nanoTime(), 10000, true));
        texts.put("checkingPassword", new Text("Entering game...", Color.BLACK, 3.0f, 400, 700, 100, 1000, 0, System.nanoTime(), 10000, true));
        texts.put("foundedOpponents", new Text("Waiting for players...", Color.BLACK, 3.0f, 100, 900, 100, 1500, 0, System.nanoTime(), 10000, true));
        texts.put("getReady", new Text("Get ready...", Color.BLACK, 3.0f, 400, 700, 100, 1000, 0, System.nanoTime(), 10000, true));
        texts.put("confirm", new Text("- Confirm -", Color.BLACK, 3.0f, 800, 200, 400, 900, 0, System.nanoTime(), 10000, true));
        texts.put("login", new Text("- Join game -", Color.BLACK, 3.0f, 1000, 300, 300, 500, 0, System.nanoTime(), 10000, true));
        texts.put("startVersusGame", new Text("- Start Game -", Color.BLACK, 3.0f, 1000, 300, 400, 300, 0, System.nanoTime(), 10000, true));
        texts.put("chooseGame", new Text("Enter game name", Color.BLACK, 3.0f, 500, 900, 0, System.nanoTime(), 10000, true));
        texts.put("enterPasswordAndPlayerName", new Text("Check your name", Color.BLACK, 3.0f, 500, 1000, 100, 1700, 0, System.nanoTime(), 10000, true));
        texts.put("restart", new Text("- Restart -", Color.BLACK, 3.0f, 1700, 500, 0, System.nanoTime(), 10000, true));
        texts.put("currentPlayer", new Text("Current player: ", Color.BLACK, 2.0f, 100, (int) ((float) arrowGame.landscapeHeight * arrowGame.factor - 200), 100, (int) ((float) arrowGame.portraitHeight * arrowGame.factor - 200), 0, System.nanoTime(), 10000, true));
    }

    private static void makeCollisionMatrix(Element element, String desc, ArrowGame arrowGame) {
        Texture texture = element.getTexture().getTexture();
        if (!texture.getTextureData().isPrepared()) {
            texture.getTextureData().prepare();
        }
        Pixmap currentPixmap = texture.getTextureData().consumePixmap();
        arrowGame.collisionMatrixWeb.put(desc, currentPixmap);
        System.out.println("matrix h/w: " + currentPixmap.getHeight() + "/" + currentPixmap.getWidth());

//        int framesAmount = element.getAnimation().getFrames().size;
//        Texture wholeImage = element.getTexture().getTexture();
//        int currentFrame = 0;
//
//        for (int x = 0; x < framesAmountX; x++) {
//            for (int y = 0; y < framesAmountY; y++) {
//                TextureRegion textureRegion = new TextureRegion(wholeImage, x * sizeX, y * sizeY, sizeX, sizeY);
//                Texture texture = textureRegion.getTexture();
//
//                if (!texture.getTextureData().isPrepared()) {
//                    texture.getTextureData().prepare();
//                }
//                Pixmap currentPixmap = texture.getTextureData().consumePixmap();
//                arrowGame.collisionMatrixWeb.add(currentFrame, currentPixmap);
//                currentFrame ++;
//
//                if (currentFrame == framesAmount)
//                    break;
//
//                System.out.println("textureRegion height" + textureRegion.getRegionHeight());
//                System.out.println("texture height" + texture.getHeight());
//                System.out.println("pixmap height" + currentPixmap.getHeight());

//            TextureRegion textureRegion = element.getTexture(i);
//            System.out.println("texture height: " + textureRegion.getRegionHeight());
//            System.out.println("texture width: " + textureRegion.getRegionWidth());
//
//            Texture texture = textureRegion
//
//            System.out.println("texturedata height" + textureData.getHeight());

//            if (!texture.getTextureData().isPrepared()) {
//                texture.getTextureData().prepare();
//            }
//
//            Pixmap currentPixmap = texture.getTextureData().consumePixmap();
//            System.out.println("pixmap height " + currentPixmap.getHeight());
//            arrowGame.collisionMatrixWeb.add(i, currentPixmap);
//            System.out.println("current consumed frame: " + i);
    }

    static Element getLastEl(ArrayList<Element> elements) {
        return elements.get(elements.size() - 1);
    }

    static Element searchObj(String name, ArrowGame play) {
        for (Element img : play.elements)
            if (img.getDesc().equals(name))
                return img;

        return null;
    }

    public static int randomNumber(int start, int range) {
        int number = -1;
        Random r = new Random();
        number = r.nextInt(range) + start;
        return number;
    }

    static Text getLastText(Map<String, Text> texts, String key) {
        return texts.get(key);
    }
}
