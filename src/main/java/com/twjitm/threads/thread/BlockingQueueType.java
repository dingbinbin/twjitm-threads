package com.twjitm.threads.thread;/** * @author twjitm - [Created on 2018-08-24 16:24] * @company https://github.com/twjitm/ * @jdk java version "1.8.0_77" */public enum  BlockingQueueType {    LINKED_BLOCKING_QUEUE("LinkedBlockingQueue"),    ARRAY_BLOCKING_QUEUE("ArrayBlockingQueue"),    SYNCHRONOUS_QUEUE("SynchronousQueue");    private String value;    private BlockingQueueType(String value) {        this.value = value;    }    public String getValue() {        return value;    }    public static BlockingQueueType fromString(String value) {        for (BlockingQueueType type : BlockingQueueType.values()) {            if (type.getValue().equalsIgnoreCase(value.trim())) {                return type;            }        }        throw new IllegalArgumentException("Mismatched type with value=" + value);    }    @Override    public String toString() {        return value;    }}