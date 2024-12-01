import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.imooc_voice.repository.Repository
import com.example.imooc_voice.ui.mine.BannerResponse
import com.example.lib_network.ApiResult
import kotlinx.coroutines.launch

class MineViewModel : ViewModel() {
    private val repository = Repository()

    private val _bannerData = MutableLiveData<BannerResponse>()
    val bannerData: LiveData<BannerResponse> = _bannerData

    private val _error = MutableLiveData<String>()
    val error: LiveData<String> = _error

    fun getBanner() = viewModelScope.launch {
        when (val result = repository.getBanner()) {
            is ApiResult.Success -> _bannerData.value = result.data
            is ApiResult.Error -> _error.value = result.message
        }
    }
}