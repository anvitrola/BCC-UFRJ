import java.util.Objects;

public class HeadAndTale {
    int head;
    int tale;

    public HeadAndTale (int head, int tale) {
        this.head = head;
        this.tale = tale;
    }

    public int getHead() {
        return head;
    }

    public int getTale() {
        return tale;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;

        if(obj == null || getClass() != obj.getClass()) return false;

        HeadAndTale that = (HeadAndTale) obj;
        return head == that.head && tale == that.tale;
    }

    @Override
    public int hashCode() {
        return Objects.hash(head, tale);
    }
}
