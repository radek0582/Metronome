package com.doga.game;

public class PlayerData {
    String playerName;
    String archerType;
    int archerX;
    int archerY;

    public PlayerData (){
    }

    public PlayerData (String playerName){
        this.playerName = playerName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public String getArcherType() {
        return archerType;
    }

    public void setArcherType(String archerType) {
        this.archerType = archerType;
    }

    public int getArcherX() {
        return archerX;
    }

    public void setArcherX(int archerX) {
        this.archerX = archerX;
    }

    public int getArcherY() {
        return archerY;
    }

    public void setArcherY(int archerY) {
        this.archerY = archerY;
    }
}
