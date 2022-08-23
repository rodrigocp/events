package br.com.rcp.home.viewmodels

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import br.com.rcp.commons.utils.Connection.hasInternetConnection
import br.com.rcp.commons.utils.ResponseHandler
import br.com.rcp.commons.viewmodels.AbstractViewModel
import br.com.rcp.domain.models.Event
import br.com.rcp.home.R
import br.com.rcp.remote.repository.EventRepository
import kotlinx.coroutines.Dispatchers.IO

class HomeViewModel(private val repository: EventRepository) : AbstractViewModel() {
    fun getEventList(context: Context) : LiveData<ResponseHandler<List<Event>>> {
        return liveData(IO) {
            loading.postValue(true)

            if (hasInternetConnection(context)) {
                try {
                    emit(ResponseHandler.Success(data = repository.getEvents()))
                    loading.postValue(false)
                } catch (exception: Exception) {
                    emit(ResponseHandler.Failure(exception = exception.message ?: context.getString(R.string.connection_error)))
                    loading.postValue(false)
                }
            } else{
                emit(ResponseHandler.Failure(exception = context.getString(R.string.connection_error)))
                loading.postValue(false)
            }
        }
    }
}