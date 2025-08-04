package com.ysmjjsy.goya.drone.dji.sdk.cloudapi.interconnection.api;

import com.ysmjjsy.goya.drone.dji.sdk.annotations.CloudSDKVersion;
import com.ysmjjsy.goya.drone.dji.sdk.cloudapi.interconnection.CustomDataTransmissionFromEsdk;
import com.ysmjjsy.goya.drone.dji.sdk.cloudapi.interconnection.CustomDataTransmissionToEsdkRequest;
import com.ysmjjsy.goya.drone.dji.sdk.cloudapi.interconnection.CustomDataTransmissionToPsdkRequest;
import com.ysmjjsy.goya.drone.dji.sdk.cloudapi.interconnection.InterconnectionMethodEnum;
import com.ysmjjsy.goya.drone.dji.sdk.config.version.CloudSDKVersionEnum;
import com.ysmjjsy.goya.drone.dji.sdk.config.version.GatewayManager;
import com.ysmjjsy.goya.drone.dji.sdk.config.version.GatewayTypeEnum;
import com.ysmjjsy.goya.drone.dji.sdk.mqtt.ChannelName;
import com.ysmjjsy.goya.drone.dji.sdk.mqtt.MqttReply;
import com.ysmjjsy.goya.drone.dji.sdk.mqtt.events.TopicEventsRequest;
import com.ysmjjsy.goya.drone.dji.sdk.mqtt.events.TopicEventsResponse;
import com.ysmjjsy.goya.drone.dji.sdk.mqtt.services.ServicesPublish;
import com.ysmjjsy.goya.drone.dji.sdk.mqtt.services.ServicesReplyData;
import com.ysmjjsy.goya.drone.dji.sdk.mqtt.services.TopicServicesResponse;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;

import jakarta.annotation.Resource;

/**
 * @author sean
 * @version 1.7
 * @date 2023/10/16
 */
public abstract class AbstractInterconnectionService {

    @Resource
    private ServicesPublish servicesPublish;

    /**
     * cloud-custom data transmit from esdk
     * @param request  data
     * @param headers  The headers for a {@link Message}.
     * @return events_reply
     */
    @ServiceActivator(inputChannel = ChannelName.INBOUND_EVENTS_CUSTOM_DATA_TRANSMISSION_FROM_ESDK, outputChannel = ChannelName.OUTBOUND_EVENTS)
    @CloudSDKVersion(since = CloudSDKVersionEnum.V1_0_0)
    public TopicEventsResponse<MqttReply> customDataTransmissionFromEsdk(TopicEventsRequest<CustomDataTransmissionFromEsdk> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("customDataTransmissionFromEsdk not implemented");
    }

    /**
     * cloud-custom data transmit to esdk
     * @param gateway   gateway device
     * @return  services_reply
     */
    @CloudSDKVersion(since = CloudSDKVersionEnum.V1_0_0, exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData> customDataTransmissionToEsdk(GatewayManager gateway, CustomDataTransmissionToEsdkRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                InterconnectionMethodEnum.CUSTOM_DATA_TRANSMISSION_TO_ESDK.getMethod(),
                request);
    }

    /**
     * cloud-custom data transmit from psdk
     * @param request  data
     * @param headers  The headers for a {@link Message}.
     * @return events_reply
     */
    @ServiceActivator(inputChannel = ChannelName.INBOUND_EVENTS_CUSTOM_DATA_TRANSMISSION_FROM_PSDK, outputChannel = ChannelName.OUTBOUND_EVENTS)
    @CloudSDKVersion(since = CloudSDKVersionEnum.V1_0_0)
    public TopicEventsResponse<MqttReply> customDataTransmissionFromPsdk(TopicEventsRequest<CustomDataTransmissionFromEsdk> request, MessageHeaders headers) {
        throw new UnsupportedOperationException("customDataTransmissionFromPsdk not implemented");
    }

    /**
     * cloud-custom data transmit to psdk
     * @param gateway   gateway device
     * @return  services_reply
     */
    @CloudSDKVersion(since = CloudSDKVersionEnum.V1_0_0, exclude = GatewayTypeEnum.RC)
    public TopicServicesResponse<ServicesReplyData> customDataTransmissionToPsdk(GatewayManager gateway, CustomDataTransmissionToPsdkRequest request) {
        return servicesPublish.publish(
                gateway.getGatewaySn(),
                InterconnectionMethodEnum.CUSTOM_DATA_TRANSMISSION_TO_PSDK.getMethod(),
                request);
    }
}
