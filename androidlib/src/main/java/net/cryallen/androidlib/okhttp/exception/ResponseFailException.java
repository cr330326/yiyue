package net.cryallen.androidlib.okhttp.exception;

/**
 * ResponseFailException
 */
public class ResponseFailException extends Exception{
    //Response Non Successful
    public ResponseFailException(){
        super("Response failure exception.");
    }
}
