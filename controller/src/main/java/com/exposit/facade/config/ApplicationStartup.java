package com.exposit.facade.config;

import com.exposit.menu.MenuController;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
@ConditionalOnProperty(name = "facade.enabled", matchIfMissing = true)
@RequiredArgsConstructor
public class ApplicationStartup implements ApplicationListener<ApplicationReadyEvent> {
    private final MenuController menuController;
    /**
     * This event is executed as late as conceivably possible to indicate that
     * the application is ready to service requests.
     */
    @Override
    public void onApplicationEvent(final ApplicationReadyEvent event) {

        menuController.run();

        return;
    }

}
