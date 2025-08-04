package com.ysmjjsy.goya.drone.dji.sdk.mqtt;

import com.ysmjjsy.goya.drone.dji.sdk.common.BaseModel;
import com.ysmjjsy.goya.drone.dji.sdk.common.Common;
import com.ysmjjsy.goya.drone.dji.sdk.mqtt.events.TopicEventsRequest;
import com.ysmjjsy.goya.drone.dji.sdk.mqtt.events.TopicEventsResponse;
import com.ysmjjsy.goya.drone.dji.sdk.mqtt.requests.TopicRequestsRequest;
import com.ysmjjsy.goya.drone.dji.sdk.mqtt.requests.TopicRequestsResponse;
import com.ysmjjsy.goya.drone.dji.sdk.mqtt.state.TopicStateRequest;
import com.ysmjjsy.goya.drone.dji.sdk.mqtt.state.TopicStateResponse;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author sean
 * @version 1.7
 * @date 2023/5/22
 */
@Aspect
@Component
public class MqttReplyHandler {

    @AfterReturning(value = "execution(public com.ysmjjsy.goya.drone.dji.sdk.mqtt.CommonTopicResponse+ com.ysmjjsy.goya.drone.dji.sdk.cloudapi.*.api.*.*(com.ysmjjsy.goya.drone.dji.sdk.mqtt.CommonTopicRequest+, org.springframework.messaging.MessageHeaders))", returning = "result")
    public Object validateReturnValue(JoinPoint point, CommonTopicResponse result) {
        if (Objects.isNull(result)) {
            return null;
        }
        CommonTopicRequest request = (CommonTopicRequest) point.getArgs()[0];
        result.setBid(request.getBid()).setTid(request.getTid()).setTimestamp(System.currentTimeMillis());
        if (result instanceof TopicEventsResponse) {
            fillEvents((TopicEventsResponse) result, (TopicEventsRequest) request);
        } else if (result instanceof TopicRequestsResponse) {
            validateRequests((TopicRequestsResponse) result, (TopicRequestsRequest) request);
        } else if (result instanceof TopicStateResponse) {
            fillState((TopicStateResponse) result, (TopicStateRequest) request);
        }
        return result;
    }

    private void fillEvents(TopicEventsResponse response, TopicEventsRequest request) {
        if (!request.isNeedReply()) {
            response.setData(null);
            return;
        }
        response.setMethod(request.getMethod()).setData(MqttReply.success());
    }

    private void validateRequests(TopicRequestsResponse response, TopicRequestsRequest request) {
        response.setMethod(request.getMethod());
        Object data = response.getData();
        if (data instanceof MqttReply) {
            MqttReply mqttData = (MqttReply) data;
            if (MqttReply.CODE_SUCCESS != mqttData.getResult()) {
                return;
            }
            data = mqttData.getOutput();
        }
        Common.validateModel((BaseModel) data);
    }

    private void fillState(TopicStateResponse response, TopicStateRequest request) {
        response.setData(request.isNeedReply() ? MqttReply.success() : null);
    }
}
