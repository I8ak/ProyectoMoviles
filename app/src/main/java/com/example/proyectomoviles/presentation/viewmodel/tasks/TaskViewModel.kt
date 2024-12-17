import androidx.lifecycle.ViewModel
import com.example.proyectomoviles.domain.model.Product
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class TasksViewModel : ViewModel() {
    // Estado mutable que almacena el listado de tareas
    private val _products = MutableStateFlow<List<Product>>(emptyList())
    // Version inmutable del estado anterior, es el estado que va a leer el UI
    val tasks: StateFlow<List<Product>> = _products

    // Contador que hace de AUTO_INCREMENT en los id de tarea
    // Normalmente esto lo haría la base de datos
    private var idCounter = 0

    // Las siguientes funciones implementan alguna funcionalidad que provoca cambios en el estado del ViewModel

    // Añade una tarea
    fun addTask(name: String, category: String, quantity: Int, price: Double) {
        val newTask = Product(id = idCounter, name = name, category = category, quantity = quantity, price = price)
        _products.value = _products.value + newTask
        idCounter++
    }




    // Elimina una tarea
    fun removeTask(id: Int) {
        _products.value = _products.value.filter { it.id != id }
    }
}