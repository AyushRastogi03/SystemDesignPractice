package LLD_CaseStudies.ParkingLotNew.Models;

import LLD_CaseStudies.ParkingLotNew.Enums.SpotState;
import LLD_CaseStudies.ParkingLotNew.Enums.SpotType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;

import java.util.concurrent.locks.ReentrantLock;

@Data
public class ParkingSpot {

    private String spotId;

    @Setter(AccessLevel.NONE)
    private SpotState spotState;

    private SpotType spotType;

    /** Protects the state transition AVAILABLE <-> OCCUPIED. */
    @EqualsAndHashCode.Exclude
    private final ReentrantLock stateLock = new ReentrantLock();

    public ParkingSpot() {
        this.spotState = SpotState.AVAILABLE;
    }

    public ParkingSpot(String spotId, SpotType spotType) {
        this.spotId = spotId;
        this.spotType = spotType;
        this.spotState = SpotState.AVAILABLE;
    }

    /**
     * Atomically claims this spot. Only one concurrent caller can receive true.
     * we can also use synchronized boolean tryOccupy() to achive thread safe , this reentrantLock provides more
     * functionality like lock.tryLock(2, TimeUnit.seconds) -> wait for 2 sec , intrerupt thread in between etc
     */
    public boolean tryOccupy() {
        stateLock.lock();
        try {
            if (spotState != SpotState.AVAILABLE) {
                return false;
            }
            spotState = SpotState.OCCUPIED;
            return true;
        } finally {
            stateLock.unlock();
        }
    }

    /**
     * Atomically releases this spot. A non-occupied spot cannot be released.
     */
    public void release() {
        stateLock.lock();
        try {
            if (spotState != SpotState.OCCUPIED) {
                throw new IllegalStateException("Spot is not occupied");
            }
            spotState = SpotState.AVAILABLE;
        } finally {
            stateLock.unlock();
        }
    }
}
