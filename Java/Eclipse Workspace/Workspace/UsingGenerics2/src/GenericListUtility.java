import java.util.ArrayList;
import java.util.List;

public class GenericListUtility 
{
	public static <E> void print(List<E> list)
	{
		for(E e : list)
			System.out.println(e);
	}
	
	//print header
	public static <E> void print(List<E> list, 
							String prompt)
	{
		System.out.println(prompt);
		print(list);
	}
	
	public static <E> void printReverse(List<E> list, 
			String prompt)
	{
		System.out.println(prompt);
		printReverse(list);
	}
	
	//reverse print
	public static <E> void printReverse(List<E> list)
	{
		//E e = null;
		
		for(int i = list.size() - 1; i >= 0; i--)
		{
			//e = list.get(i);
			System.out.println(list.get(i));
		}
	}
		
	//concatenate
	public static <E> void concatenate(List<E> listA,
			List<E> listB, List<E> listOut)
	{
		/*
		for(E e : listA)
			listOut.add(e); //add contents 1st list
		
		for(E e : listB)
			listOut.add(e); //add contents 2nd list
		*/		
		listOut.addAll(listA);
		listOut.addAll(listB);
	}
	
	public static <E> ArrayList<E> concatenate(
			List<E> listA, List<E> listB)
	{
		ArrayList<E> listOut = new ArrayList<E>();
		
		listOut.addAll(listA);
		listOut.addAll(listB);
		
		return listOut;
	}
	
	//interleave
	public static <E> ArrayList<E> interleave(List<E> listA,
			List<E> listB)
	{
		if(listA.size() != listB.size())
			return null;
		
		int outSize = 2 * listA.size();
		ArrayList<E> listOut = new ArrayList<E>(outSize);
		
		for(int i = 0; i < outSize; i++)
		{
			if(i%2 == 0) 	//even, take from A
			{
				listOut.add(listA.remove(0));
			}
			else 			//odd, take from B
			{
				listOut.add(listB.remove(0));
			}
		}
		
		return listOut;
	}
	

	//filterBy
	public static <E> ArrayList<E> filterBy(
			List<E> list, IFilter<E> filter)
	{
		ArrayList<E> listOut = new ArrayList<E>();
		
		for(E e : list)
		{
			if(filter.matches(e))
				listOut.add(e);
		}
		
		return listOut;
	}
	
	//populate
	public static <E> void populate(List<E> list, int count, 
			E defaultObject)
	{
		for(int i = 0; i < count; i++)
			list.add(defaultObject);
	}
	
	//To do in Week 10!
	
	//getMinimum
	public static <E> E getMinimum(List<E> list, 
			IMeasurer<E> measurer)
	{
		double smallestMeasure = Double.MAX_VALUE;
		double theMeasure = 0;
		
		E smallestObject = null;
		for(E obj : list)
		{
			theMeasure = measurer.getValue(obj);	
			if(theMeasure < smallestMeasure)
			{
				smallestMeasure = theMeasure; //smallest value
				smallestObject = obj; //address of smallest obj
			}
		}
		return smallestObject;	
	}
	
	public static <E> Pair<E, Integer> getMinimumAsPair(
			List<E> list, IMeasurer<E> measurer)
	{
		double smallestMeasure = Double.MAX_VALUE;
		double theMeasure = 0;
		int smallestPosition = -1;
		E smallestObject = null, obj = null;
		
		for(int i = 0; i < list.size(); i++)
		{
			obj = list.get(i);
			theMeasure = measurer.getValue(obj);
			
			if(theMeasure < smallestMeasure)
			{
				smallestMeasure = theMeasure;
				smallestObject = obj;
				smallestPosition = i;
			}
		}
		
		return new Pair<E, Integer>(smallestObject, 
				smallestPosition);
	}
	
	public static <E> void getMinimumAsPair(List<E> list, 
			IMeasurer<E> measurer, Pair<E, Integer> pair)
	{
		double smallestMeasure = Double.MAX_VALUE;
		double theMeasure = 0;
		int smallestPosition = -1;
		E smallestObject = null, obj = null;
		
		for(int i = 0; i < list.size(); i++)
		{
			obj = list.get(i);
			theMeasure = measurer.getValue(obj);
			
			if(theMeasure < smallestMeasure)
			{
				smallestMeasure = theMeasure;
				smallestObject = obj;
				smallestPosition = i;
			}
		}		
		pair.setFirst(smallestObject);
		pair.setSecond(smallestPosition);
	}
	
	public static <E> double getAverage(List<E> list, IMeasurer<E> measurer){
		double sum=0;
		for(E obj : list){
			sum += measurer.getValue(obj);
		}
		return sum/list.size();
	}

	public static <E> E getMaximum(List<E> list, IMeasurer<E> measurer){
		double highestMeasure = Double.MIN_VALUE;
		double currentMeasure;
		E largestObj = null;
		for(E obj : list){
			currentMeasure = measurer.getValue(obj);
			if(highestMeasure > currentMeasure){
				highestMeasure = currentMeasure;
				largestObj = obj;
			}
		}
		return largestObj;
	}
	
	public static <E> Pair<E, Integer> getMaximumAsPair(List<E> list, IMeasurer<E> measurer){
		double highestMeasure = Double.MIN_VALUE;
		double currentMeasure;
		E obj = null;
		E largestObj = null;
		int largestPosition = -1;
		
		for(int i = 0; i < list.size(); i++){
			obj = list.get(i);
			currentMeasure = measurer.getValue(obj);
			
			if(highestMeasure > currentMeasure){
				highestMeasure = currentMeasure;
				largestObj = obj;
				largestPosition = i;
			}
		}
		return new Pair<E, Integer>(largestObj, largestPosition);
	}
	//students - add getMaximum(), getAverage(), getStandardDeviation()
	
}













