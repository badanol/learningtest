package badanol.learningtest;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsyncConfig {

    public final static String LOG_THREAD_POOL_NAME = "log_thread_pool";
    
    @Bean(LOG_THREAD_POOL_NAME)
    public TaskExecutor taskExecutor() {		
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setQueueCapacity(5);
        executor.setCorePoolSize(1);
        executor.setMaxPoolSize(10);
        executor.setAllowCoreThreadTimeOut(true);
        executor.setKeepAliveSeconds(1);
        executor.setThreadNamePrefix("executor-");        
		return executor;
	}
}
