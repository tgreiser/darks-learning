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
package darks.learning.lossfunc;

import static darks.learning.common.utils.MatrixHelper.pow;

import org.jblas.DoubleMatrix;

import darks.learning.LearningConfig;

/**
 * Loss function
 * 
 * @author Darks.Liu
 *
 */
public class SquaredLoss extends LossFunction
{
	
	
	
	public SquaredLoss(LearningConfig config)
	{
		super(config);
	}
	
	@Override
	public double getLossValue()
	{
		DoubleMatrix target = reConstructon.reconstruct(input);
		DoubleMatrix diff = pow(target.sub(input), 2);
		double loss = diff.columnSums().sum() / input.rows;
		if(config.useRegularization) 
		{
            loss += 0.5 * config.L2 * pow(weights, 2).sum();
        }
		return loss;
	}
	
	
}

