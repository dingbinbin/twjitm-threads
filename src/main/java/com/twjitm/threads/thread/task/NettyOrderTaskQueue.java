package com.twjitm.threads.thread.task;import java.util.concurrent.ConcurrentHashMap;/** * @author twjitm - [Created on 2018-08-23 17:36] * @company https://github.com/twjitm/ * @jdk java version "1.8.0_77" * 有序队列 */public class NettyOrderTaskQueue<K, V> {    private final ConcurrentHashMap<K, NettyTaskQueue<V>> taskOrderQueue = new ConcurrentHashMap<K, NettyTaskQueue<V>>();    /**     * 获得任务队列     *     * @param key     * @return     */    public NettyTaskQueue<V> getTasksQueue(K key) {        NettyTaskQueue<V> queue = taskOrderQueue.get(key);        if (queue == null) {            NettyTaskQueue<V> newQueue = new NettyTaskQueue<V>();            queue = taskOrderQueue.putIfAbsent(key, newQueue);            if (queue == null) {                queue = newQueue;            }        }        return queue;    }    /**     * 获得全部任务队列     *     * @return     */    public ConcurrentHashMap<K, NettyTaskQueue<V>> getTasksQueues() {        return taskOrderQueue;    }    /**     * 移除任务队列     *     * @return     */    public void removeTasksQueue(K key) {        taskOrderQueue.remove(key);    }}