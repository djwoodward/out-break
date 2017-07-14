import java.util.TimerTask;

class GameLoop extends TimerTask {
	Board board;

	public GameLoop(Board board) {
		this.board = board;
	}

	@Override
	public void run() {

		board.ball.move();
		board.paddle.move();
		board.checkCollision();
		board.repaint();
	}
}