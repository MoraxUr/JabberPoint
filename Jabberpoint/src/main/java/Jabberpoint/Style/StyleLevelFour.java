package Jabberpoint.Style;

import java.awt.*;

public class StyleLevelFour extends Style
{
    private static final int FONTSIZE = 30;
    private static final int INDENT = 70;
    private static final int LEADING = 10;
    private static final Color COLOR = Color.BLUE;
    private final Font font = new Font(FONTNAME, Font.BOLD, FONTSIZE);

    public Font getFont(float scale) {
        return font.deriveFont(FONTSIZE * scale);
    }

    public int getIndent()
    {
        return INDENT;
    }

    public int getLeading() {
        return LEADING;
    }

    public Color getColor() {
        return COLOR;
    }

    public int getFontSize() {
        return FONTSIZE;
    }
}