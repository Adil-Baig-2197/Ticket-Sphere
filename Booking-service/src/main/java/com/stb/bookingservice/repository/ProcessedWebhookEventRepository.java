package com.stb.bookingservice.repository;

import com.stb.bookingservice.entity.ProcessedWebhookEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProcessedWebhookEventRepository extends JpaRepository<ProcessedWebhookEvent, String> {
}
