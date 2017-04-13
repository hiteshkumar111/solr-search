package com.apple;

import io.github.robwin.swagger2markup.Swagger2MarkupConverter;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment= SpringBootTest.WebEnvironment.DEFINED_PORT)
//public class SolrSearchApplicationTests {
//
//
//	@Test
//	public void swaggerDocGenerationTest() throws IOException {
//		Swagger2MarkupConverter.from("http://localhost:8080/v2/api-docs").build().intoFolder("src/docs/asciidoc/generated");
//	}
//
//}
