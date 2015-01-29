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
	}

	@Test
	public void test() {
		Element note = new Element("note");
		note.addTag("to","Tove");
		note.addTag("from","Jani");
		note.addTag("heading","Reminder");
		note.addTag("body","Don't forget me this weekend!");
		assertEquals(text, note.toString());
	}

	@Test
	public void testPretty() {
		Element note = new Element("note").addTag("to", "Tove")
				.addTag("from", "Jani").addTag("heading", "Reminder")
				.addTag("body", "Don't forget me this weekend!");
		assertEquals(pretty, note.toString(new Formatter().setPrettyPrint(true)));
	}
	
	@Test
	public void testFull() {
		Element note = new Element("note").addTag("to", "Tove")
				.addTag("from", "Jani").addTag("heading", "Reminder")
				.addTag("body", "Don't forget me this weekend!");
		Element test = new XMLHeader(true).add(note);
		assertEquals(full, test.toString(new Formatter().setPrettyPrint(true)));
	}

}
