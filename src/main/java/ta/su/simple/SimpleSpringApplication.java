package ta.su.simple;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import ta.su.simple.core.BatchInterface;

@SpringBootApplication
public class SimpleSpringApplication {

	private static final String JOB_ID_KEY = "jobId=";

	public static void main(String[] args) {

		if (args.length == 0) {
			throw new IllegalArgumentException("引数が指定されていない。");
		}

		boolean 起動するJobが指定されている = false;
		String 起動Job = "";
		for (String s : args) {

			if (s.startsWith(JOB_ID_KEY)) {
				起動するJobが指定されている = true;
				起動Job = s.substring(JOB_ID_KEY.length());
				break;
			}

		}

		if (!起動するJobが指定されている) {
			throw new IllegalArgumentException("起動するJobが指定されていない");
		}

		ApplicationContext context = SpringApplication.run(SimpleSpringApplication.class, args);

		List<String> 起動パラメータ = new ArrayList<>();

		for (String s : args) {

			if (!s.startsWith(JOB_ID_KEY)) {
				起動パラメータ.add(s);
			}

		}

		if (!context.containsBean(起動Job)) {
			throw new IllegalArgumentException("指定されたJob 【" + 起動Job + "】は定義されていない。");
		}

		BatchInterface bean = context.getBean(起動Job, BatchInterface.class);
		bean.run(起動パラメータ.toArray(new String[0]));
	}

}
