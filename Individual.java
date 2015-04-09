import java.util.Random;

public class Individual
{
	// @author:  original code from internet website, changes by J. Hayes
	//@version:  Internet version unknown, J. Hayes version 01
    public static final int SIZE = 500;  // @param SIZE   size of a chromosome (number of genes)
    private int[] genes = new int[SIZE]; // @param genes  a chromosome of SIZE genes
    private int fitnessValue;            // @param fitnessValue    fitness value

    public Individual() {}

    public int getFitnessValue() {
        return fitnessValue;
    }

    public void setFitnessValue(int fitnessValue) {
        this.fitnessValue = fitnessValue;
    }

    public int getGene(int index) {
        return genes[index];
    }

    public void setGene(int index, int gene) {
        this.genes[index] = gene;
    }

    public void randGenes() {
        Random rand = new Random();
        for(int i=0; i<SIZE; ++i) {
            this.setGene(i, rand.nextInt(2));
          //  System.out.print("in randGenes, i = " + i);
          //  System.out.print(" " +this.getGene(i));
        }
    }

    public void mutate() {
        Random rand = new Random();
        int index = rand.nextInt(SIZE);
        this.setGene(index, 1-this.getGene(index));    // flip
    }

    public int evaluate() {
        int fitness = 0;
        for(int i=0; i<SIZE; ++i) {
            fitness += this.getGene(i);
        }
        this.setFitnessValue(fitness);

       // System.out.print("after evaluation, fitness = " + fitness);
        
        return fitness;
    }
}