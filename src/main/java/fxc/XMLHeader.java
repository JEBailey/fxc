/**
 * Created on Sep 10, 2004
 *
 *
 */
package fxc;

import java.io.IOException;
import java.io.Writer;
import java.nio.charset.Charset;

/**
 * Encapsulates the 
 * 
 * 
 * @author je bailey
 */
public class XMLHeader extends Element {

	protected String DEFAULT_VERSION = "1.0";
	
	public XMLHeader() {
		this(false);
	}

	public XMLHeader(boolean simple) {
		super("");
		START_TAG = "<?xml%s%s?>";
		EMPTY_TAG = START_TAG;
		END_TAG = VOID;
		setAttribute(new Attribute("version", DEFAULT_VERSION));
		if (!simple){
			setAttribute(new Attribute("encoding", Charset.defaultCharset()));
		}
	}
	

	public XMLHeader setEncoding(String encoding) {
		setAttribute(new Attribute("encoding", encoding));
		return this;
	}
	
	public XMLHeader setStandalone(boolean standalone) {
		setAttribute(new Attribute("standalone", standalone ? "yes" : "no"));
		return this;
	}

	@Override
	public void write(Writer os, Formatter formatter) throws IOException {
		os.write(String.format(START_TAG, "",getAttributes()));
		if (!elements.isEmpty()){
			formatter.eol(os);
		}
		for (Element element:elements){
			element.write(os, formatter);
		}
	}
	
		
}
