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
package darks.learning.common.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FreqMatrix<T>
{
	private Map<T, FreqCount<T>> countMap = new HashMap<T, FreqCount<T>>();
	
	public void add(T real, T guess)
	{
		add(real, guess, 1);
	}
	
	public void add(T real, T guess, int value)
	{
		FreqCount<T> guessFreq = countMap.get(real);
		if (guessFreq == null)
		{
			guessFreq = new FreqCount<T>();
			countMap.put(real, guessFreq);
		}
		guessFreq.addValue(guess, value);
	}
	
	public long count(T real, T guess)
	{
		FreqCount<T> guessFreq = countMap.get(real);
		if (guessFreq == null)
		{
			guessFreq = new FreqCount<T>();
			countMap.put(real, guessFreq);
		}
		return guessFreq.getValue(guess);
	}
	
	public Set<T> getClasses()
	{
		return countMap.keySet();
	}
}