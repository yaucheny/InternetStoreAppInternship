package com.exposit.facade.config;

import com.exposit.menu.MenuController;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnProperty(name = "facade.enabled", matchIfMissing = true)
@RequiredArgsConstructor
public class ConfigFacade {

    private final MenuController menuController;

//   // @PostConstruct
//       public void initFacadeMenu() {
//        menuController.run();
//    }
}

