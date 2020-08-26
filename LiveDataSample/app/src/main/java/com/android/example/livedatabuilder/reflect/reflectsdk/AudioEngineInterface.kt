package com.android.example.livedatabuilder.reflect.reflectsdk

/**

 * @Author: chen

 * @datetime: 2020/8/26

 * @desc:

 */
interface AudioEngineInterface : SayNameInterface {

    fun evaluate(evaluateTxt: String): Float

    fun recognize(recognizeTxt: String): Boolean
}