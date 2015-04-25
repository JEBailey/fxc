package test.fxc;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import fxc.Element;
import fxc.Formatter;
import fxc.XMLHeader;

public class Note {

	private String text;
	private String pretty;
	private String full;
	private String complex;

	@Before
	public void setUp() throws Exception {
		{
			InputStream is = new FileInputStream(new File(
					"./src/test/resources/note.xml"));
			Scanner scanner = new Scanner(is, "UTF-8");
			scanner.useDelimiter("\\A");
			text = scanner.next();
			scanner.close();
		}
		{
			InputStream is = new FileInputStream(new File(
					"./src/test/resources/notePretty.xml"));
			Scanner scanner = new Scanner(is, "UTF-8");
			scanner.useDelimiter("\\A");
			pretty = scanner.next();
			scanner.close();
		}
		{
			InputStream is = new FileInputStream(new File(
					"./src/test/resources/fullNotePretty.xml"));
			Scanner scanner = new Scanner(is, "UTF-8");
			scanner.useDelimiter("\\A");
			full = scanner.next();
			scanner.close();
		}
		{
			InputStream is = new FileInputStream(new File(
					"./src/test/resources/complexNotePretty.xml"));
			Scanner scanner = new Scanner(is, "UTF-8");
			scanner.useDelimiter("\\A");
			complex = scanner.next();
			scanner.close();
		}
	}

	@Test
	public void test() {
		Element note = new Element("note");
		note.add("to","Tove");
		note.add("from","Jani");
		note.add("heading","Reminder");
		note.add("body","Don't forget me this weekend!");
		assertEquals(text, note.toString());
	}

	@Test
	public void testPretty() {
		Element note = new Element("note")
			.add("to", "Tove")
			.add("from", "Jani")
			.add("heading", "Reminder")
			.add("body", "Don't forget me this weekend!");
		assertEquals(pretty, note.toString(new Formatter().setPrettyPrint(true)));
	}
	
	@Test
	public void testFull() {
		Element note = new Element("note").add("to", "Tove")
				.add("from", "Jani").add("heading", "Reminder")
				.add("body", "Don't forget me this weekend!");
		Element test = new XMLHeader(true).add(note);
		assertEquals(full, test.toString(new Formatter().setPrettyPrint(true)));
	}
	
	@Test
	public void testComplex() {
		Element note = new Element("note").add("to", "Tove")
				.add("from", "Jani").add("heading", "Reminder")
				.add("body", "This is a very long complex note that includes a multi lined string and styling");
		Element test = new XMLHeader(true).add(note);
		assertEquals(complex, test.toString(new Formatter().setPrettyPrint(true)));
	}

}
