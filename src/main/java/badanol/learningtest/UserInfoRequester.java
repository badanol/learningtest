package badanol.learningtest;

import java.util.concurrent.CompletableFuture;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
@Async
public class UserInfoRequester {

    private static final Log logger = LogFactory.getLog(UserInfoRequester.class);
    
    
    public CompletableFuture<String> getUserInfo() throws InterruptedException {

        logger.info("Good");

        Thread.sleep(3000);

        return CompletableFuture.completedFuture("Student");
    }
}
