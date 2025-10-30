import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.testproject.repository.CourseRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

class CourseViewModel(
    private val repository: CourseRepository
) : ViewModel() {

    val courses = repository.getCourses()
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            emptyList()
        )

    fun refreshCourses() {
        viewModelScope.launch {
            try {
                repository.refreshCourses()
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}