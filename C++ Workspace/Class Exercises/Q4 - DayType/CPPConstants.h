#include <iostream>

/*
We can either add the dayArray in DayType as a static string array which will
be shared by all instances of DayType (i.e. if we create 1000 DayType objects
then we will only ever have one array of day strings) or we can declare and initialise
the string array in a constants header file (as in the approach below). Both are valid
solutions to ensuring that only a single string array is stored in RAM.
*/
const std::string dayArray[] 
		= {"monday", "tuesday", "wednesday", "thursday", "friday", "saturday", "sunday"};