package fxc;

import java.io.IOException;
import java.io.Writer;

/**
 * Utility class to represent CDATA based data within the XML Structure
 * 
 * @author Jason E Bailey
 *
 */
public class CDATA extends TextElement {

	public CDATA(String content) {
		super("");
		START_TAG = "<![CDATA[";
		END_TAG = "]]>";
		EMPTY_TAG = "<![CDATA[ ]]>";
		this.add(content);
	}

	/* (non-Javadoc)
	 * @see fxc.TextElement#write(java.io.Writer, fxc.Formatter)
	 */
	@Override
	public void write(Writer os, Formatter formatter) throws IOException {
		write(os);
	}

}
