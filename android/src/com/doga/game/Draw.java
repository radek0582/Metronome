package com.doga.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

import java.util.ArrayList;
import java.util.Random;

public class Draw {
    int counter = 0;

    public static void update(float dt, ArrowGame arrowGame) {
        for (Element el : arrowGame.elements)
            el.update(dt);

        arrowGame.cam.update();
    }

    public static void render(SpriteBatch sb, ArrowGame arrowGame) {
        sb.setProjectionMatrix(arrowGame.cam.combined);
        sb.begin();

        if (arrowGame.gamePhase != 1) {
//            draw("bkg", sb, arrowGame);
//            draw("bkg2", sb, arrowGame);
//            draw("bkg3", sb, arrowGame);
//            draw("bkg4", sb, arrowGame);
            draw("blinkyBkg", sb, arrowGame);
            draw("blinkyBkg2", sb, arrowGame);
            draw("blinkyBkg3", sb, arrowGame);
//            draw("blinkyBkg3", sb, arrowGame);
//            draw("blinkyBkg4", sb, arrowGame);
//            draw("blinkyBkg5", sb, arrowGame);
//            draw("blinkyBkg6", sb, arrowGame);
//            draw("square1", sb, arrowGame);
//            draw("whiteBkg", sb, arrowGame);

//            draw("clouds", sb, arrowGame);
//            draw("refreshLandscape", sb, play);
//            draw("refreshPortrait", sb, play);

            if (arrowGame.gamePhase != 0) {
//                draw("doga", sb, arrowGame);
//                draw("spider", sb, arrowGame);
//                draw("spider2", sb, arrowGame);
//                draw("spider3", sb, arrowGame);
//                draw("webMove", sb, arrowGame);
//                draw("webs", sb, arrowGame);
//                draw("websApla", sb, arrowGame);
//                draw("webs", sb, arrowGame);
                draw("metronome", sb, arrowGame);
                draw("pendulum", sb, arrowGame);
                draw("slider", sb, arrowGame);
//                draw("webTest", sb, arrowGame);
//                draw("highlight", sb, arrowGame);
                draw("firefly", sb, arrowGame);
                draw("bigSpider", sb, arrowGame);
                draw("blackCover", sb, arrowGame);
                draw("torch", sb, arrowGame);
                draw("torch2", sb, arrowGame);
                draw("blade2", sb, arrowGame);
//                draw("wheel", sb, arrowGame);
                draw("wheelPoint", sb, arrowGame);
                drawUntransformable("powerBlock", sb, arrowGame);
                drawUntransformable("energyBar", sb, arrowGame);
                drawUntransformable("energyBox", sb, arrowGame);
//                draw("testPoint", sb, arrowGame);

//                arrowGame.drawTimeCounter ++;
//                if (arrowGame.drawTimeCounter == 60){
//                    arrowGame.drawTimeCounter = 0;
//                    arrowGame.curSecond ++;
//                    arrowGame.gameMessage = "sek : " + arrowGame.curSecond;
//
////                    if (!arrowGame.drawnSek) {
////                        arrowGame.gameMessage = "sek" + arrowGame.curSecond;
////                        arrowGame.drawnSek = true;
////                    }
////                    else {
////                        arrowGame.gameMessage = "";
////                        arrowGame.drawnSek = false;
////                    }
//                }

            }

            if (arrowGame.gamePhase == 0) {                              // intro
                drawUntransformable("logo", sb, arrowGame);
                writeTextFlickering("tap to", sb, arrowGame);

//                writeTextFlickering("START", sb, play);
            } else if (arrowGame.gamePhase == 2) {                        // game mode menu
                writeText("singlePlayer", sb, arrowGame);
                writeText("versus", sb, arrowGame);
            } else if (arrowGame.gamePhase == 3) {
//                writeText("newGame", sb, arrowGame);
//                writeText("joinGame", sb, arrowGame);
//                draw("blackCover", sb, arrowGame);
            } else if (arrowGame.gamePhase == 4) {                // Duel - create game (with player data edition)
                writeText("enterGameName", sb, arrowGame);

//                writeText("gameName", sb, play);
                int x, y = 0;
                x = arrowGame.texts.get("playerName").getX();
                y = arrowGame.texts.get("playerName").getY();
                writeTextParam(arrowGame.playerName, "", Color.DARK_GRAY, 3.0f, x + 550, y, sb, arrowGame, 0);
                writeText("playerName", sb, arrowGame);
                writeText("password", sb, arrowGame);
                x = arrowGame.texts.get("password").getX();
                y = arrowGame.texts.get("password").getY();
                writeTextParam(arrowGame.password, "", Color.DARK_GRAY, 3.0f, x + 450, y, sb, arrowGame, 0);
                writeText("onlineId", sb, arrowGame);
                x = arrowGame.texts.get("onlineId").getX();
                y = arrowGame.texts.get("onlineId").getY();
                writeTextParam(arrowGame.onlineId, "", Color.DARK_GRAY, 3.0f, x + 450, y, sb, arrowGame, 0);

                if (!arrowGame.password.equals("") && !arrowGame.gameName.equals("") && !arrowGame.playerName.equals(""))
                    arrowGame.texts.get("confirm").setColor(Color.BLACK);
                else
                    arrowGame.texts.get("confirm").setColor(Color.GRAY);

                writeText("confirm", sb, arrowGame);
            } else if (arrowGame.gamePhase == 5) {
                writeText("waitingForOpponents", sb, arrowGame);
            } else if (arrowGame.gamePhase == 1111) {
                writeText("enterFriendId", sb, arrowGame);
                int x = arrowGame.texts.get("enterFriendId").getX();
                int y = arrowGame.texts.get("enterFriendId").getY();
                writeTextParam(arrowGame.onlineId, "", Color.DARK_GRAY, 3.0f, x + 450, y, sb, arrowGame, 0);

//                writeText("gameName", sb, play);
//                x = play.texts.get("playerName").getX();
//                y = play.texts.get("playerName").getY();
                writeText("yourName", sb, arrowGame);
                x = arrowGame.texts.get("yourName").getX();
                writeTextParam(arrowGame.playerName, "", Color.DARK_GRAY, 3.0f, x + 500, y - 100, sb, arrowGame, 0);
//                writeText("onlineId", sb, play);

//                writeText("password", sb, play);

                if (!arrowGame.onlineId.equals("") && !arrowGame.playerName.equals(""))
                    arrowGame.texts.get("confirm").setColor(Color.BLACK);
                else
                    arrowGame.texts.get("confirm").setColor(Color.GRAY);

                writeText("confirm", sb, arrowGame);
            } else if (arrowGame.gamePhase == 6) {               // Draw & Update - looking for friend and/or games
                writeText("lookingForGames", sb, arrowGame);
            } else if (arrowGame.gamePhase == 7) {
                writeText("chooseGame", sb, arrowGame);
                writeText("gameName", sb, arrowGame);
                writeTextParam(arrowGame.gameName, "", Color.BLACK, 3.0f, 750f, 500f, sb, arrowGame, 0);

                if (!arrowGame.gameName.equals(""))
                    arrowGame.texts.get("confirm").setColor(Color.BLACK);
                else
                    arrowGame.texts.get("confirm").setColor(Color.GRAY);

                writeText("confirm", sb, arrowGame);
            } else if (arrowGame.gamePhase == 8 || arrowGame.gamePhase == 20) {
                writeText("checkingPassword", sb, arrowGame);
            } else if (arrowGame.gamePhase == 9 || arrowGame.gamePhase == 18) {
                writeText("getReady", sb, arrowGame);
            } else if (arrowGame.gamePhase == 12) {
                int x = arrowGame.texts.get("foundedOpponents").getX();
                int y = arrowGame.texts.get("foundedOpponents").getY();
                writeText("foundedOpponents", sb, arrowGame);
                arrowGame.playersAmount = toListFromDH(arrowGame.dataHolder.getValue()).size();
                System.out.println(arrowGame.playersAmount);

                for (int i = 0; i < arrowGame.playersAmount; i++)
                    writeTextParam(toListFromDH(arrowGame.dataHolder.getValue()).get(i), "", Color.BLACK, 3.0f, x + 100, y - 100 * (i + 1) - 100, sb, arrowGame, 0);

                if (arrowGame.playersAmount > 1)
                    arrowGame.texts.get("startVersusGame").setColor(Color.BLACK);
                else
                    arrowGame.texts.get("startVersusGame").setColor(Color.GRAY);

                writeText("startVersusGame", sb, arrowGame);
            } else if (arrowGame.gamePhase == 14) {
//                writeText("enterPasswordAndPlayerName", sb, play);
//                writeText("gameName", sb, play);
                writeTextParam("Your name: " + arrowGame.playerName, "", Color.BLACK, 3.0f, arrowGame.texts.get("playerName").getX(), arrowGame.texts.get("playerName").getY(), sb, arrowGame, 0);
//                writeText("playerName", sb, play);
//                writeText("password", sb, play);

                if (!arrowGame.playerName.equals(""))
                    arrowGame.texts.get("login").setColor(Color.BLACK);
                else
                    arrowGame.texts.get("login").setColor(Color.GRAY);

                writeText("login", sb, arrowGame);
            }
        } else if (arrowGame.gamePhase == 1) {
//            draw("bkg", sb, arrowGame);
//            draw("bkg2", sb, arrowGame);
//            draw("bkg3", sb, arrowGame);
//            draw("bkg4", sb, arrowGame);
            draw("square1", sb, arrowGame);
//            draw("doga", sb, arrowGame);
//            draw("zoomIN", sb, play);
//            draw("zoomOUT", sb, play);
//            draw("archer0", sb, arrowGame);
//            draw("archer1", sb, arrowGame);


//            if (arrowGame.players.size() == 3)
//                draw("archer2", sb, arrowGame);

            if (arrowGame.moveAvailable) {
                int x = searchObj(arrowGame.selectedPawn, arrowGame).getX();
                int y = searchObj(arrowGame.selectedPawn, arrowGame).getY();
                Element pawn = searchObj("highlight", arrowGame);
                pawn.setX(x - 15);
                pawn.setY(y - 15);
                draw("highlight", sb, arrowGame);
            }

            draw("guardian1", sb, arrowGame);
            draw("guardian2", sb, arrowGame);
            draw("guardian3", sb, arrowGame);

            Color selColor = Color.BLACK;
            String colorName = "white";

            if (arrowGame.thisPlayerId == 0) {
                selColor = Color.BLACK;
                colorName = "gold";
            } else if (arrowGame.thisPlayerId == 1) {
                selColor = Color.BLACK;
                colorName = "silver";
            } else if (arrowGame.thisPlayerId == 2) {
                selColor = Color.BLACK;
                colorName = "bronze";
            }

            writeText("currentPlayer", sb, arrowGame);
            int y = arrowGame.texts.get("currentPlayer").getY();
            int x = arrowGame.texts.get("currentPlayer").getX();
            writeTextParam("You: " + arrowGame.playerName + " (" + colorName + ")", "", selColor, 2f, 100f, y - 100, sb, arrowGame, 0);
            if (arrowGame.currentPlayerId > -1)
                writeTextParam(arrowGame.playersData.get(arrowGame.currentPlayerId).getPlayerName(), "", Color.BLACK, 2f, x + 400, y, sb, arrowGame, 0);
//            writeTextParam("Round: " + play.currentRound, "", Color.ORANGE, 1.5f, 100f, 800f, sb, play, 0);
//            for (int i = 0; i < play.playersData.size(); i++) {
//                writeTextParam("Player " + i + " name: " + play.playersData.get(i).getPlayerName(), "", Color.ORANGE, 1.5f, 100f, 700f - i * 100, sb, play, 0);
//            }
//            writeTextParam(play.gameMessage, "", Color.RED, 3f, (Constants.SCREEN_WIDTH / 2 - play.gameMessage.length() * 10) * play.factor, 500f, sb, play, 0);

//            for (int i = 0; i < play.players.size(); i++)
//                writeTextParam(play.playersData.get(i).getPlayerName(), "", Color.ORANGE, 2.0f, play.playersData.get(i).getArcherX() + 200, play.playersData.get(i).getArcherY() + 400, sb, play, 1);

            if (arrowGame.thisPlayerId == arrowGame.currentPlayerId)
                writeTextFlickering("yourTurn", sb, arrowGame);
        }

        if (arrowGame.multiplayerPhase == 5) {            // Victory special effects
            searchObj("win1", arrowGame).setX(randomNumber(10, 2000));
            searchObj("win1", arrowGame).setY(randomNumber(10, 1000));
            draw("win1", sb, arrowGame);
            searchObj("win2", arrowGame).setX(randomNumber(10, 2000));
            searchObj("win2", arrowGame).setY(randomNumber(10, 1000));
            draw("win2", sb, arrowGame);
            searchObj("win3", arrowGame).setX(randomNumber(10, 2000));
            searchObj("win3", arrowGame).setY(randomNumber(10, 1000));
            draw("win3", sb, arrowGame);
//            writeText("restart", sb, play);
        }

        if (!arrowGame.gameMessage.equals(""))
            writeTextParam(arrowGame.gameMessage, "", Color.RED, 2.0f, 100, 100, sb, arrowGame, 0);

//        writeTextParam(String.valueOf(play.gamePhase), "", Color.RED, 2.0f, 200, 100, sb, play, 0);

        if (arrowGame.keyboardMode) {
//            drawUntrasformable("keyboard", sb, play);
//            Element el = searchObj("writingField", play);
//            Element elK = searchObj("keyboard", play);
//            el.setX(elK.getX());
//            el.setY(elK.getY() + 480);
//            drawUntrasformable("writingField", sb, play);
//            writeTextParam(play.writtenText + "_", "sans", Color.BLACK, 1.2f, el.getX() + 50, el.getY() + 100, sb, play, 0);

            drawUntransformable("key1", sb, arrowGame);
            drawUntransformable("key2", sb, arrowGame);
            drawUntransformable("key3", sb, arrowGame);
            drawUntransformable("key4", sb, arrowGame);
            drawUntransformable("key5", sb, arrowGame);
            drawUntransformable("key6", sb, arrowGame);
            drawUntransformable("key7", sb, arrowGame);
            drawUntransformable("key8", sb, arrowGame);
            drawUntransformable("key9", sb, arrowGame);
            drawUntransformable("key0", sb, arrowGame);
            drawUntransformable("keyq", sb, arrowGame);
            drawUntransformable("keyw", sb, arrowGame);
            drawUntransformable("keye", sb, arrowGame);
            drawUntransformable("keyr", sb, arrowGame);
            drawUntransformable("keyt", sb, arrowGame);
            drawUntransformable("keyy", sb, arrowGame);
            drawUntransformable("keyu", sb, arrowGame);
            drawUntransformable("keyi", sb, arrowGame);
            drawUntransformable("keyo", sb, arrowGame);
            drawUntransformable("keyp", sb, arrowGame);
            drawUntransformable("keya", sb, arrowGame);
            drawUntransformable("keys", sb, arrowGame);
            drawUntransformable("keyd", sb, arrowGame);
            drawUntransformable("keyf", sb, arrowGame);
            drawUntransformable("keyg", sb, arrowGame);
            drawUntransformable("keyh", sb, arrowGame);
            drawUntransformable("keyj", sb, arrowGame);
            drawUntransformable("keyk", sb, arrowGame);
            drawUntransformable("keyl", sb, arrowGame);
            drawUntransformable("keyup", sb, arrowGame);
            drawUntransformable("keyz", sb, arrowGame);
            drawUntransformable("keyx", sb, arrowGame);
            drawUntransformable("keyc", sb, arrowGame);
            drawUntransformable("keyv", sb, arrowGame);
            drawUntransformable("keyb", sb, arrowGame);
            drawUntransformable("keyn", sb, arrowGame);
            drawUntransformable("keym", sb, arrowGame);
            drawUntransformable("keyback", sb, arrowGame);
            drawUntransformable("keyenter", sb, arrowGame);
            drawUntransformable("keycancel", sb, arrowGame);
            drawUntransformable("writingField", sb, arrowGame);
            Element writingField = searchObj("writingField", arrowGame);
            int x = writingField.getX();
            int y = writingField.getY();
            writeTextParam(arrowGame.writtenText + "_", "sans", Color.YELLOW, 1.2f, x + 40, y + 90, sb, arrowGame, 0);

            if (arrowGame.keyClicked)
                drawUntransformable("keyClicked", sb, arrowGame);
        }

        sb.end();
    }

