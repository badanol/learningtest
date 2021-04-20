package badanol.learningtest;

import java.time.Duration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;

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

        String userInfo = Mono.fromFuture(requester.getUserInfo())
                              .doOnNext(c -> logger.info(c))
                              .timeout(Duration.ofMillis(5000))
                              .doOnNext(c -> logger.info(c))
                              .onErrorReturn("fallback")
                              .doOnNext(c -> logger.info(c))
                              .block();
      
        logger.info("User info: " + userInfo);        
    }      
}
