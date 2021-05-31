package me.vkpower.butterflyblog.admin.util;

import org.springframework.http.server.reactive.ServerHttpRequest;
import reactor.core.publisher.Mono;
/**
 *
 * 工具类
 * 获取request 通过filter中的配置
 * @author xaiyuancheng
 * @date 2020/4/16 - 18:44
 */
public class ReactiveRequestContextHolder {
  public static final Class<ServerHttpRequest> CONTEXT_KEY = ServerHttpRequest.class;

  public static Mono<ServerHttpRequest> getRequest() {
    return   Mono.subscriberContext()
            .map(ctx -> ctx.get(CONTEXT_KEY));
  }
}