package com.exposit.confiapp;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan({"com/exposit/dao", "com/exposit/service", "com/exposit/controller", "com/exposit/confiapp",
        "com/exposit/menu"})
public class ConfigApp {
}
