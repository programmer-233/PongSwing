import javax.swing.JFrame;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Window extends JFrame implements Runnable{

    Graphics2D g2;
    KL keyListener = new KL();
    Player playerOne;
    Player ai;
    Player ball;

    public Window() {
        this.setSize(Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);
        this.setTitle(Constants.SCREEN_TITLE);
        this.setResizable(false);
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.addKeyListener(keyListener);
        g2 = (Graphics2D)this.getGraphics();
        playerOne = new Player(Constants.HORIZONTAL_PADDING,40, Constants.PLAYER_WIDTH, Constants.PLAYER_HEIGHT, Constants.PLAYER_COLOR);
        ai = new Player(Constants.SCREEN_WIDTH - Constants.PLAYER_WIDTH -Constants.HORIZONTAL_PADDING , 40, Constants.PLAYER_WIDTH, Constants.PLAYER_HEIGHT, Constants.PLAYER_COLOR);
        ball = new Player(Constants.SCREEN_WIDTH/2, Constants.SCREEN_HEIGHT/2, Constants.BALL_SIZE, Constants.BALL_SIZE, Constants.PLAYER_COLOR);
    }
    // Delta Time
    public void update(double dt){
        g2.setColor(new Color(120, 177, 114));
        g2.fillRect(0, 0, Constants.SCREEN_WIDTH, Constants.SCREEN_HEIGHT);

        // Drawing Normal
        // Player player = new Player(50,100,40,80,Color.WHITE);
        // player.draw(g2);
        playerOne.draw(g2);
        ai.draw(g2);
        ball.draw(g2);


        /*
        // Up Key Pressed
        if (keyListener.isKeyPressed(KeyEvent.VK_UP)){
            System.out.println("UP Key Pressed");
        }
        // Down Key Pressed
        else if (keyListener.isKeyPressed(KeyEvent.VK_DOWN)) {
            System.out.println("Down Key Pressed");
        }
        */

    }
    public void run(){
        double lastFrameTime = 0.0;
        while (true) {
            double time = Time.getTime();
            double deltaTime = time - lastFrameTime;
            lastFrameTime = time;

            update(deltaTime);

            try {
                Thread.sleep(30);
            }catch (Exception e){

            }
        }

    }
}
