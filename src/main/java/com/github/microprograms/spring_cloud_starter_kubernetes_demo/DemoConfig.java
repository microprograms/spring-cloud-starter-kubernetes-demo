package com.github.microprograms.spring_cloud_starter_kubernetes_demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "demo")
public class DemoConfig {
    private String staticHostname;
    private String iconName;
    private String chassis;
    private String machineId;
    private String bootId;
    private String virtualization;
    private String operatingSystem;
    private String cpeOsName;
    private String kernel;
    private String architecture;

    public String getStaticHostname() {
        return staticHostname;
    }

    public void setStaticHostname(String staticHostname) {
        this.staticHostname = staticHostname;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    public String getChassis() {
        return chassis;
    }

    public void setChassis(String chassis) {
        this.chassis = chassis;
    }

    public String getMachineId() {
        return machineId;
    }

    public void setMachineId(String machineId) {
        this.machineId = machineId;
    }

    public String getBootId() {
        return bootId;
    }

    public void setBootId(String bootId) {
        this.bootId = bootId;
    }

    public String getVirtualization() {
        return virtualization;
    }

    public void setVirtualization(String virtualization) {
        this.virtualization = virtualization;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getCpeOsName() {
        return cpeOsName;
    }

    public void setCpeOsName(String cpeOsName) {
        this.cpeOsName = cpeOsName;
    }

    public String getKernel() {
        return kernel;
    }

    public void setKernel(String kernel) {
        this.kernel = kernel;
    }

    public String getArchitecture() {
        return architecture;
    }

    public void setArchitecture(String architecture) {
        this.architecture = architecture;
    }

}
