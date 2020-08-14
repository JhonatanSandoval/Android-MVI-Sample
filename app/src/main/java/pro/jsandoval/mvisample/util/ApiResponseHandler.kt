package pro.jsandoval.mvisample.util

abstract class ApiResponseHandler<ViewState, Data>(
    private val response: ApiResult<Data?>
) {
    suspend fun getResult(): DataState<ViewState> {
        return when (response) {
            is ApiResult.GenericError ->
                DataState.error(message = response.message.toString())

            is ApiResult.NetworkError ->
                DataState.error(message = "Network error")

            is ApiResult.Success ->
                if (response.value == null) {
                    DataState.error(message = "Reason: Data is NULL.")
                } else {
                    handleSuccess(resultObj = response.value)
                }
        }
    }

    abstract suspend fun handleSuccess(resultObj: Data): DataState<ViewState>

}