package com.android.example.livedatabuilder.kt

/**

 * @Author: chen

 * @datetime: 2020/8/26

 * @desc:

 */


fun main() {
//    operationMap()
//    operationZip()
    operationJoinToString()
}

fun operationMap() {

    // map的使用，针对集合的铺平
    var list = listOf<String>("1", "2", "3")

    var mapList = list.map {
        it.plus("x")
    }

    mapList.forEach {
        print(it)
    }

    println(list.toString())
    println(mapList.toString())

    //flatmap 是对嵌套集合的铺平
    var listContainer =
        listOf<List<String>>(listOf("a", "b", "c"), listOf("hha", "bb", "cc"), listOf("eee"))

    listContainer.flatten().forEach {
        print("$it".plus(" "))
    }

    println()

    listContainer.flatMap { it ->
        it.map {
            print("$it& ")
        }
    }
}

fun operationZip() {
    var list1 = listOf("cjx","yaoming","hash")
    var list2 = listOf("vip","normal","super")

    val zip = list1.zip(list2)

    zip.forEach {
        println(it.first.plus(" ").plus(it.second))
    }

//    println(zip)
}


fun operationJoinToString() {
    var numbers = listOf("one","two","three")

    val joinToString = numbers.joinToString(separator = " ") {
        it.toUpperCase()
    }
    println(joinToString)

}