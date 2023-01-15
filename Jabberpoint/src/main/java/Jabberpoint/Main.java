package Jabberpoint;

import Jabberpoint.DemoPresentation.DemoPresentation;
import Jabberpoint.Accessor.XMLAccessor;
import Jabberpoint.Viewer.SlideViewerFrame;

import javax.swing.JOptionPane;

import java.io.IOException;

/** Jabberpoint.JabberPoint Main Program
 * <p>This program is distributed under the terms of the accompanying
 * COPYRIGHT.txt file (which is NOT the GNU General Public License).
 * Please read it. Your use of the software constitutes acceptance
 * of the terms in the COPYRIGHT.txt file.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public class Main {
	protected static final String IOERR = "IO Error: ";
	protected static final String JABERR = "Jabberpoint Error ";
	protected static final String JABVERSION = "Jabberpoint 1.6 - OU version";

	/** The main program */
	public static void main(String[] argv) {

		ControlRoom controlRoom = new ControlRoom();
		new SlideViewerFrame(JABVERSION, controlRoom);
		try {
			if (argv.length == 0)
			{
				DemoPresentation.showDemo(controlRoom);
			}
			else
			{
				new XMLAccessor().loadFile(controlRoom, argv[0]);
			}
			controlRoom.setSlideNumber(0);
		} catch (IOException ex) {
			JOptionPane.showMessageDialog(null,
					IOERR + ex, JABERR,
					JOptionPane.ERROR_MESSAGE);
		}
	}
}