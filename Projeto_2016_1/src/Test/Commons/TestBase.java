package Test.Commons;

import org.junit.BeforeClass;

public class TestBase {
	
	@BeforeClass
	public void setUp() {
		ContextSpecifier.setContext("br.com.fatec.projeto");
		ConfigDbMapper.setDefaultConnectionName("test");
		LiquibaseRunnerService.run();
	}
	
}
