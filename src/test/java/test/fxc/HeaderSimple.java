package test.fxc;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.junit.Before;
import org.junit.Test;

import fxc.Element;
import fxc.XMLHeader;


public class HeaderSimple {

	private String text;

	@Before
	public void setUp() throws Exception {
		InputStream is = new FileInputStream(new File("./src/test/resources/headersimple.xml"));
		Scanner scanner = new Scanner(is, "UTF-8");
		scanner.useDelimiter("\\A");
		text = scanner.next();
		scanner.close();
	}

	@Test
	public void test() {
		String element = new XMLHeader().toString();
		assertEquals(text, element);
	}

}
