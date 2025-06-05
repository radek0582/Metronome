package com.doga.game;



import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.FrameBuffer;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.math.Vector3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Brent on 7/5/2015.
 */
public class ArrowGame extends ApplicationAdapter {
    protected int rotationCounter = 0;
    protected OrthographicCamera cam, font_cam;
    protected Vector3 mouse;
    protected AndroidLauncher al;

    protected ArrayList<Element> elements;
    protected Map<String, Element> elementsMap;
    protected ArrayList<Music> musicList;
    protected ArrayList<Sound> soundList;
    protected Map<String, Text> texts;
    protected Map<String, Text> choiceTexts;
    protected String currentPlayerName = "";
    protected int currentPlayerId = -1;
    protected ArrayList<String> players;            // names of players
    protected HashMap<String, String> playersValues;
    protected HashMap<Integer, PlayerData> playersData;

    protected DataHolderClass dataHolder;
    protected Update update;

    protected BitmapFont font;
    protected BitmapFont fontSans;
    protected BitmapFont fontTimesBold;
    long currentCounterTime = 0;
    long startCounterTime = 0;
    protected double gameTime;
    protected float factor;
    protected int powerArcher1 = 20;
    protected int angleArcher1 = 90;
    protected double gravity = 9.81d;
    protected int cameraShiftX;
    protected int cameraShiftY;
    protected int rotationShiftX;
    protected int rotationShiftY;
    protected int gamePhase = 3;
    protected int multiplayerPhase = 0;
    protected int roundStartCounter = 5;
    protected boolean keyboardMode = false;
    protected boolean keyboardUp = false;

    protected String password = "1111";
    protected String gameName = "100";
    protected String playerName = "anonymous";
    protected String player2Name = "";
    protected String player3Name = "";
    protected String player4Name = "";


    //    protected String friendId = "Anonymous1";
    protected String onlineId = "anonymous1";
    protected int dBSize = 0;

    protected int playersAmount;
    protected int currentRound = 0;
    protected int gameMode = 2;         // single player
    protected String chosenArcher = "archer";
    protected int movingPlayer = -1;
    protected long gameCounter = 0;
    protected long startGameCounter = 0;
    protected boolean host;

    protected boolean moveAvailable = false;
    protected String selectedPawn = "";

    protected char sign = 0;
    protected String writtenText = "";
    protected String writtenTextCopy = "";
    protected String keyboardWord = "";
    protected boolean pressedEnter = false;

    protected int thisPlayerId = -1;

    protected String gameMessage = "";

    protected int transitionX = 0;
    protected int transitionY = 0;
    protected float zoomRatio = 1f;
    protected int zoomLevel = 0;
    protected float zoomTranslation = 1f;
    protected float zoomModifier = 1;
//    protected float screenRatio = 1f;

    protected int distanceYprev;
    protected int distanceY;
    protected int distanceYDelta;
    protected int zoomingPhase = -1;
    protected int zoomIteration = 0;
    protected int distance;
    protected int distancePrev;
    protected int distanceDelta;

    protected boolean startedOrientationLandscape = false;

    protected int screenOrientationDegrees;
    protected int startScreenOrientationDegrees;
    protected String desiredOrientation;

    protected boolean refreshLandscape = false;
    protected boolean refreshPortrait = false;
    protected boolean refreshOrientation = false;
    protected boolean refreshOrientationFinal = false;

    protected String currentOrientation = "";
    protected int currentWidth;
    protected int desiredWidth;

    protected int landscapeHeight;
    protected int landscapeWidth;
    protected int portraitHeight;
    protected int portraitWidth;

    protected SpriteBatch spriteBatch;
    //    protected Stage stage;
    private Touch touch;
//    private AndroidLauncher al;

    protected FireBaseInterface _FBIC;

    private int i = 0;
    private long currentTime;// = System.nanoTime();
    private long timeDiff;

    protected int draggingDistanceX;
    protected int draggingDistanceY;

    protected boolean keyClicked = false;

