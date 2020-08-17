package com.android.example.livedatabuilder.kt

import androidx.core.util.rangeTo

/**

 * @Author: chen

 * @datetime: 2020/8/11

 * @desc:

 */


fun testVarargs() {

    var arrays = listOf(1, 2, 3)


}

fun partFun(x : Int) {
    fun test() {
        println("value:".plus(x))
    }
}

fun <T> asList(vararg params: T): List<T> {

    var arrays = ArrayList<T>()

    for (num in params) {
        arrays.add(num)
    }
    return arrays

}


class Ticket(id : String,time : String) {
    //订单号
    var ticketId : String = id

    //创建订单的时间
    var ticketCreateTime : String = time

}


//// Collection集合的一个高阶函数，将function作为参数使用，在方法体里面能够使用这个"函数"参数
//fun <T, R> Collection<T>.fold(
//    initial: R,
//    combine: (acc: R, nextElement: T) -> R
//): R {
//    var accumulator: R = initial
//    for (element: T in this) {
//        accumulator = combine(accumulator, element)
//    }
//    return accumulator
//}


// 扩展函数
fun Ticket.printSelf() {

    println("id:${this.ticketId},time:${this.ticketCreateTime}")
}


fun main() {
    //这里如果使用arraylistof，是不行的，因为函数使用了T类型，限定了参数类型
//    var list = arrayListOf(2,3)
//    var list = arrayOf(2, 3)
//    println(asList(1, 2, *list, 3).size)

    // 高阶函数使用案例1
    var items = listOf("a","b","1","c")

    var result = items.fold("elements:",{acc,i ->

        var result = acc.plus(" ").plus(i)

        result

    })

    println("$result")


    // foldRight的使用
    var resultRight = items.foldRight("elements:",{acc,i ->

        var result = acc.plus(" ").plus(i)

        println("acc:${acc},i:${i}")

        result

    })

    println("$resultRight")

    //高阶函数使用案例2

    var nums = listOf(1,2,3,5,6)

    var numsResult = nums.fold(100,{acc,nextElement ->

        //根据collection.fold的扩展函数，每次都会将经过combine操作之后的函数，重新赋值给acc
        var result = acc + nextElement + 10

        println("acc:${acc},nextElement:${nextElement},result:${result}")

        result

    })


    var ticket = Ticket("11111","2019-09-01")


    ticket.printSelf()


    //高阶函数的调用，也可以当作函数的引用，作为参数
    var x = nums.fold(1, Int::times)

    println("x:${x}")


    //"函数字面值"的理解 https://blog.csdn.net/OneDeveloper/article/details/103625518
    //"函数字面值"可以理解为"一段函数文本"，在kotlin中可以狭义的理解为lambada表达式或者匿名函数
    //带有指定接收者的函数类型 https://blog.csdn.net/OneDeveloper/article/details/82907555

    //带有接受者类型的函数
    var sayHello : String.(str : String) -> String = {
        this.plus(it)
    }

    println("小明".sayHello("你好"))


    // 变量类型为可为空的函数类型
    var tmp: ((Int) -> Boolean)? = null


//    testThread()

//    testReturn()

//    testLikeContinue()
//
//    foo()
//
//    foo2()

//    testLinqFun()

    testFlatMap()

}

fun testThread() {
    println("thread:1")
    Thread(Runnable {
        Thread(Runnable {
            println("thread:2")
        }).start()
    }).start()
}

//返回标签的使用 return break continue
fun testReturn() {
    for(i in 1..20) {
        println("i:${i}")
        when(i == 5) {
            true -> return
        }
    }
    // for循环中的return代表直接跳出testReturn函数，下面的println("testReturn")，不再执行了
    println("testReturn")

}

fun testLikeContinue() {
    //显示声明
    for(x in 1.. 20) {
        if(x == 5) {
            continue
        }
        println("x:${x}")
    }
    println("testLikeContinue")
}

//显式局部返回
fun foo() {
    listOf(1, 2, 3, 4, 5).forEach lit@{
        if (it == 3) return@lit // 局部返回到该 lambda 表达式的调用者，即 forEach 循环
        println(it)
    }
    println(" done with explicit label")
}

//隐式局部返回
fun foo2() {
    listOf(1,2,3,4,5).forEach {
        if( it == 3) return@forEach
        println("it:${it}")
    }
    println("foo2")
}



//linq风格的写法
fun testLinqFun() {

    var strs = listOf("abc","helloworld","hahahah","aihao","guagua")

    var result = strs.filter { it.length > 3 }.sortedBy { it }.map { it.toUpperCase() }

    var s = result.fold("", { acc, s ->
        acc.plus(" ").plus(s)
    })

    println(s)


}

fun testFlatMap() {

    var arrays = listOf("a","bc","def","123")

    //这里和map的区别就是lambada表达式中返回值的类型
    var result = arrays.flatMap { it.asIterable().filter { it -> it.isDigit() } }

    println(result)

}