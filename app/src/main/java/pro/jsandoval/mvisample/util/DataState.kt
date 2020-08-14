package pro.jsandoval.mvisample.util

data class DataState<T>(
    var data: T? = null,
    var loading: Boolean = false,
    var type: DataType = DataType.Success,
    var message: String? = null
) {
    companion object {
        fun <T> error(message: String?): DataState<T> {
            return DataState(type = DataType.Error, message = message)
        }

        fun <T> loading(isLoading: Boolean): DataState<T> {
            return DataState(message = null, loading = isLoading, data = null, type = DataType.Loading)
        }

        fun <T> data(message: String? = null, data: T? = null): DataState<T> {
            return DataState(
                message = null, type = DataType.Success,
                data = data, loading = false
            )
        }
    }
}

sealed class DataType {
    object Loading : DataType()
    object Success : DataType()
    object Error : DataType()
}