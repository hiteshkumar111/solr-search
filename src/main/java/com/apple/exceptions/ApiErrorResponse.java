package com.apple.exceptions;

import java.util.Date;
import java.util.Map;

public class ApiErrorResponse {
	
    private Map<String,String> error;
    private Date timestamp;
    public Map<String,String> getError() {
        return error;
    }

    public void setError( Map<String,String> error) {
        this.error= error;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

}
