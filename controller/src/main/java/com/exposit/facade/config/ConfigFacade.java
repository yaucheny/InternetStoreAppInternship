package com.exposit.facade.config;

import com.exposit.menu.MenuController;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * Special class that gives on opportunity of working with console interface.
 * Console interface can be switch on  @see #field facade.enabled in application.properties.
 * When facade.enabled=true controller layer is switch off and console interface is loaded.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@Component
@ConditionalOnProperty(name = "facade.enabled", matchIfMissing = true)
@RequiredArgsConstructor
public class ConfigFacade implements ApplicationListener<ApplicationReadyEvent> {

    private final MenuController menuController;

    /**
     * This event is executed as late as conceivably possible to indicate that
     * the application is ready to work with console interface.
     *
     * @author Yauheni Markevich
     */
    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {
        menuController.run();
    }
}
