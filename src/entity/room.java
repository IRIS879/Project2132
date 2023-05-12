package entity;

public class room {
    private int hotel_id;
    private int room_id;
    private double price;
    private String amenities;
    private String capacity;
    private boolean hasSeaView;
    private boolean hasMountainView;
    private boolean canBeExtended;
    private String problems;

    public room(int hotel_id, int room_id, double price, String amenities, String capacity, boolean hasSeaView, boolean hasMountainView, boolean canBeExtended, String problems) {
        this.hotel_id = hotel_id;
        this.room_id = room_id;
        this.price = price;
        this.amenities = amenities;
        this.capacity = capacity;
        this.hasSeaView = hasSeaView;
        this.hasMountainView = hasMountainView;
        this.canBeExtended = canBeExtended;
        this.problems = problems;
    }

    public room() {

    }

    public int getHotelId() {
        return hotel_id;
    }

    public void setHotelId(int hotel_id) {
        this.hotel_id = hotel_id;
    }

    public int getRoom_id(){
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getAmenities() {
        return amenities;
    }

    public void setAmenities(String amenities) {
        this.amenities = amenities;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public boolean hasSeaView() {
        return hasSeaView;
    }

    public void setHasSeaView(boolean hasSeaView) {
        this.hasSeaView = hasSeaView;
    }

    public boolean hasMountainView() {
        return hasMountainView;
    }

    public void setHasMountainView(boolean hasMountainView) {
        this.hasMountainView = hasMountainView;
    }

    public boolean canBeExtended() {
        return canBeExtended;
    }

    public void setCanBeExtended(boolean canBeExtended) {
        this.canBeExtended = canBeExtended;
    }

    public String getProblems() {
        return problems;
    }

    public void setProblems(String problems) {
        this.problems = problems;
    }
    @Override
    public String toString() {
        return "Room [room_id=" + room_id + ", price=" + price + ", amenities=" + amenities + ", capacity=" + capacity
                + ", has_sea_view=" + hasSeaView + ", has_mountain_view=" + hasMountainView + ", can_be_extended="
                + canBeExtended + ", problems=" + problems + "]";
    }
}