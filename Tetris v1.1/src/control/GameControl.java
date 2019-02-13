package control;

import service.GameService;
import ui.JPanelGame;

/**
 * 接收玩家鼠标事件
 * 控制画面
 * 控制游戏逻辑
 * 
 * @author Zheheng
 * 
 */

public class GameControl {

	/*
	 * 游戏界面层
	 */
	private JPanelGame panelGame;
	
	/*
	 * 游戏逻辑层
	 */
	private GameService gameService;
	
	public GameControl(JPanelGame panelGame, GameService gameService){
		this.panelGame = panelGame;
		this.gameService = gameService;
	}

	/*
	 * 鼠标左键左移方块
	 */
	public void left() {
		this.gameService.left();
		this.panelGame.repaint();
	}
	/*
	 * 鼠标右键右移方块
	 */
	public void right() {
		this.gameService.right();
		this.panelGame.repaint();
	}
	/*
	 * 方块向下掉
	 */
	public void down() {
		this.gameService.down();
		this.panelGame.repaint();
	}
	/*
	 * 顺时针转动方块
	 */
	public void clockRound() {
		this.gameService.clockRound();
		this.panelGame.repaint();
		
	}
	/*
	 * 逆时针转动方块
	 */
	public void counterClockRound() {
		this.gameService.counterClockRound();
		this.panelGame.repaint();
	}
	/*
	 * 线程
	 */
	
	
}
