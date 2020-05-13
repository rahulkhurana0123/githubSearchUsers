package com.android.rahul.domain.interactor

import java.io.IOException
import java.util.ArrayList

import com.android.rahul.domain.SystemInterface
import com.android.rahul.domain.github_repo.GitHubRequests
import com.android.rahul.domain.github_repo.ResponseParser
import com.android.rahul.domain.utils.Pair

/**
 * Created by rahul khurana on 13.05.2020.
 */

class SearchObservable(query: String,
                       private val system: SystemInterface,
                       private val favorites: FavoritesManagement) : UserListObservable(query) {

    @Throws(IOException::class, ResponseParser.ParseException::class)
    override fun obtain(limit: Int, offset: Int): Pair<ArrayList<UserModel>, Int> {
        val url = GitHubRequests.searchUser(query, limit, offset)
        val result = String(system.httpGet(url!!, null).t)
        val users = ResponseParser.parseSearchResults(result)
        return Pair(
                favorites.sortFavorites(users.t),
                if (users.u > 1000) 1000 else users.u)
    }
}
