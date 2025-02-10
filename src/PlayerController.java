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

                this.player.y += 100 *dt;
        }else if (keyListener.isKeyPressed(KeyEvent.VK_UP)){

            this.player.y -= 100 *dt;
        }
    }
}
