package Jabberpoint.Controller;

import Jabberpoint.Presentation;

import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;

/** <p>This is the Jabberpoint.Controller.KeyController (KeyListener)</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
*/

public class KeyController extends KeyAdapter {
	private Presentation presentation; //Commands are given to the presentation

	public KeyController(Presentation p) {
		presentation = p;
	}

	public void keyPressed(KeyEvent keyEvent) {
		int keyCode = keyEvent.getKeyCode();
		if (keyCode == KeyEvent.VK_PAGE_DOWN || keyCode == KeyEvent.VK_DOWN || keyCode == KeyEvent.VK_ENTER || keyCode == '+') {
			presentation.nextSlide();
		}
		if (keyCode == KeyEvent.VK_PAGE_UP || keyCode == KeyEvent.VK_UP || keyCode == '-') {
			presentation.prevSlide();
		}
		if (keyCode == KeyEvent.VK_Q) {
			System.exit(0);
		}
	}
}
