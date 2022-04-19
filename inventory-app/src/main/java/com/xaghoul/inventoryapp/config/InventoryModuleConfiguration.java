package com.xaghoul.inventoryapp.config;


import org.springframework.cloud.openfeign.FeignClientProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import(FeignClientProperties.FeignClientConfiguration.class)
public class InventoryModuleConfiguration {
}
