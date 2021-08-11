package com.exposit.confiapp;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com/exposit/dao", "com/exposite/service", "com/exposit/controller", "com/exposit/confiapp"})
public class ConfigApp {
}
