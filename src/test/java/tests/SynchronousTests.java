package tests;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.junit.Assert;
import org.junit.Test;

import helio.blueprints.TranslationUnit;

public class SynchronousTests {



	@Test
	public void test01() throws Exception {
		ExecutorService service = Executors.newFixedThreadPool(4);
		TranslationUnit unit = TestUtils.build("./src/test/resources/sync-tests/01-mapping.ldmap");
		String result = TestUtils.runUnit(unit, service);
		String expected = TestUtils.readFile("./src/test/resources/sync-tests/01-expected.jsonld");
		service.shutdownNow();
		Assert.assertTrue(TestUtils.equals(result, expected));
	}

	@Test
	public void test02() throws Exception {
		ExecutorService service = Executors.newFixedThreadPool(4);
		TranslationUnit unit = TestUtils.build("./src/test/resources/sync-tests/02-mapping.ldmap");
		String result = TestUtils.runUnit(unit, service);
		service.shutdownNow();
		String expected = TestUtils.readFile("./src/test/resources/sync-tests/02-expected.jsonld");
		Assert.assertTrue(TestUtils.equals(result, expected));
	}

	@Test
	public void test03() throws Exception {
		ExecutorService service = Executors.newFixedThreadPool(4);
		TranslationUnit unit = TestUtils.build("./src/test/resources/sync-tests/03-mapping.ldmap");
		String result = TestUtils.runUnit(unit, service);
		String expected = TestUtils.readFile("./src/test/resources/sync-tests/03-expected.jsonld");
		service.shutdownNow();
		Assert.assertTrue(TestUtils.equals(result, expected));
	}
	
	/**
	 * It expects an exception to be thrown
	 */
	@Test
	public void test04() throws Exception {
		boolean isThrown = false;
		ExecutorService service = Executors.newCachedThreadPool();
		TranslationUnit unit =TestUtils.build("./src/test/resources/sync-tests/04-mapping.ldmap");
		
		try {
			TestUtils.runUnit(unit, service);
		}catch(Exception e) {
			isThrown = true;
			System.out.println(e.toString());
		}
		Assert.assertTrue(isThrown);
	}
}
