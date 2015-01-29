package fxc;

import java.io.IOException;
import java.io.Writer;

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
	public Element addText(Object label) throws UnsupportedOperationException {
		throw new UnsupportedOperationException();
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
		os.write(String.format(label, getAttributes()));
	}
	
	
	
}