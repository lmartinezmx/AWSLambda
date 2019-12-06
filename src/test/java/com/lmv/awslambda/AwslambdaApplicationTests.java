package com.lmv.awslambda;

import com.amazonaws.services.lambda.runtime.ClientContext;
import com.amazonaws.services.lambda.runtime.CognitoIdentity;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.lmv.awslambda.handler.LambdaMethodEndPointHandler;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.*;

@SpringBootTest
class AwslambdaApplicationTests {

	@Test
	void contextLoads() {
	}

	void testLambdaMethod() throws IOException{

		InputStream inputStream = new InputStream() {
			@Override
			public int read() throws IOException {
				return 0;
			}
		};
		final File tempFile = File.createTempFile("myfile", ".temp");
		OutputStream outputStream = new FileOutputStream(tempFile);
		Context context = new Context() {
			@Override
			public String getAwsRequestId() {
				return null;
			}

			@Override
			public String getLogGroupName() {
				return null;
			}

			@Override
			public String getLogStreamName() {
				return null;
			}

			@Override
			public String getFunctionName() {
				return null;
			}

			@Override
			public String getFunctionVersion() {
				return null;
			}

			@Override
			public String getInvokedFunctionArn() {
				return null;
			}

			@Override
			public CognitoIdentity getIdentity() {
				return null;
			}

			@Override
			public ClientContext getClientContext() {
				return null;
			}

			@Override
			public int getRemainingTimeInMillis() {
				return 0;
			}

			@Override
			public int getMemoryLimitInMB() {
				return 0;
			}

			@Override
			public LambdaLogger getLogger() {
				return null;
			}
		};
		LambdaMethodEndPointHandler lambdaMethodEndPointHandler = new LambdaMethodEndPointHandler();
		lambdaMethodEndPointHandler.handleRequest(inputStream, outputStream, context);

	}

}
