package com.ysmjjsy.goya.drone.dji.sdk.cloudapi.control;

import com.ysmjjsy.goya.drone.dji.sdk.cloudapi.device.PayloadIndex;
import com.ysmjjsy.goya.drone.dji.sdk.common.BaseModel;

import jakarta.validation.constraints.NotNull;

/**
 * @author sean
 * @version 1.4
 * @date 2023/3/1
 */
public class CameraPhotoTakeRequest extends BaseModel {

    @NotNull
    private PayloadIndex payloadIndex;

    public CameraPhotoTakeRequest() {
    }

    @Override
    public String toString() {
        return "CameraPhotoTakeRequest{" +
                "payloadIndex=" + payloadIndex +
                '}';
    }

    public PayloadIndex getPayloadIndex() {
        return payloadIndex;
    }

    public CameraPhotoTakeRequest setPayloadIndex(PayloadIndex payloadIndex) {
        this.payloadIndex = payloadIndex;
        return this;
    }
}
