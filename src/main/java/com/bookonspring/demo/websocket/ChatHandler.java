package com.bookonspring.demo.websocket;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

@Component
public class ChatHandler extends TextWebSocketHandler {

	private List<WebSocketSession> connectedUsers = new CopyOnWriteArrayList<>();

	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		TextMessage textMessage = new TextMessage(
				session.getId() + "님이 접속했습니다. (IP:" + session.getRemoteAddress().getAddress() + ")");
		for (WebSocketSession userSession : connectedUsers) {
			userSession.sendMessage(textMessage);
		}
		connectedUsers.add(session);
		session.sendMessage(new TextMessage(
				"나의 세션 ID : " + session.getId() + " (IP:" + session.getRemoteAddress().getAddress() + ")"));
	}

	@Override
	protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
		TextMessage textMessage = new TextMessage(session.getId() + " : " + message.getPayload());
		for (WebSocketSession userSession : connectedUsers) {
			if (!session.getId().equals(userSession.getId())) {
				userSession.sendMessage(textMessage);
			}
		}
	}

	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		connectedUsers.remove(session);
		TextMessage textMessage = new TextMessage(
				session.getId() + "님이 퇴장했습니다. (IP:" + session.getRemoteAddress().getAddress() + ")");
		for (WebSocketSession userSession : connectedUsers) {
			userSession.sendMessage(textMessage);
		}
	}
}
