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

    /**
     * Invokes methods clearCasheFile() to clean cache.txt file {@see application.src.main.resources.csv},
     * where info about process of parsing is saved.
     * Invokes method inspectParseDirForErrors(), which moves files from parse directory where files
     * can have errors from previous session.
     * Method is executed after dependency injection is done.
     *
     * @author Yauheni Markevich
     */
    @PostConstruct
    public void init() {
        CacheCsv.clearCasheFile();
        ParseFromCsv.inspectParseDirForErrors();
    }

    /**
     * Works on schedule.
     * Invokes methods moveSearchToErrorDir(), which searches errors in csv files.
     * Invokes methods moveSearchToParseDir(), which moving file from search directory to parse directory.
     * Scheduling can be switch off @see #field scheduling.enabled in application.properties.
     * Scheduling can be configured with property  fixedDelayString @see #field searching.file.delay
     * in application.properties.
     * Invokes methods of service layer updateShopProductsFromCsv().
     *
     * @author Yauheni Markevich
     */
    @Scheduled(fixedDelayString = "${searching.file.delay}", initialDelay = 100)
    public void inspectDirectoryScheduling() {
        ParseFromCsv.moveSearchToErrorDir();
        ParseFromCsv.moveSearchToParseDir();
        LOG.info(Thread.currentThread().getName());
        shopProductService.updateShopProductsFromCsv();
    }
}
