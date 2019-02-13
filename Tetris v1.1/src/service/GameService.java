package service;

import java.awt.Point;
import java.util.Random;


import dto.GameDto;
import entity.GameAct;

public class GameService {
	
	/*
	 * 
	 */
	private GameDto dto;
	/*
	 * 随机数生成器
	 */
	private Random random = new Random();
	/*
	 * 方块种类个数
	 */
	private static final int MAX_TYPE = 7;
	
	public GameService(GameDto dto) {
		this.dto = dto;
		GameAct act = new GameAct(random.nextInt(MAX_TYPE));
		dto.setGameAct(act);
	}
	
	public void down(){
		if (this.dto.getGameAct().move(0, 1, this.dto.getGameMap())) {
			return;
		}
		//获得游戏地图对象
		boolean[][] map = this.dto.getGameMap();
		//获得方块对象
		Point[] act = this.dto.getGameAct().getActPoints();
		//将方块堆积到地图数组
		for (int i = 0; i < act.length; i++) {
			map[act[i].x][act[i].y] = true;
		}
		//判断消行，并计算经验值
		int exp = this.plusExp();
		//判断是否可以消行
		
		//算分操作
		//判断是否升级
		//升级
		//创建下一个方块
		this.dto.getGameAct().init(this.dto.getNext());
		//随机生成再下一个方块	
		this.dto.setNext(new Random().nextInt(MAX_TYPE));
	}

	
	/*
	 * 鼠标左键左移方块
	 */
	public void left() {
		this.dto.getGameAct().move(-1, 0, this.dto.getGameMap());
	}
	/*
	 * 鼠标右键右移方块
	 */
	public void right() {
		this.dto.getGameAct().move(1, 0, this.dto.getGameMap());
	}
	/*
	 * 鼠标滚轮向前顺时针转动方块
	 */
	public void clockRound() {
		this.dto.getGameAct().clockRound(this.dto.getGameMap());
		
	}
	/*
	 * 鼠标滚轮向后逆时针转动方块
	 */
	public void counterClockRound() {
		this.dto.getGameAct().counterClockRound(this.dto.getGameMap());
		
	}
	/*
	 * 消行操作
	 */
	private int plusExp() {
		//获得游戏地图
		boolean[][] map = this.dto.getGameMap();
		int exp = 0;
		//扫描游戏地图，看是否有可消行
		for (int y = 0; y < this.dto.getGameAct().MAX_Y + 1; y++) {
			//判断是否可消行
			if (isCanRemoveLine(y, map)) {
				//如果可消行，消行
				this.removeLine(y, map);
				//增加经验值
				exp++;
			}
		}
		return exp;
	}
	/*
	 * 消行处理
	 */
	private void removeLine(int rowNumber, boolean[][] map) {
		for (int x = 0; x < this.dto.getGameAct().MAX_X + 1; x++) {
			for (int y = rowNumber; y > 0; y--) {
				map[x][y] = map[x][y-1];
			}
			map[x][0] = false;
		}
	}

	private boolean isCanRemoveLine(int y, boolean[][] map){
		//单行内对每个单元格进行扫描
		for (int x = 0; x < this.dto.getGameAct().MAX_X + 1; x++) {
			if (!map[x][y]) {
				//如果有一个方格为false，直接跳到下一行
				return false;
			}
		}
		
		return true;
	}


}
