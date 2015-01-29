/*
 * Element.java
 *
 * Created on April 30, 2004, 8:39 AM
 */

package fxc;

import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Basic element of an XML structure.
 * 
 * 
 * @author je bailey
 */
public class Element {

	protected static final String VOID = "";

	protected String START_TAG = "<%s%s>";
	protected String EMPTY_TAG = "<%s%s/>";
	protected String END_TAG = "</%s>";
	
	/**
	 * tag name
	 */
	protected String label = "";

	public List<Element> elements = new ArrayList<Element>(4);
	public Set<Attribute> attributes = new LinkedHashSet<Attribute>();

	/** Creates a new instance of Element */
	public Element(String label) {
		this.label = label;
	}

	public void write(Writer os) throws IOException {
		String tag = elements.isEmpty()? EMPTY_TAG : START_TAG;
		os.write(String.format(tag, label, getAttributes()));
		if (!elements.isEmpty()) {
			for (Element element : elements) {
				element.write(os);
			}
			os.write(String.format(END_TAG, label));
		}
	}

	public void write(Writer os, Formatter formatter) throws IOException {
		String tag = elements.isEmpty()? EMPTY_TAG : START_TAG;
		os.write(String.format(tag, label, getAttributes()));
		if (!elements.isEmpty()) {
			//end of a tag with contents. if this element is is not inline then eol;
			if (!this.isInline()){
				formatter.eol(os);
				formatter.inc();
			}
			for (Element element : elements) {
				if (!this.isInline()){
					formatter.indent(os);
				}
				element.write(os, formatter);
				if (!this.isInline()){
					formatter.eol(os);
				}
			}
			if (!this.isInline()){
				formatter.dec();
				formatter.indent(os);
			}
			os.write(String.format(END_TAG, label));
		}

	}

	public Element addText(Object label) throws UnsupportedOperationException {
		if (label instanceof Element) {
			throw new UnsupportedOperationException();
		}
		elements.add(new TextElement(label.toString()));
		return this;
	}

	public Element add(Element value) throws UnsupportedOperationException {
		elements.add(value);
		return this;
	}

	public Element add(String tag) throws UnsupportedOperationException {
		return this.add(new Element(tag));
	}

	public Element addTag(String tagName, Object value) {
		this.add(new Element(tagName).addText(value));
		return this;
	}

	public Element setAttribute(Attribute attribute) {
		if (!attributes.add(attribute)) {
			for (Attribute a : attributes) {
				if (a.equals(attribute)) {
					a.update(attribute);
				}
			}
		}
		;
		return this;
	}

	public Element setAttribute(String attribute) {
		return this.setAttribute(new Attribute(attribute));
	}

	public Element setAttribute(String attribute, String value) {
		return this.setAttribute(new Attribute(attribute, value));
	}

	protected String getAttributes(){
		StringBuilder sb = new StringBuilder();
		for (Attribute key : attributes) {
			sb.append(" ");
			sb.append(key.toString());
		}
		return sb.toString();
	}
	
	public boolean isInline(){
		if (elements.size()>1){
			return false;
		} else {
			return getSize() < 50;
		}
	}
	
	public int getSize() {
		int response = this.label.length();
		for (Element element:elements){
			response += element.getSize();
		}
		return response;
	}

	public String toString() {
		return toString(null);
	}

	public String toString(Formatter formatter) {
		StringWriter bos = new StringWriter();
		try {
			if (formatter == null) {
				write(bos);
			} else {
				write(bos, formatter);
			}
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return bos.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + END_TAG.hashCode();
		result = prime * result + START_TAG.hashCode();
		result = prime * result
				+ ((attributes == null) ? 0 : attributes.hashCode());
		result = prime * result + label.hashCode();
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Element other = (Element) obj;
		if (!END_TAG.equals(other.END_TAG)) {
			return false;
		}
		if (!EMPTY_TAG.equals(other.EMPTY_TAG)) {
			return false;
		}
		if (!START_TAG.equals(other.START_TAG)) {
			return false;
		}
		if (attributes == null) {
			if (other.attributes != null) {
				return false;
			}
		} else if (!attributes.equals(other.attributes)) {
			return false;
		}
		if (!label.equals(other)) {
			return false;
		}
		return true;
	}

}
