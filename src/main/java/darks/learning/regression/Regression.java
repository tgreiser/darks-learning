/**
 * 
 * Copyright 2014 The Darks Learning Project (Liu lihua)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package darks.learning.regression;

import org.jblas.DoubleMatrix;

import darks.learning.model.ModelSet;

/**
 * Regression model
 * @author Darks.Liu
 *
 */
public abstract class Regression
{
	
	public RegressionConfig config = new RegressionConfig();

	/**
	 * Train model set
	 * 
	 * @param modelSet Model set
	 */
	public void train(ModelSet modelSet)
	{
		train(modelSet.getInput(), modelSet.getOutput());
	}

	/**
	 * Train model set
	 * 
	 * @param input Model input
	 * @param output Model output
	 */
	public abstract void train(DoubleMatrix input, DoubleMatrix output);
	
	/**
	 * Predict model result by input matrix
	 * 
	 * @param input Input matrix
	 * @return Result label matrix
	 */
	public abstract DoubleMatrix predict(DoubleMatrix input);
	
}
