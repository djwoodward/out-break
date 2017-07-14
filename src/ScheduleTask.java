import java.util.TimerTask;

class ScheduleTask extends TimerTask {
	Board board;

	public ScheduleTask(Board board) {
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