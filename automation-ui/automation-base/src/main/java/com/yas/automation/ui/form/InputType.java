package com.yas.automation.ui.form;

import lombok.Getter;

@Getter
public enum InputType {

    TEXT("textService"),
    DROPDOWN("dropdownService");

    private final String serviceName;

    InputType(String serviceName) {
        this.serviceName = serviceName;
    }

}
