package Jabberpoint.Controller;

import Jabberpoint.Presentation;
import Jabberpoint.Accessor.Accessor;
import Jabberpoint.Accessor.XMLAccessor;

import java.awt.MenuBar;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuItem;
import java.awt.MenuShortcut;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;

import javax.swing.JOptionPane;

/** <p>The controller for the menu</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */
public class MenuController extends MenuBar {
	
	private final Frame parent; //The frame, only used as parent for the Dialogs
	private final Presentation presentation; //Commands are given to the presentation
	
	private static final long serialVersionUID = 227L;
	
	protected static final String ABOUT = "About";
	protected static final String FILE = "File";
	protected static final String EXIT = "Exit";
	protected static final String GOTO = "Go to";
	protected static final String HELP = "Help";
	protected static final String NEW = "New";
	protected static final String NEXT = "Next";
	protected static final String OPEN = "Open";
	protected static final String PAGENR = "Page number?";
	protected static final String PREV = "Prev";
	protected static final String SAVE = "Save";
	protected static final String VIEW = "View";
	
	protected static final String TESTFILE = "./assets/testPresentation.xml";
	protected static final String SAVEFILE = "savedPresentation.xml";
	
	protected static final String IOEX = "IO Exception: ";
	protected static final String LOADERR = "Load Error";
	protected static final String SAVEERR = "Save Error";

	public MenuController(Frame frame, Presentation pres) {
		this.parent = frame;
		this.presentation = pres;
		addToMenuBar();
	}

	// adds the menu's to the menu bar
	protected void addToMenuBar()
	{
		add(makeFileMenu());
		add(makeViewMenu());
		setHelpMenu(makeHelpMenu());
	}

	//Creating a menu-item
	protected MenuItem mkMenuItem(String name, char shortCut) {
		MenuItem item = new MenuItem(name, new MenuShortcut(shortCut));
		giveActionListener(item);
		return item;
	}

	protected Menu makeFileMenu()
	{
		Menu fileMenu = new Menu(FILE);
		fileMenu.add(mkMenuItem(OPEN,'o'));
		fileMenu.add(mkMenuItem(NEW,'n'));
		fileMenu.add(mkMenuItem(SAVE,'s'));
		fileMenu.addSeparator();
		fileMenu.add(mkMenuItem(EXIT,'e'));
		return fileMenu;
	}

	protected Menu makeViewMenu()
	{
		Menu viewMenu = new Menu(VIEW);
		viewMenu.add(mkMenuItem(NEXT,'['));
		viewMenu.add(mkMenuItem(PREV,'p'));
		viewMenu.add(mkMenuItem(GOTO,'g'));
		return(viewMenu);
	}

	protected Menu makeHelpMenu()
	{
		Menu helpMenu = new Menu(HELP);
		helpMenu.add(mkMenuItem(ABOUT,'a'));
		return helpMenu;
	}

	protected void giveActionListener(MenuItem menuItem)
	{
		switch (menuItem.getLabel()) {
			case OPEN -> {
				menuOpenListener(menuItem);
			}
			case NEW -> {
				menuItem.addActionListener(actionEvent -> {
					presentation.clear();
					parent.repaint();
				});
			}
			case SAVE -> {
				menuSaveListener(menuItem);
			}
			case EXIT -> {
				menuItem.addActionListener(actionEvent -> presentation.exit(0));
			}
			case NEXT -> {
				menuItem.addActionListener(actionEvent -> presentation.nextSlide());
			}
			case PREV -> {
				menuItem.addActionListener(actionEvent -> presentation.prevSlide());
			}
			case GOTO -> {
				menuItem.addActionListener(actionEvent -> {
					String pageNumberStr = JOptionPane.showInputDialog(PAGENR);
					int pageNumber = Integer.parseInt(pageNumberStr);
					presentation.setSlideNumber(pageNumber - 1);
				});
			}
			case ABOUT -> menuItem.addActionListener(actionEvent -> AboutBox.show(parent));
		}
	}

	protected void menuOpenListener(MenuItem menuItem)
	{
		menuItem.addActionListener(actionEvent -> {
			presentation.clear();
			Accessor xmlAccessor = new XMLAccessor();
			try {
				xmlAccessor.loadFile(presentation, TESTFILE);
				presentation.setSlideNumber(0);
			} catch (IOException exc) {
				JOptionPane.showMessageDialog(parent, IOEX + exc,
						LOADERR, JOptionPane.ERROR_MESSAGE);
			}
			parent.repaint();
		});
	}

	protected void menuSaveListener(MenuItem menuItem)
	{
		menuItem.addActionListener(e -> {
			Accessor xmlAccessor = new XMLAccessor();
			try {
				xmlAccessor.saveFile(presentation, SAVEFILE);
			} catch (IOException exc) {
				JOptionPane.showMessageDialog(parent, IOEX + exc,
						SAVEERR, JOptionPane.ERROR_MESSAGE);
			}
		});
	}
}
