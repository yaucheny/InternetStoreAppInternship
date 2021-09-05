package com.exposit.confiapp;

import com.exposit.api.service.ShopProductService;
import com.exposit.utils.parsecsv.CacheCsv;
import com.exposit.utils.parsecsv.ParseFromCsv;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.PostConstruct;

/**
 * Class to configure scheduler in spring boot.
 * Scheduling can be switch off @see #field scheduling.enabled in application.properties.
 * Scheduling can be configured with property  fixedDelayString @see #field searching.file.delay
 * in application.properties.
 *
 * @author Yauheni Markevich
 * @version 1.0
 */
@Configuration
@EnableScheduling
@RequiredArgsConstructor
@ConditionalOnProperty(name = "scheduling.enabled", matchIfMissing = true)
public class ConfigSchedule {

    private static final Logger LOG = LoggerFactory.getLogger(ConfigSchedule.class);
    private final ShopProductService shopProductService;

    @PostConstruct
    public void init() {
        CacheCsv.clearCasheFile();
        ParseFromCsv.inspectParseDirForErrors();
    }

    @Scheduled(fixedDelayString = "${searching.file.delay}", initialDelay = 100)
    public void inspectDirectoryScheduling() {
        ParseFromCsv.moveSearchToErrorDir();
        ParseFromCsv.moveSearchToParseDir();
        LOG.info(Thread.currentThread().getName());
        shopProductService.updateShopProductsFromCsv();


    }
}
