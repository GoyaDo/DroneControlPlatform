package com.ysmjjsy.goya.drone.dji.sdk.cloudapi.debug;

import com.ysmjjsy.goya.drone.dji.sdk.cloudapi.device.LinkWorkModeEnum;
import com.ysmjjsy.goya.drone.dji.sdk.common.BaseModel;

import jakarta.validation.constraints.NotNull;

/**
 * @author sean
 * @version 1.3
 * @date 2022/11/25
 */
public class SdrWorkmodeSwitchRequest extends BaseModel {

    @NotNull
    private LinkWorkModeEnum linkWorkmode;

    public SdrWorkmodeSwitchRequest() {
    }

    @Override
    public String toString() {
        return "SdrWorkmodeSwitchRequest{" +
                "linkWorkmode=" + linkWorkmode +
                '}';
    }

    public LinkWorkModeEnum getLinkWorkmode() {
        return linkWorkmode;
    }

    public SdrWorkmodeSwitchRequest setLinkWorkmode(LinkWorkModeEnum linkWorkmode) {
        this.linkWorkmode = linkWorkmode;
        return this;
    }
}
