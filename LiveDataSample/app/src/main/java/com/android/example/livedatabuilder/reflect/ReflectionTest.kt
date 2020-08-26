package com.android.example.livedatabuilder.reflect

import java.sql.Connection
import java.sql.DriverManager

/**

 * @Author: chen

 * @datetime: 2020/8/24

 * @desc:

 */


fun main() {

    testReflect()


}


// 掘金反射分享文章：https://juejin.im/post/6864324335654404104
fun testReflect() {
    val orderClazz = Class.forName("com.android.example.livedatabuilder.reflect.Order")
    val constructor = orderClazz.getConstructor(Int::class.java, String::class.java)
    constructor.isAccessible = true
    val order = constructor.newInstance(123, "淘宝订单")
    order.toString()

    //获取类中所有的方法
    for (method in orderClazz.declaredMethods) {
        println("method name:${method.name}")
    }

    //获取类中所有的成员变量，但无法获得类通过继承获得的属性
    for (field in orderClazz.declaredFields) {
        println("field name:${field.name}")
    }
}


// 利用反射 + 工厂模式

//https://juejin.im/post/6864324335654404104#heading-13
// 反射的应用场景之一，生成数据库驱动器类
fun getConnection(): Connection {
    val driver_class_name: String = "com.mysql.jdbc.Driver"
    //加载驱动类
    val driver = Class.forName(driver_class_name)
    //获取数据链接
    var conn = DriverManager.getConnection("jdbc:mysql://···", "root", "root")
    return conn
}