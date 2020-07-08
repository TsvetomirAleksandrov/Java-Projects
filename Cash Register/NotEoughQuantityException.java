public class NotEoughQuantityException extends Exception {
    public NotEoughQuantityException(){
        super("Not enough quantity");
    }
    public NotEoughQuantityException(String message){
        super(message);
    }
}
