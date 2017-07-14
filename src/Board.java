import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Timer;

import javax.swing.*;

public class Board extends JPanel implements Commons {
    public BallHOlder getBallHolder() {
        return ballHolder;
    }

    private Timer timer;
    private String message = "Game Over";
    private BallHOlder ballHolder;
    public Paddle paddle;
    private Brick bricks[];
    private boolean ingame = true;
    private long score = new GlobalNumbers().getZero();
    private long lives = new GlobalNumbers().getTwo();

    public Board() {
        initBoard();
    }

    private void initBoard() {

        addKeyListener(new TAdapter());
        setFocusable(true);

        bricks = new Brick[N_OF_BRICKS];
        setDoubleBuffered(true);
        timer = new Timer();
        timer.scheduleAtFixedRate(new GameLoop(this), DELAY, PERIOD);
    }

    @Override
    public void addNotify() {

        super.addNotify();
        gameInit();
    }

    private void gameInit() {
        ballHolder = BallHOlder.BallHOlderBuilder.startBuilding().includeThisBallInsideTheBuilder(new Ball()).build();
        paddle = new Paddle();

        GlobalNumbers nums = new GlobalNumbers();
        int k = nums.getZero();
        for (int i = nums.getZero(); i < nums.getFive(); i++) {
            for (int j = nums.getZero(); j < nums.getSix(); j++) {
                bricks[k] = new Brick(j * nums.getFourty() + nums.getThirty(), i * nums.getSeven() + nums.getFifty());
                k++;
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        if (ingame) {
            
            drawObjects(g2d);
        } else {

            gameFinished(g2d);
        }

        Toolkit.getDefaultToolkit().sync();
    }
    
    private void drawObjects(Graphics2D g2d) {
        g2d.drawString("Your Score: " + score, 20, 20);
        g2d.drawString("Lives Left: " + lives, 20, 30);
        g2d.drawImage(ballHolder.ballToHold.getImage(), ballHolder.ballToHold.getX(), ballHolder.ballToHold.getY(),
                ballHolder.ballToHold.getWidth(), ballHolder.ballToHold.getHeight(), this);
        g2d.drawImage(paddle.getImage(), paddle.getX(), paddle.getY(),
                paddle.getWidth(), paddle.getHeight(), this);

        for (int i = new GlobalNumbers().getZero(); i < N_OF_BRICKS; i++) {
            if (!bricks[i].isDestroyed()) {
                g2d.drawImage(bricks[i].getImage(), bricks[i].getX(),
                        bricks[i].getY(), bricks[i].getWidth(),
                        bricks[i].getHeight(), this);
            }
        }
    }
    
    private void gameFinished(Graphics2D g2d) {

        Font font = new Font("Verdana", Font.BOLD, 28);
        FontMetrics metr = this.getFontMetrics(font);

        g2d.setColor(Color.BLACK);
        g2d.setFont(font);
        g2d.drawString(message,
                (Commons.WIDTH - metr.stringWidth(message)) / new GlobalNumbers().getTwo(),
                Commons.WIDTH / new GlobalNumbers().getTwo());
    }

    private class TAdapter extends KeyAdapter {

        @Override
        public void keyReleased(KeyEvent e) {
            paddle.keyReleased(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            paddle.keyPressed(e);
        }
    }

    private void stopGame() {

        ingame = false;
        timer.cancel();
    }

    public void checkCollision() throws InterruptedException {

        if (ballHolder.ballToHold.getRect().getMaxY() > Commons.BOTTOM_EDGE) {
            if (lives > 0) {
                lives--;
                ballHolder.ballToHold.setYDir(new GlobalNumbers().getOne(true));
                ballHolder.ballToHold.setX((int) (paddle.getRect().getMinX() + 4));
                ballHolder.ballToHold.setY((int) (paddle.getRect().getMinY() + 4));
            } else {
                stopGame();
            }
        }

        for (int i = new GlobalNumbers().getZero(), j = new GlobalNumbers().getZero(); i < N_OF_BRICKS; i++) {
            
            if (bricks[i].isDestroyed()) {
                j++;
            }
            
            if (j == N_OF_BRICKS) {
                message = "Victory";
                stopGame();
            }
        }

        if ((ballHolder.ballToHold.getRect()).intersects(paddle.getRect())) {

            int paddleLPos = (int) paddle.getRect().getMinX();
            int ballLPos = (int) ballHolder.ballToHold.getRect().getMinX();

            int first = paddleLPos + 8;
            int second = paddleLPos + 26;
            int third = paddleLPos + 24;
            int fourth = paddleLPos + 32;

            if (ballLPos < first) {
                ballHolder.ballToHold.setXDir(new GlobalNumbers().getOne(true));
                ballHolder.ballToHold.setYDir(new GlobalNumbers().getOne(true));
            }

            if (ballLPos >= first && ballLPos < second) {
                ballHolder.ballToHold.setXDir(new GlobalNumbers().getOne(true));
                ballHolder.ballToHold.setYDir(new GlobalNumbers().getOne(true) * ballHolder.ballToHold.getYDir());
            }

            if (ballLPos >= second && ballLPos < third) {
                ballHolder.ballToHold.setXDir(new GlobalNumbers().getZero());
                ballHolder.ballToHold.setYDir(new GlobalNumbers().getOne(true));
            }

            if (ballLPos >= third && ballLPos < fourth) {
                ballHolder.ballToHold.setXDir(new GlobalNumbers().getOne(false));
                ballHolder.ballToHold.setYDir(new GlobalNumbers().getOne(true) * ballHolder.ballToHold.getYDir());
            }

            if (ballLPos > fourth) {
                ballHolder.ballToHold.setXDir(new GlobalNumbers().getOne(false));
                ballHolder.ballToHold.setYDir(new GlobalNumbers().getOne(true));
            }
        }

        for (int i = new GlobalNumbers().getZero(); i < N_OF_BRICKS; i++) {
            
            if ((ballHolder.ballToHold.getRect()).intersects(bricks[i].getRect())) {

                int ballLeft = (int) ballHolder.ballToHold.getRect().getMinX();
                int ballHeight = (int) ballHolder.ballToHold.getRect().getHeight();
                int ballWidth = (int) ballHolder.ballToHold.getRect().getWidth();
                int ballTop = (int) ballHolder.ballToHold.getRect().getMinY();

                Point pointRight = new Point(ballLeft + ballWidth + new GlobalNumbers().getOne(false), ballTop);
                Point pointLeft = new Point(ballLeft - new GlobalNumbers().getOne(false), ballTop);
                Point pointTop = new Point(ballLeft, ballTop - new GlobalNumbers().getOne(false));
                Point pointBottom = new Point(ballLeft, ballTop + ballHeight + new GlobalNumbers().getOne(false));

                if (!bricks[i].isDestroyed()) {
                    if (bricks[i].getRect().contains(pointRight)) {
                        ballHolder.ballToHold.setXDir(new GlobalNumbers().getOne(true));
                    } else if (bricks[i].getRect().contains(pointLeft)) {
                        ballHolder.ballToHold.setXDir(new GlobalNumbers().getOne(false));
                    }

                    if (bricks[i].getRect().contains(pointTop)) {
                        ballHolder.ballToHold.setYDir(new GlobalNumbers().getOne(false));
                    } else if (bricks[i].getRect().contains(pointBottom)) {
                        ballHolder.ballToHold.setYDir(new GlobalNumbers().getOne(true));
                    }
                    score++;
                    bricks[i].setDestroyed(true);
                }
            }
        }
    }
}