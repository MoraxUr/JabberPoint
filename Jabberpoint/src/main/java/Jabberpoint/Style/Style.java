package Jabberpoint.Style;

import java.awt.Color;
import java.awt.Font;

/** <p>Jabberpoint.Style.Style stands for Indent, Color, Font and Leading.</p>
 * <p>The link between a style number and a item level is hard-linked:
 * in Jabberpoint.Presentation.Jabberpoint.Slide the style is grabbed for an item
 * with a style number the same as the item level.</p>
 * @author Ian F. Darwin, ian@darwinsys.com, Gert Florijn, Sylvia Stuurman
 * @version 1.1 2002/12/17 Gert Florijn
 * @version 1.2 2003/11/19 Sylvia Stuurman
 * @version 1.3 2004/08/17 Sylvia Stuurman
 * @version 1.4 2007/07/16 Sylvia Stuurman
 * @version 1.5 2010/03/03 Sylvia Stuurman
 * @version 1.6 2014/05/16 Sylvia Stuurman
 */

public abstract class Style {
	protected static final String FONTNAME = "Helvetica";

	public static Style getStyle(int level)
	{
		switch (level) {
			case 0 -> {
				return new StyleLevelOne();
			}
			case 1 -> {
				return new StyleLevelTwo();
			}
			case 2 -> {
				return new StyleLevelThree();
			}
			case 3 -> {
				return new StyleLevelFour();
			}
			case 4 -> {
				return new StyleLevelFive();
			}
		}
		return new StyleLevelFive();
	}

	public abstract Font getFont(float scale);
	public abstract int getIndent();
	public abstract Color getColor();
	public abstract int getFontSize();
	public abstract int getLeading();

}
