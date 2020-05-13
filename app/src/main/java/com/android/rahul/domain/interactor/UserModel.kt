package com.android.rahul.domain.interactor

import com.android.rahul.domain.github_repo.GitHubUserShort

/**
 * Created by rahul khurana on 13.05.2020.
 */

class UserModel : GitHubUserShort {

    fun isFavorite(): Boolean {
        return isFavorite
    }

    private var isFavorite = false

    constructor(id: Int, login: String) : super(id, login)

    constructor(id: Int, login: String, favorite: Boolean) : super(id, login) {
        isFavorite = favorite
    }

    constructor(user: GitHubUserShort, favorite: Boolean) : super(user.id, user.login) {
        this.isFavorite = favorite
    }

    fun setFavorite(favor: Boolean): UserModel {
        isFavorite = favor
        return this
    }
}
