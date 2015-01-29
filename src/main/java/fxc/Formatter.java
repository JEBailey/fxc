package fxc;

import java.io.IOException;
import java.io.Writer;

public class Formatter {
	
	private boolean prettyPrint;

	private int indent;

	private String INDENT = "  ";
	//TODO technically this is incorrect
	private String LFCR = "\r\n";
	
	public void indent(Writer os) throws IOException {
		if (prettyPrint) {
			for (int i = indent; i-- > 0;) {
				os.write(INDENT);
			}
		}
	}
	
	public Formatter eol(Writer os) throws IOException {
		if (prettyPrint) {
			os.write(LFCR);
		}
		return this;
	}
	
	public Formatter setPrettyPrint(boolean prettyPrint) {
		this.prettyPrint = prettyPrint;
		return this;
	}
	
	public Formatter setIndentSize(int size) {
		INDENT = String.format("%1$" + size + "s", " "); 
		return this;
	}

	public Formatter inc() {
		++indent;
		return this;
	}

	public Formatter dec() {
		--indent;
		return this;
	}

}
