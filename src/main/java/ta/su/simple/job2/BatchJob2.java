package ta.su.simple.job2;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import ta.su.simple.core.BatchInterface;

@Component("batchJob2")
@Slf4j
public class BatchJob2 implements BatchInterface {

	@Override
	public void run(String[] args) {
		log.info("Hello, BatchJob2");
	}

}
