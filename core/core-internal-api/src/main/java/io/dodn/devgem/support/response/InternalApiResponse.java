package io.dodn.devgem.support.response;

import io.dodn.devgem.support.error.InternalErrorMessage;
import io.dodn.devgem.support.error.InternalErrorType;

public class InternalApiResponse<S> {
    private final InternalResultType result;
    private final S data;
    private final InternalErrorMessage error;

    private InternalApiResponse(InternalResultType result, S data, InternalErrorMessage error) {
        this.result = result;
        this.data = data;
        this.error = error;
    }

    public static InternalApiResponse<?> success() {
        return new InternalApiResponse<>(InternalResultType.SUCCESS, null, null);
    }

    public static <S> InternalApiResponse<S> success(S data) {
        return new InternalApiResponse<>(InternalResultType.SUCCESS, data, null);
    }

    public static InternalApiResponse<?> error(InternalErrorType error) {
        return new InternalApiResponse<>(
                InternalResultType.ERROR, null, new InternalErrorMessage(error));
    }

    public static InternalApiResponse<?> error(InternalErrorType error, Object errorData) {
        return new InternalApiResponse<>(
                InternalResultType.ERROR, null, new InternalErrorMessage(error, errorData));
    }

    public InternalResultType getResult() {
        return result;
    }

    public Object getData() {
        return data;
    }

    public InternalErrorMessage getError() {
        return error;
    }
}
