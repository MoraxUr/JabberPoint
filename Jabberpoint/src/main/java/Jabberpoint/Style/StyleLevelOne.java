package Jabberpoint.Style;

import java.awt.*;

public class StyleLevelOne extends Style
{
    private static final int FONTSIZE = 48;
    private static final int INDENT = 0;
    private static final int LEADING = 20;
    private static final Color COLOR = Color.RED;
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
