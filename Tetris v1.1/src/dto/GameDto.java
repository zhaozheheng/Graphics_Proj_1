package dto;

import java.util.List;

import entity.GameAct;

public class GameDto {

	private List<Player> dbRecode;
	
	private List<Player> diskRecode;
	/*
	 * 游戏地图
	 */
	private boolean[][] gameMap;
	/*
	 * 下落方块
	 */
	private GameAct gameAct;
	/*
	 * 下一个方块
	 */
	private int next;
	/*
	 * 等级
	 */
	private int level;
	/*
	 * 分数
	 */
	private int score;
	/*
	 * 消行
	 */
	private int RemoveLine;
	/*
	 * 构造函数
	 */
	public GameDto(){
		dtoInit();
	}
	/*
	 * dto初始化
	 */
	public void dtoInit(){
		this.gameMap = new boolean[10][20];
		//初始化所有游戏对象
	}

	public List<Player> getDbRecode() {
		return dbRecode;
	}

	public void setDbRecode(List<Player> dbRecode) {
		this.dbRecode = dbRecode;
	}

	public List<Player> getDiskRecode() {
		return diskRecode;
	}

	public void setDiskRecode(List<Player> diskRecode) {
		this.diskRecode = diskRecode;
	}

	public boolean[][] getGameMap() {
		return gameMap;
	}

	public void setGameMap(boolean[][] gameMap) {
		this.gameMap = gameMap;
	}

	public GameAct getGameAct() {
		return gameAct;
	}

	public void setGameAct(GameAct gameAct) {
		this.gameAct = gameAct;
	}
	
	public int getNext() {
		return next;
	}

	public void setNext(int next) {
		this.next = next;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public int getRemoveLine() {
		return RemoveLine;
	}

	public void setRemoveLine(int removeLine) {
		RemoveLine = removeLine;
	}

}
