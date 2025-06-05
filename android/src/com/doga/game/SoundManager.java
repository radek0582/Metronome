package com.doga.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;

import java.util.ArrayList;

public class SoundManager {
    static void soundManager (ArrayList <Sound> soundList){
        soundList.add(Gdx.audio.newSound(Gdx.files.internal("tick2.ogg")));
    }

    static void musicManager (ArrayList <Music> musicList){
        musicList.add(Gdx.audio.newMusic(Gdx.files.internal("music.mp3")));
        System.out.println(Gdx.files.internal("music.mp3").path());
    }
}
