package com.jrkg.jetpack

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import com.jrkg.jetpack.databinding.ActivityMainBinding
import kotlinx.coroutines.*

class MainActivity2 : AppCompatActivity() {
    private val TAG = "MyLog";
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val binding: ActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)
//        binding.user = User("aaa")

        Log.e(TAG, "主线程id: ${mainLooper.thread.id}")
        //test()
//        val job = GlobalScope.launch {
//            delay(6000)
//            Log.e(TAG, "协程执行结束 -- 线程id：${Thread.currentThread().id}")
//        }
        GlobalScope.launch {
            val result1 = GlobalScope.async {
                getResult1()
            }
            val result2 = GlobalScope.async {
                getResult2()
            }
            val result = result1.await() + result2.await()
            Log.e(TAG,"result = $result")
        }
        //Log.e(TAG, "协程执行结束")
    }

    private fun test() = runBlocking {
        repeat(8) {
            Log.e(TAG, "协程执行$it 线程id：${Thread.currentThread().id}")
            delay(1000)
        }
    }

    private suspend fun getResult1(): Int {
        delay(3000)
        return 1
    }

    private suspend fun getResult2(): Int {
        delay(4000)
        return 2
    }
}