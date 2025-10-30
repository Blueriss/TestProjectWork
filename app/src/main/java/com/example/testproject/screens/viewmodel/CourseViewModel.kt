import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testproject.repository.CourseRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class CourseViewModel(
    private val repository: CourseRepository
) : ViewModel() {

    private val _isSorted = MutableStateFlow(false)
    val isSorted: StateFlow<Boolean> = _isSorted.asStateFlow()
    val courses = _isSorted.flatMapLatest { isSorted ->
        if (isSorted) {
            repository.getCoursesSortedByPublishDate()
        } else {
            repository.getCourses()
        }
    }.stateIn(
        viewModelScope,
        SharingStarted.WhileSubscribed(5000),
        emptyList()
    )

    val favoriteCourses = repository.getFavoriteCourses()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )

    fun toggleSort() {
        _isSorted.value = !_isSorted.value
    }

    fun refreshCourses() {
        viewModelScope.launch {
            try {
                repository.refreshCourses()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    fun toggleFavorite(courseId: Int) {
        viewModelScope.launch {
            try {
                repository.toggleFavorite(courseId)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}