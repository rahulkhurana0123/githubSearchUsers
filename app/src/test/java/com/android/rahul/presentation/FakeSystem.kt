package com.android.rahul.presentation

import java.io.IOException
import java.net.URL
import java.util.ArrayDeque
import java.util.concurrent.TimeUnit

import com.android.rahul.domain.SystemInterface
import com.android.rahul.domain.utils.HttpParams
import com.android.rahul.domain.utils.Pair

/**
 * Created by rahul khurana on 13.05.2020.
 */

class FakeSystem : SystemInterface {

    private val requests = ArrayDeque<String>()

    fun addRequest(req: String) {
        requests.add(req)
    }

    override fun doOnBackground(background: ()->Unit) {
        Thread(Runnable { background() }).start()
    }

    override fun doOnForeground(foreground: ()->Unit) {
        Thread(Runnable { foreground() }).start()
    }

    @Throws(IOException::class)
    override fun httpGet(url: URL, params: HttpParams?): Pair<ByteArray, HttpParams> {
        try {
            TimeUnit.SECONDS.sleep(2)
        } catch (e: InterruptedException) {
        }

        return Pair<ByteArray, HttpParams>(requests.poll().toByteArray(), null)
    }

    override fun getSavedStringArray(title: String, def: Array<String>?): Array<String> {
        return Array(0, {""})
    }

    override fun saveStringArray(title: String, array: Array<String>) {

    }

    override fun removeSaved(str: String) {

    }

}
