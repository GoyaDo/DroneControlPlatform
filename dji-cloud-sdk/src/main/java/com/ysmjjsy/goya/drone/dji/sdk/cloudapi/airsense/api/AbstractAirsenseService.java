package com.ysmjjsy.goya.drone.dji.sdk.cloudapi.airsense.api;

import com.ysmjjsy.goya.drone.dji.sdk.cloudapi.airsense.AirsenseWarning;
import com.ysmjjsy.goya.drone.dji.sdk.config.version.CloudSDKVersionEnum;
import com.ysmjjsy.goya.drone.dji.sdk.mqtt.ChannelName;
import com.ysmjjsy.goya.drone.dji.sdk.mqtt.MqttReply;
import com.ysmjjsy.goya.drone.dji.sdk.mqtt.events.TopicEventsRequest;
import com.ysmjjsy.goya.drone.dji.sdk.mqtt.events.TopicEventsResponse;
import com.ysmjjsy.goya.drone.dji.sdk.annotations.CloudSDKVersion;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import java.util.List;

/**
 * @author sean
 * @version 1.7
 * @date 2023/10/16
 */
public abstract class AbstractAirsenseService {


    /**
     * cloud-custom data transmit from psdk
     * @param request  data
     * @param headers  The headers for a {@link Message}.
     * @return events_reply
     */
    @ServiceActivator(inputChannel = ChannelName.INBOUND_EVENTS_AIRSENSE_WARNING, outputChannel = ChannelName.OUTBOUND_EVENTS)
    @CloudSDKVersion(since = CloudSDKVersionEnum.V1_0_0)
    public TopicEventsResponse<MqttReply> airsenseWarning(TopicEventsRequest<List<AirsenseWarning>> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("airsenseWarning not implemented");
    }

}
