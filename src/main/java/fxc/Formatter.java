package fxc;

/*
 * Copyright 2015 Jason E Bailey
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
