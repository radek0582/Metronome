package com.doga.game;

import android.util.JsonToken;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.backends.android.AndroidAudio;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.Random;

import javax.microedition.khronos.opengles.GL10;


public class Update {
    public void update(ArrowGame arrowGame) {
//        if (arrowGame.musicList.get(0).isPlaying() == false) {
//            arrowGame.musicList.get(0).setVolume(0.99f);
//            arrowGame.musicList.get(0).play();
//        }

        if (arrowGame.makeBeatSound) {
//            arrowGame.musicList.get(1).setVolume(0.99f);
//            arrowGame.musicList.get(1).play();
//            arrowGame.musicList.get(1).setLooping(false);
            arrowGame.makeBeatSound = false;


//            if (arrowGame.soundList.get(0) != null) {
//                arrowGame.soundId = arrowGame.soundList.get(0).play(1.0f);
//
////            arrowGame.soundList.get(0).setPitch(arrowGame.soundId, 0);
//                arrowGame.soundList.get(0).setLooping(arrowGame.soundId, false);
//
//            }

//            arrowGame.manager.get("t2.ogg", Sound.class).stop();
            arrowGame.manager.get("t2.ogg", Sound.class).play();
            System.out.println("played at " + System.currentTimeMillis());
//            arrowGame.gameMessage = searchObj("pendulum", arrowGame).getStringVariableValue("direction");
        }
//       arrowGame.lightX--;

        Element torch = searchObj("torch", arrowGame);
        int torchX = torch.getX();
        int torchY = torch.getY();
//        torch.setX(torchX - 1);

        Element torch2 = searchObj("torch2", arrowGame);
        int torch2X = torch2.getX();
        int torch2Y = torch2.getY();

        Element firefly = searchObj("firefly", arrowGame);
        int fireflyX = firefly.getX();
        int fireflyY = firefly.getY();

//        if (fireflyX > 4096) {
//            searchObj("blinkyBkg", arrowGame).setX(6144);
//            searchObj("blinkyBkg3", arrowGame).setX(6144);
//        }
        Element powerBlock = searchObj("powerBlock", arrowGame);
        float maskScale = 2f;
        maskScale = (float) powerBlock.getY() / (float) 1080 + (float) 1;
        arrowGame.maskScaleX = arrowGame.maskScaleY = maskScale;

        arrowGame.bpm = (int) ((float) powerBlock.getY() / (float) 8 + (float) 1);
        arrowGame.sliderY = 800 - arrowGame.bpm * 2;

        Element energyBox = searchObj("energyBox", arrowGame);
        float energyUsage = maskScale;
        arrowGame.energyTimeCounter--;

        if (arrowGame.energyTimeCounter == 0) {
            arrowGame.energyTimeCounter = 10;
            int energyBoxY = energyBox.getY() - (int) (energyUsage * energyUsage);
            energyBox.setY(energyBoxY);
        }

//        arrowGame.maskBuff.begin();
//        Gdx.gl.glClearColor(255, 255, 255, 0);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//        arrowGame.spriteBatch.begin();

//        if (arrowGame.currentOrientation.equals("landscape")) {
//            arrowGame.maskFactor = (float) Gdx.graphics.getWidth() / Gdx.graphics.getHeight();
//            arrowGame.maskHeightFactor = (float) arrowGame.coverSpriteHeight / 1080;
//            arrowGame.maskWidthFactor = (float) arrowGame.coverSpriteWidth / Gdx.graphics.getWidth();
//            //            arrowGame.spriteBatch.draw(arrowGame.testMask,
////                    (2000) * arrowGame.factor / arrowGame.maskWidthFactor,
////                    1080 - (900 + (float) arrowGame.testMaskHeight / 2 + (float) firefly.getTexture().getRegionHeight() / 2) / arrowGame.maskHeightFactor,
////                    0, 0,
////                    arrowGame.testMaskWidth * arrowGame.maskFactor / arrowGame.maskHeightFactor,
////                    arrowGame.testMaskHeight / arrowGame.maskHeightFactor,
////                    1, 1, 0, 0, 0,
////                    arrowGame.testMaskWidth, arrowGame.testMaskHeight, false, true);       // 1050: test x position
//            arrowGame.spriteBatch.draw(arrowGame.bulbMask, (torchX - arrowGame.cameraShiftX + (float) torch.getTexture().getRegionWidth() / 2 - (float) arrowGame.bulbMaskWidth / 2) * arrowGame.factor / arrowGame.maskWidthFactor, 1080 - (torchY -arrowGame.cameraShiftY + (float) arrowGame.bulbMaskHeight / 2 + (float) torch.getTexture().getRegionHeight() / 2) / arrowGame.maskHeightFactor, 0, 0, arrowGame.bulbMaskWidth * arrowGame.maskFactor / arrowGame.maskHeightFactor, arrowGame.bulbMaskHeight / arrowGame.maskHeightFactor, 1, 1, 0, 0, 0, arrowGame.bulbMaskWidth, arrowGame.bulbMaskHeight, false, true);
//
//            arrowGame.spriteBatch.draw(arrowGame.smallBulbMask, (torch2X - arrowGame.cameraShiftX + (float) torch2.getTexture().getRegionWidth() / 2 - (float) arrowGame.smallBulbMaskWidth / 2) * arrowGame.factor / arrowGame.maskWidthFactor, 1080 - (torch2Y -arrowGame.cameraShiftY + (float) arrowGame.smallBulbMaskHeight / 2 + (float) torch2.getTexture().getRegionHeight() / 2) / arrowGame.maskHeightFactor, 0, 0, arrowGame.smallBulbMaskWidth * arrowGame.maskFactor / arrowGame.maskHeightFactor, arrowGame.smallBulbMaskHeight / arrowGame.maskHeightFactor, 1, 1, 0, 0, 0, arrowGame.smallBulbMaskWidth, arrowGame.smallBulbMaskHeight, false, true);
//
//            arrowGame.spriteBatch.draw(arrowGame.viewMask,
//                    (fireflyX - arrowGame.cameraShiftX + (float) firefly.getTexture().getRegionWidth() / 2 - (float) arrowGame.viewMaskWidth * arrowGame.maskScaleX / 2) * arrowGame.factor / arrowGame.maskWidthFactor,
//                    1080 - (fireflyY -arrowGame.cameraShiftY + (float) arrowGame.viewMaskHeight * arrowGame.maskScaleY / 2 + (float) firefly.getTexture().getRegionHeight() / 2)  / arrowGame.maskHeightFactor, 0, 0,
//                    arrowGame.viewMaskWidth * arrowGame.maskScaleX * arrowGame.maskFactor / arrowGame.maskHeightFactor,
//                    arrowGame.viewMaskHeight * arrowGame.maskScaleY / arrowGame.maskHeightFactor,
//                    arrowGame.maskScaleX, arrowGame.maskScaleY, 0, 0, 0,
//                    (int)((float)arrowGame.viewMaskWidth * arrowGame.maskScaleX), (int)((float)arrowGame.viewMaskHeight * arrowGame.maskScaleY), false, true);
//        } else{
//            arrowGame.maskFactor = (float) Gdx.graphics.getHeight() / Gdx.graphics.getWidth();
//            arrowGame.maskHeightFactor = (float) arrowGame.coverSpriteHeight / Gdx.graphics.getHeight();
//            arrowGame.maskWidthFactor = (float) arrowGame.coverSpriteWidth / Gdx.graphics.getWidth();
//
//            arrowGame.spriteBatch.draw(arrowGame.viewMask,
//                    (fireflyX + arrowGame.rotationShiftX - arrowGame.cameraShiftX + (float) firefly.getTexture().getRegionWidth() / 2 - (float) arrowGame.viewMaskWidth * arrowGame.maskScaleX / 2) * arrowGame.factor / arrowGame.maskWidthFactor,
//                    Gdx.graphics.getHeight() * arrowGame.factor - (arrowGame.rotationShiftY -arrowGame.cameraShiftY + fireflyY + (float) arrowGame.viewMaskHeight * arrowGame.maskScaleY / 2 + (float) firefly.getTexture().getRegionHeight() / 2) * arrowGame.factor / arrowGame.maskHeightFactor,
//                    0, 0,
//                    arrowGame.viewMaskWidth * arrowGame.maskScaleX * arrowGame.factor / arrowGame.maskWidthFactor,
//                    arrowGame.viewMaskHeight * arrowGame.maskScaleY * arrowGame.factor / arrowGame.maskHeightFactor,
//                    arrowGame.maskScaleX, arrowGame.maskScaleY, 0, 0, 0,
//                    (int)((float)arrowGame.viewMaskWidth * arrowGame.maskScaleX), (int)((float)arrowGame.viewMaskHeight * arrowGame.maskScaleY), false, true);
//
//            arrowGame.spriteBatch.draw(arrowGame.smallBulbMask,
//                    (torch2X + arrowGame.rotationShiftX - arrowGame.cameraShiftX + (float) torch2.getTexture().getRegionWidth() / 2 - (float) arrowGame.smallBulbMaskWidth / 2) * arrowGame.factor / arrowGame.maskWidthFactor,
//                    Gdx.graphics.getHeight() * arrowGame.factor - (arrowGame.rotationShiftY - arrowGame.cameraShiftY + torch2Y + (float) arrowGame.smallBulbMaskHeight / 2 + (float) torch2.getTexture().getRegionHeight() / 2) * arrowGame.factor / arrowGame.maskHeightFactor,
//                    0, 0,
//                    arrowGame.smallBulbMaskWidth * arrowGame.factor / arrowGame.maskWidthFactor,
//                    arrowGame.smallBulbMaskHeight * arrowGame.factor / arrowGame.maskHeightFactor,
//                    1, 1, 0, 0, 0,
//                    arrowGame.smallBulbMaskWidth, arrowGame.smallBulbMaskHeight, false, true);
//
//            arrowGame.spriteBatch.draw(arrowGame.bulbMask,
//                    (torchX + arrowGame.rotationShiftX - arrowGame.cameraShiftX + (float) torch.getTexture().getRegionWidth() / 2 - (float) arrowGame.bulbMaskWidth / 2) * arrowGame.factor / arrowGame.maskWidthFactor,
//                    Gdx.graphics.getHeight() * arrowGame.factor - (arrowGame.rotationShiftY - arrowGame.cameraShiftY + torchY + (float) arrowGame.bulbMaskHeight / 2 + (float) torch.getTexture().getRegionHeight() / 2) * arrowGame.factor / arrowGame.maskHeightFactor,
//                    0, 0,
//                    arrowGame.bulbMaskWidth * arrowGame.factor / arrowGame.maskWidthFactor,
//                    arrowGame.bulbMaskHeight * arrowGame.factor / arrowGame.maskHeightFactor,
//                    1, 1, 0, 0, 0,
//                    arrowGame.bulbMaskWidth, arrowGame.bulbMaskHeight, false, true);
//
////            arrowGame.gameMessage = "wxh: " + Gdx.graphics.getWidth() + ", " + Gdx.graphics.getHeight();
//
//  // 1050: test x position
//        }
//        arrowGame.spriteBatch.end();
//        arrowGame.maskBuff.end();

//        searchObj("torch", arrowGame).setX(2953 / 2 + arrowGame.lightX);

        if (arrowGame.screenOrientationDegrees != Gdx.input.getRotation() && !arrowGame.refreshOrientation) {
            arrowGame.refreshOrientation = true;

            if (arrowGame.screenOrientationDegrees - Gdx.input.getRotation() == 0 || arrowGame.screenOrientationDegrees - Gdx.input.getRotation() == -180
                    || arrowGame.screenOrientationDegrees - Gdx.input.getRotation() == 180) {
                arrowGame.desiredOrientation = arrowGame.currentOrientation;
            } else {
                if (arrowGame.currentOrientation.equals("landscape")) {
                    arrowGame.desiredOrientation = "portrait";
                } else {
                    arrowGame.desiredOrientation = "landscape";
                }
            }
        }

        if (arrowGame.refreshOrientation) {
            arrowGame.rotationCounter++;
            System.out.println("rotation counter" + arrowGame.rotationCounter);
            if (arrowGame.desiredOrientation.equals("landscape")) {
                if (Gdx.graphics.getWidth() >= Gdx.graphics.getHeight())
                    arrowGame.refreshOrientationFinal = true;
            } else {
                if (Gdx.graphics.getWidth() <= Gdx.graphics.getHeight())
                    arrowGame.refreshOrientationFinal = true;
            }
        }

        if (arrowGame.refreshOrientationFinal) {
            arrowGame.rotationCounter = 0;
            if (arrowGame.desiredOrientation.equals("landscape")) {         // landscape
                for (Map.Entry<String, Text> text : arrowGame.texts.entrySet()) {
                    int x = text.getValue().getLandscapeX();
                    int y = text.getValue().getLandscapeY();
                    text.getValue().setX(x);
                    text.getValue().setY(y);
                }

                for (Element el : arrowGame.elements) {
                    if (!el.isTransformable()) {
                        el.setX(el.getLandscapeX());
                        el.setY(el.getLandscapeY());
                    }
                }

                int newX, newY;
                arrowGame.factor = 1080 / (float) Gdx.graphics.getHeight();
                newY = (int) (Gdx.graphics.getHeight() * arrowGame.factor);
                newX = (int) (Gdx.graphics.getWidth() * arrowGame.factor);
                arrowGame.cam.viewportWidth = newX;
                arrowGame.cam.viewportHeight = (float) newY;
                arrowGame.cam.position.x = (float) newX / (float) 2;
                arrowGame.cam.position.y = (float) newY / (float) 2;
                arrowGame.transitionX = (int) (((float) Gdx.graphics.getWidth() - (float) Gdx.graphics.getWidth() * arrowGame.zoomModifier) / 2f * arrowGame.factor);
                arrowGame.transitionY = (int) (((float) Gdx.graphics.getHeight() - (float) Gdx.graphics.getHeight() * arrowGame.zoomModifier) / 2f * arrowGame.factor);

                if (arrowGame.currentOrientation.equals("portrait")) {
                    arrowGame.rotationShiftY = 0;
                    arrowGame.rotationShiftX = 0;
                }

                arrowGame.currentOrientation = "landscape";
                arrowGame.screenOrientationDegrees = Gdx.input.getRotation();
                arrowGame.refreshOrientationFinal = false;
                arrowGame.refreshOrientation = false;

//                arrowGame.gameMessage = arrowGame.currentOrientation + ", WD, HE, fac:" + Gdx.graphics.getWidth() + ", " + Gdx.graphics.getHeight() + ", " + arrowGame.factor;
                System.out.println("landscape");
                System.out.println("factor " + arrowGame.factor + "newX " + newX + " newY " + newY);
                System.out.println("screen width: " + Gdx.graphics.getWidth() + " scr height " + Gdx.graphics.getHeight());
                System.out.println("Constants.SCREEN_WIDTH: " + Constants.SCREEN_WIDTH + ", HEIGHT: " + Constants.SCREEN_HEIGHT);
                System.out.println("rotation" + Gdx.input.getRotation());
                System.out.println("curHeight & width: " + Gdx.graphics.getHeight() + ", " + Gdx.graphics.getWidth());

            } else if (arrowGame.desiredOrientation.equals("portrait")) {                  // portrait
                for (Map.Entry<String, Text> text : arrowGame.texts.entrySet()) {
                    int x = text.getValue().getPortraitX();
                    int y = text.getValue().getPortraitY();
                    text.getValue().setX(x);
                    text.getValue().setY(y);
                }

                for (Element el : arrowGame.elements) {
                    if (!el.isTransformable()) {
                        el.setX(el.getPortraitX());
                        el.setY(el.getPortraitY());
                    }
                }

//                arrowGame.factor = 2340 / (float) Gdx.graphics.getHeight();
                arrowGame.factor = 1080 / (float) Gdx.graphics.getWidth();
                int newY = (int) (Gdx.graphics.getHeight() * arrowGame.factor);
                int newX = (int) (Gdx.graphics.getWidth() * arrowGame.factor);
                System.out.println("factor " + arrowGame.factor + "newX " + newX + " newY " + newY);
                System.out.println("screen width: " + Gdx.graphics.getWidth() + " scr height " + Gdx.graphics.getHeight());
                System.out.println("Constants.SCREEN_WIDTH: " + Constants.SCREEN_WIDTH + ", HEIGHT: " + Constants.SCREEN_HEIGHT);
                arrowGame.cam.viewportWidth = newX;
                arrowGame.cam.viewportHeight = newY;
                arrowGame.cam.position.x = (float) newX / (float) 2;
                arrowGame.cam.position.y = (float) newY / (float) 2;
                System.out.println("curHeight & width: " + Gdx.graphics.getHeight() + ", " + Gdx.graphics.getWidth());
                System.out.println("switched to portrait");
                System.out.println("rotation" + Gdx.input.getRotation());
                arrowGame.transitionX = (int) (((float) Gdx.graphics.getWidth() - (float) Gdx.graphics.getWidth() * arrowGame.zoomModifier) / 2f * arrowGame.factor);
                arrowGame.transitionY = (int) (((float) Gdx.graphics.getHeight() - (float) Gdx.graphics.getHeight() * arrowGame.zoomModifier) / 2f * arrowGame.factor);

                if (arrowGame.currentOrientation.equals("landscape")) {
                    arrowGame.rotationShiftX = (int) (((float) (Gdx.graphics.getWidth() - Gdx.graphics.getHeight()) * arrowGame.factor / 2));
                    arrowGame.rotationShiftY = (int) (((float) (Gdx.graphics.getHeight() - Gdx.graphics.getWidth()) * arrowGame.factor / 2));
                }

                arrowGame.currentOrientation = "portrait";
                arrowGame.screenOrientationDegrees = Gdx.input.getRotation();
                arrowGame.refreshOrientationFinal = false;
                arrowGame.refreshOrientation = false;

//                arrowGame.gameMessage = arrowGame.currentOrientation + ", WD, HE, fac:" + Gdx.graphics.getWidth() + ", " + Gdx.graphics.getHeight() + ", " + arrowGame.factor;
            }
        }

        if (true) {
            if (arrowGame.zoomingPhase == 1)
                arrowGame.zoomIteration++;

            if (arrowGame.zoomIteration >= 1) {
                arrowGame.zoomIteration = 0;
                arrowGame.zoomingPhase = 2;

                if (arrowGame.distanceDelta < 0) {
                    if (arrowGame.zoomLevel < 20)
                        arrowGame.zoomLevel++;
                } else if (arrowGame.distanceDelta > 0) {
                    if (arrowGame.zoomLevel > 1)
                        arrowGame.zoomLevel--;
                }

                if (arrowGame.distanceDelta != 0) {
                    if (arrowGame.zoomLevel == 10) {
                        arrowGame.cam.zoom = 1f;
                        arrowGame.transitionX = 0;
                        arrowGame.transitionY = 0;
                        arrowGame.zoomTranslation = 1f;
                    } else if (arrowGame.zoomLevel < 10) {
                        arrowGame.zoomModifier = 1f - 0.02f * arrowGame.zoomLevel;
                        arrowGame.cam.zoom = arrowGame.zoomModifier;
//                        arrowGame.transitionX = (int) (((float) Constants.SCREEN_WIDTH - (float) Constants.SCREEN_WIDTH * arrowGame.zoomModifier) / 2f * arrowGame.factor);
//                        arrowGame.transitionY = (int) (((float) Constants.SCREEN_HEIGHT - (float) Constants.SCREEN_HEIGHT * arrowGame.zoomModifier) / 2f * arrowGame.factor);

                        arrowGame.transitionX = (int) (((float) Gdx.graphics.getWidth() - (float) Gdx.graphics.getWidth() * arrowGame.zoomModifier) / 2f * arrowGame.factor);
                        arrowGame.transitionY = (int) (((float) Gdx.graphics.getHeight() - (float) Gdx.graphics.getHeight() * arrowGame.zoomModifier) / 2f * arrowGame.factor);
                        arrowGame.zoomTranslation = arrowGame.zoomModifier;
                    } else {
                        arrowGame.zoomModifier = 1f + 0.02f * arrowGame.zoomLevel;
                        arrowGame.cam.zoom = arrowGame.zoomModifier;
//                        arrowGame.transitionX = (int) (((float) Constants.SCREEN_WIDTH - (float) Constants.SCREEN_WIDTH * arrowGame.zoomModifier) / 2f * arrowGame.factor);
//                        arrowGame.transitionY = (int) (((float) Constants.SCREEN_HEIGHT - (float) Constants.SCREEN_HEIGHT * arrowGame.zoomModifier) / 2f * arrowGame.factor);

                        arrowGame.transitionX = (int) (((float) Gdx.graphics.getWidth() - (float) Gdx.graphics.getWidth() * arrowGame.zoomModifier) / 2f * arrowGame.factor);
                        arrowGame.transitionY = (int) (((float) Gdx.graphics.getHeight() - (float) Gdx.graphics.getHeight() * arrowGame.zoomModifier) / 2f * arrowGame.factor);
                        arrowGame.zoomTranslation = arrowGame.zoomModifier;
                    }
                }
            }
        }

        if (arrowGame.gamePhase == 0) {
//            System.out.println("rotation: " + Gdx.input.getRotation());
            if (arrowGame.musicList.get(0).isPlaying() == false) {
//                arrowGame.musicList.get(0).setVolume(0.5f);
//                arrowGame.musicList.get(0).play();

            }
        } else if (arrowGame.gamePhase == 1100) {
            String playerFileName = "player.dat";
            File playerFile = new File(arrowGame.al.outputDirectory, playerFileName);

            if (playerFile.exists()) {
                arrowGame.playerName = "";
                arrowGame.onlineId = "";
                arrowGame.password = "";

                int length = (int) playerFile.length();

                byte[] bytes = new byte[length];

                FileInputStream in = null;

                try {
                    in = new FileInputStream(playerFile);
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }

                try {
                    in.read(bytes);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                } finally {
                    try {
                        in.close();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                }

                String contents = new String(bytes);

                char ch = ' ';
                int charId = 0;
                System.out.println("fileName contents: " + contents);

                ch = contents.charAt(charId);

                while (ch != '=' && ch != '*') {
                    ch = contents.charAt(charId);
                    charId++;
                }

                while (ch != '.' && ch != '*') {
                    ch = contents.charAt(charId);
                    arrowGame.playerName += ch;
                    charId++;
                    ch = contents.charAt(charId);
                }

                while (ch != '=' && ch != '*') {
                    ch = contents.charAt(charId);
                    charId++;
                }

                while (ch != '.' && ch != '*') {
                    ch = contents.charAt(charId);
                    arrowGame.onlineId += ch;
                    charId++;
                    ch = contents.charAt(charId);
                }

                while (ch != '=' && ch != '*') {
                    ch = contents.charAt(charId);
                    charId++;
                }

                while (ch != '.' && ch != '*') {
                    ch = contents.charAt(charId);
                    arrowGame.password += ch;
                    charId++;
                    ch = contents.charAt(charId);
                }

                if (arrowGame.host) {
                    arrowGame.gamePhase = 4;         // Draw - host game and player data
//                    savePlayerData(arrowGame);
                } else {
                    arrowGame.gamePhase = 1111;       // Draw - guest game and player data
//                    savePlayerData(arrowGame);
                }
                System.out.println("player data received from file: " + arrowGame.playerName + "." + arrowGame.onlineId + "." + arrowGame.password);
            } else {                             // create player data file
                savePlayerData(arrowGame);

                if (arrowGame.host)
                    arrowGame.gamePhase = 4;         // Draw - create (host) game menu and player data
                else
                    arrowGame.gamePhase = 1111;        // Draw - join (guest) game menu and player data
            }
        }

        // HOST

        else if (arrowGame.gamePhase == 5) {
            if (arrowGame.dataHolder.getChanges().get("playersAmount").equals("0")) {
                arrowGame.dataHolder.getChanges().put("playersAmount", "-1");
                arrowGame._FBIC.setRef("players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/playersAmount");
                arrowGame._FBIC.SetOnValueChangedListener1(arrowGame.dataHolder, "playersAmount");
            }

            if (arrowGame.dataHolder.getChanges().get("playersAmount").equals("1")) {
                arrowGame.dataHolder.getChanges().put("playersAmount", "0");
                arrowGame.gamePhase = 11;
            }
        } else if (arrowGame.gamePhase == 11) {
            System.out.println("phase " + arrowGame.gamePhase);
            if (arrowGame.dataHolder.getFound() == 0) {
                arrowGame.dataHolder.setFound(-1);
                arrowGame._FBIC.readData(arrowGame.dataHolder, "", "players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/", "playersList", null);
            }

            if (arrowGame.dataHolder.getFound() == 1) {
                System.out.println("dataH " + arrowGame.dataHolder.getValue());
                arrowGame.gamePhase = 12;
                arrowGame.dataHolder.setFound(0);
            }
        } else if (arrowGame.gamePhase == 12) {      // HOST
//            System.out.println("phase " + arrowGame.gamePhase);
            int plAmnt = Integer.parseInt(arrowGame.dataHolder.getChanges().get("playersAmount"));
            if (plAmnt >= 2) {
                arrowGame.gamePhase = 11;
                arrowGame.dataHolder.getChanges().put("playersAmount", "0");
            }
        } else if (arrowGame.gamePhase == 13) {          // HOST
            retrieveDataNullable(arrowGame, "", "players/" + arrowGame.onlineId + "/games", "list", null);

            if (arrowGame.dataHolder.getFound() == 1) {
                if (arrowGame.playerName.length() < 2 && arrowGame.password.length() < 2) {
                    arrowGame.gamePhase = 4;
                    arrowGame.gameMessage = "Player name and password at least 2 chars!";
                } else if (arrowGame.playerName.length() < 2) {
                    arrowGame.gameMessage = "Player name at least 2 signs!";
                    arrowGame.gamePhase = 4;
                } else if (arrowGame.password.length() < 2) {
                    arrowGame.gameMessage = "Password at least 2 signs!";
                    arrowGame.gamePhase = 4;
                } else if (arrowGame.gameName.length() < 2) {
                    arrowGame.gameMessage = "Game name at least 2 signs!";
                    arrowGame.gamePhase = 4;
                } else if (arrowGame.dataHolder.getValue() != null) {
                    ArrayList<String> arr = toListFromDH(arrowGame.dataHolder.getValue());

                    if (arr != null)
                        for (String s : arr) {
                            if (s.equals(arrowGame.gameName)) {
                                arrowGame.gamePhase = 4;
                                arrowGame.gameMessage = "Game '" + arrowGame.gameName + "' exists! Change name";
                                break;
                            }
                        }
                }

                if (arrowGame.gamePhase != 4)
                    arrowGame.gamePhase = 16;

                arrowGame.dataHolder.setFound(0);
            }
        } else if (arrowGame.gamePhase == 1200) {
            arrowGame.gamePhase = 1201;
            retrieveDataNullable(arrowGame, "", "players/", arrowGame.onlineId, null);
        } else if (arrowGame.gamePhase == 1201) {
//            System.out.println("getfound val " + dataHolder.getFound());

            if (arrowGame.dataHolder.getFound() == 1) {
                if (arrowGame.dataHolder.isFoundEntry()) {        //  already exists - check the password if it is correct
                    ArrayList<String> arr = onlineIdFromDH(arrowGame.dataHolder.getValue());
                    System.out.println("onlineId : " + arr);
                    System.out.println("dupa001");

                    String s = arrowGame.dataHolder.getValue();
                    System.out.println("s -> " + s);
                    int charId = 0;
                    int charIdPass = 0;
                    String password = "";
                    while (s.charAt(charId) != '}') {
                        if (s.charAt(charId) == '=' && s.charAt(charId - 1) == 'd') {
                            charId++;
                            while (s.charAt(charId + charIdPass) != ',' && s.charAt(charId + charIdPass) != '}') {
                                password += s.charAt(charId + charIdPass);
                                charIdPass++;
                            }
                            break;
                        }
                        charId++;
                    }
                    System.out.println("pass: '" + password + "'");

                    if (!password.equals(arrowGame.password)) {
                        System.out.println("wrong password! + " + password + " != " + arrowGame.password);
                        arrowGame.gameMessage = "- WRONG PASSWORD -";
                        arrowGame.gamePhase = 4;
                    } else {
                        arrowGame.gamePhase = 1202;
                        arrowGame.gameMessage = "- Profile " + arrowGame.onlineId + " updated -";
                    }
                } else {
                    arrowGame.gamePhase = 1202;       // new entry of onlineId
                    arrowGame.gameMessage = "- Profile " + arrowGame.onlineId + " created -";
                }

                arrowGame.dataHolder.setFound(0);
            }
        } else if (arrowGame.gamePhase == 1202) {          // sending players data
            arrowGame._FBIC.SetValueInDb(arrowGame.dataHolder, "players/" + arrowGame.onlineId, "");
            arrowGame._FBIC.SetValueInDb(arrowGame.dataHolder, "players/" + arrowGame.onlineId + "/playerName", arrowGame.playerName);
            arrowGame._FBIC.SetValueInDb(arrowGame.dataHolder, "players/" + arrowGame.onlineId + "/password", arrowGame.password);
            arrowGame._FBIC.SetValueInDb(arrowGame.dataHolder, "players/" + arrowGame.onlineId + "/onlineId", arrowGame.onlineId);
//            arrowGame._FBIC.SetValueInDb(arrowGame.dataHolder,"players/list/" + arrowGame.onlineId + "/onlineId", "");
            arrowGame.dataHolder.setVerifiedAmount(4);
            arrowGame.gamePhase = 1013;          // verify sent players data
        } else if (arrowGame.gamePhase == 16) {          // HOST
            arrowGame._FBIC.SetValueInDb(arrowGame.dataHolder, "players/" + arrowGame.onlineId + "/games/list/" + arrowGame.gameName, "");
            arrowGame._FBIC.SetValueInDb(arrowGame.dataHolder, "players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/admin", arrowGame.playerName);
            arrowGame._FBIC.SetValueInDb(arrowGame.dataHolder, "players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/password", arrowGame.password);
            arrowGame._FBIC.SetValueInDb(arrowGame.dataHolder, "players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/sessionStatus", "waiting");
            arrowGame._FBIC.SetValueInDb(arrowGame.dataHolder, "players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/playersList/" + arrowGame.playerName, "");
            arrowGame._FBIC.SetValueInDb(arrowGame.dataHolder, "players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/world/tree", "");
            arrowGame._FBIC.SetValueInDb(arrowGame.dataHolder, "players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/world/eye", "");
            arrowGame._FBIC.SetValueInDb(arrowGame.dataHolder, "players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/" + arrowGame.playerName + "/x", String.valueOf(50));
            arrowGame._FBIC.SetValueInDb(arrowGame.dataHolder, "players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/" + arrowGame.playerName + "/y", String.valueOf(150));
            arrowGame._FBIC.SetValueInDb(arrowGame.dataHolder, "players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/currentPlayer", arrowGame.playerName);
            arrowGame._FBIC.SetValueInDb(arrowGame.dataHolder, "players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/playersAmount", "1");
            arrowGame._FBIC.SetValueInDb(arrowGame.dataHolder, "players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/currentRound", "0");
            arrowGame._FBIC.SetValueInDb(arrowGame.dataHolder, "players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/changedValues", "0");
            arrowGame.dataHolder.setVerifiedAmount(13);
            arrowGame.gamePhase = 1009;      // verify dataholder amount
        } else if (arrowGame.gamePhase == 1009) {  // verify dataholder amount
            if (arrowGame.dataHolder.getVerifiedAmount() == 0) {
                arrowGame.gamePhase = 5;
                arrowGame.dataHolder.getChanges().put("playersAmount", "0");
                System.out.println("data saved and verified.");
            } else if (arrowGame.dataHolder.getVerifiedAmount() <= -1) {
                arrowGame.gamePhase = 16;
                System.out.println("data sending error, retry again");
                arrowGame.dataHolder.setVerifiedAmount(0);
            }
        } else if (arrowGame.gamePhase == 1010) {  // verify dataholder amount
            if (arrowGame.dataHolder.getVerifiedAmount() == 0) {
                arrowGame.gamePhase = 21;
                System.out.println("data saved and verified.");
            } else if (arrowGame.dataHolder.getVerifiedAmount() <= -1) {
                arrowGame.gamePhase = 19;
                System.out.println("data sending error, retry again");
                arrowGame.dataHolder.setVerifiedAmount(0);
            }
        } else if (arrowGame.gamePhase == 1011) {  // verify dataholder amount
            if (arrowGame.dataHolder.getVerifiedAmount() == 0) {
                arrowGame.gamePhase = 23;
                System.out.println("data saved and verified.");
            } else if (arrowGame.dataHolder.getVerifiedAmount() <= -1) {
                arrowGame.gamePhase = 22;
                System.out.println("data sending error, retry again");
                arrowGame.dataHolder.setVerifiedAmount(0);
            }
        } else if (arrowGame.gamePhase == 1012) {  // verify dataholder amount
            if (arrowGame.dataHolder.getVerifiedAmount() == 0) {
                arrowGame.gamePhase = 18;
                arrowGame.dataHolder.getChanges().put("sessionStatus", "unknown");
                System.out.println("data saved and verified.");
            } else if (arrowGame.dataHolder.getVerifiedAmount() <= -1) {
                arrowGame.gamePhase = 9;
                System.out.println("data sending error, retry again");
                arrowGame.dataHolder.setVerifiedAmount(0);
            }
        } else if (arrowGame.gamePhase == 1013) {  // verify dataholder amount
            if (arrowGame.dataHolder.getVerifiedAmount() == 0) {
                arrowGame.gamePhase = 13;
                System.out.println("data saved and verified.");
            } else if (arrowGame.dataHolder.getVerifiedAmount() <= -1) {
                arrowGame.gamePhase = 1202;
                System.out.println("data sending error, retry again");
                arrowGame.dataHolder.setVerifiedAmount(0);
            }
        } else if (arrowGame.gamePhase == 19) {          // HOST
            System.out.println("phase " + arrowGame.gamePhase);
            arrowGame.dataHolder.setVerifiedAmount(5);
            arrowGame._FBIC.SetValueInDb(arrowGame.dataHolder, "players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/sessionStatus", "playing");
            arrowGame._FBIC.SetValueInDb(arrowGame.dataHolder, "players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/world/eye/x", String.valueOf(searchObj("eye", arrowGame).getX()));
            arrowGame._FBIC.SetValueInDb(arrowGame.dataHolder, "players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/world/eye/y", String.valueOf(searchObj("eye", arrowGame).getY()));
            arrowGame._FBIC.SetValueInDb(arrowGame.dataHolder, "players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/world/tree/x", String.valueOf(searchObj("tree", arrowGame).getX()));
            arrowGame._FBIC.SetValueInDb(arrowGame.dataHolder, "players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/world/tree/y", String.valueOf(searchObj("tree", arrowGame).getY()));
            arrowGame.gamePhase = 1010;
        } else if (arrowGame.gamePhase == 21) {          // HOST
            System.out.println("gphase " + arrowGame.gamePhase);
            if (arrowGame.dataHolder.getFound() == 0) {
                arrowGame.dataHolder.setFound(-1);
                arrowGame._FBIC.readData(arrowGame.dataHolder, "", "players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/", "playersList", null);
            }

            if (arrowGame.dataHolder.getFound() == 1) {
                arrowGame.dataHolder.setFound(0);
//                int player = randomNumber(1, 3);
                arrowGame.players = toListFromDH(arrowGame.dataHolder.getValue());
//                int playersAmount = playersList.size();
                Collections.sort(arrowGame.players);

                for (String s : arrowGame.players) {
                    System.out.println("player " + s);
                }

                arrowGame.gamePhase = 22;
            }
        } else if (arrowGame.gamePhase == 22) {        // HOST
            System.out.println("gphase " + arrowGame.gamePhase);
            arrowGame.dataHolder.setVerifiedAmount(4);
            arrowGame._FBIC.SetValueInDb(arrowGame.dataHolder, "players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/" + arrowGame.playerName + "/playerName", arrowGame.playerName);
            arrowGame._FBIC.SetValueInDb(arrowGame.dataHolder, "players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/" + arrowGame.playerName + "/archer", arrowGame.chosenArcher);
            arrowGame._FBIC.SetValueInDb(arrowGame.dataHolder, "players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/" + arrowGame.playerName + "/x", String.valueOf(50));
            arrowGame._FBIC.SetValueInDb(arrowGame.dataHolder, "players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/" + arrowGame.playerName + "/y", String.valueOf(150));
//            arrowGame.gamePhase = 23;
            arrowGame.gamePhase = 1011;
            arrowGame.dataHolder.setFound(-2);
        } else if (arrowGame.gamePhase == 23) {       // HOST
            System.out.println("gphase " + arrowGame.gamePhase);
            int dbSize = arrowGame.players.size() * 4;

            if (arrowGame.dataHolder.getFound() == -2) {
                for (int i = 0; i < arrowGame.players.size(); i++) {
                    arrowGame.dataHolder.getToSearch().put("playerName_" + i, "");
                    arrowGame.dataHolder.getToSearch().put("archer_" + i, "");
                    arrowGame.dataHolder.getToSearch().put("x_" + i, "");
                    arrowGame.dataHolder.getToSearch().put("y_" + i, "");
                }
                arrowGame.dataHolder.setFound(0);
                dbSize = arrowGame.dataHolder.getToSearch().size();
            }

            if (arrowGame.dataHolder.getFound() == 0) {
                System.out.println("for1");
                arrowGame.dataHolder.setFound(-1);
                for (int i = 0; i < arrowGame.players.size(); i++) {
                    arrowGame._FBIC.readData4(arrowGame.dataHolder, "", "players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/" + arrowGame.players.get(i) + "/", "playerName", "playerName_" + i);
                    arrowGame._FBIC.readData4(arrowGame.dataHolder, "", "players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/" + arrowGame.players.get(i) + "/", "archer", "archer_" + i);
                    arrowGame._FBIC.readData4(arrowGame.dataHolder, "", "players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/" + arrowGame.players.get(i) + "/", "x", "x_" + i);
                    arrowGame._FBIC.readData4(arrowGame.dataHolder, "", "players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/" + arrowGame.players.get(i) + "/", "y", "y_" + i);
                }
            }

            if (arrowGame.dataHolder.getFounds().size() == dbSize) {
                arrowGame.dataHolder.setFound(1);
                arrowGame.dataHolder.getMissedFounds().clear();
            } else if (arrowGame.dataHolder.getFounds().size() < arrowGame.dBSize && !arrowGame.dataHolder.getMissedFounds().isEmpty()) {
                System.out.println("missed founds size: -> " + arrowGame.dataHolder.getMissedFounds().size());
                arrowGame.dataHolder.setFound(0);
            }
            if (arrowGame.dataHolder.getFound() == 1) {
                System.out.println("for2");
                System.out.println(arrowGame.players.size());
                arrowGame.dataHolder.setFound(0);
                for (int i = 0; i < arrowGame.players.size(); i++) {
                    if (arrowGame.playersData.size() == i)
                        arrowGame.playersData.put(i, new PlayerData());

                    arrowGame.playersData.get(i).setPlayerName(arrowGame.dataHolder.getFounds().get("playerName_" + i));
                    arrowGame.dataHolder.getFounds().remove("playerName_" + i);
                    arrowGame.playersData.get(i).setArcherType(arrowGame.dataHolder.getFounds().get("archer_" + i));
                    arrowGame.dataHolder.getFounds().remove("archer_" + i);
                    arrowGame.playersData.get(i).setArcherX(Integer.parseInt(arrowGame.dataHolder.getFounds().get("x_" + i)));
                    arrowGame.dataHolder.getFounds().remove("x_" + i);
                    arrowGame.playersData.get(i).setArcherY(Integer.parseInt(arrowGame.dataHolder.getFounds().get("y_" + i)));
                    arrowGame.dataHolder.getFounds().remove("y_" + i);
                }
                if (arrowGame.dataHolder.getFounds().isEmpty()) {
                    System.out.println("for6");
                    arrowGame.gamePhase = 100;
                    int playersNumber = arrowGame.players.size();
                    arrowGame.thisPlayerId = getPlayerId(arrowGame);

                    for (int i = 0; i < playersNumber; i++) {
                        int index = -1;
                        for (int j = 0; j < arrowGame.elements.size(); j++) {
                            if (arrowGame.elements.get(j).getDesc().equals("eye")) {
                                index = j;
                                break;
                            }
                        }
                        PlayerData p = arrowGame.playersData.get(i);
                        if (i == 0) {    // HOST
                            arrowGame.elements.add(index + 1, new Element("archer" + i, "archer.png", p.getArcherX(), p.getArcherY(), 1, 1, 0.05f));
                            searchObj("archer0", arrowGame).setX(500 + 577 - 40 / 2);
                            searchObj("archer0", arrowGame).setY(50 + 875 - 40 / 2);
                            searchObj("archer0", arrowGame).addStringVariable("currentField", "field0");
                        } else if (i == 1) {        // GUEST 1
                            arrowGame.elements.add(index + 1, new Element("archer" + i, "archer10.png", p.getArcherX(), p.getArcherY(), 1, 1, 0.05f));
                            searchObj("archer1", arrowGame).setX(500 + 145 - 40 / 2);
                            searchObj("archer1", arrowGame).setY(50 + 127 - 40 / 2);
                            searchObj("archer1", arrowGame).addStringVariable("currentField", "field14");
                        } else if (i == 2) {       // GUEST 2
                            arrowGame.elements.add(index + 1, new Element("archer" + i, "archer11.png", p.getArcherX(), p.getArcherY(), 1, 1, 0.05f));
                            searchObj("archer2", arrowGame).setX(1008 + 500 - 40 / 2);
                            searchObj("archer2", arrowGame).setY(50 + 127 - 40 / 2);
                            searchObj("archer2", arrowGame).addStringVariable("currentField", "field18");
                            searchObj("field18", arrowGame).setStringVariableValue("status", "archer2");
                        }
                        searchObj("archer" + i, arrowGame).addNumericalVariable("playerId", i);
                        searchObj("archer" + i, arrowGame).addStringVariable("direction", "right");
                    }
                    System.out.println("players data: ");
                    for (int i = 0; i < playersNumber; i++) {
                        System.out.println(arrowGame.playersData.get(i).getPlayerName());
                        System.out.println(arrowGame.playersData.get(i).getArcherType());
                        System.out.println(arrowGame.playersData.get(i).getArcherX());
                        System.out.println(arrowGame.playersData.get(i).getArcherY());
                    }
                }
            }
        }

        // GUEST

        else if (arrowGame.gamePhase == 6) {        // GUEST
            if (arrowGame.dataHolder.getFound() == 0) {
                arrowGame.dataHolder.setFound(-1);
                arrowGame._FBIC.readData(arrowGame.dataHolder, "", "players/" + arrowGame.onlineId + "/games", "list", null);
            }

            if (arrowGame.dataHolder.getFound() == 1) {
                arrowGame.gamePhase = 17;
//                arrowGame.gamePhase = 7;         // list out found games
//
//                int gamesAmount = toListFromDH(arrowGame.dataHolder.getValue()).size();
//
//                for (int i = 0; i < gamesAmount; i++) {
//                    String gameName = toListFromDH(arrowGame.dataHolder.getValue()).get(i);
//                    arrowGame.choiceTexts.put("game" + i, new Text(gameName, Color.WHITE, 2.0f, 400, 700 - 100 * i, 0, System.nanoTime(), 10000, true));
//                }
//                arrowGame.dataHolder.setFound(0);
            }

            if (arrowGame.dataHolder.getFounds().size() == 1) {
                arrowGame.gameMessage = "Friend " + arrowGame.onlineId + " not found!";
                arrowGame.dataHolder.getFounds().clear();
                arrowGame.dataHolder.getMissedFounds().clear();
                arrowGame.dataHolder.setFound(0);
                arrowGame.gamePhase = 1111;
            }
        } else if (arrowGame.gamePhase == 8) {       // GUEST
//            retrieveData(arrowGame, "players/" + arrowGame.friendId + "/games", arrowGame.gameName, "password", null);
//
//            if (arrowGame.dataHolder.getFound() == 1) {
//                System.out.println("p1 " + arrowGame.dataHolder.getValue() + " p2 " + arrowGame.password);
//
//                if (arrowGame.dataHolder.getValue().equals(arrowGame.password) == true) {
//                    System.out.println("password correct");
//                    arrowGame.gamePhase = 20;
//                } else {
//                    System.out.println("wrong password");
//                    arrowGame.gamePhase = 14;
//                    arrowGame.gameMessage = "Wrong password!";
//                }
//                System.out.println(arrowGame.password);
//                arrowGame.dataHolder.setFound(0);
//            }
            arrowGame.gamePhase = 9;

        } else if (arrowGame.gamePhase == 9) {           // GUEST
            System.out.println("phase " + arrowGame.gamePhase);
            if (arrowGame.dataHolder.getFound() == 0) {
                arrowGame.dataHolder.setFound(-1);
                arrowGame._FBIC.readData3(arrowGame.dataHolder, "", "players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/", "playersAmount", "playersAmount");
            }

            if (arrowGame.dataHolder.getFounds().size() == 1) {
                arrowGame.playersAmount = Integer.parseInt(arrowGame.dataHolder.getFounds().get("playersAmount"));
                arrowGame.dataHolder.restoreFounds("playersAmount");
                arrowGame.playersAmount++;
//                arrowGame.gamePhase = 18;
                arrowGame.gamePhase = 1012;
                arrowGame.dataHolder.setVerifiedAmount(6);
                arrowGame._FBIC.SetValueInDb(arrowGame.dataHolder, "players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/playersAmount", String.valueOf(arrowGame.playersAmount));
                arrowGame._FBIC.SetValueInDb(arrowGame.dataHolder, "players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/playersList/" + arrowGame.playerName, "");
                arrowGame._FBIC.SetValueInDb(arrowGame.dataHolder, "players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/" + arrowGame.playerName + "/playerName", arrowGame.playerName);
                arrowGame._FBIC.SetValueInDb(arrowGame.dataHolder, "players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/" + arrowGame.playerName + "/archer", arrowGame.chosenArcher);
                arrowGame._FBIC.SetValueInDb(arrowGame.dataHolder, "players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/" + arrowGame.playerName + "/x", "3000");
                arrowGame._FBIC.SetValueInDb(arrowGame.dataHolder, "players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/" + arrowGame.playerName + "/y", "100");
            }
        } else if (arrowGame.gamePhase == 17) {      // GUEST
            System.out.println("phase " + arrowGame.gamePhase);
            if (arrowGame.dataHolder.getFound() == 0) {
                arrowGame._FBIC.readData(arrowGame.dataHolder, "", "players/" + arrowGame.onlineId + "/games", "list", null);
                arrowGame.dataHolder.setFound(-1);
            }

            if (arrowGame.dataHolder.getFound() == 1) {
                ArrayList<String> arr = toListFromDH(arrowGame.dataHolder.getValue());
                System.out.println("gamesList " + arr.get(0) + " " + arrowGame.gameName);

                for (String s : arr) {
                    if (s.equals(arrowGame.gameName)) {      // game exists
                        arrowGame.gamePhase = 14;
                        break;
                    }
                }
                if (arrowGame.gamePhase != 14) {
                    arrowGame.gameMessage = "Game '" + arrowGame.gameName + "' not found!";
                    arrowGame.gamePhase = 7;
                }
                arrowGame.dataHolder.setFound(0);
            }
        } else if (arrowGame.gamePhase == 18) {          // GUEST
            System.out.println("phase " + arrowGame.gamePhase);
            if (arrowGame.dataHolder.getChanges().get("sessionStatus").equals("unknown")) {
                arrowGame.dataHolder.getChanges().put("sessionStatus", "waiting");
                arrowGame._FBIC.setRef("players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/sessionStatus");
//                arrowGame._FBIC.SetOnValueChangedListener(arrowGame.dataHolder);
                arrowGame._FBIC.SetOnValueChangedListener1(arrowGame.dataHolder, "sessionStatus");
            }

            if (arrowGame.dataHolder.getChanges().get("sessionStatus").equals("playing")) {
//                arrowGame.dataHolder.getChanges().remove("sessionStatus");
                System.out.println("guest ch");
                arrowGame.gamePhase = 24;
            }
        } else if (arrowGame.gamePhase == 20) {       // GUEST
            if (arrowGame.dataHolder.getFound() == 0) {
                arrowGame.dataHolder.setFound(-1);
                arrowGame._FBIC.readData(arrowGame.dataHolder, "", "players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/", "playersList", null);
            }
            if (arrowGame.dataHolder.getFound() == 1) {
                boolean properName = true;
                ArrayList<String> players = toListFromDH(arrowGame.dataHolder.getValue());

                for (String name : players) {
                    if (name.equals(arrowGame.playerName)) {
                        properName = false;
                        break;
                    }
                }

                if (!properName) {
                    arrowGame.gamePhase = 14;
                    arrowGame.gameMessage = "Player '" + arrowGame.playerName + "' already exists!";
                } else
                    arrowGame.gamePhase = 9;

                arrowGame.dataHolder.setFound(0);
            }
        } else if (arrowGame.gamePhase == 24) {           // GUEST
            System.out.println("gphase " + arrowGame.gamePhase);
            if (arrowGame.dataHolder.getFound() == 0) {
                arrowGame.dataHolder.setFound(-1);
                arrowGame._FBIC.readData(arrowGame.dataHolder, "", "players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/", "playersList", null);
            }

            if (arrowGame.dataHolder.getFound() == 1) {
                arrowGame.dataHolder.setFound(-2);
                arrowGame.players = toListFromDH(arrowGame.dataHolder.getValue());
                Collections.sort(arrowGame.players);
                arrowGame.gamePhase = 25;
            }
        } else if (arrowGame.gamePhase == 25) {          // GUEST
            System.out.println("gphase " + arrowGame.gamePhase);

            if (arrowGame.dataHolder.getFound() == -2) {
                for (int i = 0; i < arrowGame.players.size(); i++) {
                    arrowGame.dataHolder.getToSearch().put("playerName_" + i, "");
                    arrowGame.dataHolder.getToSearch().put("archer_" + i, "");
                    arrowGame.dataHolder.getToSearch().put("x_" + i, "");
                    arrowGame.dataHolder.getToSearch().put("y_" + i, "");
                }
                arrowGame.dataHolder.getToSearch().put("world_tree_x", "");
                arrowGame.dataHolder.getToSearch().put("world_tree_y", "");
                arrowGame.dataHolder.getToSearch().put("world_eye_x", "");
                arrowGame.dataHolder.getToSearch().put("world_eye_y", "");
                arrowGame.dataHolder.setFound(0);
                arrowGame.dBSize = arrowGame.dataHolder.getToSearch().size();
            }

            if (arrowGame.dataHolder.getFound() == 0) {
                System.out.println("for01");
                arrowGame.dataHolder.setFound(-1);
                for (int i = 0; i < arrowGame.players.size(); i++) {
                    arrowGame._FBIC.readData4(arrowGame.dataHolder, "", "players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/" + arrowGame.players.get(i) + "/", "playerName", "playerName_" + i);
                    arrowGame._FBIC.readData4(arrowGame.dataHolder, "", "players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/" + arrowGame.players.get(i) + "/", "archer", "archer_" + i);
                    arrowGame._FBIC.readData4(arrowGame.dataHolder, "", "players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/" + arrowGame.players.get(i) + "/", "x", "x_" + i);
                    arrowGame._FBIC.readData4(arrowGame.dataHolder, "", "players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/" + arrowGame.players.get(i) + "/", "y", "y_" + i);
                }
                arrowGame._FBIC.readData4(arrowGame.dataHolder, "", "players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/world/tree/", "x", "world_tree_x");
                arrowGame._FBIC.readData4(arrowGame.dataHolder, "", "players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/world/tree/", "y", "world_tree_y");
                arrowGame._FBIC.readData4(arrowGame.dataHolder, "", "players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/world/eye/", "x", "world_eye_x");
                arrowGame._FBIC.readData4(arrowGame.dataHolder, "", "players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/world/eye/", "y", "world_eye_y");
            }

            if (arrowGame.dataHolder.getFounds().size() == arrowGame.dBSize) {
                arrowGame.dataHolder.setFound(1);
                arrowGame.dataHolder.getMissedFounds().clear();
            } else if (arrowGame.dataHolder.getFounds().size() < arrowGame.dBSize && !arrowGame.dataHolder.getMissedFounds().isEmpty()) {
                System.out.println("missed founds size: -> " + arrowGame.dataHolder.getMissedFounds().size());
                arrowGame.dataHolder.setFound(0);
            }

            if (arrowGame.dataHolder.getFound() == 1) {
                for (int i = 0; i < arrowGame.players.size(); i++) {
                    if (arrowGame.playersData.size() == i)
                        arrowGame.playersData.put(i, new PlayerData());

                    arrowGame.playersData.get(i).setPlayerName(arrowGame.dataHolder.getFounds().get("playerName_" + i));
                    arrowGame.playersData.get(i).setArcherType(arrowGame.dataHolder.getFounds().get("archer_" + i));
                    arrowGame.playersData.get(i).setArcherX(Integer.parseInt(arrowGame.dataHolder.getFounds().get("x_" + i)));
                    arrowGame.playersData.get(i).setArcherY(Integer.parseInt(arrowGame.dataHolder.getFounds().get("y_" + i)));
                }
                searchObj("tree", arrowGame).setX(Integer.parseInt(arrowGame.dataHolder.getFounds().get("world_tree_x")));
                searchObj("tree", arrowGame).setY(Integer.parseInt(arrowGame.dataHolder.getFounds().get("world_tree_y")));
                searchObj("eye", arrowGame).setX(Integer.parseInt(arrowGame.dataHolder.getFounds().get("world_eye_x")));
                searchObj("eye", arrowGame).setY(Integer.parseInt(arrowGame.dataHolder.getFounds().get("world_eye_y")));
                arrowGame.dataHolder.setChange(0);
                arrowGame.dataHolder.setFound(0);
                arrowGame.dataHolder.getFounds().clear();
                arrowGame.gamePhase = 100;
                System.out.println("getfounds size1: -> " + arrowGame.dataHolder.getFounds().size());
                arrowGame.thisPlayerId = getPlayerId(arrowGame);

                for (int i = 0; i < arrowGame.players.size(); i++) {
                    int index = -1;
                    for (int j = 0; j < arrowGame.elements.size(); j++) {
                        if (arrowGame.elements.get(j).getDesc().equals("eye")) {
                            index = j;
                            break;
                        }
                    }
                    PlayerData p = arrowGame.playersData.get(i);

                    if (i == 0) {    // HOST
                        arrowGame.elements.add(index + 1, new Element("archer" + i, "archer.png", p.getArcherX(), p.getArcherY(), 1, 1, 0.05f));
                        searchObj("archer0", arrowGame).setX(500 + 577 - 40 / 2);
                        searchObj("archer0", arrowGame).setY(50 + 875 - 40 / 2);
                        searchObj("archer0", arrowGame).addStringVariable("currentField", "field0");
                    } else if (i == 1) {        // GUEST 1
                        arrowGame.elements.add(index + 1, new Element("archer" + i, "archer10.png", p.getArcherX(), p.getArcherY(), 1, 1, 0.05f));
                        searchObj("archer1", arrowGame).setX(500 + 145 - 40 / 2);
                        searchObj("archer1", arrowGame).setY(50 + 127 - 40 / 2);
                        searchObj("archer1", arrowGame).addStringVariable("currentField", "field14");
                    } else if (i == 2) {       // GUEST 2
                        arrowGame.elements.add(index + 1, new Element("archer" + i, "archer11.png", p.getArcherX(), p.getArcherY(), 1, 1, 0.05f));
                        searchObj("archer2", arrowGame).setX(1008 + 500 - 40 / 2);
                        searchObj("archer2", arrowGame).setY(50 + 127 - 40 / 2);
                        searchObj("archer2", arrowGame).addStringVariable("currentField", "field18");
                        searchObj("field18", arrowGame).setStringVariableValue("status", "archer2");
                    }

                    searchObj("archer" + i, arrowGame).addNumericalVariable("playerId", i);
                    searchObj("archer" + i, arrowGame).addStringVariable("direction", "left");
                }
            }
        }

        // HOST & GUEST

        else if (arrowGame.gamePhase == 1) {
            arrowGame.powerArcher1 = (int) ((searchObj("powerblock", arrowGame).getY()) * 0.1);
            arrowGame.angleArcher1 = (int) ((searchObj("angleblock", arrowGame).getY()) * 0.157);
//        System.out.println("pow " + arrowGame.powerArcher1 + " ang " + arrowGame.angleArcher1);

            if (arrowGame.gameMode == 2) {           // multiplayer game
                if (arrowGame.host) {
                    if (arrowGame.currentRound == 0) {
                        arrowGame.gameCounter += 1;

                        if (arrowGame.gameCounter >= 100 && arrowGame.roundStartCounter > 0) {
                            arrowGame.roundStartCounter--;
                            arrowGame.gameCounter = 0;
                            arrowGame._FBIC.SetValueInDb("players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/startCounter", String.valueOf(arrowGame.roundStartCounter));
                            arrowGame.gameMessage = String.valueOf(arrowGame.roundStartCounter);
                        }

                        if (arrowGame.roundStartCounter == 0) {
                            arrowGame.currentPlayerId = randomNumber(0, arrowGame.players.size());
                            arrowGame.currentRound = -1;
                            arrowGame._FBIC.SetValueInDb(arrowGame.dataHolder, "players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/currentPlayerId", String.valueOf(arrowGame.currentPlayerId));
                            arrowGame._FBIC.SetValueInDb(arrowGame.dataHolder, "players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/currentRound", "1");
                            arrowGame.dataHolder.setVerifiedAmount(2);
                        }
                    } else if (arrowGame.currentRound == -1) {
                        if (arrowGame.dataHolder.getVerifiedAmount() == 0) {
                            System.out.println("round 1 start!");
                            arrowGame.multiplayerPhase = 4;
                            arrowGame.currentRound = 1;
                            arrowGame._FBIC.setRef("players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/changedValues");
                            arrowGame._FBIC.SetOnValueChangedListener2(arrowGame.dataHolder, "changedValues");
                        }
                    }
                } else {
//                    arrowGame._FBIC.setRef("players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/currentRound");
//                    arrowGame._FBIC.SetOnValueChangedListener2(arrowGame.dataHolder, "currentRound");
//                    arrowGame.dataHolder.getChanges().put("startCounter", "-1");
//                    arrowGame._FBIC.setRef("players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/startCounter");
//                    arrowGame._FBIC.SetOnValueChangedListener2(arrowGame.dataHolder, "startCounter");

                    if (arrowGame.multiplayerPhase == 0) {
                        arrowGame.multiplayerPhase = 1;
                        arrowGame.dataHolder.getChanges().put("startCounter", "-1");
                    }

                    if (arrowGame.multiplayerPhase == 1 && arrowGame.dataHolder.getChanges().get("startCounter").equals("-1")) {
                        arrowGame._FBIC.setRef("players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/startCounter");
                        arrowGame._FBIC.SetOnValueChangedListener2(arrowGame.dataHolder, "startCounter");
                        arrowGame.multiplayerPhase = 2;
                    }
                    String dH = "";

                    if (arrowGame.multiplayerPhase == 2 && !(dH = arrowGame.dataHolder.getChanges().get("startCounter")).equals("-1")) {
                        arrowGame.gameMessage = arrowGame.dataHolder.getChanges().get("startCounter");
                        arrowGame.multiplayerPhase = 2;

                        if (dH.equals("0"))
                            arrowGame.multiplayerPhase = 3;
                    }

                    if (arrowGame.multiplayerPhase == 3 && arrowGame.dataHolder.getChanges().get("startCounter").equals("0")) {
                        System.out.println("getFound 648 -> " + arrowGame.dataHolder.getFound());
                        if (arrowGame.dataHolder.getFound() == 0) {
                            arrowGame.dataHolder.setFound(-1);
                            arrowGame._FBIC.readData3(arrowGame.dataHolder, "", "players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/", "currentPlayerId", "currentPlayerId");
                            arrowGame._FBIC.readData3(arrowGame.dataHolder, "", "players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/", "currentRound", "currentRound");
                        }

                        if (arrowGame.dataHolder.getFounds().size() == 2) {
                            arrowGame.dataHolder.setFound(1);
                            arrowGame.dataHolder.getMissedFounds().clear();
                        } else if (arrowGame.dataHolder.getFounds().size() < 2 && arrowGame.dataHolder.getMissedFounds().size() > 0)
                            arrowGame.dataHolder.setFound(0);

                        if (arrowGame.dataHolder.getFound() == 1) {
                            arrowGame.currentPlayerId = Integer.parseInt(arrowGame.dataHolder.getFounds().get("currentPlayerId"));
                            arrowGame.dataHolder.getFounds().remove("currentPlayerId");
                            arrowGame.dataHolder.setChange(0);
                            arrowGame.dataHolder.setFound(0);
                            arrowGame.multiplayerPhase = 4;
                            arrowGame._FBIC.removeEventListener2();
                            arrowGame._FBIC.setRef("players/" + arrowGame.onlineId + "/games/" + arrowGame.gameName + "/changedValues");
                            arrowGame._FBIC.SetOnValueChangedListener2(arrowGame.dataHolder, "changedValues");
                        }
                    }
                }

                if (arrowGame.multiplayerPhase == 4) {
                    Element fieldCenter = searchObj("field7", arrowGame);

                    if (!fieldCenter.getStringVariableValue("status").equals("free")) {       // check for the winner
                        arrowGame.multiplayerPhase = 5;
                    } else if (arrowGame.dataHolder.isDataChanged() && !arrowGame.dataHolder.getChanges().get("changedValues").equals("")
                            && !arrowGame.dataHolder.getChanges().get("changedValues").equals("0")) {
                        String changedValues = arrowGame.dataHolder.getChanges().get("changedValues");
                        System.out.println("changed values: " + changedValues);
                        arrowGame.dataHolder.setDataChanged(false);
                        arrowGame.currentPlayerId = arrowGame.dataHolder.getChanges().get("changedValues").charAt(0) - '0';
                        int newFieldId = changedValues.charAt(3);
                        int oldFieldId = changedValues.charAt(2);
                        System.out.println("newField id - " + newFieldId);
                        System.out.println("oldField id - " + oldFieldId);
                        Element newField = searchObj("field" + newFieldId, arrowGame);

                        if (changedValues.charAt(1) == '0') {
                            Element archer0 = searchObj("archer0", arrowGame);
                            Element oldField = searchObj("field" + oldFieldId, arrowGame);
                            archer0.setStringVariableValue("currentField", newField.getDesc());
                            searchObj("field" + oldFieldId, arrowGame).setStringVariableValue("status", "free");
                            newField.setStringVariableValue("status", "archer0");
                            archer0.setX(newField.getX() - 16);
                            archer0.setY(newField.getY() - 16);
                            System.out.println("archer0 currField: " + archer0.getStringVariableValue("currentField") + " old field id " + oldField.getDesc() + " new field id " + newField.getDesc());
                        } else if (changedValues.charAt(1) == '1') {
                            Element archer1 = searchObj("archer1", arrowGame);
                            Element oldField = searchObj("field" + oldFieldId, arrowGame);
                            archer1.setStringVariableValue("currentField", newField.getDesc());
                            searchObj("field" + oldFieldId, arrowGame).setStringVariableValue("status", "free");
                            newField.setStringVariableValue("status", "archer1");
                            archer1.setX(newField.getX() - 16);
                            archer1.setY(newField.getY() - 16);
                            System.out.println("archer1 currField: " + archer1.getStringVariableValue("currentField") + " old field id " + oldField.getDesc() + " new field id " + newField.getDesc());
                        } else if (changedValues.charAt(1) == '2') {
                            Element archer2 = searchObj("archer2", arrowGame);
                            Element oldField = searchObj("field" + oldFieldId, arrowGame);
                            archer2.setStringVariableValue("currentField", newField.getDesc());
                            searchObj("field" + oldFieldId, arrowGame).setStringVariableValue("status", "free");
                            newField.setStringVariableValue("status", "archer2");
                            archer2.setX(newField.getX() - 16);
                            archer2.setY(newField.getY() - 16);
                            System.out.println("archer2 currField: " + archer2.getStringVariableValue("currentField") + " old field id " + oldField.getDesc() + " new field id " + newField.getDesc());
                        } else if (changedValues.charAt(1) == 'g') {
                            Element guardian1 = searchObj("guardian1", arrowGame);
                            Element oldField = searchObj("field" + oldFieldId, arrowGame);
                            guardian1.setStringVariableValue("currentField", newField.getDesc());
                            searchObj("field" + oldFieldId, arrowGame).setStringVariableValue("status", "free");
                            newField.setStringVariableValue("status", "guardian1");
                            guardian1.setX(newField.getX() - 16);
                            guardian1.setY(newField.getY() - 16);
                            System.out.println("archer0 currField: " + guardian1.getStringVariableValue("currentField") + " old field id " + oldField.getDesc() + " new field id " + newField.getDesc());
                        } else if (changedValues.charAt(1) == 'h') {
                            Element guardian2 = searchObj("guardian2", arrowGame);
                            Element oldField = searchObj("field" + oldFieldId, arrowGame);
                            guardian2.setStringVariableValue("currentField", newField.getDesc());
                            searchObj("field" + oldFieldId, arrowGame).setStringVariableValue("status", "free");
                            newField.setStringVariableValue("status", "guardian2");
                            guardian2.setX(newField.getX() - 16);
                            guardian2.setY(newField.getY() - 16);
                            System.out.println("archer0 currField: " + guardian2.getStringVariableValue("currentField") + " old field id " + oldField.getDesc() + " new field id " + newField.getDesc());
                        } else if (changedValues.charAt(1) == 'i') {
                            Element guardian3 = searchObj("guardian3", arrowGame);
                            Element oldField = searchObj("field" + oldFieldId, arrowGame);
                            guardian3.setStringVariableValue("currentField", newField.getDesc());
                            searchObj("field" + oldFieldId, arrowGame).setStringVariableValue("status", "free");
                            newField.setStringVariableValue("status", "guardian3");
                            guardian3.setX(newField.getX() - 16);
                            guardian3.setY(newField.getY() - 16);
                            System.out.println("archer0 currField: " + guardian3.getStringVariableValue("currentField") + " old field id " + oldField.getDesc() + " new field id " + newField.getDesc());
                        }
                    }
                }

                if (arrowGame.multiplayerPhase == 5) {
                    Element field7Winner = searchObj("field7", arrowGame);
                    String archer = field7Winner.getStringVariableValue("status");
                    String winner = "";
                    arrowGame.cam.zoom = 1f;
                    arrowGame.transitionX = 0;
                    arrowGame.transitionY = 0;
                    arrowGame.zoomTranslation = 1f;

                    if (archer.equals("archer0"))
                        winner = "gold";
                    else if (archer.equals("archer1"))
                        winner = "silver";
                    else if (archer.equals("archer2"))
                        winner = "bronze";

                    arrowGame.gameMessage = "The winner is " + winner;
                }
            }
        } else if (arrowGame.gamePhase == 100) {
            searchObj("doga", arrowGame).setAlpha(1);
//            Element archer = searchObjByVariable("archer" + arrowGame.thisPlayerId, "playerId", arrowGame.thisPlayerId, arrowGame);
//
//            if (archer.getStringVariableValue("direction").equals("left"))
//                arrowGame.cameraShiftX = -(int) ((float) Constants.SCREEN_WIDTH * arrowGame.factor - 300) + archer.getX();
//            else
//                arrowGame.cameraShiftX = archer.getX();

            arrowGame.gamePhase = 1;
        }

        if (arrowGame.pressedEnter) {
            arrowGame.pressedEnter = false;

            switch (arrowGame.keyboardWord) {
                case "password":
                    arrowGame.password = arrowGame.writtenText;
                    break;
//                case "friendId":
//                    arrowGame.friendId = arrowGame.writtenText;
//                    break;
                case "onlineId":
                    arrowGame.onlineId = arrowGame.writtenText;
                    break;
                case "playerName":
                    arrowGame.playerName = arrowGame.writtenText;
                    break;
                case "gameName":
                    arrowGame.gameName = arrowGame.writtenText;
                    break;
            }

            System.out.println("k. word" + arrowGame.keyboardWord);

            arrowGame.writtenText = "";
            arrowGame.keyboardWord = "";
        }

        if (!arrowGame.keyboardWord.equals("") && !arrowGame.keyboardMode) {
//            if (arrowGame.keyboardWord.equals("password")) {
//                arrowGame.texts.get("password").setValue(arrowGame.writtenText);
//                arrowGame.password = arrowGame.writtenText;
//            } else if (arrowGame.keyboardWord.equals("gameName")) {
//                arrowGame.texts.get("gameName").setValue(arrowGame.writtenText);
//                arrowGame.gameName = arrowGame.writtenText;
//            } else if (arrowGame.keyboardWord.equals("playerName")) {
//                arrowGame.texts.get("playerName").setValue(arrowGame.writtenText);
//                arrowGame.playerName = arrowGame.writtenText;
//            }

            arrowGame.writtenText = "";
            arrowGame.keyboardWord = "";
        }


    }

    private int calculateFromString(String changedValues, int i) {
        int j = -10000;
        String s = "";

        for (int x = i; x < changedValues.length(); x++) {
            if (changedValues.charAt(x) == ',')
                break;

            s += changedValues.charAt(x);
        }

        if (s.length() == 1)
            j = s.charAt(1) - '0';
        else if (s.length() == 2)
            j = s.charAt(2) - '0' + (s.charAt(1) - '0') * 10;
        else if (s.length() == 3)
            j = s.charAt(3) - '0' + (s.charAt(2) - '0') * 10 + (s.charAt(1) - '0') * 100;
        else if (s.length() == 4)
            j = s.charAt(4) - '0' + (s.charAt(3) - '0') * 10 + (s.charAt(2) - '0') * 100 + (s.charAt(1) - '0') * 1000;

        return j;
    }

    private String searchFor(String changedValues, String word, int l) {
        StringBuilder s = new StringBuilder();
        int length = word.length();
        int j = 0;

        for (int i = 0; i < changedValues.length(); i++) {
            if (changedValues.charAt(i) == word.charAt(j) && changedValues.charAt(i + 1) == word.charAt(j + 1))
                s.append(changedValues.charAt(i));
        }

        return s.toString();
    }

    private void savePlayerData(ArrowGame play) {
        FileOutputStream stream;
        String playerFileName = "player.dat";
        File playerFile = new File(play.al.outputDirectory, playerFileName);

        try {
            stream = new FileOutputStream(playerFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            stream.write("Arrows player data file.".getBytes());
            String data1 = "Player name=" + play.playerName + ".";
            stream.write(data1.getBytes());
            String data2 = "Friend's id=" + play.onlineId + ".";
            stream.write(data2.getBytes());
            String data3 = "Password=" + play.password + ".";
            stream.write(data3.getBytes());
            stream.write("*".getBytes());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                stream.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    static Element searchObj(String name, ArrowGame play) {
        for (Element img : play.elements)
            if (img.getDesc().equals(name))
                return img;

        return null;
    }

    static ArrayList<String> toListFromDH(String dataHolder) {
        ArrayList<String> elements = new ArrayList<>();
        String element = "";
        int charId = 1;

        if (dataHolder.charAt(0) == 'n')
            return null;

        while (dataHolder.charAt(charId) != '}') {
            while (dataHolder.charAt(charId) != '=') {
                element += dataHolder.charAt(charId);
                charId++;
            }
            elements.add(element);
            element = "";

            if (dataHolder.charAt(charId + 1) != '}')
                charId += 3;
            else
                break;
        }

        return elements;
    }

    public static int randomNumber(int start, int range) {
        int number = -1;
        Random r = new Random();
        number = r.nextInt(range) + start;
        return number;
    }

    static int getPlayerId(ArrowGame play) {
        int plId = -1;

        for (int i = 0; i < play.players.size(); i++)
//            if (play.playersValues.get("" + i + "playerName").equals(play.playerName)){
            if (play.playersData.get(i).getPlayerName().equals(play.playerName)) {
                System.out.println("this player ID: " + i);
                plId = i;
                break;
            }

        return plId;
    }

    static Element searchObjByVariable(String name, String variable, int value, ArrowGame play) {
        for (Element img : play.elements)
            if (img.getDesc().equals(name) && img.getNumericalVariableValue(variable) == value)
                return img;

        return null;
    }

    static void retrieveData(ArrowGame play, String reference, String data, String dataToRetrieve, String id) {
        if (play.dataHolder.getFound() == 0) {
            play.dataHolder.setFound(-1);
            play._FBIC.readData(play.dataHolder, reference, data, dataToRetrieve, id);
        }
    }

    static void retrieveDataNullable(ArrowGame play, String reference, String data, String dataToRetrieve, String id) {
        if (play.dataHolder.getFound() == 0) {
            play.dataHolder.setFound(-1);
            play._FBIC.readDataNullable(play.dataHolder, reference, data, dataToRetrieve, id);
        }
    }

    static ArrayList<String> onlineIdFromDH(String dataHolder) {
        ArrayList<String> elements = new ArrayList<>();
        String element = "";
        int length = dataHolder.length();
        int charId = 1;

        if (dataHolder.charAt(0) == 'n')
            return null;

        while (dataHolder.charAt(charId) != '}') {
            while (dataHolder.charAt(charId) != '=') {
                element += dataHolder.charAt(charId);
                charId++;
            }
            elements.add(element);
            element = "";

            while (dataHolder.charAt(charId) != ',') {
                charId++;

                if (charId == length - 1)
                    break;
            }

            if (charId == length - 1)
                break;
        }

        return elements;
    }
}
