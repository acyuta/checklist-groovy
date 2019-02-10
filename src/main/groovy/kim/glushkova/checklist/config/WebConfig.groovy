package kim.glushkova.checklist.config

import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

/**
 *
 */
@Configuration
@ComponentScan('kim.glushkova.checklist')
class WebConfig implements WebMvcConfigurer {
}
