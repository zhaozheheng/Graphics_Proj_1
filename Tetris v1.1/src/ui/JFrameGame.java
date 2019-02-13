package ui;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class JFrameGame extends JFrame{
	
	public JFrameGame(JPanelGame panelGame){
		//设置标题
		this.setTitle("Java Tetris");
		//设计默认关闭
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//设置窗口大小
		this.setSize(600, 600);
		//不允许用户改变窗口大小
		this.setResizable(false);
		//居中属性
		//this.setLocation(100,100);
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Dimension screen = toolkit.getScreenSize();
		int x = (screen.width - this.getWidth()) / 2;
		int y = (screen.height - this.getHeight()) / 2 - 32;
		this.setLocation(x, y);
		//设置默认Panel
		this.setContentPane(panelGame);
		//默认可见
		this.setVisible(true);
		System.out.println(panelGame.getSize().width);
	}
}
