package com.ysmjjsy.goya.drone.dji.sdk.cloudapi.property;

import com.ysmjjsy.goya.drone.dji.sdk.cloudapi.control.CommanderModeLostActionEnum;
import com.ysmjjsy.goya.drone.dji.sdk.common.BaseModel;
import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotNull;

/**
 * @author sean
 * @version 1.7
 * @date 2023/10/19
 */
public class DockDroneCommanderModeLostAction extends BaseModel {

    @JsonProperty("commander_mode_lost_action")
    @NotNull
    private CommanderModeLostActionEnum commanderModeLostAction;

    public DockDroneCommanderModeLostAction() {
    }

    @Override
    public String toString() {
        return "DockDroneCommanderModeLostAction{" +
                "commanderModeLostAction=" + commanderModeLostAction +
                '}';
    }

    public CommanderModeLostActionEnum getCommanderModeLostAction() {
        return commanderModeLostAction;
    }

    public DockDroneCommanderModeLostAction setCommanderModeLostAction(CommanderModeLostActionEnum commanderModeLostAction) {
        this.commanderModeLostAction = commanderModeLostAction;
        return this;
    }
}
