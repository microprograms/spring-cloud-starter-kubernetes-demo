package com.github.microprograms.spring_cloud_starter_kubernetes_demo;

public class MemoryStatistics {
    private MemoryUnit memoryUnit;
    private long maxMemory; // 可以获得最大内存
    private long totalMemory; // 已分配到的内存大小
    private long freeMemory; // 所分配内存的剩余大小
    private long usableMemony; // 最大可用内存大小

    public MemoryStatistics() {
        this(MemoryUnit.bytes);
    }

    public MemoryStatistics(MemoryUnit memoryUnit) {
        this.memoryUnit = memoryUnit;
        int mb = 1024 * 1024;
        switch (memoryUnit) {
            case mb:
                this.maxMemory = Runtime.getRuntime().maxMemory() / mb;
                this.totalMemory = Runtime.getRuntime().totalMemory() / mb;
                this.freeMemory = Runtime.getRuntime().freeMemory() / mb;
                this.usableMemony = maxMemory - totalMemory + freeMemory;
                break;

            default:
                this.maxMemory = Runtime.getRuntime().maxMemory();
                this.totalMemory = Runtime.getRuntime().totalMemory();
                this.freeMemory = Runtime.getRuntime().freeMemory();
                this.usableMemony = maxMemory - totalMemory + freeMemory;
                break;
        }
    }

    public MemoryUnit getMemoryUnit() {
        return memoryUnit;
    }

    public long getMaxMemory() {
        return maxMemory;
    }

    public long getTotalMemory() {
        return totalMemory;
    }

    public long getFreeMemory() {
        return freeMemory;
    }

    public long getUsableMemony() {
        return usableMemony;
    }

    public static enum MemoryUnit {
        bytes, mb
    }
}
