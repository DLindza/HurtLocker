/**
 * Created by devon on 10/17/16.
 */
public class NoCurrentValueException extends Exception {

        static int counter = 0;

        public NoCurrentValueException(String message){
            super(message);

        }

}
