package dwmh.models;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

public class Reservation {

    String hostId;
    int id;
    LocalDate start;
    LocalDate end;
    int guestId;
    BigDecimal total;

    public Reservation() {
    }

    public Reservation(String hostId, LocalDate start, LocalDate end, int guestId, BigDecimal total) {
        this.hostId = hostId;
        this.start = start;
        this.end = end;
        this.guestId = guestId;
        this.total = total;
    }

    public String getHostId() {
        return hostId;
    }

    public void setHostId(String hostId) {
        this.hostId = hostId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public int getGuestId() {
        return guestId;
    }

    public void setGuestId(int guestId) {
        this.guestId = guestId;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return id == that.id && guestId == that.guestId && Objects.equals(hostId, that.hostId) && Objects.equals(start, that.start) && Objects.equals(end, that.end) && Objects.equals(total, that.total);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hostId, id, start, end, guestId, total);
    }
}
