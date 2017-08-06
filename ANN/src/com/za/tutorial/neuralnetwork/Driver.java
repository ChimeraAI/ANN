/*
 * This is the main class for supervised learning ANN
 */
package com.za.tutorial.neuralnetwork;

public class Driver {
	public static void main(String[] args){
		int[][][] data = Perceptron.andData;
		double[] weights = Perceptron.INITIAL_WEIGHTS;
		Perceptron perceptron = new Perceptron();
		boolean errorFlag = true;
		double[] adjustedWeights = null;
		int epoch = 0;
		double error = 0;
		while(errorFlag) {
			error = 0;
			errorFlag = false;
			System.out.println("epoch" + (epoch++));
			for(int x = 0; x < data.length; x++){
				System.out.print(weights[0] + " " + weights[1] + "\n");
				double weightedSum = perceptron.calculateWeightedSum(data[x][0], weights);
				System.out.println("WeightedSum:" + weightedSum);
				double result = perceptron.activationFunction(weightedSum);
				error = data[x][1][0] - result;
				System.out.println("error: " + error);
				if(error != 0) errorFlag = true;
				adjustedWeights = perceptron.adjustWeight(data[x][0], weights, error);
				weights = adjustedWeights;
			}
		}
		for(int x = 0; x < data.length; x++){
			System.out.println(perceptron.activationFunction(perceptron.calculateWeightedSum(data[x][0], weights)));
		}
	}
}

