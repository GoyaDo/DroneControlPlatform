package com.ysmjjsy.goya.drone.dji.sdk.cloudapi.debug;

import com.ysmjjsy.goya.drone.dji.sdk.cloudapi.device.SwitchActionEnum;
import com.ysmjjsy.goya.drone.dji.sdk.common.BaseModel;

import jakarta.validation.constraints.NotNull;

/**
 * @author sean
 * @version 1.3
 * @date 2022/11/25
 */
public class AlarmStateSwitchRequest extends BaseModel {

    @NotNull
    private SwitchActionEnum action;

    public AlarmStateSwitchRequest() {
    }

    @Override
    public String toString() {
        return "AlarmStateSwitchRequest{" +
                "action=" + action +
                '}';
    }

    public SwitchActionEnum getAction() {
        return action;
    }

    public AlarmStateSwitchRequest setAction(SwitchActionEnum action) {
        this.action = action;
        return this;
    }
}
