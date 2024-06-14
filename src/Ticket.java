import java.time.Instant;



public class Ticket extends Printable implements Identifiable {
    private int id; // Implementing Identifiable
    private String concertHall; // Max 10 chars
    private int eventCode; // 3 digits
    private long time; // Unix timestamp
    private boolean isPromo;
    private char stadiumSector; // From 'A' to 'C'
    private double maxAllowedBackpackWeight; // In kg with grams precision
    private double price; // Ticket price
    private final long creationTime; // Automatically detect and save ticket creation time

    public Ticket(String id, String concertHall, int eventCode, long time, boolean isPromo, char stadiumSector, double maxAllowedBackpackWeight, double price) {
        this.id = Integer.parseInt(id); // Changed to int
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.time = time;
        this.isPromo = isPromo;
        this.stadiumSector = stadiumSector;
        this.maxAllowedBackpackWeight = maxAllowedBackpackWeight;
        this.price = price;
        this.creationTime = Instant.now().getEpochSecond();
    }

    public Ticket(String concertHall, int eventCode, long time) {
        this.concertHall = concertHall;
        this.eventCode = eventCode;
        this.time = time;
        this.creationTime = Instant.now().getEpochSecond();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public char getStadiumSector() {
        return stadiumSector;
    }

    public void setStadiumSector(char stadiumSector) {
        this.stadiumSector = stadiumSector;
    }

    public String getConcertHall() {
        return concertHall;
    }

    public int getEventCode() {
        return eventCode;
    }

    public boolean isPromo() {
        return isPromo;
    }

    public double getMaxAllowedBackpackWeight() {
        return maxAllowedBackpackWeight;
    }

    public double getPrice() {
        return price;
    }

    public long getCreationTime() {
        return creationTime;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", concertHall='" + concertHall + '\'' +
                ", eventCode=" + eventCode +
                ", time=" + time +
                ", isPromo=" + isPromo +
                ", stadiumSector=" + stadiumSector +
                ", maxAllowedBackpackWeight=" + maxAllowedBackpackWeight +
                ", price=" + price +
                ", creationTime=" + creationTime +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        return id == ticket.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    // Method to share by phone
    public void share(String phoneNumber) {
        System.out.println("Sharing ticket with ID: " + id + " to phone: " + phoneNumber);
    }

    // Method to share by phone and email
    public void share(String phoneNumber, String email) {
        System.out.println("Sharing ticket with ID: " + id + " to phone: " + phoneNumber + " and email: " + email);
    }


public interface Identifiable {
        int getId();
        void setId(int id);
    }

    public abstract class Printable {
        public void print() {
            System.out.println(this.toString());
        }
    }

    }


}


