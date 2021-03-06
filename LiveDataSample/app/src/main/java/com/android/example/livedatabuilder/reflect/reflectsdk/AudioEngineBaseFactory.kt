package com.android.example.livedatabuilder.reflect.reflectsdk

/**

 * @Author: chen

 * @datetime: 2020/8/26

 * @desc:

 */
abstract class AudioEngineBaseFactory {

    abstract fun createAudioEngine(engine: AudioEngineInterface): AudioEngineInterface
}