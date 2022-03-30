package com.shopstyle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorProvider")
public class JpaAuditingConfig {

	@Bean
	public AuditorAware<String> auditorProvider() {
		return new AuditorAwareImpl();
	}

	public static class AuditorAwareImpl implements AuditorAware<String> {
		
		@Override
		public String getCurrentAuditor() { // Get thông tin user name ra để đưa dữ liệu vào @CreatedBy ./entity/BaseEntity
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication(); // Lấy user name
			if (authentication == null) {
				return null;
			}
			return authentication.getName();
		}
	}
}