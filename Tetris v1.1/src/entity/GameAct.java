package entity;


import java.awt.Point;
import java.util.ArrayList;
import java.util.List;

public class GameAct {

	/*
	 * 方块数组
	 */
	private Point[] actPoints = null;
	
	private static int MIN_X = 0;
	public static int MAX_X = 9;
	private static int MIN_Y = 0;
	public static int MAX_Y = 19;
	
	private int typeCode;
	
	private static List<Point[]> TYPE_CONFIG;
	
	static{
		TYPE_CONFIG = new ArrayList<Point[]>(7);
		TYPE_CONFIG.add(new Point[]{new Point(4, 0),new Point(5, 0),new Point(3, 1),new Point(4, 1)});//旋转中心点，黄色
		TYPE_CONFIG.add(new Point[]{new Point(4, 0),new Point(3, 0),new Point(4, 1),new Point(5, 1)});//旋转中心点，紫色
		TYPE_CONFIG.add(new Point[]{new Point(4, 0),new Point(3, 0),new Point(5, 0),new Point(3, 1)});//旋转中心点，深蓝
		TYPE_CONFIG.add(new Point[]{new Point(4, 0),new Point(3, 0),new Point(5, 0),new Point(5, 1)});//旋转中心点，红色
		TYPE_CONFIG.add(new Point[]{new Point(4, 0),new Point(5, 0),new Point(4, 1),new Point(5, 1)});//旋转中心点，绿色
		TYPE_CONFIG.add(new Point[]{new Point(4, 0),new Point(3, 0),new Point(5, 0),new Point(4, 1)});//旋转中心点，橙色
		TYPE_CONFIG.add(new Point[]{new Point(4, 0),new Point(3, 0),new Point(5, 0),new Point(6, 0)});//旋转中心点，淡蓝
	}
	public Point[] getActPoints() {
		return actPoints;
	}
	
	public GameAct(int typeCode) {
		this.init(typeCode);
	}
	
	public void init(int typeCode){
		this.typeCode = typeCode;
		Point[] points = TYPE_CONFIG.get(typeCode);
		actPoints = new Point[points.length];
		for (int i = 0; i < points.length; i++) {
			actPoints[i] = new Point(points[i].x, points[i].y);
		}
				
	}
	/**
	 * 方块移动
	 * 
	 * @param moveX x轴偏移量
	 * @param moveY y轴偏移量
	 */
	public boolean move(int moveX, int moveY, boolean[][] gameMap){
		//移动处理
		for(int i=0; i<actPoints.length; i++){
			int newX = actPoints[i].x + moveX;
			int newY = actPoints[i].y + moveY;
			if(this.isOverZone(newX, newY, gameMap)){
				return false;
			}
		}
		for(int i=0; i<actPoints.length; i++){
			actPoints[i].x += moveX;
			actPoints[i].y += moveY;
		}
		return true;
	}
	
	/**
	 * 方块旋转
	 * 
	 * 顺时针：
	 * A.x = O.y + O.x - B.y
	 * A.y = O.y - O.x + B.x
	 */
	public void clockRound(boolean[][] gameMap){
		if (this.typeCode == 4) {
			return;
		}
		for(int i=1; i<actPoints.length; i++){
			int newX = actPoints[0].y+actPoints[0].x-actPoints[i].y;
			int newY = actPoints[0].y-actPoints[0].x+actPoints[i].x;
			//todo是否可以旋转
			if(this.isOverZone(newX, newY, gameMap)){
				return;
			}
		}
		for(int i=1; i<actPoints.length; i++){
			int newX = actPoints[0].y+actPoints[0].x-actPoints[i].y;
			int newY = actPoints[0].y-actPoints[0].x+actPoints[i].x;
			actPoints[i].x = newX;
			actPoints[i].y = newY;
		}
	}
	/**
	 * 方块旋转
	 * 
	 * 逆时针：
	 * B.x = O.x - O.y + A.y
	 * B.y = O.x + O.y - A.x
	 */
	public void counterClockRound(boolean[][] gameMap){
		if (this.typeCode == 4) {
			return;
		}
		for(int i=1; i<actPoints.length; i++){
			int newX = actPoints[0].x-actPoints[0].y+actPoints[i].y;
			int newY = actPoints[0].x+actPoints[0].y-actPoints[i].x;
			//todo是否可以旋转
			if(this.isOverZone(newX, newY, gameMap)){
				return;
			}
		}
		for(int i=1; i<actPoints.length; i++){
			int newX = actPoints[0].x-actPoints[0].y+actPoints[i].y;
			int newY = actPoints[0].x+actPoints[0].y-actPoints[i].x;
			actPoints[i].x = newX;
			actPoints[i].y = newY;
		}
	}
	
	/*
	 * 判断是否超出边界
	 */
	private boolean isOverZone(int x, int y, boolean[][] gameMap){
		return x<MIN_X || x>MAX_X || y<MIN_Y || y>MAX_Y || gameMap[x][y]==true;
	}
	/*
	 * 获得方块类型编号
	 */
	public int getTypeCode() {
		return typeCode;
	}
	
}
