package main;

import control.AutoDown;
import control.GameControl;
import control.PlayerControl;
import dto.GameDto;
import service.GameService;
import ui.JFrameGame;
import ui.JPanelGame;

public class Main {

	public static void main(String[] args) {
		//创建游戏数据源
		GameDto dto = new GameDto();
		//创建游戏面板
		JPanelGame panel = new JPanelGame(dto);
		//创建游戏逻辑块（连接游戏数据源）
		GameService service = new GameService(dto);
		//创建游戏控制器（连接游戏面板与游戏逻辑块）
		GameControl gameControl = new GameControl(panel, service);
		AutoDown autoDown = new AutoDown(panel, service);
		panel.setAutoDown(autoDown);
		//将控制器交给panel
		panel.setGameControl(gameControl);
		//创建玩家控制器（连接游戏控制器）
		PlayerControl control = new PlayerControl(gameControl, autoDown);
		//安装玩家控制器
		panel.setGameControl(control);
		//创建游戏窗口，安装游戏面板
		new JFrameGame(panel);
		autoDown.start();
	}

}
