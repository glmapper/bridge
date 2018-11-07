package com.glmapper.bridge.exception;

/**
 * BridgeRpcRuntimeException
 *
 * @version 1.0
 * @author: guolei.sgl
 * @since: 18/11/7 下午12:24
 **/
public class BridgeRpcRuntimeException extends RuntimeException {
    protected BridgeRpcRuntimeException() {

    }
    public BridgeRpcRuntimeException(String message) {
        super(message);
    }
    public BridgeRpcRuntimeException(String message, Throwable cause) {
        super(message, cause);
    }

    public BridgeRpcRuntimeException(Throwable cause) {
        super(cause);
    }
}
