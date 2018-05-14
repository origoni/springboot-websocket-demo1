package com.bookonspring.demo.websocket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

	@Autowired
	private ChatHandler chatHandler;

	@Bean
	public WebSocketHandler echoHandler() {
		return new EchoHandler();
	}

	@Override
	public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
		registry.addHandler(echoHandler(), "/echo"); // .setAllowedOrigins("*")
		registry.addHandler(echoHandler(), "/echo-sockjs").withSockJS();
		registry.addHandler(chatHandler, "/chat");
		registry.addHandler(chatHandler, "/chat-sockjs").withSockJS();
	}
}