    protected int lightX = 2000;


    protected FrameBuffer frmBuff;
    protected TextureRegion frm;
    protected OrthographicCamera frmCam;
    protected FrameBuffer maskBuff;
    protected TextureRegion msk;

    Texture bulbMask;
    Texture smallBulbMask;
    Texture viewMask;
    Texture testMask;
    protected float maskFactor;
    protected float maskHeightFactor;
    protected float maskWidthFactor;
    protected ShaderProgram shader;
    protected ShaderProgram defaultShader;
    protected Sprite coverSprite;
    protected Sprite coverSpriteBack;
    protected Texture coverTexture;
    protected int coverSpriteHeight;
    protected int coverSpriteWidth;
    protected int viewMaskHeight;
    protected int bulbMaskHeight;
    protected int smallBulbMaskHeight;
    protected int testMaskHeight;
    protected int viewMaskWidth;
    protected int bulbMaskWidth;
    protected int smallBulbMaskWidth;
    protected int testMaskWidth;

    protected int frmSizeY;
    protected int frmSizeX;

    protected int destinationX;
    protected int destinationY;

    protected float fireflySpeed = 0f;
    protected boolean flyModeOn = false;
    protected double wayX;
    protected double wayY;
    protected double madeX;
    protected double madeY;
    protected double angle;
    protected double degrees;
    protected double a;
//    protected ArrayList <Pixmap> collisionMatrixWeb;
    protected Map <String, Pixmap> collisionMatrixWeb;

    protected boolean trapped = false;
    protected boolean spiderComes = false;

    protected float maskScaleX = 2f;
    protected float maskScaleY = 2f;

    int energyTimeCounter = 100;
    long moveTimeCounter = 0;
    long moveTimeCounterDifference = 0;
    long moveTimeCounterPrevious = 0;
    long moveTimeCounterDiff = 0;
    int drawTimeCounter = 0;
    boolean drawnSek = false;
    int curSecond = -5;

    long curSec = 0;
    long prevSec = 0;
    int sec = -5;
    int milliSec = 0;
    long startTime;
    long totalMilliSec = 0;
    long prevMilliSec = 0;
    long passedMilliSec = 0;
    int bpm = 120;
    long milliSecToBeat = 0;
    long milliSecLeftToBeat = 60000 / bpm;
    boolean makeBeatSound = false;
    long soundId;
    int sliderY = 500;

    protected AssetManager manager;
    

