package com.exposit.confiapp;

import com.exposit.api.service.ShopProductService;
import com.exposit.utils.parsecsv.ParseFromCsv;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Log4j
@Configuration
@EnableScheduling
@RequiredArgsConstructor
@ConditionalOnProperty(name = "searching.file.delay", matchIfMissing = true)
public class ConfigSchedule {

    private final ShopProductService shopProductService;

    @Scheduled(fixedDelayString = "${searching.file.delay}", initialDelay = 100)
    public void inspectDirectoryScheduling() {
        System.out.println("" + Thread.currentThread().getName());

        if (ParseFromCsv.moveToParseDir()) {
            shopProductService.updateShopProductsFromCsv();
        }

    }
}
