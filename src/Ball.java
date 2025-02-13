public class Ball {
    public Player player;
    public Player leftPlayer, rightPlayer;


    private double velocityy = 10.0;
    private double velocityx = -150.0;

    public Ball(Player player, Player leftPlayer, Player rightPlayer){
        this.player = player;
        this.leftPlayer = leftPlayer;
        this.rightPlayer = rightPlayer;
    }

    public void update(double dt){
        // left
        if (velocityx < 0 ){
            if(this.player.x <= this.leftPlayer.x + this.leftPlayer.width && this.player.x >= this.leftPlayer.x &&
                    this.player.y >= this.leftPlayer.y &&
                    this.player.y <= this.leftPlayer.y + this.leftPlayer.height){
                this.velocityx *= -1;
                this.velocityy *= -1;
            } else if (this.player.x + this.player.width < this.leftPlayer.x) {
                System.out.println("You Lost");
                
            }
        } // right
        else if (velocityx > 0) {
            if(this.player.x + this.player.width >= this.rightPlayer.x && this.player.x <= this.rightPlayer.x &&
                    this.player.y <= this.rightPlayer.y &&
                    this.player.y >= this.rightPlayer.y + this.rightPlayer.height){
                this.velocityx *= -1;
                this.velocityy *= -1;
            } else if (this.player.x + this.player.width > this.rightPlayer.x + this.rightPlayer.width){
                System.out.println("AI has lost a point");
            }

        }
        if (velocityy > 0){
            if (this.player.y + this.player.height > Constants.SCREEN_HEIGHT){
                this.velocityy *= -1;
            } else if (velocityy < 0 ) {
                if (this.player.y < Constants.TOOLBAR_HEIGHT){
                    this.velocityy *= -1;
                }

            }
        }
        this.player.x += velocityx * dt;
        this.player.y += velocityy * dt;
    }
}
