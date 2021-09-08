package com.exposit.confiapp;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Class to configure component scan in spring boot.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@Configuration
@ComponentScan({"com/exposit/dao", "com/exposit/service", "com/exposit/controller", "com/exposit/confiapp",
        "com/exposit/menu"})
public class ConfigApp {
}
