package com.android.rahul.presentation

import org.junit.Assert
import org.junit.Before
import org.junit.Test

import java.net.URL

/**
 * Created by rahul khurana on 13.05.2020.
 */
class AndroidInterfaceTest {

    internal var androidInterface: AndroidInterface = null!!

    @Before
    fun before() {
        androidInterface = AndroidInterface(null)
    }

    @Test
    @Throws(Exception::class)
    fun doOnBackground() {
                androidInterface.doOnBackground( { Assert.assertNotEquals("main", Thread.currentThread().getName()) } );
    }

    @Test
    @Throws(Exception::class)
    fun httpGet() {
        val url = URL("https://api.github.com/users/rahulkhurana0123")
        val data = androidInterface.httpGet(url, null).t
        Assert.assertEquals(
                "{ \"login\": \"rahulkhurana0123\", \"id\": 21967461, \"node_id\": \"MDQ6VXNlcjIxOTY3NDYx\", \"avatar_url\": \"https://avatars0.githubusercontent.com/u/21967461?v=4\", \"gravatar_id\": \"\", \"url\": \"https://api.github.com/users/rahulkhurana0123\", \"html_url\": \"https://github.com/rahulkhurana0123\", \"followers_url\": \"https://api.github.com/users/rahulkhurana0123/followers\", \"following_url\": \"https://api.github.com/users/rahulkhurana0123/following{/other_user}\", \"gists_url\": \"https://api.github.com/users/rahulkhurana0123/gists{/gist_id}\", \"starred_url\": \"https://api.github.com/users/rahulkhurana0123/starred{/owner}{/repo}\", \"subscriptions_url\": \"https://api.github.com/users/rahulkhurana0123/subscriptions\", \"organizations_url\": \"https://api.github.com/users/rahulkhurana0123/orgs\", \"repos_url\": \"https://api.github.com/users/rahulkhurana0123/repos\", \"events_url\": \"https://api.github.com/users/rahulkhurana0123/events{/privacy}\", \"received_events_url\": \"https://api.github.com/users/rahulkhurana0123/received_events\", \"type\": \"User\", \"site_admin\": false, \"name\": \"Rahul khurana\", \"company\": null, \"blog\": \"\", \"location\": \"Gurugram\", \"email\": null, \"hireable\": null, \"bio\": \"working as a android developer from more than 4 year. experienced in designing and maintaining enterprise level application.\", \"public_repos\": 7, \"public_gists\": 0, \"followers\": 0, \"following\": 0, \"created_at\": \"2016-09-03T07:25:41Z\", \"updated_at\": \"2020-05-01T06:19:18Z\" }",
                String(data))
    }

}