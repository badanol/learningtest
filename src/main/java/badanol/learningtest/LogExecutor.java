package badanol.learningtest;

import java.time.Duration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;

@Component
public class LogExecutor implements CommandLineRunner {

    private final static Log logger = LogFactory.getLog(LogExecutor.class);

    private final UserInfoRequester requester;

    public LogExecutor(UserInfoRequester requester) {
        this.requester = requester;
    }

    @Override
    public void run(String... args) throws Exception {

        logger.info("Executing...");

        String userInfo = Mono.fromFuture(requester.getUserInfo()).timeout(Duration.ofMillis(100000)).onErrorReturn("fallback").block();

      
        logger.info("User info: " + userInfo);        
    }      
}
