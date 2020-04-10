package com.smartphone.topnews.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.smartphone.topnews.network.NewsProperty
import com.smartphone.topnews.network.TopNewsApi
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val NewsAPIKEY = "727becd0df6e438593877e51a80f6bf4"

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text
    val newsErrorResponse = MutableLiveData<String>()
    val newsResponse = MutableLiveData<NewsProperty>()

    init {
        getTopBusinessNews()
    }

    private fun getTopBusinessNews() {
        TopNewsApi.retrofitService.getProperties("us", "business", NewsAPIKEY).enqueue(
            object : Callback<NewsProperty> {
                override fun onFailure(call: Call<NewsProperty>, t: Throwable) {
                    newsErrorResponse.value = t.message
                }

                override fun onResponse(
                    call: Call<NewsProperty>,
                    response: Response<NewsProperty>
                ) {
                    newsResponse.value = response.body()
                }

            }
        )

    }
}