package com.apple.boardback.common;

    public interface ResponseMessage {

        String SUCCESS = "SU";


        String VALIDATION_FAILED = "Validation failed.";
        String DUPLICATE_EMAIL = "Duplicate email.";
        String DUPLICATE_NICKNAME = "Duplicate Nickname.";
        String DUPLICATE_TEL_NUMBER = "Duplicate Tel number.";
        String NOT_EXISTED_USER = "This user does not exist.";
        String NOT_EXISTED_BOARD = "This board does not exist.";

        String SIGN_IN_FAIL ="Login information mismatch.";
        String AUTHORIZATION_FAIL = "Authorization Failed.";
        String NO_PERMISSION = "Do not have permission.";
        String DATABASE_ERROR = "Database error." 

    }
}
