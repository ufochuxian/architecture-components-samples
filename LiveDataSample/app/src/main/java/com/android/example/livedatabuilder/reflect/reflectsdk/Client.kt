package com.android.example.livedatabuilder.reflect.reflectsdk

/**

 * @Author: chen

 * @datetime: 2020/8/26

 * @desc:

 */

fun main() {
    val audioEngineFactory = AudioEngineFactory()
    val audioEngine = audioEngineFactory.createAudioEngine(JLGLAudioEngine())
    audioEngine.sayName()
    println("评测获得了".plus(audioEngine.evaluate("测试文本")).plus("分"))
}