    @Override
    public void create() {
        spriteBatch = new SpriteBatch();
//        stage = new Stage();
        touch = new Touch(this);

        cam = new OrthographicCamera();
        mouse = new Vector3();
        elements = new ArrayList<>();
        elementsMap = new HashMap<>();
        soundList = new ArrayList<>();
        musicList = new ArrayList<>();
        texts = new HashMap<>();
        choiceTexts = new HashMap<>();
        players = new ArrayList<>();
        playersValues = new HashMap<>();
        playersData = new HashMap<>();
        collisionMatrixWeb = new HashMap<>();
        manager = new AssetManager();

        manager.load("t2.ogg", Sound.class);
        manager.finishLoading();

        dataHolder = new DataHolderClass();
        dataHolder.getChanges().put("playersAmount", "0");
        dataHolder.getChanges().put("sessionStatus", "unknown");

        if (Constants.SCREEN_WIDTH > Constants.SCREEN_HEIGHT) {
            currentOrientation = "landscape";
            landscapeHeight = Constants.SCREEN_HEIGHT;
            landscapeWidth = Constants.SCREEN_WIDTH;
            portraitHeight = Constants.SCREEN_WIDTH;
            portraitWidth = Constants.SCREEN_HEIGHT;
        } else {
            currentOrientation = "portrait";
            portraitHeight = Constants.SCREEN_HEIGHT;
            portraitWidth = Constants.SCREEN_WIDTH;
            landscapeHeight = Constants.SCREEN_WIDTH;
            landscapeWidth = Constants.SCREEN_HEIGHT;
        }

        if (currentOrientation.equals("landscape")) {      // landscape
            startedOrientationLandscape = true;
            System.out.println("chosen rotation landscape");
            factor = 1080 / (float) Constants.SCREEN_HEIGHT;
            currentOrientation = "landscape";
            int newY = (int) (Constants.SCREEN_HEIGHT * factor);
            int newX = (int) (Constants.SCREEN_WIDTH * factor);
            System.out.println("factor: " + factor + ", screen width: " + Gdx.graphics.getWidth() + " scr height " + Gdx.graphics.getHeight() + ", landscapeHeight: " + landscapeHeight + ", portraitHeight: " + portraitHeight);
            cam.viewportWidth = newX;
            cam.viewportHeight = (float) newY;
            cam.position.x = (float) newX / (float) 2;
            cam.position.y = (float) newY / (float) 2;
//            rotationShiftX = (int) (((float) (Gdx.graphics.getWidth() - Gdx.graphics.getHeight()) / 2));
//            rotationShiftY = (int) (((float) (Gdx.graphics.getHeight() - Gdx.graphics.getWidth()) / 2));
        } else {            // portrait
            System.out.println("chosen rotation portrait");
            currentOrientation = "portrait";
            startedOrientationLandscape = false;
            factor = 1080 / (float) Gdx.graphics.getWidth();
            int newY = (int) (Constants.SCREEN_HEIGHT * factor);
            int newX = (int) (Constants.SCREEN_WIDTH * factor);
            System.out.println("factor: " + factor + ", screen width: " + Gdx.graphics.getWidth() + " scr height " + Gdx.graphics.getHeight() + ", landscapeHeight: " + landscapeHeight + ", portraitHeight: " + portraitHeight);
            cam.viewportWidth = newX;
            cam.viewportHeight = newY;
            cam.position.x = (float) newX / (float) 2;
            cam.position.y = (float) newY / (float) 2;
            rotationShiftX = (int) (((float) (Gdx.graphics.getWidth() - Gdx.graphics.getHeight()) * factor / 2));
            rotationShiftY = (int) (((float) (Gdx.graphics.getHeight() - Gdx.graphics.getWidth()) * factor / 2));
        }

        screenOrientationDegrees = Gdx.input.getRotation();
        startScreenOrientationDegrees = Gdx.input.getRotation();
        font_cam = new OrthographicCamera();
        font = new BitmapFont(Gdx.files.internal("normalFont64.fnt"));
        fontSans = new BitmapFont(Gdx.files.internal("microsoftSansFont.fnt"));
        fontTimesBold = new BitmapFont(Gdx.files.internal("timesBold.fnt"));

        ElementsManager.elementsManager(this);
        SoundManager.soundManager(soundList);
        SoundManager.musicManager(musicList);

        if (currentOrientation.equals("portrait")) {
            for (Map.Entry<String, Text> text : texts.entrySet()) {
                int x = text.getValue().getPortraitX();
                int y = text.getValue().getPortraitY();
                text.getValue().setX(x);
                text.getValue().setY(y);
            }

            for (Element el : elements
            ) {
                if (!el.isTransformable()) {
                    el.setX(el.getPortraitX());
                    el.setY(el.getPortraitY());
                }
            }
        } else if (currentOrientation.equals("landscape")) {
            for (Map.Entry<String, Text> text : texts.entrySet()) {
                int x = text.getValue().getLandscapeX();
                int y = text.getValue().getLandscapeY();
                text.getValue().setX(x);
                text.getValue().setY(y);
            }
        }
        update = new Update();

        ShaderProgram.pedantic = false;
        frmSizeX = 4096;
        frmSizeY = 4096;

        bulbMask = new Texture(Gdx.files.internal("bigSunMega.png"));
        smallBulbMask = new Texture(Gdx.files.internal("mediumSunMega.png"));
        viewMask = new Texture(Gdx.files.internal("viewBlinky7.png"));
        testMask = new Texture(Gdx.files.internal("testMask.png"));

        maskBuff = new FrameBuffer(Pixmap.Format.RGBA8888, frmSizeX, frmSizeY, false);
        msk = new TextureRegion(maskBuff.getColorBufferTexture());

        frmBuff = new FrameBuffer(Pixmap.Format.RGBA8888, frmSizeX, frmSizeY, false);
        frm = new TextureRegion(frmBuff.getColorBufferTexture());

        coverSprite = new Sprite(new Texture("blackCover4096.png"));

        coverSpriteHeight = (int) coverSprite.getHeight();
        coverSpriteWidth = (int) coverSprite.getWidth();
        viewMaskHeight = viewMask.getHeight();
        bulbMaskHeight = bulbMask.getHeight();
        smallBulbMaskHeight = smallBulbMask.getHeight();
        testMaskHeight = testMask.getHeight();
        viewMaskWidth = viewMask.getWidth();
        bulbMaskWidth = bulbMask.getWidth();
        smallBulbMaskWidth = smallBulbMask.getWidth();
        testMaskWidth = testMask.getWidth();
        System.out.println("viewMaskHeight: " + viewMaskHeight);

        if (currentOrientation.equals("landscape")) {
            maskFactor = (float) Gdx.graphics.getWidth() / Gdx.graphics.getHeight();
            maskHeightFactor = (float) coverSpriteHeight / 1080;
            maskWidthFactor = (float) coverSpriteWidth / Gdx.graphics.getWidth();
        } else{
            maskFactor = (float) Gdx.graphics.getHeight() / Gdx.graphics.getWidth();
            maskHeightFactor = (float) coverSpriteHeight / Gdx.graphics.getHeight();
            maskWidthFactor = (float) coverSpriteWidth / Gdx.graphics.getWidth();
        }
        System.out.println("mask factor: " + maskFactor + ", mask height factor: " + maskHeightFactor + ", mask width factor: " + maskWidthFactor);

//        coverSpriteBack = new Sprite(new Texture("grayCover.png"));
        coverSprite.setPosition(0, 0);
//        coverSpriteBack.setPosition(0, 0);

        cam.update();
        shader = new ShaderProgram(Gdx.files.internal("vertex.glsl"), Gdx.files.internal("fragment-video.glsl"));
        if (!shader.isCompiled()) {
            System.err.println(shader.getLog());
            System.exit(0);
        }
        if (!shader.getLog().isEmpty())
            System.out.println(shader.getLog());

        shader.bind();
        shader.setUniformi("u_texture1", 1);
        shader.setUniformi("u_mask", 2);
        defaultShader = spriteBatch.getShader();
        msk.getTexture().bind(2);
        frm.getTexture().bind(1);
        Gdx.gl.glActiveTexture(GL20.GL_TEXTURE0);
        startTime = System.nanoTime();
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        while (i < 2) {
            timeDiff = System.nanoTime() - currentTime;
            if (timeDiff > 8000000) {
                this.updateElements();
                currentTime = System.nanoTime();
                i++;
                timeDiff = 0;
            }
        }
        i = 0;
        this.updateAnimations(Gdx.graphics.getDeltaTime());
        this.render(spriteBatch);
    }

    public ArrowGame(FireBaseInterface FBIC, AndroidLauncher al) {
        this._FBIC = FBIC;
        this.al = al;
    }

    public void updateAnimations(float dt) {
        Draw.update(dt, this);
    }

    public void render(SpriteBatch sb) {
        if (!refreshOrientation && !refreshOrientationFinal) {
            Draw.render(sb, this);
        }
    }

    public void updateElements() {
        currentCounterTime = System.nanoTime() - startCounterTime;

        if (currentCounterTime >= 5000000) {
            startCounterTime = System.nanoTime();

            update.update(this);
            Move.moveElements(this);
            Collisions.detectCollisions(this);
        }
    }

    public void dispose (){
        spriteBatch.dispose();
//        soundList.get(0).dispose();
        font.dispose();
    }
}
