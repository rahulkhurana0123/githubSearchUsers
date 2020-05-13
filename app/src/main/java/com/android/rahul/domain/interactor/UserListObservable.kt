package com.android.rahul.domain.interactor

import java.io.IOException
import java.util.ArrayList

import com.android.rahul.domain.github_repo.ResponseParser
import com.android.rahul.domain.utils.Pair

/**
 * Created by rahul khurana on 13.05.2020.
 */

abstract class UserListObservable(var query: String) {

    @Throws(IOException::class, ResponseParser.ParseException::class)
    abstract fun obtain(limit: Int, offset: Int): Pair<ArrayList<UserModel>, Int>

    override fun equals(other: Any?): Boolean {
        if (other !is UserListObservable) return false
        val compareWith = other
        return this.query == compareWith.query
    }
}
