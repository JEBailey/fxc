package fxc;

import java.io.IOException;
import java.io.Writer;
import java.util.StringTokenizer;

/**
 * Element of text with no encapsulating structure
 * 
 */
class TextElement extends Element {
	
	
	public TextElement(String label) {
		super(label);
		START_TAG = VOID;
		END_TAG = VOID;
		EMPTY_TAG =  "%s%s";
	}

	@Override
	public Element add(Element value) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}

	@Override
	public Element add(String value) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
	}
	

	@Override
	public Element setAttribute(Attribute attribute) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Element setAttribute(String attribute) {
		throw new UnsupportedOperationException();
	}
	
	@Override
	public void write(Writer os, Formatter formatter) throws IOException {
		int maxSegmentLength = formatter.getSegmentLength();
	    String[] words = label.split("((?<= )|(?= ))");
	    int lineLen = 0;
	    for (String word: words) {
	        if (lineLen + word.length() > maxSegmentLength) {
	        	if (lineLen != 0){
		        	formatter.eol(os);
		        	formatter.indent(os);
	        	}
	            lineLen = 0;
	        }
	        os.write(word);
	        lineLen += word.length();
	    }
	}

	/* (non-Javadoc)
	 * @see fxc.Element#add(java.lang.String, java.lang.String)
	 */
	@Override
	public Element add(String tagName, String textValue) {
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see fxc.Element#setAttribute(java.lang.String, java.lang.String)
	 */
	@Override
	public Element setAttribute(String attribute, String value) {
		throw new UnsupportedOperationException();
	}

	/* (non-Javadoc)
	 * @see fxc.Element#getAttributes()
	 */
	@Override
	protected String getAttributes() {
		throw new UnsupportedOperationException();
	}
	
	
}