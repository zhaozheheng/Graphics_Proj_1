package control;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class PlayerControl implements MouseListener,MouseWheelListener,MouseMotionListener{

	private GameControl gameControl = null;
	
	private AutoDown autoDown = null;
	
	public PlayerControl(GameControl gameControl, AutoDown autoDown) {
		this.gameControl = gameControl;
		this.autoDown = autoDown;
	}
	
	/*
	 * 鼠标点击事件
	 */

	@Override
	public void mouseClicked(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		if (x>100&&x<300&&y>100&&y<500) {
			return;
			}
		switch (e.getButton()) {
		case MouseEvent.BUTTON1:
			this.gameControl.left();
			break;
		case MouseEvent.BUTTON3:
			this.gameControl.right();
			break;
		default:
			break;
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	/*
	 * 鼠标滚轮事件
	 * (non-Javadoc)
	 * @see java.awt.event.MouseWheelListener#mouseWheelMoved(java.awt.event.MouseWheelEvent)
	 */
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		int x = e.getX();
		int y = e.getY();
		if (x>100&&x<300&&y>100&&y<500) {
			return;
			}
		switch (e.getWheelRotation()) {
		case 1:
			this.gameControl.clockRound();
			break;
		case -1:
			this.gameControl.counterClockRound();
			break;
		default:
			break;
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		//this.autoDown.start();
		int x = e.getX();
		int y = e.getY();
		if (x>100&&x<300&&y>100&&y<500) {
			this.autoDown.suspend();
			}
		else{
			this.autoDown.resume();
		}
	}
	
}
