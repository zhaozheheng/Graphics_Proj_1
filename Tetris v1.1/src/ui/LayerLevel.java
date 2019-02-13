package ui;

import java.awt.Font;
import java.awt.Graphics;

import dto.GameDto;

public class LayerLevel {
	
	private String t;
	
	private int w;
	
	private int h;
	/*
	 * 游戏数据
	 */
	protected GameDto dto = null;
	
	public void setDto(GameDto dto) {
		this.dto = dto;
	}
	public LayerLevel(String t, int w, int h){
		this.t = t;
		this.w = w;
		this.h = h;
	}
	
	public void paint(Graphics g){
		Font f1 = new Font("黑体", Font.BOLD, 18);
		g.setFont(f1);
		g.drawString(t, w, h);
	}
}
