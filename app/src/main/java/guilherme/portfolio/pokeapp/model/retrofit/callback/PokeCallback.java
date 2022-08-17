package guilherme.portfolio.pokeapp.model.retrofit.callback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class PokeCallback<T> implements Callback<T> {

    final String ERROR_NO_RESPONSE = "Error: Unsuccessful response.";
    final String ERROR_BAD_CONNECTION = "Error: Bad connection.";
    private final CallbackResponse<T> callback;

    public PokeCallback(CallbackResponse<T> callback) {
        this.callback = callback;
    }

    @Override
    @EverythingIsNonNull
    public void onResponse(Call<T> call, Response<T> response) {
        if(response.isSuccessful()){
            T result = response.body();
            if(result != null){
                callback.ifSuccess(result);
            }
        } else {
            callback.ifFailure(ERROR_NO_RESPONSE);
        }
    }

    @Override
    @EverythingIsNonNull
    public void onFailure(Call<T> call, Throwable t) {
        callback.ifFailure(ERROR_BAD_CONNECTION + t.getMessage());
    }

    public interface CallbackResponse<T> {
        void ifSuccess(T result);
        void ifFailure(String error);
    }

}
