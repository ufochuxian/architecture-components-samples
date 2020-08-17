package com.android.example.livedatabuilder.kt

/**

 * @Author: chen

 * @datetime: 2020/8/14

 * @desc:

 */


class QueueTest {

    fun testTaskQueue() {

        var queue = TaskQueue()

        for (x in 1..10) {
            var thread = Thread(Runnable {
                queue.addTask(x.toString())
            }).start()
        }


        for (x in 1..10) {
            var thread = Thread(Runnable {
                queue.getTask()
            }).apply {
                Thread.sleep(500)
                start()
            }
        }

    }


    fun testProduceAndConsume() {

    }

}

fun main() {
    var test = QueueTest()

    test.testTaskQueue()
}