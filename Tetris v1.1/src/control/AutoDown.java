package control;

import service.GameService;
import ui.JPanelGame;

public class AutoDown extends Thread{
	
	private final int STOP = -1;
	private final int SUSPEND = 0;
	private final int RUNNING = 1;
	private int status = 1;
	
	/*
	 * 游戏界面层
	 */
	private JPanelGame panelGame;
	
	/*
	 * 游戏逻辑层
	 */
	private GameService gameService;
	
	public AutoDown(JPanelGame panelGame, GameService gameService){
		this.panelGame = panelGame;
		this.gameService = gameService;
	}

	@Override
	public void run(){
		while(status != STOP){
			if (status == SUSPEND) {
				try {
					wait();
				} catch (InterruptedException e) {
					//e.printStackTrace();
				}
			}
			else{
				try {
					Thread.sleep(500);
					this.gameService.down();
					this.panelGame.repaint();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	/*
	 * 恢复
	 */
	public synchronized void myResume(){
		//修改状态
		status = RUNNING;
		//唤醒
		notifyAll();
	}
	
	/*
	 * 挂起
	 */
	public void mySuspend(){
		//修改状态
		status = SUSPEND;
	}
	
	/*
	 * 停止
	 */
	public void myStop(){
		//修改状态
		status = STOP;
	}
}
