package com.doga.game;

import com.badlogic.gdx.graphics.Color;

public class Collisions {
    public static void detectCollisions(ArrowGame arrowGame) {
//        Element firefly = searchObj("firefly", arrowGame);
//        Element web = searchObj("webs", arrowGame);
//
//        int fireflyX = firefly.getX();
//        int fireflyY = firefly.getY();
//        int webX = web.getX();
//        int webY = web.getY();
//        int centerFireflyX = fireflyX + firefly.getTexture().getRegionWidth() / 2;
//        int centerFireflyY = fireflyY + firefly.getTexture().getRegionHeight() / 2;
//        int width = web.getTexture().getRegionWidth();
//        int height = web.getTexture().getRegionHeight();
//        int centerWebX = webX + width / 2;
//        int centerWebY = webY + height / 2;
//        int currentFrame = web.getAnimation().getCurrentFrame();
//        int framesAmountX = web.getFrameCountX();
//        int xFrame = currentFrame % framesAmountX;
//        int yFrame = currentFrame / framesAmountX;
//        int angleTransX = 0;
//        int angleTransY = 0;
//        double angle = web.getNumericalVariableValue("actAngle");
//        double radians = Math.toRadians(-angle);
//        int xPos = centerFireflyX - centerWebX;
//        int yPos = centerFireflyY - centerWebY;
//        angleTransX = (int) ((double) xPos * Math.cos(radians) - (double) yPos * Math.sin(radians));
//        angleTransY = (int) ((double) xPos * Math.sin(radians) + (double) yPos * Math.cos(radians));
//        arrowGame.gameMessage = ", centerFX/Y " + centerFireflyX + "/" + centerFireflyY;
//        int xCheck = width / 2 + angleTransX + width * xFrame;
//        int yCheck = height / 2 - angleTransY + height * yFrame;
//
//        if (xCheck >= width * xFrame && xCheck < width * (xFrame + 1) && yCheck >= height * yFrame && yCheck < height * (yFrame + 1)) {
//            int c = arrowGame.collisionMatrixWeb.get(web.getDesc()).getPixel(xCheck, yCheck);
//            arrowGame.gameMessage = "color: " + c + ", xPos/yPos " + xPos + "/" + yPos;
//            if (c != -256) {
////                arrowGame.trapped = true;
//            }
//        }
    }

    // TODO: parallax factor

    static int checkCollision(Element el1, int rangeX, int rangeY, Element el2) {
        int el1centerX = el1.getX() + el1.getTexture().getRegionWidth() / 2;
        int el1centerY = el1.getY() + el1.getTexture().getRegionHeight() / 2;
        int el2centerX = el2.getX() + el2.getTexture().getRegionWidth() / 2;
        int el2centerY = el2.getY() + el2.getTexture().getRegionHeight() / 2;

        if (el1centerX - rangeX < el2centerX && el1centerX + rangeX > el2centerX
                && el1centerY + rangeY > el2centerY && el1centerY - rangeY < el2centerY) {
//            System.out.println("kolizja");
            return 1;       // collision
        }

        return -1;
    }

    static Element searchObj(String name, ArrowGame play) {
        for (Element img : play.elements)
            if (img.getDesc().equals(name))
                return img;

        return null;
    }
}
