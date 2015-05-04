package fxc;


public class Formatter {

	private int depth;

	private int INDENT = 2;
	// TODO technically this is incorrect
	private String LFCR = "\r\n";

	private int segmentLength = 50;

	public int getSegmentLength() {
		return segmentLength;
	}

	public void setSegmentLength(int lineLength) {
		this.segmentLength = lineLength;
	}

	public String getIndent() {
		int indentation = depth * INDENT;
		if (indentation > 0) {
			return String.format("%1$" + indentation + "s", " ");
		} else {
			return "";
		}
	}

	public Formatter setEol(String eol) {
		this.LFCR = eol;
		return this;
	}

	public String getEol() {
		return LFCR;
	}

	public Formatter setIndentSize(int size) {
		INDENT = size;
		return this;
	}

	public int getIndentSize() {
		return INDENT;
	}

	public Formatter inc() {
		++depth;
		return this;
	}

	public Formatter dec() {
		--depth;
		return this;
	}

}
