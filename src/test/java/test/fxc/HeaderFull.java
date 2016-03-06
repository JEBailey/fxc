package test.fxc;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org._24601.fxc.Element;
import org._24601.fxc.xml.XMLHeader;
import org.junit.Before;
import org.junit.Test;


public class HeaderFull {

	private String text;

	@Before
	public void setUp() throws Exception {
		InputStream is = new FileInputStream(new File("./src/test/resources/headerfull.xml"));
		Scanner scanner = new Scanner(is, "UTF-8");
		scanner.useDelimiter("\\A");
		text = scanner.next();
		scanner.close();
	}

	@Test
	public void test() {
		XMLHeader header = new XMLHeader();
		header.setStandalone(true);
		header.setEncoding("UTF-8");
		assertEquals(text, header.toString());
	}
	
	
	

}
