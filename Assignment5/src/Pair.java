public class Pair implements Comparable<Pair>{
    // declare all required fields
    private char value;
    private double prob;
    public Pair(char value, double prob) {
        this.value=value;
        this.prob=prob;
    }


    public char getValue() {
        return value;
    }

    public void setValue(char value) {
        this.value = value;
    }

    public double getProb() {
        return prob;
    }

    public void setProb(double prob) {
        this.prob = prob;
    }

    @Override
    public String toString() {
        return "Pair [value=" + value + ", prob=" + prob + "]";
    }


    @Override
    public int compareTo(Pair p){
        return Double.compare(this.getProb(), p.getProb());
    }
}