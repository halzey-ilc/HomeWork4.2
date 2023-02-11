package com.example.homework42.utils

import android.widget.Toast
import androidx.fragment.app.Fragment

sealed class Resource <out T>(
    val data: T? = null,
    val message: String? = null
) {
    class Loading<T>(data: T? = null) : Resource<T>(data = data)
    class Success<T>(data: T) : Resource<T>(data = data)
    class Error<T>(message: String, data: T? = null) : Resource<T>(data = data, message = message)
}
fun Fragment.showText(text: String) {
    Toast.makeText(requireContext(), text, Toast.LENGTH_SHORT).show()
}