    static ArrayList<String> toListFromDH(String dataHolder) {
        ArrayList<String> elements = new ArrayList<>();
        String element = "";
        int charId = 1;

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

    static String toString(int value) {
        String text = String.valueOf(value);
        return text;
    }

    static Element searchObj(String name, ArrowGame play) {
        for (Element img : play.elements)
            if (img.getDesc().equals(name))
                return img;

        return null;
    }

    static void writeText(String key, SpriteBatch sb, ArrowGame play) {
        String text = play.texts.get(key).getText();
        String value = play.texts.get(key).getValue();
        Color color = play.texts.get(key).getColor();
        float scale = play.texts.get(key).getScale() * play.zoomTranslation;
        float posX = 0;
        float posY = 0;


        posX = (float) play.texts.get(key).getX() * play.zoomTranslation + play.transitionX;
        posY = (float) play.texts.get(key).getY() * play.zoomTranslation + play.transitionY;


        play.font.setColor(color);
        play.font.getData().setScale(scale);

        if (value.equals(""))
            play.font.draw(sb, text, posX, posY);
        else
            play.font.draw(sb, text + " " + value, posX, posY);
    }


    static void writeTextTransformable(String key, SpriteBatch sb, ArrowGame play) {
        String text = play.texts.get(key).getText();
        String value = play.texts.get(key).getValue();
        Color color = play.texts.get(key).getColor();
        float scale = play.texts.get(key).getScale();
        float posX = (float) play.texts.get(key).getX();
        float posY = (float) play.texts.get(key).getY();

        play.font.setColor(color);
        play.font.getData().setScale(scale);

        if (value.equals(""))
            play.font.draw(sb, text, posX, posY);
        else
            play.font.draw(sb, text + " " + value, posX, posY);
    }


    static void writeTextParam(String text, String font, Color color, float scale, float posX, float posY, SpriteBatch sb, ArrowGame play, int movingText) {
        if (play.gamePhase == 1 && movingText == 1) {
            posX -= play.cameraShiftX;
            posY -= play.cameraShiftY;
        }

        scale = scale * play.zoomTranslation;


        posX = posX * play.zoomTranslation + play.transitionX;
        posY = posY * play.zoomTranslation + play.transitionY;

        if (font.equals("")) {
            play.font.setColor(color);
            play.font.getData().setScale(scale);
            play.font.draw(sb, text, posX, posY);
        } else if (font.equals("sans")) {
            play.fontSans.setColor(color);
            play.fontSans.getData().setScale(scale);
            play.fontSans.draw(sb, text, posX, posY);
        }
    }

    static void writeTextParamTransformable(String text, String font, Color color, float scale, float posX, float posY, SpriteBatch sb, ArrowGame play, int movingText) {
        if (play.gamePhase == 1 && movingText == 1) {
            posX -= play.cameraShiftX;
            posY -= play.cameraShiftY;
        }

        if (font.equals("")) {
            play.font.setColor(color);
            play.font.getData().setScale(scale);
            play.font.draw(sb, text, posX, posY);
        } else if (font.equals("sans")) {
            play.fontSans.setColor(color);
            play.fontSans.getData().setScale(scale);
            play.fontSans.draw(sb, text, posX, posY);
        }
    }

    static void writeTextFlickering(String key, SpriteBatch sb, ArrowGame play) {
        Text val = play.texts.get(key);

        play.texts.get(key).setTimeCurrent(System.nanoTime() - val.getTimeStart());

        if (val.getTimeCurrent() >= val.getDuration() * 100000) {
            val.setTimeStart(System.nanoTime());

            if (val.isShow() == false) {
                play.texts.get(key).setShow(true);
            } else
                play.texts.get(key).setShow(false);
        }

        float posX = 0;
        float posY = 0;
        float scale = val.getScale() * play.zoomTranslation;

        posX = (float) play.texts.get(key).getX() * play.zoomTranslation + play.transitionX;
        posY = (float) play.texts.get(key).getY() * play.zoomTranslation + play.transitionY;

        if (val.isShow() == true) {
            play.font.setColor(val.getColor());
            play.font.getData().setScale(scale);
            play.font.draw(sb, val.getText(), posX, posY);
        }
    }

    static void draw(String desc, SpriteBatch sb, ArrowGame arrowGame) {
        TextureRegion texture = null;
        String spriteDesc = "";
        int x = 0;
        int y = 0;
        float angle = 0;
        float alpha = 1;

        for (Element element : arrowGame.elements) {
            if (element.getDesc().equals(desc)) {
                texture = element.getTexture();
                x = element.getX() - (int) ((double) arrowGame.cameraShiftX * element.getParallaxFactorX() - arrowGame.rotationShiftX);
                y = element.getY() - (int) ((double) arrowGame.cameraShiftY * element.getParallaxFactorY() - arrowGame.rotationShiftY);
                angle = (float) element.getNumericalVariableValue("actAngle");
                alpha = element.getAlpha();
                spriteDesc = desc;
                break;
            }
        }

        if (angle == -1000000) {            // not rotated sprite
            if (alpha != 1) {
                Sprite bkg = new Sprite(texture);
                bkg.setPosition(x, y);
                bkg.draw(sb, alpha);
            } else {
                if (desc.equals("blackCover")) {
//                    sb.setShader(arrowGame.shader);
//                    arrowGame.coverSprite.draw(sb);
//                    sb.setShader(arrowGame.defaultShader);
                } else {
                    sb.draw(texture, x, y);
                }
//                System.out.println("ddd");
            }
        } else {
            sb.draw(texture, x, y,
                    texture.getRegionWidth() / 2,
                    texture.getRegionHeight() / 2,
                    texture.getRegionWidth(),
                    texture.getRegionHeight(),
                    1, 1, angle);

        }
    }

    static void drawUntransformable(String desc, SpriteBatch sb, ArrowGame play) {
        TextureRegion texture = null;
        int x = 0;
        int y = 0;
        int angle = 0;
        float alpha = 1;

        for (Element element : play.elements) {
            if (element.getDesc().equals(desc)) {
                texture = element.getTexture();
//                x = element.getX() - (int) ((double) play.cameraShiftX * element.getParallaxFactorX());
//                y = element.getY() - (int) ((double) play.cameraShiftY * element.getParallaxFactorY());


                x = (int) ((float) element.getX() * play.zoomTranslation + play.transitionX);
                y = (int) ((float) element.getY() * play.zoomTranslation + play.transitionY);

                angle = (int) element.getNumericalVariableValue("actAngle");
                alpha = element.getAlpha();
                break;
            }
        }

        if (angle == -1000000) {
            if (alpha != 1) {
                Sprite bkg = new Sprite(texture);
                bkg.setPosition(x, y);
                bkg.draw(sb, alpha);
            } else {
//                sb.draw(texture, x, y);
                sb.draw(texture, x, y,
                        0,
                        0,
                        texture.getRegionWidth(),
                        texture.getRegionHeight(),
                        play.zoomTranslation, play.zoomTranslation, 0);
            }
        } else {
            sb.draw(texture, x, y,
                    0,
                    0,
                    texture.getRegionWidth(),
                    texture.getRegionHeight(),
                    play.zoomTranslation, play.zoomTranslation, angle);
        }
    }

    public void dispose(ArrowGame play) {
        for (Element el : play.elements)
            el.dispose();

        System.out.println("Play State Disposed");
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

    public static int randomNumber(int start, int range) {
        int number = -1;
        Random r = new Random();
        number = r.nextInt(range) + start;
        return number;
    }


}
