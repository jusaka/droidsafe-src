package javax.sip.header;

// Droidsafe Imports
import droidsafe.annotations.*;
import javax.sip.InvalidArgumentException;

public interface MaxForwardsHeader extends Header {
    String NAME = "Max-Forwards";

    void decrementMaxForwards() throws TooManyHopsException;

    int getMaxForwards();
    void setMaxForwards(int maxForwards) throws InvalidArgumentException;

    boolean hasReachedZero();
}
