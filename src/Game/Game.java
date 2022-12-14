package Game;

import Game.GUI.GamePanel;
import Game.GUI.Window;

public abstract class Game {

    public static final int PORT = 8000;
    public static final int WIN_WIDTH = 1000, WIN_HEIGHT = 1000;
    public static final int BOARD_X_START = 200, BOARD_Y_START = 200;
    public static final int BOARD_WIDTH = WIN_WIDTH - BOARD_X_START, BOARD_HEIGHT = WIN_HEIGHT - BOARD_Y_START;

    public static final int X_SPACING = BOARD_WIDTH / 4, Y_SPACING = BOARD_HEIGHT / 4;

    public static final int BOX_X_PADDING = 20, BOX_Y_PADDING = 20;
    public static final int BOX_X_CENTER = BOARD_X_START + X_SPACING / 2, BOX_Y_CENTER = BOARD_Y_START + Y_SPACING / 2;
    public static final int BOX_X_START = BOARD_X_START + BOX_X_PADDING, BOX_Y_START = BOARD_Y_START + BOX_Y_PADDING;
    public static final int BOX_WIDTH = X_SPACING - (BOX_X_PADDING * 2), BOX_HEIGHT = Y_SPACING - (BOX_Y_PADDING * 2);

    public static final int FREE = 0, PLAYER_ONE = 1, PLAYER_TWO = 2;
    protected int[][] fields;

    private Window window;
    protected GamePanel gamePanel;
    protected int currentPlayer;
    protected int thisPlayer;

    public Game() {
        this.thisPlayer = Game.FREE;
        window = new Window(this, "Nic-Nac-Noe", WIN_WIDTH, WIN_HEIGHT);
        gamePanel = new GamePanel(this);
        fields = new int[3][3];
        window.add(gamePanel);
        window.setVisible(true);
        currentPlayer = Game.PLAYER_ONE;
    }

    public void setPlayer(int player) {
        thisPlayer = player;
    }

    protected boolean isMyTurn() {
        return thisPlayer == currentPlayer;
    }

    public abstract void inputReceived(int x, int y);
    public abstract void packetReceived(Object object);
    public abstract void close();

    public final int[][] getFields() {
        return fields;
    }

}
