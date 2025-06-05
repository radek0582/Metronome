package com.doga.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.math.Vector2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Objects;

public class Touch implements InputProcessor {
    private ArrowGame arrowGame;
    private Vector2 lastTouch = new Vector2();
    private int prevX;
    private int prevY;

    private int touchedX;
    private int touchedY;
    private boolean draggingMove = false;
    private boolean draggingMove0 = false;
    private boolean draggingMove1 = false;

    public Touch(ArrowGame play) {
        this.arrowGame = play;
        Gdx.input.setInputProcessor(this);
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        touchedX = (int) ((float) screenX * arrowGame.factor);
        touchedY = (int) (((float) Gdx.graphics.getHeight() - (float) screenY) * arrowGame.factor);

        prevX = screenX;
        prevY = screenY;
        searchObj("powerBlock").setNumericalVariableValue("pointer", -1);

        Element powerBlock = checkElementTouchUntransformable("powerBlock", 100, 50);

        if (powerBlock != null) {
            powerBlock.setNumericalVariableValue("pointer", pointer);
        }

        if (pointer == 0) {
            searchObj("dragger0").setNumericalVariableValue("pointer", 0);
            searchObj("dragger0").setNumericalVariableValue("prevX", screenX);
            searchObj("dragger0").setNumericalVariableValue("prevY", screenY);
        }

        if (pointer == 1) {
            searchObj("dragger1").setNumericalVariableValue("pointer", 1);
            searchObj("dragger1").setNumericalVariableValue("prevX", screenX);
            searchObj("dragger1").setNumericalVariableValue("prevY", screenY);
        }

        if (arrowGame.keyboardMode) {
//            Element key1 = checkElementTouchUntransformable("key1", 50, 50);
//            Element key2 = checkElementTouchUntransformable("key2", 50, 50);
//            Element key3 = checkElementTouchUntransformable("key3", 50, 50);
//            Element key4 = checkElementTouchUntransformable("key4", 50, 50);
//            key = checkElementTouchUntransformable("key5", 50, 50);
//            key = checkElementTouchUntransformable("key6", 50, 50);
//            key = checkElementTouchUntransformable("key7", 50, 50);
//            key = checkElementTouchUntransformable("key8", 50, 50);
//            key = checkElementTouchUntransformable("key9", 50, 50);
//            key = checkElementTouchUntransformable("key0", 50, 50);

            Element key;
            key = checkElementTouchUntransformable("keyq", 50, 50);
            if (key == null) key = checkElementTouchUntransformable("keyw", 50, 50);
            if (key == null) key = checkElementTouchUntransformable("keye", 50, 50);
            if (key == null) key = checkElementTouchUntransformable("keyr", 50, 50);
            if (key == null) key = checkElementTouchUntransformable("keyt", 50, 50);
            if (key == null) key = checkElementTouchUntransformable("keyy", 50, 50);
            if (key == null) key = checkElementTouchUntransformable("keyu", 50, 50);
            if (key == null) key = checkElementTouchUntransformable("keyi", 50, 50);
            if (key == null) key = checkElementTouchUntransformable("keyo", 50, 50);
            if (key == null) key = checkElementTouchUntransformable("keyp", 50, 50);

            if (key == null) key = checkElementTouchUntransformable("keya", 50, 50);
            if (key == null) key = checkElementTouchUntransformable("keys", 50, 50);
            if (key == null) key = checkElementTouchUntransformable("keyd", 50, 50);
            if (key == null) key = checkElementTouchUntransformable("keyf", 50, 50);
            if (key == null) key = checkElementTouchUntransformable("keyg", 50, 50);
            if (key == null) key = checkElementTouchUntransformable("keyh", 50, 50);
            if (key == null) key = checkElementTouchUntransformable("keyj", 50, 50);
            if (key == null) key = checkElementTouchUntransformable("keyk", 50, 50);
            if (key == null) key = checkElementTouchUntransformable("keyl", 50, 50);
            if (key == null) key = checkElementTouchUntransformable("keyup", 50, 50);

            if (key == null) key = checkElementTouchUntransformable("keyz", 50, 50);
            if (key == null) key = checkElementTouchUntransformable("keyx", 50, 50);
            if (key == null) key = checkElementTouchUntransformable("keyc", 50, 50);
            if (key == null) key = checkElementTouchUntransformable("keyv", 50, 50);
            if (key == null) key = checkElementTouchUntransformable("keyb", 50, 50);
            if (key == null) key = checkElementTouchUntransformable("keyn", 50, 50);
            if (key == null) key = checkElementTouchUntransformable("keym", 50, 50);

            if (key == null) key = checkElementTouchUntransformable("key1", 50, 50);
            if (key == null) key = checkElementTouchUntransformable("key2", 50, 50);
            if (key == null) key = checkElementTouchUntransformable("key3", 50, 50);
            if (key == null) key = checkElementTouchUntransformable("key4", 50, 50);
            if (key == null) key = checkElementTouchUntransformable("key5", 50, 50);
            if (key == null) key = checkElementTouchUntransformable("key6", 50, 50);
            if (key == null) key = checkElementTouchUntransformable("key7", 50, 50);
            if (key == null) key = checkElementTouchUntransformable("key8", 50, 50);
            if (key == null) key = checkElementTouchUntransformable("key9", 50, 50);
            if (key == null) key = checkElementTouchUntransformable("key0", 50, 50);

            if (key != null) {
                int x = key.getX();
                int y = key.getY();
                searchObj("keyClicked").setX(x);
                searchObj("keyClicked").setY(y);
                searchObj("keyClicked").setAlpha(0.5f);
                arrowGame.keyClicked = true;
            }
        }

        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        touchedX = (int) ((float) screenX * arrowGame.factor);
        touchedY = (int) (((float) Gdx.graphics.getHeight() - (float) screenY) * arrowGame.factor);

        arrowGame.gameMessage = "";
        System.out.println("touch up: x " + touchedX + " y " + touchedY);

        if (pointer == 0) {
            searchObj("dragger0").setNumericalVariableValue("pointer", -1);

        } else if (pointer == 1) {
            searchObj("dragger1").setNumericalVariableValue("pointer", -1);

        }

        if (arrowGame.keyClicked)
            arrowGame.keyClicked = false;

        if (!draggingMove0 && !draggingMove1) {
            if (arrowGame.keyboardMode) {
                Element key1 = checkElementTouchUntransformable("key1", 50, 50);
                Element key2 = checkElementTouchUntransformable("key2", 50, 50);
                Element key3 = checkElementTouchUntransformable("key3", 50, 50);
                Element key4 = checkElementTouchUntransformable("key4", 50, 50);
                Element key5 = checkElementTouchUntransformable("key5", 50, 50);
                Element key6 = checkElementTouchUntransformable("key6", 50, 50);
                Element key7 = checkElementTouchUntransformable("key7", 50, 50);
                Element key8 = checkElementTouchUntransformable("key8", 50, 50);
                Element key9 = checkElementTouchUntransformable("key9", 50, 50);
                Element key0 = checkElementTouchUntransformable("key0", 50, 50);

                Element keyq = checkElementTouchUntransformable("keyq", 50, 50);
                Element keyw = checkElementTouchUntransformable("keyw", 50, 50);
                Element keye = checkElementTouchUntransformable("keye", 50, 50);
                Element keyr = checkElementTouchUntransformable("keyr", 50, 50);
                Element keyt = checkElementTouchUntransformable("keyt", 50, 50);
                Element keyy = checkElementTouchUntransformable("keyy", 50, 50);
                Element keyu = checkElementTouchUntransformable("keyu", 50, 50);
                Element keyi = checkElementTouchUntransformable("keyi", 50, 50);
                Element keyo = checkElementTouchUntransformable("keyo", 50, 50);
                Element keyp = checkElementTouchUntransformable("keyp", 50, 50);

                Element keya = checkElementTouchUntransformable("keya", 50, 50);
                Element keys = checkElementTouchUntransformable("keys", 50, 50);
                Element keyd = checkElementTouchUntransformable("keyd", 50, 50);
                Element keyf = checkElementTouchUntransformable("keyf", 50, 50);
                Element keyg = checkElementTouchUntransformable("keyg", 50, 50);
                Element keyh = checkElementTouchUntransformable("keyh", 50, 50);
                Element keyj = checkElementTouchUntransformable("keyj", 50, 50);
                Element keyk = checkElementTouchUntransformable("keyk", 50, 50);
                Element keyl = checkElementTouchUntransformable("keyl", 50, 50);
                Element keyup = checkElementTouchUntransformable("keyup", 50, 50);

                Element keyz = checkElementTouchUntransformable("keyz", 50, 50);
                Element keyx = checkElementTouchUntransformable("keyx", 50, 50);
                Element keyc = checkElementTouchUntransformable("keyc", 50, 50);
                Element keyv = checkElementTouchUntransformable("keyv", 50, 50);
                Element keyb = checkElementTouchUntransformable("keyb", 50, 50);
                Element keyn = checkElementTouchUntransformable("keyn", 50, 50);
                Element keym = checkElementTouchUntransformable("keym", 50, 50);
                Element keyback = checkElementTouchUntransformable("keyback", 50, 50);
                Element keyenter = checkElementTouchUntransformable("keyenter", 50, 50);
                Element keycancel = checkElementTouchUntransformable("keycancel", 50, 50);

                if (key1 != null) {
                    arrowGame.writtenText += '1';
                } else if (key2 != null) {
                    arrowGame.writtenText += '2';
                } else if (key3 != null) {
                    arrowGame.writtenText += '3';
                } else if (key4 != null) {
                    arrowGame.writtenText += '4';
                } else if (key5 != null) {
                    arrowGame.writtenText += '5';
                } else if (key6 != null) {
                    arrowGame.writtenText += '6';
                } else if (key7 != null) {
                    arrowGame.writtenText += '7';
                } else if (key8 != null) {
                    arrowGame.writtenText += '8';
                } else if (key9 != null) {
                    arrowGame.writtenText += '9';
                } else if (key0 != null) {
                    arrowGame.writtenText += '0';
                } else if (keyq != null) {
                    arrowGame.writtenText += 'q';
                } else if (keyw != null) {
                    arrowGame.writtenText += 'w';
                } else if (keye != null) {
                    arrowGame.writtenText += 'e';
                } else if (keyr != null) {
                    arrowGame.writtenText += 'r';
                } else if (keyt != null) {
                    arrowGame.writtenText += 't';
                } else if (keyy != null) {
                    arrowGame.writtenText += 'y';
                } else if (keyu != null) {
                    arrowGame.writtenText += 'u';
                } else if (keyi != null) {
                    arrowGame.writtenText += 'i';
                } else if (keyo != null) {
                    arrowGame.writtenText += 'o';
                } else if (keyp != null) {
                    arrowGame.writtenText += 'p';
                } else if (keya != null) {
                    arrowGame.writtenText += 'a';
                } else if (keys != null) {
                    arrowGame.writtenText += 's';
                } else if (keyd != null) {
                    arrowGame.writtenText += 'd';
                } else if (keyf != null) {
                    arrowGame.writtenText += 'f';
                } else if (keyg != null) {
                    arrowGame.writtenText += 'g';
                } else if (keyh != null) {
                    arrowGame.writtenText += 'h';
                } else if (keyj != null) {
                    arrowGame.writtenText += 'j';
                } else if (keyk != null) {
                    arrowGame.writtenText += 'k';
                } else if (keyl != null) {
                    arrowGame.writtenText += 'l';
                } else if (keyup != null) {
                    arrowGame.keyboardUp = !arrowGame.keyboardUp;
                } else if (keyz != null) {
                    arrowGame.writtenText += 'z';
                } else if (keyx != null) {
                    arrowGame.writtenText += 'x';
                } else if (keyc != null) {
                    arrowGame.writtenText += 'c';
                } else if (keyv != null) {
                    arrowGame.writtenText += 'v';
                } else if (keyb != null) {
                    arrowGame.writtenText += 'b';
                } else if (keyn != null) {
                    arrowGame.writtenText += 'n';
                } else if (keym != null) {
                    arrowGame.writtenText += 'm';
                } else if (keyback != null && !arrowGame.writtenText.isEmpty()) {
                    arrowGame.writtenText = arrowGame.writtenText.substring(0, arrowGame.writtenText.length() - 1);
                } else if (keyenter != null) {
                    arrowGame.keyboardMode = false;
                    arrowGame.pressedEnter = true;
                } else if (keycancel != null) {
                    arrowGame.keyboardMode = false;
                    arrowGame.writtenText = arrowGame.writtenTextCopy;
                }

                if (arrowGame.writtenText.length() > 16)
                    arrowGame.writtenText = arrowGame.writtenText.substring(0, arrowGame.writtenText.length() - 1);

            } else if (arrowGame.gamePhase == 0) {           // intro
                arrowGame.gamePhase = 3;             // -> game mode select
            } else if (arrowGame.gamePhase == 1) {
                arrowGame.destinationX = touchedX;
                arrowGame.destinationY = touchedY;
            } else if (arrowGame.gamePhase == 2) {        // new game menu
                searchObj("intro").setAlpha(0.5f);
                Text versus = checkTextTouch("versus");
                Text solo = checkTextTouch("singlePlayer");


                if (versus != null) {
                    arrowGame.gamePhase = 3;             // -> create new game/join
//                play.gamePhase = 1100;             // -> Update - is player created?
                    arrowGame.gameMode = 2;
                }

                if (solo != null) {
                    arrowGame.gamePhase = 1;             // -> Single player mode

                    int index = -1;
                    for (int j = 0; j < arrowGame.elements.size(); j++) {
                        if (arrowGame.elements.get(j).getDesc().equals("eye")) {
                            index = j;
                            break;
                        }
                    }

                    arrowGame.elements.add(index + 1, new Element("archer", "archer.gif", 50, 150, 5, 5, 0.05f));
                    searchObj("archer").getAnimation().setStartFrame(0);
                    searchObj("archer").getAnimation().setFinishFrame(23);
                    searchObj("archer").addNumericalVariable("actualArrowID", 0);
                    searchObj("archer").addNumericalVariable("timePassed", 0);
                    searchObj("archer").addNumericalVariable("position", 1);
                    searchObj("archer").addNumericalVariable("playerId", -1);
                    searchObj("archer").addStringVariable("direction", "right");
                }
            } else if (arrowGame.gamePhase == 3) {        // versus game menu
                Element powerBlock = searchObj("powerBlock");
                powerBlock.setNumericalVariableValue("pointer", -1);
//                Element powerBlock = checkElementTouchUntransformable("powerBlock", 100, 50);
//
//                if (powerBlock.getNumericalVariableValue("pointer") == pointer)
//                    powerBlock.setNumericalVariableValue("pointer", -1);

                Element firefly = checkElementTouch("firefly", 50, 50);

                if (firefly != null)
                    arrowGame.flyModeOn = false;
                else {
                    arrowGame.flyModeOn = true;
                    arrowGame.wayX = arrowGame.wayY = arrowGame.madeX = arrowGame.madeY = 0;
                    arrowGame.destinationX = (int) ((double) arrowGame.transitionX + (double) touchedX * arrowGame.zoomTranslation) - arrowGame.rotationShiftX;
                    arrowGame.destinationY = (int) ((double) arrowGame.transitionY + (double) touchedY * arrowGame.zoomTranslation) - arrowGame.rotationShiftY;
                    System.out.println("destination x&y " + arrowGame.destinationX + ", " + arrowGame.destinationY);
                }
            } else if (arrowGame.gamePhase == 4) {    // create new versus game
                Text password = checkTextTouch("password");
//            Text gameName = checkTextTouch("gameName", screenX, screenY);
                Text playerName = checkTextTouch("playerName");
                Text onlineId = checkTextTouch("onlineId");
                Text confirm = checkTextTouch("confirm");

                if (password != null) {
                    arrowGame.keyboardMode = true;
                    arrowGame.keyboardWord = "password";
                    arrowGame.writtenTextCopy = arrowGame.writtenText = arrowGame.password;
                }

                if (onlineId != null) {
                    arrowGame.keyboardMode = true;
                    arrowGame.keyboardWord = "onlineId";
                    arrowGame.writtenTextCopy = arrowGame.writtenText = arrowGame.onlineId;
                }
                if (playerName != null) {
                    arrowGame.keyboardMode = true;
                    arrowGame.keyboardWord = "playerName";
//                play.writtenTextCopy = play.playerName = play.writtenText = play.texts.get("playerName").getValue();
                    arrowGame.writtenTextCopy = arrowGame.writtenText = arrowGame.playerName;
                }

                if (confirm != null) {
                    System.out.println("pl " + arrowGame.password + arrowGame.gameName + arrowGame.playerName);
                    if (!arrowGame.password.equals("") && !arrowGame.onlineId.equals("") && !arrowGame.playerName.equals("")) {
                        arrowGame.gamePhase = 1200;
//                    play.friendId = "AnonymousX1";
                        savePlayerData(arrowGame);
                        System.out.println("conf");
                    }
                }
            } else if (arrowGame.gamePhase == 1111) {    // guest game
                Text confirm = checkTextTouch("confirm");
                Text friendId = checkTextTouch("enterFriendId");
                Text yourName = checkTextTouch("yourName");

                if (yourName != null) {
                    arrowGame.keyboardMode = true;
                    arrowGame.keyboardWord = "playerName";
                    arrowGame.writtenTextCopy = arrowGame.writtenText = arrowGame.playerName;
                }

                if (friendId != null) {
                    arrowGame.keyboardMode = true;
                    arrowGame.keyboardWord = "onlineId";
                    arrowGame.writtenTextCopy = arrowGame.writtenText = arrowGame.onlineId;
                }

                if (confirm != null) {
                    System.out.println("pl " + arrowGame.password + arrowGame.gameName + arrowGame.playerName);
                    if (!arrowGame.playerName.equals("") && !arrowGame.onlineId.equals("")) {
                        arrowGame.gamePhase = 6;
//                    play.friendId = "AnonymousX1";
                        savePlayerData(arrowGame);
                        System.out.println("conf");

                    }
                }
            } else if (arrowGame.gamePhase == 6) {               // Update & Draw - looking for games/friend
            } else if (arrowGame.gamePhase == 7) {        // choose game
                Text gameName = checkTextTouch("gameName");
                Text confirm = checkTextTouch("confirm");

                if (gameName != null) {
                    arrowGame.keyboardMode = true;
                    arrowGame.keyboardWord = "gameName";
                    arrowGame.writtenTextCopy = arrowGame.writtenText = arrowGame.gameName;
                }
                if (confirm != null) {
                    if (!arrowGame.gameName.equals("")) {
                        arrowGame.gamePhase = 17;
                        System.out.println("conf");
                    }
                }
            } else if (arrowGame.gamePhase == 12) {          // HOST
                Text startVersus = checkTextTouch("startVersusGame");

                if (startVersus != null && arrowGame.playersAmount > 1) {
                    arrowGame.gamePhase = 19;
                    arrowGame._FBIC.removeEventListener1();
                }
            } else if (arrowGame.gamePhase == 14) {
                Text playerName = checkTextTouch("playerName");
//                Text password = checkTextTouch("password", screenX, screenY);
                Text login = checkTextTouch("login");

                if (playerName != null) {
                    arrowGame.keyboardMode = true;
                    arrowGame.keyboardWord = "playerName";
                    arrowGame.writtenTextCopy = arrowGame.playerName = arrowGame.writtenText = arrowGame.playerName;
                }
                if (login != null) {
                    System.out.println("pl " + arrowGame.password + arrowGame.gameName + arrowGame.playerName);
                    if (!arrowGame.playerName.equals("")) {
//                    play.gamePhase = 8;
                        arrowGame.gamePhase = 20;
                        System.out.println("login");
                        arrowGame.gameMessage = "";
                    }
                }
            }
//        } else draggingMove = false;
        } else {
            if (pointer == 0) {
                draggingMove0 = false;
            }

            if (pointer == 1) {
                draggingMove1 = false;
            }
        }
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        Element dragger0 = searchObj("dragger0");
        Element dragger1 = searchObj("dragger1");

        if (dragger0.getNumericalVariableValue("pointer") == pointer) {
            dragger0.setNumericalVariableValue("distanceX", Math.abs(screenX - dragger0.getNumericalVariableValue("prevX")));
            dragger0.setNumericalVariableValue("distanceY", Math.abs(screenY - dragger0.getNumericalVariableValue("prevY")));
        }

        if (dragger1.getNumericalVariableValue("pointer") == pointer) {
            dragger1.setNumericalVariableValue("distanceX", Math.abs(screenX - dragger1.getNumericalVariableValue("prevX")));
            dragger1.setNumericalVariableValue("distanceY", Math.abs(screenY - dragger1.getNumericalVariableValue("prevY")));
        }

        arrowGame.draggingDistanceX = Math.abs(screenX - prevX);
        arrowGame.draggingDistanceY = Math.abs(screenY - prevY);

        if (arrowGame.draggingDistanceX + arrowGame.draggingDistanceY > 5) {
            draggingMove = true;
            arrowGame.draggingDistanceX = arrowGame.draggingDistanceY = 0;
        }

        Element powerBlock = searchObj("powerBlock");

        if (powerBlock.getNumericalVariableValue("pointer") == pointer) {
            powerBlock.setY((int) (((Constants.SCREEN_HEIGHT - (float) screenY)) * arrowGame.factor) - powerBlock.getTexture().getRegionHeight() / 2);
        }
//
        if (dragger0.getNumericalVariableValue("pointer") == pointer && dragger0.getNumericalVariableValue("distanceX") + dragger0.getNumericalVariableValue("distanceY") > 5) {
            draggingMove0 = true;
            dragger0.setNumericalVariableValue("distanceX", 0);
            dragger0.setNumericalVariableValue("distanceY", 0);
        }

        if (dragger1.getNumericalVariableValue("pointer") == pointer && dragger1.getNumericalVariableValue("distanceX") + dragger1.getNumericalVariableValue("distanceY") > 5) {
            draggingMove1 = true;
            dragger1.setNumericalVariableValue("distanceX", 0);
            dragger1.setNumericalVariableValue("distanceY", 0);
        }


//        if (dragger0.getNumericalVariableValue("pointer") == pointer) {
//            dragger0.setY((int) (((Constants.SCREEN_HEIGHT - (float) screenY)) * arrowGame.factor) - dragger0.getTexture().getRegionHeight() / 2);
//            dragger0.setX((int) (((float) (screenX)) * arrowGame.factor) - dragger0.getTexture().getRegionWidth() / 2);
//        }
//
//        if (dragger1.getNumericalVariableValue("pointer") == pointer) {
//            dragger1.setY((int) (((Constants.SCREEN_HEIGHT - (float) screenY)) * arrowGame.factor) - dragger0.getTexture().getRegionHeight() / 2);
//            dragger1.setX((int) (((float) (screenX)) * arrowGame.factor) - dragger0.getTexture().getRegionWidth() / 2);
//        }
//
//        if (dragger0.getNumericalVariableValue("pointer") == 0 && dragger1.getNumericalVariableValue("pointer") == 1) {
//            arrowGame.distancePrev = arrowGame.distance;
////            arrowGame.distanceY = (dragger1.getY() - dragger0.getY()) * (dragger1.getY() - dragger0.getY());
//
//            int a = Math.abs(dragger1.getY() - dragger0.getY());
//            int b = Math.abs(dragger1.getX() - dragger0.getX());
//            arrowGame.distance = (int) Math.sqrt(a * a + b * b);
//            arrowGame.distanceDelta = (arrowGame.distancePrev - arrowGame.distance);
//            arrowGame.zoomingPhase = 1;
//        }

        if (dragger0.getNumericalVariableValue("pointer") == pointer) {
            dragger0.setNumericalVariableValue("deltaX", screenX - dragger0.getNumericalVariableValue("prevX"));
            dragger0.setNumericalVariableValue("deltaY", screenY - dragger0.getNumericalVariableValue("prevY"));
            dragger0.setX(screenX);
            dragger0.setY(screenY);
        }

        if (dragger1.getNumericalVariableValue("pointer") == pointer) {
            dragger1.setNumericalVariableValue("deltaX", screenX - dragger1.getNumericalVariableValue("prevX"));
            dragger1.setNumericalVariableValue("deltaY", screenY - dragger1.getNumericalVariableValue("prevY"));
            dragger1.setX(screenX);
            dragger1.setY(screenY);
        }

        if (dragger0.getNumericalVariableValue("pointer") == 0 && dragger1.getNumericalVariableValue("pointer") == 1) {
            arrowGame.distancePrev = arrowGame.distance;

            int x0 = dragger0.getX();
            int y0 = dragger0.getY();
            int x1 = dragger1.getX();
            int y1 = dragger1.getY();

            int distanceX = Math.abs(x0 - x1);
            int distanceY = Math.abs(y0 - y1);

            arrowGame.distance = (int) Math.sqrt(distanceX * distanceX + distanceY * distanceY);
            arrowGame.distanceDelta = arrowGame.distancePrev - arrowGame.distance;
            arrowGame.zoomingPhase = 1;
            arrowGame.gameMessage = arrowGame.distanceDelta + ", dst: " + arrowGame.distance;
        }

        if (dragger0.getNumericalVariableValue("pointer") == pointer) {
//            if (arrowGame.flyModeOn) {
//                touchedX = (int) ((float) screenX * arrowGame.factor);
//                touchedY = (int) (((float) Gdx.graphics.getHeight() - (float) screenY) * arrowGame.factor);
//
//                arrowGame.wayX = arrowGame.wayY = arrowGame.madeX = arrowGame.madeY = 0;
//                arrowGame.destinationX = (int) ((double) arrowGame.transitionX + (double) touchedX * arrowGame.zoomTranslation) - arrowGame.rotationShiftX;
//                arrowGame.destinationY = (int) ((double) arrowGame.transitionY + (double) touchedY * arrowGame.zoomTranslation) - arrowGame.rotationShiftY;
//                System.out.println("destination x&y " + arrowGame.destinationX + ", " + arrowGame.destinationY);
//            }


            arrowGame.cameraShiftX -= (int) (dragger0.getNumericalVariableValue("deltaX") * (double) arrowGame.zoomModifier);
            arrowGame.cameraShiftY += (int) (dragger0.getNumericalVariableValue("deltaY") * (double) arrowGame.zoomModifier);

            if (arrowGame.cameraShiftY < -2000)
                arrowGame.cameraShiftY = -2000;

            if (arrowGame.cameraShiftY > 2000)
                arrowGame.cameraShiftY = 2000;

            if (arrowGame.cameraShiftX < -2000)
                arrowGame.cameraShiftX = -2000;

            if (arrowGame.cameraShiftX > 2000)
                arrowGame.cameraShiftX = 2000;

            if (dragger0.getNumericalVariableValue("delta") > 2)
                draggingMove = true;

            dragger0.setNumericalVariableValue("prevX", screenX);
            dragger0.setNumericalVariableValue("prevY", screenY);
        }
//
        if (dragger1.getNumericalVariableValue("pointer") == pointer) {
            arrowGame.cameraShiftX -= (int) (dragger1.getNumericalVariableValue("deltaX") * (double)arrowGame.zoomModifier);
            arrowGame.cameraShiftY += (int) (dragger1.getNumericalVariableValue("deltaY") * (double)arrowGame.zoomModifier);

            if (arrowGame.cameraShiftY < -1000)
                arrowGame.cameraShiftY = -1000;

            if (arrowGame.cameraShiftY > 500)
                arrowGame.cameraShiftY = 500;

            if (arrowGame.cameraShiftX < -1000)
                arrowGame.cameraShiftX = -1000;

            if (arrowGame.cameraShiftX > 1500)
                arrowGame.cameraShiftX = 1500;

//            if (dragger1.getNumericalVariableValue("delta") > 2)
//                draggingMove = true;

            dragger1.setNumericalVariableValue("prevX", screenX);
            dragger1.setNumericalVariableValue("prevY", screenY);
        }

        prevX = screenX;
        prevY = screenY;

        if (pointer == 0) {
            searchObj("dragger0").setNumericalVariableValue("pointer", 0);
            searchObj("dragger0").setNumericalVariableValue("prevX", screenX);
            searchObj("dragger0").setNumericalVariableValue("prevY", screenY);
        }

        if (pointer == 1) {
            searchObj("dragger1").setNumericalVariableValue("pointer", 1);
            searchObj("dragger1").setNumericalVariableValue("prevX", screenX);
            searchObj("dragger1").setNumericalVariableValue("prevY", screenY);
        }

        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(float amountX, float amountY) {
        return false;
    }

    private Element checkElementTouch(String desc, int rangeX, int rangeY) {
        Element touchedElement = null;
        Element element = searchObj(desc);
        int elCenterX = element.getTexture().getRegionWidth() / 2;
        int elCenterY = element.getTexture().getRegionHeight() / 2;
        double touchedTranslatedX = 0, touchedTranslatedY = 0;


        touchedTranslatedX = (double) arrowGame.transitionX + (double) touchedX * arrowGame.zoomTranslation;
        touchedTranslatedY = (double) arrowGame.transitionY + (double) touchedY * arrowGame.zoomTranslation;


        System.out.println("checkElementTouch2: X & Y -> " + touchedTranslatedX + "," + touchedTranslatedY + " el.X " + element.getX() + " el Y: " + element.getY());
//        arrowGame.gameMessage = ("X&Y-> " + (int) touchedTranslatedX + ", " + (int) touchedTranslatedY + ", factor-> " + arrowGame.factor);

        if (touchedTranslatedX < (double) element.getX() + (double) elCenterX + (double) rangeX - (double) arrowGame.cameraShiftX * element.getParallaxFactorX() + arrowGame.rotationShiftX &&
                touchedTranslatedX > (double) element.getX() + (double) elCenterX - (double) rangeX - (double) arrowGame.cameraShiftX * element.getParallaxFactorX() + arrowGame.rotationShiftX &&
                touchedTranslatedY < (double) element.getY() + (double) elCenterY + (double) rangeY - (double) arrowGame.cameraShiftY * element.getParallaxFactorY() + arrowGame.rotationShiftY &&
                touchedTranslatedY > (double) element.getY() + (double) elCenterY - (double) rangeY - (double) arrowGame.cameraShiftY * element.getParallaxFactorY() + arrowGame.rotationShiftY) {

            touchedElement = element;
        }
        return touchedElement;
    }

    private Element checkElementTouchUntransformable(String desc, int rangeX, int rangeY) {
        Element touchedElement = null;
        Element element = searchObj(desc);
        int elCenterX = element.getTexture().getRegionWidth() / 2;
        int elCenterY = element.getTexture().getRegionHeight() / 2;
        float touchedTranslatedX = touchedX;
        float touchedTranslatedY = touchedY;
        System.out.println("checkElementTouch2: X & Y -> " + touchedTranslatedX + "," + touchedTranslatedY + " el.X " + element.getX());

        if (touchedTranslatedX < element.getX() + elCenterX + rangeX &&
                touchedTranslatedX > element.getX() + elCenterX - rangeX &&
                touchedTranslatedY < element.getY() + elCenterY + rangeY &&
                touchedTranslatedY > element.getY() + elCenterY - rangeY) {

            touchedElement = element;
        }
        return touchedElement;
    }

    private Text checkTextTouch(String key) {
        Text touchedText = null;
        Text text = arrowGame.texts.get(key);
        int elCenterX = text.getText().length() * 20;
        int elCenterY = 25;
        int rangeX = 200;
        int rangeY = 50;
        float touchedTranslatedX = touchedX;
        float touchedTranslatedY = touchedY;
//        System.out.println("checkElementTouch2: X & Y -> " + touchedTranslatedX + "," + touchedTranslatedY + " el.X " + element.getX());
//        System.out.println("transitionX -> " + arrowGame.transitionX + ", zoomTransition: " + arrowGame.zoomTranslation);

        if (touchedTranslatedX < text.getX() + elCenterX + rangeX &&
                touchedTranslatedX > text.getX() + elCenterX - rangeX &&
                touchedTranslatedY < text.getY() - elCenterY + rangeY &&
                touchedTranslatedY > text.getY() - elCenterY - rangeY) {

            touchedText = text;
        }
        return touchedText;
    }

    private Text checkTextTouchTransformable(String key) {
//        Text touchedText = null;
//        Text text = arrowGame.texts.get(key);
//        int rangeX = text.getText().length() * 14;
//        int rangeY = 50;
//
//        if ((((int) ((float) screenX * arrowGame.factor)) - rangeX < text.getX() + text.getText().length() * 14) &&
//                (((int) ((float) screenX * arrowGame.factor)) + rangeX > text.getX() + text.getText().length() * 14) &&
//                ((((Constants.SCREEN_HEIGHT - (float) screenY)) * arrowGame.factor) - rangeY < text.getY() - rangeY) &&
//                ((((Constants.SCREEN_HEIGHT - (float) screenY)) * arrowGame.factor) + rangeY > text.getY() - rangeY)) {
//            System.out.println("touched");
//            touchedText = text;
//        }
//        return touchedText;


        Text touchedText = null;
        Text text = arrowGame.texts.get(key);
        int elCenterX = text.getText().length() * 7;
        int elCenterY = 25;
        int rangeX = 200;
        int rangeY = 50;
        float touchedTranslatedX = arrowGame.transitionX + touchedX * arrowGame.zoomTranslation;
        float touchedTranslatedY = arrowGame.transitionY + touchedY * arrowGame.zoomTranslation;
//        System.out.println("checkElementTouch2: X & Y -> " + touchedTranslatedX + "," + touchedTranslatedY + " el.X " + element.getX());
//        System.out.println("transitionX -> " + arrowGame.transitionX + ", zoomTransition: " + arrowGame.zoomTranslation);

        if (touchedTranslatedX < text.getX() + elCenterX + rangeX - arrowGame.cameraShiftX &&
                touchedTranslatedX > text.getX() + elCenterX - rangeX - arrowGame.cameraShiftX &&
                touchedTranslatedY < text.getY() + elCenterY + rangeY - arrowGame.cameraShiftY &&
                touchedTranslatedY > text.getY() + elCenterY - rangeY - arrowGame.cameraShiftY) {

            touchedText = text;
        }
        return touchedText;
    }

    private Element searchObj(String name) {
        for (Element img : arrowGame.elements)
            if (img.getDesc().equals(name))
                return img;

        return null;
    }

    private Element searchObjByVariable(String name, String variable, int value) {
        for (Element img : arrowGame.elements)
            if (img.getDesc().equals(name) && img.getNumericalVariableValue(variable) == value)
                return img;

        return null;
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
}
