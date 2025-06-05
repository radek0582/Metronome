package com.doga.game;


import java.util.Random;

public class Move {
    public static int randomNumber(int start, int range) {
        int number = -1;
        Random r = new Random();
        number = r.nextInt(range) + start;
        return number;
    }

    public static void moveElements(ArrowGame arrowGame) {
        double angle = 0d;
//        double a1 = 0;

        if (arrowGame.gamePhase == 3) {
//            Element webs2 = searchObj("webs", arrowGame);
//            double curAngle = webs2.getNumericalVariableValue("actAngle");
//            webs2.setNumericalVariableValue("actAngle", curAngle + 1);

//            arrowGame.curSec = (System.nanoTime() - arrowGame.startTime) / 1000000000;
//
//            if (arrowGame.curSec != arrowGame.prevSec){
//                arrowGame.sec ++;
//                arrowGame.prevSec = arrowGame.curSec;
//            }
//            arrowGame.gameMessage = "sek: " + arrowGame.sec;
            arrowGame.milliSecToBeat = 60000 / arrowGame.bpm;

            arrowGame.totalMilliSec = (System.nanoTime() - arrowGame.startTime) / 1000000;

            if (arrowGame.totalMilliSec != arrowGame.prevMilliSec) {
                arrowGame.passedMilliSec = arrowGame.totalMilliSec - arrowGame.prevMilliSec;
                arrowGame.prevMilliSec = arrowGame.totalMilliSec;
                arrowGame.milliSecLeftToBeat -= arrowGame.passedMilliSec;
            }

//            arrowGame.gameMessage = "sek: " + arrowGame.sec;

//            Element blade = searchObj("testPoint", arrowGame);
            Element blade = searchObj("pendulum", arrowGame);
            double angle1 = blade.getNumericalVariableValue("externalAngle");
            Element slider = searchObj("slider", arrowGame);

            Element firefly1 = searchObj("wheelPoint", arrowGame);

            int centerRotationPointX = firefly1.getX() + firefly1.getTexture().getRegionWidth() / 2;
            int centerRotationPointY = firefly1.getY() + firefly1.getTexture().getRegionHeight() / 2;

            double radians = Math.toRadians(-angle1);
            int xPos = 400;//centerBladeX - centerRotationPointX;
            int yPos = 400;//centerBladeY - centerRotationPointY;
            int angleTransX = (int) ((double) xPos * Math.cos(radians) - (double) yPos * Math.sin(radians));
            int angleTransY = (int) ((double) xPos * Math.sin(radians) + (double) yPos * Math.cos(radians));
            blade.setX(centerRotationPointX - blade.getTexture().getRegionWidth() / 2 + angleTransX);
            blade.setY(centerRotationPointY - blade.getTexture().getRegionHeight() / 2 + angleTransY);


            xPos = yPos = arrowGame.sliderY;
            angleTransX = (int) ((double) xPos * Math.cos(radians) - (double) yPos * Math.sin(radians));
            angleTransY = (int) ((double) xPos * Math.sin(radians) + (double) yPos * Math.cos(radians));
            slider.setX(centerRotationPointX - slider.getTexture().getRegionWidth() / 2 + angleTransX);
            slider.setY(centerRotationPointY - slider.getTexture().getRegionHeight() / 2 + angleTransY);

            System.out.println("angle1, centerRotPX, anglTransX: " + angle1 + ", " + centerRotationPointX + ", " + angleTransX);
//            angle1 += 0.2;
//            if (angle1 >= 360)
//                angle1 = 0;
            double speed = arrowGame.bpm;
            String direction = blade.getStringVariableValue("direction");

//            if (direction.equals("left")) {
//                double angleWay = angle1 -
//            }
            double angleWay = 0;        // way left to make


            if (direction.equals("right")) {
                angle1 = -(double) arrowGame.milliSecLeftToBeat * 30 / arrowGame.milliSecToBeat - 30;
            } else {
                angle1 = -60 + (double) arrowGame.milliSecLeftToBeat * 30 / arrowGame.milliSecToBeat;
            }
//            arrowGame.gameMessage = "speed: " + arrowGame.bpm + " angle: " + angle1;

//            if (direction.equals("right")) {
//                angle1 += 0.3;
////                arrowGame.gameMessage = "right, " + angle1;
//            } else {
////                angle1 -= speed;
//                angle1 -= 0.3;
////                arrowGame.gameMessage = "left, " + angle1;
//            }

            if (arrowGame.milliSecLeftToBeat <= 0) {
                arrowGame.makeBeatSound = true;
                arrowGame.gameMessage = "diff: " + arrowGame.milliSecLeftToBeat;
//                arrowGame.musicList.get(1).setVolume(0.99f);
//                arrowGame.musicList.get(1).play();
//                arrowGame.musicList.get(1).setLooping(false);
//                arrowGame.soundList.get(0).play();
                arrowGame.milliSecLeftToBeat = 60000 / arrowGame.bpm;
                if (direction.equals("left")) {
                    blade.setStringVariableValue("direction", "right");
                    slider.setStringVariableValue("direction", "right");
                }
                else {
                    blade.setStringVariableValue("direction", "left");
                    slider.setStringVariableValue("direction", "left");
                }
            }

//            if (angle1 >= -30) {
//                blade.setStringVariableValue("direction", "left");
//
//            } else if (angle1 <= -60) blade.setStringVariableValue("direction", "right");


            blade.setNumericalVariableValue("externalAngle", angle1);
            slider.setNumericalVariableValue("externalAngle", angle1);
            double actAngle = 0;

            int bladeX = blade.getX();
            int bladeY = blade.getY();
            int centerBladeX = bladeX + blade.getTexture().getRegionWidth() / 2;
            int centerBladeY = bladeY + blade.getTexture().getRegionHeight() / 2;

            int sliderX = slider.getX();
            int sliderY = slider.getY();
            int centerSliderX = sliderX + slider.getTexture().getRegionWidth() / 2;
            int centerSliderY = sliderY + slider.getTexture().getRegionHeight() / 2;

            double a1;

            if (centerBladeX == centerRotationPointX)
                a1 = 0;
            else
                a1 = ((double) centerRotationPointY - (double) centerBladeY) / ((double) centerRotationPointX - (double) centerBladeX);

            double degs1 = Math.toDegrees(Math.atan(a1));

            if (centerRotationPointX == centerBladeX) {
                if (centerRotationPointY < centerBladeY)
                    degs1 = -90;
                else
                    degs1 = 90;
            }
            if (centerRotationPointX - centerBladeX < 0)
                degs1 -= 180;

            actAngle = degs1 - 90;

            blade.setNumericalVariableValue("actAngle", actAngle + 180);




//            double a1;

            if (centerSliderX == centerRotationPointX)
                a1 = 0;
            else
                a1 = ((double) centerRotationPointY - (double) centerSliderY) / ((double) centerRotationPointX - (double) centerSliderX);

            degs1 = Math.toDegrees(Math.atan(a1));

            if (centerRotationPointX == centerSliderX) {
                if (centerRotationPointY < centerSliderY)
                    degs1 = -90;
                else
                    degs1 = 90;
            }
            if (centerRotationPointX - centerSliderX < 0)
                degs1 -= 180;

            actAngle = degs1 - 90;

            slider.setNumericalVariableValue("actAngle", actAngle + 180);


//            arrowGame.gameMessage = "actAngle " + actAngle;


            if (arrowGame.trapped) {
                arrowGame.flyModeOn = false;
                arrowGame.spiderComes = true;
                Element webs = searchObj("webs", arrowGame);
                int currentFrame = webs.getAnimation().getCurrentFrame();

                if (currentFrame == 0) {
                    webs.getAnimation().setStartFrame(0);
                    webs.getAnimation().setFinishFrame(1);
                } else if (currentFrame == 15) {
                    webs.getAnimation().setStartFrame(14);
                    webs.getAnimation().setFinishFrame(15);
                } else {
                    webs.getAnimation().setStartFrame(currentFrame - 1);
                    webs.getAnimation().setFinishFrame(currentFrame + 1);
                }
                arrowGame.trapped = false;
            }

            if (arrowGame.spiderComes) {
                Element spider = searchObj("bigSpider", arrowGame);
                Element fireFly = searchObj("firefly", arrowGame);
                int spiderX = spider.getX();
                int spiderY = spider.getY();
                int fireflyX = fireFly.getX();
                int fireflyY = fireFly.getY();

                if (spiderX > fireflyX)
                    spider.setX(spiderX - 1);
                else spider.setX(spiderX + 1);

                if (spiderY > fireflyY)
                    spider.setY(spiderY - 1);
                else spider.setY(spiderY + 1);
            }

            if (arrowGame.flyModeOn && !arrowGame.spiderComes) {
                arrowGame.fireflySpeed += 1f;

                if (arrowGame.fireflySpeed >= 1) {
                    Element firefly = searchObj("firefly", arrowGame);

                    int screenFireflyX = (int) ((float) (firefly.getX() + firefly.getTexture().getRegionWidth() / 2 - arrowGame.cameraShiftX));
                    int screenFireflyY = firefly.getY() + firefly.getTexture().getRegionHeight() / 2 - arrowGame.cameraShiftY;

                    double a;

                    if (arrowGame.destinationX == screenFireflyX)
                        a = 0;
                    else
                        a = ((double) arrowGame.destinationY - (double) screenFireflyY) / ((double) arrowGame.destinationX - (double) screenFireflyX);

                    double degs = Math.toDegrees(Math.atan(a));

                    if (arrowGame.destinationX == screenFireflyX) {
                        if (arrowGame.destinationY < screenFireflyY)
                            degs = -90;
                        else
                            degs = 90;
                    }
                    if (arrowGame.destinationX - screenFireflyX < 0)
                        degs -= 180;

                    angle = degs - 90;

                    firefly.setNumericalVariableValue("actAngle", angle);
//                    System.out.println("screen firefly x & y & angle: " + screenFireflyX + ", " + screenFireflyY + ", " + angle);

                    int fireflyX = firefly.getX();
                    int fireflyY = firefly.getY();
                    int fireflySpeed = 1;

                    if (degs <= 45 && degs >= -45) {
                        arrowGame.wayX = fireflyX + fireflySpeed;
                        arrowGame.wayY = fireflyY;
                        arrowGame.madeX += fireflySpeed;

                        if (arrowGame.madeX * a >= fireflySpeed) {
                            arrowGame.madeX = 0;
                            arrowGame.wayY = fireflyY + fireflySpeed;
                        } else if (arrowGame.madeX * a <= -fireflySpeed) {
                            arrowGame.madeX = 0;
                            arrowGame.wayY = fireflyY - fireflySpeed;
                        }
                        arrowGame.gameMessage = "a: " + a;
                    } else if (degs >= -225 && degs <= -135) {
                        arrowGame.wayX = fireflyX - fireflySpeed;
                        arrowGame.wayY = fireflyY;
                        arrowGame.madeX += fireflySpeed;

                        if (arrowGame.madeX * a >= 1) {
                            arrowGame.madeX = 0;
                            arrowGame.wayY = fireflyY - fireflySpeed;
                        } else if (arrowGame.madeX * a <= -fireflySpeed) {
                            arrowGame.madeX = 0;
                            arrowGame.wayY = fireflyY + fireflySpeed;
                        }
                        arrowGame.gameMessage = "a: " + a;
                    } else if (degs < -225 && degs >= -270 || degs > 45) {
                        arrowGame.wayY = fireflyY + fireflySpeed;
                        arrowGame.wayX = fireflyX;
                        arrowGame.madeY += fireflySpeed;

                        if (arrowGame.madeY / a >= 2) {
                            arrowGame.madeY = 0;
                            arrowGame.wayX = fireflyX + fireflySpeed;
                        } else if (arrowGame.madeY / a <= -2) {
                            arrowGame.madeY = 0;
                            arrowGame.wayX = fireflyX - fireflySpeed;
                        }
                        arrowGame.gameMessage = "a: " + a;
                    } else if (degs < -45 && degs > -135) {
                        arrowGame.wayY = fireflyY - fireflySpeed;
                        arrowGame.wayX = fireflyX;
                        arrowGame.madeY += fireflySpeed;

                        if (arrowGame.madeY / a >= fireflySpeed) {
                            arrowGame.madeY = 0;
                            arrowGame.wayX = fireflyX - fireflySpeed;
                        } else if (arrowGame.madeY / a <= -fireflySpeed) {
                            arrowGame.madeY = 0;
                            arrowGame.wayX = fireflyX + fireflySpeed;
                        }
                    }
////                    else if (degs < -45 && degs >= -135) {
////                        newY = fireflyY - 1;
////                        newX = newY / a;
////                    } else if (degs < -135 && degs >= -225) {
////                        newX = fireflyX - 1;
////                        newY = a * newX;
////                    } else if (degs > 45 || degs < -225 && degs >= -270) {
////                        newY = fireflyY + 1;
////                        newX = newY / a;
////                    }
//
////                arrowGame.cameraShiftX += fireflyX + (int)newX;
////                arrowGame.cameraShiftY += fireflyY + (int)newY;
                    arrowGame.cameraShiftX += (int) (arrowGame.wayX - firefly.getX());
                    arrowGame.cameraShiftY += (int) (arrowGame.wayY - firefly.getY());
                    firefly.setX((int) arrowGame.wayX);
                    firefly.setY((int) arrowGame.wayY);


                    arrowGame.fireflySpeed = 0;
                }
            }
        }

        if (arrowGame.gamePhase == 1) {
            arrowGame.gameTime++;

            for (Element el : arrowGame.elements) {
                if (el.getDesc().equals("arrow")) {
                    if (el.getNumericalVariableValue("place") == 2) {
                        el.getAnimation().setStartFrame(1);
                        el.getAnimation().setCurrentFrame(1);
                        el.getAnimation().setFinishFrame(9);
                        el.getAnimation().setPlayOnlyOnce(true);
                        el.getAnimation().setMaxFrameTime(0.1f);
//                            el.rotateFrames(1, 9, 1, 10, img.getVariableValue("actAngle"));
                        el.setNumericalVariableValue("place", 5);
                    } else if (el.getNumericalVariableValue("place") == 1) {
                        double elapsedTime = el.getNumericalVariableValue("elapsedTime");

                        if (el.getNumericalVariableValue("isShoot") == -1) {
                            el.setToDraw(true);
                            el.setNumericalVariableValue("isShoot", 1);
                            el.setNumericalVariableValue("elapsedTime", 0.0d);
                            el.setNumericalVariableValue("initialX", el.getX());
                            el.setNumericalVariableValue("initialY", el.getY());
                            el.setNumericalVariableValue("prevX", el.getX());
                            el.setNumericalVariableValue("prevY", el.getY());
                            el.setNumericalVariableValue("startPower", arrowGame.powerArcher1);
                            el.setNumericalVariableValue("startAngle", arrowGame.angleArcher1);
                        }
                        double v0X = (double) el.getNumericalVariableValue("startPower") * Math.cos(Math.toRadians(el.getNumericalVariableValue("startAngle")));
                        double v0Y = (double) el.getNumericalVariableValue("startPower") * Math.sin(Math.toRadians(el.getNumericalVariableValue("startAngle")));
                        double currentVx = v0X / 2;
                        double currentVy = (v0Y - arrowGame.gravity * elapsedTime) / 2;

                        double xRoad = currentVx;
                        double yRoad = currentVy;
                        el.setNumericalVariableValue("elapsedTime", elapsedTime + 0.05d);

                        el.setX(el.getX() + (int) xRoad);
                        el.setY(el.getY() + (int) yRoad);

                        int flyingDuration = (int) el.getNumericalVariableValue("flyingDuration");
                        el.setNumericalVariableValue("flyingDuration", flyingDuration + 1);

                        if (flyingDuration > 2)
                            el.setNumericalVariableValue("inMove", 1);

                        int angleArrowCalcTime = (int) el.getNumericalVariableValue("angleArrowCalcTime");

                        if (angleArrowCalcTime > 1) {
                            double a;

                            if (el.getX() == el.getNumericalVariableValue("prevX"))
                                a = 0;
                            else
                                a = (double) (el.getY() - el.getNumericalVariableValue("prevY")) / (el.getX() - el.getNumericalVariableValue("prevX"));

                            double degs = Math.toDegrees(Math.atan(a));

                            if (el.getX() == el.getNumericalVariableValue("prevX")) {
                                if (el.getY() < el.getNumericalVariableValue("prevY"))
                                    degs = -90;
                                else
                                    degs = 90;
                            }
                            if (el.getX() - el.getNumericalVariableValue("prevX") < 0)
                                degs -= 180;

                            angle = degs;

                            el.setNumericalVariableValue("actAngle", (int) angle);
                            el.setNumericalVariableValue("angleArrowCalcTime", 0);

                            System.out.println("angleact " + el.getNumericalVariableValue("actAngle"));
                        } else if (angleArrowCalcTime == 0) {
                            el.setNumericalVariableValue("angleArrowCalcTime", 1);
                            el.setNumericalVariableValue("prevX", el.getX());
                            el.setNumericalVariableValue("prevY", el.getY());
                        } else if (angleArrowCalcTime == 1)
                            el.setNumericalVariableValue("angleArrowCalcTime", 2);
                    }
                }

                if (el.getDesc().equals("archer")) {
                    if (el.getNumericalVariableValue("position") == 1) {        // stand by
                        el.getAnimation().setStartFrame(22);
                        el.getAnimation().setCurrentFrame(22);
                        el.getAnimation().setFinishFrame(22);
                    } else if (el.getNumericalVariableValue("position") == 2) { // loading...
                        el.getAnimation().setStartFrame(0);
                        el.getAnimation().setCurrentFrame(0);
                        el.getAnimation().setFinishFrame(10);
                        el.getAnimation().setPlayOnlyOnce(true);
                        el.getAnimation().setMaxFrameTime(0.05f);
                        el.setNumericalVariableValue("position", -1);
                        el.setNumericalVariableValue("timePassed", 0);
                    } else if (el.getNumericalVariableValue("position") == 3) {     // shooting...
                        el.getAnimation().setStartFrame(11);
                        el.getAnimation().setFinishFrame(22);
                        el.getAnimation().setPlayOnlyOnce(true);
                        el.getAnimation().setMaxFrameTime(0.05f);
                        el.setNumericalVariableValue("position", -3);
                    } else if (el.getNumericalVariableValue("position") == -1) {    // loaded, ready to shot
                        if (el.getNumericalVariableValue("timePassed") == 5) {
                            el.setNumericalVariableValue("position", -2);
                            el.setNumericalVariableValue("timePassed", 0);
                        }
                        el.setNumericalVariableValue("timePassed", el.getNumericalVariableValue("timePassed") + 1);
                    }
                }

                if (el.getDesc().equals("arrow") && (el.getX() >= 10500 || el.getY() < 100)) {
                    el.setNumericalVariableValue("place", 0);
                    el.setToDraw(false);
                    el.setX(200);
                    el.setY(200);
                    el.setNumericalVariableValue("inMove", 0);
                    el.setNumericalVariableValue("inApple", 0);
                    el.setNumericalVariableValue("inEye", 0);
                    el.setNumericalVariableValue("elapsedTime", 0.0d);
                    el.setNumericalVariableValue("isShoot", -1);
                    el.setNumericalVariableValue("initialX", -10000);
                    el.setNumericalVariableValue("initialY", -10000);
                    el.setNumericalVariableValue("flyingDuration", 0);
                    el.setNumericalVariableValue("vX", -10000.0d);
                    el.setNumericalVariableValue("vY", -10000.0);
                    el.setNumericalVariableValue("actAngle", 0);
                    el.getAnimation().setMaxFrameTime(200);
                    el.getAnimation().setStartFrame(0);
                    el.getAnimation().setFinishFrame(0);
                    el.getAnimation().setPlayOnlyOnce(false);
                    searchObj("archer", arrowGame).setNumericalVariableValue("position", 1);
                    el.setNumericalVariableValue("prevX", -10000);
                    el.setNumericalVariableValue("prevY", -10000);
                    System.out.println("new game");
                }
//
//                    if (img.getVariableValueString("type").equals("apple") && img.getVariableValue("isHit") == 1) {
//                        if (img.getPositionY() < 800) {
//                            double elapsedTime = img.getVariableValueDouble("elapsedTimeApple");
//                            double currentVy = gamePanel.gravity * elapsedTime;
//                            double yRoad = currentVy;
//                            img.setPositionY(img.getPositionY() + (int) yRoad);
//                            elapsedTime += 0.025d;
//                            img.setVariableValueDouble("elapsedTimeApple", elapsedTime);
//                        }
//                    }

//                    if (img.getDesc().equals("eye")) {
//                        if (img.getVariableValue("isHit") == 1) {
//                            img.setVariableValue("isHit", 2);
////                            img.getAnimation().setFrameShift(3);
//                            img.getAnimation().setCurrentFrame(3);
//                            img.getAnimation().setFinishFrame(4);
////                            img.getAnimation().setAnimationLength(1);
//                            img.getAnimation().setPlayOnlyOnce(true);
//                            img.getAnimation().setPlayBackwards(false);
//                            img.getAnimation().setStartTime(System.nanoTime());
//                            img.getAnimation().setDelay(300);
//                            img.setVariableValue("time", img.getVariableValue("time") + 1);
//                        }
//                        if (img.getVariableValue("isHit") == 2) {
//                            if (img.getVariableValue("time") == 10) {
//                                img.setPositionX(-10000);
//                                img.setPositionY(-10000);
//                            }
//                            if (img.getVariableValue("time") == 50) {
//                                img.setPositionX(500);
//                                img.setPositionY(200);
//                            }
//                        }
//                    }

            }

        }
    }

    static Element searchObj(String name, ArrowGame play) {
        for (Element img : play.elements)
            if (img.getDesc().equals(name))
                return img;

        return null;
    }

}
