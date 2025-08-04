package com.ysmjjsy.goya.drone.dji.sdk.cloudapi.control;

import com.ysmjjsy.goya.drone.dji.sdk.cloudapi.device.PayloadIndex;
import com.ysmjjsy.goya.drone.dji.sdk.common.BaseModel;

import jakarta.validation.constraints.NotNull;

/**
 * @author sean
 * @version 1.4
 * @date 2023/3/1
 */
public class CameraRecordingStopRequest extends BaseModel {

    @NotNull
    private PayloadIndex payloadIndex;

    public CameraRecordingStopRequest() {
    }

    @Override
    public String toString() {
        return "CameraRecordingStopRequest{" +
                "payloadIndex=" + payloadIndex +
                '}';
    }

    public PayloadIndex getPayloadIndex() {
        return payloadIndex;
    }

    public CameraRecordingStopRequest setPayloadIndex(PayloadIndex payloadIndex) {
        this.payloadIndex = payloadIndex;
        return this;
    }
}
