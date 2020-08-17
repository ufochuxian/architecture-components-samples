package com.android.example.livedatabuilder.kt

import java.util.*
import java.util.concurrent.locks.ReentrantLock

/**

 * @Author: chen

 * @datetime: 2020/8/14

 * @desc:

 */
class TaskQueue {

    var lock = ReentrantLock()

    var condition = lock.newCondition()
    private var queue = LinkedList<String>()


    fun addTask(s : String) {

        lock.lock()

        println("produce [addTask] s:${s},threadName:${Thread.currentThread().name}")

        queue.add(s)

        condition.signalAll()

        lock.unlock()

    }

    fun getTask(): String {
        lock.lock()

        while(queue.isEmpty()) {
            println("queue is empty")
            condition.await()
        }
        val s = queue.poll()
        println("consume [getTask] s:${s},threadName:${Thread.currentThread().name},queue size:${queue.size}")
        lock.unlock()
        return s
    }


}