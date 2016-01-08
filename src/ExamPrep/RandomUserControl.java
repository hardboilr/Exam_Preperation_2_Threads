package ExamPrep;

import java.util.Observable;
import java.util.logging.Level;
import java.util.logging.Logger;
import randomperson.RandomUser;
import randomperson.RandomUserGenerator;

/**
 * This class extends Observable and implements Runnable!
 *
 * 1. Get random user from RandomUserGenerator
 *
 * 2. Notify observers and pass user-object to them
 *
 * @author Tobias Jacobsen
 */
public class RandomUserControl extends Observable implements Runnable {

    private RandomUser user;

    @Override
    public void run() {
        user = null;
        try {
            user = RandomUserGenerator.getRandomUser();
        } catch (InterruptedException ex) {
            Logger.getLogger(RandomUserControl.class.getName()).log(Level.SEVERE, null, ex);
        }
        setChanged(); // marks this observable as having been changed 
        notifyObservers(user); // notify observers and pass user on to the swing frontend  
    }
}
