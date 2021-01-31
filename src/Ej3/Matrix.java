package Ej3;

import java.util.ArrayList;

public class Matrix {

	static final int DATA = 1;
	static final int UTILIZATION = 2;
	static final int EVENTS = 3;
	
	private ArrayList<ArrayList<Double>> matrix;
	
	public Matrix(int quantityOfRows) {
		this.matrix = new ArrayList<ArrayList<Double>>();
		
		for (int i = 0; i< quantityOfRows; i++) {			
			this.matrix.add(new ArrayList<Double>());
		}
	}
	
	public void addValue(Double value, int numberOfRow, int numberOfColumn) {
		this.matrix.get(numberOfRow).add(numberOfColumn, value);
	}
	
	public void replaceValue(Double value, int numberOfRow, int numberOfColumn) {
		this.matrix.get(numberOfRow).set(numberOfColumn, value);
	}

	public ArrayList<Double> getRow(int numberOfRow) {
		return this.matrix.get(numberOfRow);
	}
	
	public Double getValue(int numberOfRow, int numberOfColumn) {
		return this.matrix.get(numberOfRow).get(numberOfColumn);
	}
	
	public int getSize() {
		return this.matrix.size();
	}
	
	private void showDataMatrixOrUtilizationMatrix(StringBuilder matrix, int numberOfProcess) {
		for (int i=0; i<getSize(); i++) {
			for (int j=0; j<this.matrix.get(i).size(); j++) {
				if (j==0) {					
					matrix.append("Proc. " + numberOfProcess + "	|	" + String.format("%.4f", getValue(i, j)));
				} else {
					matrix.append("	|		" + String.format("%.4f", getValue(i, j)));
				}
			}
			
			numberOfProcess++;
			matrix.append("	|\n|	");
		}
	}
	
	private void showEventsMatrix(StringBuilder matrix, int numberOfProcess) {
		for (int i=0; i<getSize(); i++) {
			if (i == 0) {
				for (int j=0; j<this.matrix.get(i).size(); j++) {
					matrix.append(String.format("%.4f", getValue(i, j)) + "	|	");
				}
				
				matrix.append("\n|	");
			} else {
				for (int j=0; j<this.matrix.get(i).size(); j++) {
					if (j==0) {					
						matrix.append("Proc. " + numberOfProcess + "	|	" + String.format("%.4f", getValue(i, j)));
					} else {
						matrix.append("	|	" + String.format("%.4f", getValue(i, j)));
					}
				}
				
				matrix.append("	|\n|	");
				numberOfProcess++;
			}
		}
	}
	
	public void show(int matrixType) {
		StringBuilder matrix = new StringBuilder("|	");
		int numberOfProcess = 1;
		
		switch (matrixType) {
			case DATA: 
				matrix.append("	|	");
				matrix.append("Inicio	|	");
				matrix.append("Duración	|	");
				matrix.append("\n|	");
				
				showDataMatrixOrUtilizationMatrix(matrix, numberOfProcess);
				break;
			case UTILIZATION:
				matrix.append("	|");
				matrix.append("CPU ociosa	|	");
				matrix.append("CPU ocupada	|	");
				matrix.append("CPU/Proceso	|	");
				matrix.append("\n|	");
				
				showDataMatrixOrUtilizationMatrix(matrix, numberOfProcess);
				break;
			case EVENTS:
				matrix.append("	|	");
				
				showEventsMatrix(matrix, numberOfProcess);
				break;
		}
			
		matrix.deleteCharAt(matrix.length() - 2);
		System.out.println(matrix + "\n");
	}
	
}