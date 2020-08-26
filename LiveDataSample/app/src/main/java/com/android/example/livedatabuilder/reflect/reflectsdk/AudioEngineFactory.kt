package com.android.example.livedatabuilder.reflect.reflectsdk

/**

 * @Author: chen

 * @datetime: 2020/8/26

 * @desc:

 */
class AudioEngineFactory : AudioEngineBaseFactory() {

    override fun createAudioEngine(engine: AudioEngineInterface): AudioEngineInterface {
        return engine
    }
}