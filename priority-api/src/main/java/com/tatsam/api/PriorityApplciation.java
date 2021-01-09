package com.tatsam.api;

import com.tatsam.service.ServiceConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import({ServiceConfiguration.class})
public class PriorityApplciation {
}
