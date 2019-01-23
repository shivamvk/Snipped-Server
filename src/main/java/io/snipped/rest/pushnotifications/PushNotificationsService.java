package io.snipped.rest.pushnotifications;

import java.util.ArrayList;
import java.util.concurrent.CompletableFuture;

import org.springframework.http.HttpEntity;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PushNotificationsService {

	private static final String FIREBASE_SERVER_KEY =
			"AAAAJXSnXhw:APA91bH9y-SKYMMEzCS0xVHKUXh9xvu2j8hnngMHFWhR5LRCOubWXYBFhA7cq1EKn1XXNWJ7pSIgPfwsOYhQcYQBPW1nD6mJumLcLGy02-Lv2ahxHA7o2Byn7o2_jvLdixxZDozkiltp";
	private static final String FIREBASE_API_URL = "https://fcm.googleapis.com/fcm/send";
	
	@Async
	public CompletableFuture<String> send(HttpEntity<String> entity) {

		RestTemplate restTemplate = new RestTemplate();

		ArrayList<ClientHttpRequestInterceptor> interceptors = new ArrayList<>();
		interceptors.add(new HeaderRequestInterceptor("Authorization", "key=" + FIREBASE_SERVER_KEY));
		interceptors.add(new HeaderRequestInterceptor("Content-Type", "application/json"));
		restTemplate.setInterceptors(interceptors);

		String firebaseResponse = restTemplate.postForObject(FIREBASE_API_URL, entity, String.class);

		return CompletableFuture.completedFuture(firebaseResponse);
	}
}
