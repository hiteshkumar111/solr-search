package com.apple.exceptions;


public enum ErrorCode {

  REQUESTER_IDENTITY_MISSING(900,"Auth token missing"),
  INVALID_REQUEST(901,"Invalid Request."),
  SAVE_OR_UPDATE_FAILED(902,"Error while saving or updating to database."),
  NO_RECORD_FOUND(903,"No Records Found"),
  NO_RESOURCE_FOUND(903,"No Resource found."),
  PARTIAL_DATA(904,"Incomplete requestDTO."),
  READ_FAILED(905,"Errow while reading data from database.");


  private Integer subErrorCode;
  private String message;

  ErrorCode(Integer subErrorCode,String message) {
    this.subErrorCode = subErrorCode;
    this.message = message;
  }

  public Integer getSubErrorCode() {
    return subErrorCode;
  }

  public String getMessage() {
    return message;
  }

  public static ErrorCode getEnumByMessage(String message) {
    for(ErrorCode errorCode : ErrorCode.values()) {
      if(errorCode.getMessage().equalsIgnoreCase(message)) {
        return errorCode;
      }
    }
    return null;
  }

  public static ErrorCode getEnumBySubErrorCode(Integer subErrorCode) {
    for(ErrorCode errorCode : ErrorCode.values()) {
      if(errorCode.getSubErrorCode()==subErrorCode) {
        return errorCode;
      }
    }
    return null;
  }
}
