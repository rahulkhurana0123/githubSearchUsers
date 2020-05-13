package com.android.rahul.domain.github_repo

import java.io.UnsupportedEncodingException
import java.net.MalformedURLException
import java.net.URL
import java.net.URLEncoder

/**
 * Created by rahul khurana on 13.05.2020.
 */

object GitHubRequests {

    fun searchUser(searchFor: String, limit: Int, offset: Int): URL? {
        try {
            return URL("https://api.github.com/search/users?q=" + URLEncoder.encode(searchFor, "utf-8") + "&page=" + (offset / limit + 1) + "&per_page=" + limit)
        } catch (e: Exception) {
            e.printStackTrace()
            return null
        } catch (e: UnsupportedEncodingException) {
            e.printStackTrace()
            return null
        }

    }

}
