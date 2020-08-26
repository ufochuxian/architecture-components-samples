package com.android.example.livedatabuilder.reflect.reflectsdk

/**

 * @Author: chen

 * @datetime: 2020/8/26

 * @desc:

 */
class ZLAudioEngine : AudioEngineInterface {

    override fun evaluate(evaluateTxt: String): Float {
        println("使用智聆引擎进行评测")
        return 100f
    }

    override fun recognize(recognizeTxt: String): Boolean {
        println("使用智聆引擎进行识别")
        return true
    }

    override fun sayName(): String {
        println("我是智聆引擎")
        return "ZL"
    }
}