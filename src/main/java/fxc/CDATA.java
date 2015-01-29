package fxc;

import fxc.Element;

public class CDATA extends Element {

	public CDATA(String content){
		super("");
		START_TAG = "<![CDATA[";
		END_TAG = "]]>";
		EMPTY_TAG = "<![CDATA[ ]]>";
		this.addText(content);
	}
	
}
