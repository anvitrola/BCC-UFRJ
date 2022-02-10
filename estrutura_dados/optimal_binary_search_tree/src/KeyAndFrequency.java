public class KeyAndFrequency implements Comparable<KeyAndFrequency>{
    private final int key;
    private final int frequency;

    public KeyAndFrequency (int key, int frequency) {
        this.key = key;
        this.frequency = frequency;
    }

    public int getFrequency() {
        return frequency;
    }

    public int getKey() {
        return key;
    }

    @Override
    public int compareTo(KeyAndFrequency o) {
        return this.key - o.key;
    }

    @Override
    public String toString() {
        return "(key = " + key + ", frequency = " + frequency +
                ")";
    }
}
