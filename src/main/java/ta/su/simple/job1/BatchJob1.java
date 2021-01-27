package ta.su.simple.job1;

import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;
import ta.su.simple.core.BatchInterface;

@Component("batchJob1")
@Slf4j
public class BatchJob1 implements BatchInterface {

	@Override
	public void run(String[] args) {
		log.info("Hello, BatchJob1");
	}

}
