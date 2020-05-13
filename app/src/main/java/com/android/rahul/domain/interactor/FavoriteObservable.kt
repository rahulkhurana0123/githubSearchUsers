package com.android.rahul.domain.interactor

import java.io.IOException
import java.util.ArrayList

import com.android.rahul.domain.github_repo.ResponseParser
import com.android.rahul.domain.utils.Pair

/**
 * Created by rahul khurana on 13.05.2020.
 */

class FavoriteObservable(private val favorites: FavoritesManagement) : UserListObservable(FavoritesManagement.FAVORITES) {

    @Throws(IOException::class, ResponseParser.ParseException::class)
    override fun obtain(limit: Int, offset: Int): Pair<ArrayList<UserModel>, Int> {
        return Pair(favorites.getFavorites(), favorites.getFavorites().size)
    }
}
