package com.example.trending.ui.main

import android.app.Application
import android.util.Log
import androidx.lifecycle.*
import com.example.trending.MyApplication
import com.example.trending.di.RetroService
import com.example.trending.models.TrendingRepo
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class MainViewModel(application: Application) : AndroidViewModel(application) {

    @Inject
    lateinit var repository:RetroService
    private val _repos = MutableLiveData<List<TrendingRepo>>()
    private var filteredRepo = MutableLiveData<List<TrendingRepo>>()
    val repos:LiveData<List<TrendingRepo>> = filteredRepo
    val selectedItem = MutableLiveData<TrendingRepo>()

    init {
        (application as MyApplication).getComponent().inject(this)
    }

    fun apiCall(){
            repository.getAllData()?.enqueue(object : Callback<List<TrendingRepo>> {
                override fun onResponse(call: Call<List<TrendingRepo>>, response: Response<List<TrendingRepo>>) {
                    response.body()?.let {
                        _repos.postValue(it)
                        filteredRepo.postValue(it)
                    }
                }

                override fun onFailure(call: Call<List<TrendingRepo>>, t: Throwable) {
                    Log.i("Rest Call",t.localizedMessage!!)
                }

            })
    }

    fun filter(query:String?){
        query?.also {
            if (it.isNotEmpty()){
                filteredRepo.value = _repos.value?.filter { it1 ->
                    it1.repositoryName?.contains(query,true) ?: true
                }
            }else{
                filteredRepo.value = _repos.value
            }
        }
    }
}