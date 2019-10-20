package com.jsonplaceholder.testing;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.jsonplaceholder.testing.configuration.ApiApplicationConfig;

@Tag("All")
@ContextConfiguration(classes = {ApiApplicationConfig.class})
@ExtendWith({SpringExtension.class})
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTest {

}
