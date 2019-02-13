package ui;

import java.awt.Graphics;

import dto.GameDto;

public class Layer {

	protected int x;
	
	protected int y;
	
	protected int w;
	
	protected int h;
	/*
	 * 游戏数据
	 */
	protected GameDto dto = null;
	
	public void setDto(GameDto dto) {
		this.dto = dto;
	}

	public Layer(int x, int y, int w, int h){
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	
	public void createWindow(Graphics g){
		g.drawRect(x, y, w, h);
	}
}
