package com.ysmjjsy.goya.drone.dji.sdk.cloudapi.firmware.api;

import com.ysmjjsy.goya.drone.dji.sdk.cloudapi.firmware.FirmwareMethodEnum;
import com.ysmjjsy.goya.drone.dji.sdk.cloudapi.firmware.OtaCreateRequest;
import com.ysmjjsy.goya.drone.dji.sdk.cloudapi.firmware.OtaCreateResponse;
import com.ysmjjsy.goya.drone.dji.sdk.cloudapi.firmware.OtaProgress;
import com.ysmjjsy.goya.drone.dji.sdk.config.version.GatewayManager;
import com.ysmjjsy.goya.drone.dji.sdk.mqtt.ChannelName;
import com.ysmjjsy.goya.drone.dji.sdk.mqtt.MqttReply;
import com.ysmjjsy.goya.drone.dji.sdk.mqtt.events.EventsDataRequest;
import com.ysmjjsy.goya.drone.dji.sdk.mqtt.events.TopicEventsRequest;
import com.ysmjjsy.goya.drone.dji.sdk.mqtt.events.TopicEventsResponse;
import com.ysmjjsy.goya.drone.dji.sdk.mqtt.services.ServicesPublish;
import com.ysmjjsy.goya.drone.dji.sdk.mqtt.services.ServicesReplyData;
import com.ysmjjsy.goya.drone.dji.sdk.mqtt.services.TopicServicesResponse;
import com.fasterxml.jackson.core.type.TypeReference;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import jakarta.annotation.Resource;

/**
 * @author sean
 * @version 1.7
 * @date 2023/6/28
 */
public abstract class AbstractFirmwareService {

    @Resource
    private ServicesPublish servicesPublish;

    /**
     * Firmware upgrade progress
     * @param request  data
     * @param headers   The headers for a {@link Message}.
     */
    @ServiceActivator(inputChannel = ChannelName.INBOUND_EVENTS_OTA_PROGRESS, outputChannel = ChannelName.OUTBOUND_EVENTS)
    public TopicEventsResponse<MqttReply> otaProgress(TopicEventsRequest<EventsDataRequest<OtaProgress>> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("otaProgress not implemented");
    }

    /**
     * Firmware upgrade
     * @param gateway
     * @param request   data
     * @return  services_reply
     */
    public TopicServicesResponse<ServicesReplyData<OtaCreateResponse>> otaCreate(GatewayManager gateway, OtaCreateRequest request) {
        return servicesPublish.publish(
                new TypeReference<OtaCreateResponse>() {},
                gateway.getGatewaySn(),
                FirmwareMethodEnum.OTA_CREATE.getMethod(),
                request);
    }

}
