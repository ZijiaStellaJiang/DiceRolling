package edu.duke.summer.server.inteceptor;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.http.server.ServletServerHttpRequest;
import org.springframework.util.StringUtils;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

public class HttpHandShakeInteceptor implements HandshakeInterceptor {

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        if(request instanceof ServletServerHttpRequest){//if request exist
//            //Get Session out of ServletHttpRequest
//            HttpSession session = ((ServletServerHttpRequest) request).getServletRequest().getSession();
//            String sessionId= session.getId();
//            System.out.println("HandshakeInterceptor.beforeHandshake()---[SessionID:]"+sessionId);
//            attributes.put("sessionID",sessionId);
        }
        return true;
    }


    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {
        if(request instanceof ServletServerHttpRequest){//if request exist
            //Get Session out of ServletHttpRequest
        }
    }
}
