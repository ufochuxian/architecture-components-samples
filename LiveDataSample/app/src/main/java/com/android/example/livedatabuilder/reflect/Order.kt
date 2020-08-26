package com.android.example.livedatabuilder.reflect

/**

 * @Author: chen

 * @datetime: 2020/8/24

 * @desc:

 */
class Order(open val id : Int, open val type : String) {

    @Transient
    var info : String = ""

    override fun toString(): String {
        val message = "id:${id},type:${type}"
        println(message)
        return message
    }


    @Override
    fun testAnnotation() {

    }
}