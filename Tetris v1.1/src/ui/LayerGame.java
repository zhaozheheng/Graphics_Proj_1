package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

import entity.GameAct;

public class LayerGame extends Layer{
	
	public LayerGame(int x, int y, int w, int h){
		super(x, y, w, h);
	}
	
	/*public void getColor(){
		//获得方块类型编号
		Color gc = null;
		int typeCode = this.dto.getGameAct().getTypeCode();
		switch (typeCode) {
		case 0:
			gc = Color.YELLOW;
			break;
		case 1:
			gc = Color.MAGENTA;
			break;
		case 2:
			gc = Color.BLUE;
			break;
		case 3:
			gc = Color.RED;
			break;
		case 4:
			gc = Color.GREEN;
			break;
		case 5:
			gc = Color.ORANGE;
			break;
		case 6:
			gc = Color.PINK;
			break;
		default:
			break;
		}
	}*/
	
	public void paint(Graphics g) {
		this.createWindow(g);
		//绘制游戏地图
		Point[] points = this.dto.getGameAct().getActPoints();
		//获得方块类型编号
		int typeCode = this.dto.getGameAct().getTypeCode();
			//打印方块
			for (int i = 0; i < points.length; i++){
				Color c = g.getColor();
				switch (typeCode) {
				case 0:
					g.setColor(Color.YELLOW);
					break;
				case 1:
					g.setColor(Color.MAGENTA);
					break;
				case 2:
					g.setColor(Color.BLUE);
					break;
				case 3:
					g.setColor(Color.RED);
					break;
				case 4:
					g.setColor(Color.GREEN);
					break;
				case 5:
					g.setColor(Color.ORANGE);
					break;
				case 6:
					g.setColor(Color.PINK);
					break;
				default:
					break;
				}
				g.fillRect(this.x + points[i].x * 20, this.y + points[i].y * 20, 20, 20);
				g.setColor(c);
				g.drawRect(this.x + points[i].x * 20, this.y + points[i].y * 20, 20, 20);
			
		}
		//打印地图
		boolean[][] map = this.dto.getGameMap();
		for (int x = 0; x < map.length; x++) {
			for (int y = 0; y < map[x].length; y++) {
				if (map[x][y]) {
					Color c = g.getColor();
					g.setColor(Color.WHITE);
					g.fillRect(this.x + x * 20, this.y + y * 20, 20, 20);
					g.setColor(c);
					g.drawRect(this.x + x * 20, this.y + y * 20, 20, 20);
				}
				
			}
		}
		
		/*for (int i = 0; i < act.getActPoint2().length; i++){
			Color c = g.getColor();				
			g.setColor(Color.YELLOW);
			g.fillRect(100 + act.getActPoint2()[i].x * 20, 100 + act.getActPoint2()[i].y * 20, 20, 20);
			g.setColor(c);
			g.drawRect(100 + act.getActPoint2()[i].x * 20, 100 + act.getActPoint2()[i].y * 20, 20, 20);
		}
			
						
		for (int i = 0; i < act.getActPoint3().length; i++){
			Color c = g.getColor();
			g.setColor(Color.BLUE);
			g.fillRect(100 + act.getActPoint3()[i].x * 20, 100 + act.getActPoint3()[i].y * 20, 20, 20);
			g.setColor(c);									
			g.drawRect(100 + act.getActPoint3()[i].x * 20, 100 + act.getActPoint3()[i].y * 20, 20, 20);
			}*/
	}
}
