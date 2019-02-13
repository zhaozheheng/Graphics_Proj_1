package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import control.AutoDown;
import control.GameControl;
import control.PlayerControl;
import dto.GameDto;
import service.GameService;

public class JPanelGame extends JPanel{
	
	private LayerGame lay1 = new LayerGame(100, 100, 200, 400);
	private LayerNext lay2 = new LayerNext(350, 100, 120, 80);
	private LayerLevel lay3 = new LayerLevel("Level:    1", 350, 240);
	private LayerLines lay4 = new LayerLines("Lines:    0", 350, 280);
	private LayerScore lay5 = new LayerScore("Score:    0", 350, 320);
	
	private GameDto dto = null;
	
	private GameControl gameControl = null;
	
	private AutoDown autoDown = null;
	
	
	
	public JPanelGame(GameDto dto){
		//获得dto对象
		this.dto = dto;
		//初始化组件
		initComponent();
		//初始化层
		initLayer();
		
	}
	public void setAutoDown(AutoDown autoDown){
		this.autoDown = autoDown;
	}
	public void setGameControl(GameControl gameControl) {
		this.gameControl = gameControl;
	}
	/*
	 * 安装玩家控制器
	 */
	public void setGameControl(PlayerControl control){
		this.addMouseListener(control);
		this.addMouseWheelListener(control);
		this.addMouseMotionListener(control);
	}
	/*
	 * 初始化组件
	 */
	public void initComponent(){

	}
	/*
	 *  初始化层
	 */
	public void initLayer(){
		
		lay1.setDto(this.dto);
		lay2.setDto(this.dto);
		lay3.setDto(this.dto);
		lay4.setDto(this.dto);
		lay5.setDto(this.dto);
		
		this.setLayout(null);
		
		JButton bt1 = new JButton("QUIT");
		bt1.setForeground(Color.BLACK);
		bt1.setFont(new Font("黑体", Font.BOLD, 18));
		bt1.setBackground(Color.WHITE);
		bt1.setBounds(350, 470, 90, 30);
		bt1.setBorder(new LineBorder(Color.BLACK));
		bt1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}
		});
		this.add(bt1);
		
		/*
		 * PAUSE按钮
		 */
		/*JButton bt2 = new JButton("PAUSE");
		bt2.setForeground(Color.BLUE);
		bt2.setFont(new Font("黑体", Font.BOLD, 24));
		bt2.setBackground(Color.WHITE);
		bt2.setBounds(140, 290, 120, 40);
		bt2.setBorder(new LineBorder(Color.BLUE));
		this.add(bt2).setVisible(false);
		
		this.addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO Auto-generated method stub
				int x = e.getX();
				int y = e.getY();
				
				if(x>100&&x<300&&y>100&&y<500){
					bt2.setVisible(true);
				}
				else{
					bt2.setVisible(false);
				}
			}
			

			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});*/
		
		
		
		
	}
	
	@Override
	public void paintComponent(Graphics g){
		//循环刷新游戏画面
		lay1.paint(g);
		lay2.paint(g);
		lay3.paint(g);
		lay4.paint(g);
		lay5.paint(g);
		
	}
	
}
