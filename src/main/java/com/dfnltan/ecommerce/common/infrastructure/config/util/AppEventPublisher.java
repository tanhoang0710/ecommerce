package com.dfnltan.ecommerce.common.infrastructure.config.util;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class AppEventPublisher {
    private final ApplicationEventPublisher publisher;

    public <T> void publishEvent(T event) {
        try {
            log.info("[AppEventPublisher] Published an event: {}", event);
            publisher.publishEvent(event);
        } catch (Exception e) {
            log.error("[AppEventPublisher] error when published an event: {}", e.getMessage(), e);
        }
    }
}
