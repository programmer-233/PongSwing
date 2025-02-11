import java.awt.event.KeyEvent;

public class PlayerController {
    public Player player;
    public KL keyListener;
    public PlayerController(Player player, KL keyListener){
        this.player = player;
        this.keyListener = keyListener;

    }
    public void update(double dt){
        if (keyListener.isKeyPressed(KeyEvent.VK_DOWN)){
            if ((player.y + Constants.PLAYER_SPEED * dt) + player.height < Constants.SCREEN_HEIGHT - Constants.INSETS_BOTTOM) {
                this.player.y += Constants.PLAYER_SPEED * dt;
            }
        }else if (keyListener.isKeyPressed(KeyEvent.VK_UP)){
            if (player.y - Constants.PLAYER_SPEED *dt > Constants.TOOLBAR_HEIGHT) {
                this.player.y -= Constants.PLAYER_SPEED * dt;
            }
        }
    }
}
