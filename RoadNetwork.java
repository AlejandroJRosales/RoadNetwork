import java.util.Arrays;

public class RoadNetwork extends java.lang.Object{
	
	public String state;
	public int cities;
	public int maxSize;
	public java.lang.String[][] arrCities = new java.lang.String[500][500];
	
	RoadNetwork(){
		this.state = "Wonderland";
		this.cities = 0;
		this.maxSize = 500;
	}
	
	RoadNetwork(int maxSize){
		this.state = "Nova";
		this.cities = 0;
		this.maxSize = maxSize;
	}
	
	public boolean addCity(java.lang.String name) {
		if (cities < maxSize) {
			arrCities[cities][0] = name;
			cities++;
			return true;
			}
		return false;
	}
	
	public boolean areConnected(java.lang.String city1, java.lang.String city2) {
		for(int i = 0; i < cities; i++) {
			if(arrCities[i][0].equals(city1)) {
				for(int a = 0; a < maxSize; a++) {
					if(arrCities[i][a].equals(city2))
						return true;
				}
			}
		}
		return false;
	
	}
	
	public boolean areDirectlyConnected(java.lang.String city1, java.lang.String city2) {
		for(int i = 0; i < cities; i++) {
			if(arrCities[i][0].equals(city1)) {
				for(int a = 0; a < maxSize; a++) {
					if(arrCities[i][a].equals(city2))
						return true;
				}
			}
		}
		return false;
	
	}
	
	public boolean connect(java.lang.String city1, java.lang.String city2) {
		for(int i = 0; i < cities; i++) {
			if(arrCities[i][0].equals(city1)) {
				for(int a = maxSize; a > 0 ; a--) {
					arrCities[i][a] = arrCities[i][a - 1];
				}
				arrCities[i][0] = city2;
				return true;
			}
		}
		return false;
	
	}
	
	public boolean containsCity(java.lang.String name) {
		for(int i = 0; i < cities; i++) {
			if(arrCities[i][0].equals(name))
				return true;
		}
		return false;
	
	}
	
	public void disconnect(java.lang.String city1, java.lang.String city2) {
		for(int i = 0; i < cities; i++) {
			if(arrCities[i][0].equals(city1)) {
				for(int a = 0; a < maxSize; a++) {
					if(arrCities[i][a].equals(city2)) {
						arrCities[i][a] = null;
					}
				}
			}
			
			if(arrCities[i][0].equals(city2)) {
				for(int c = 0; c < maxSize; c++) {
					if(arrCities[i][c].equals(city1)) {
						arrCities[i][c] = null;
					}
				}
			}
		}
	}
	
	public java.lang.String[] getCities() {
		java.lang.String[] sorted = new java.lang.String[maxSize];
		Arrays.sort(arrCities); 
		for(int i = 0; i < maxSize; i++)
			sorted[i] = arrCities[i][0];
		return sorted;
		
	}
	
	public int getCityCount() {
		return cities;
	}
	
	public java.lang.String[] getDirectlyConnectedCities(java.lang.String name){
		java.lang.String[] sorted = new java.lang.String[maxSize];
		for(int i = 0; i < cities; i++) {
			if(arrCities[i][0].equals(name)) {
				Arrays.sort(arrCities[i]); 
				for(int a = 0; a < maxSize; a++)
					sorted[a] = arrCities[i][a];
				return sorted;
			}
		}
		java.lang.String[] sorted2 = new java.lang.String[0];
		return sorted2;
	}
	
	public void removeCity(java.lang.String name) {
		for(int i = 0; i < cities; i++) {
			if(arrCities[i][0].equals(name)) {
				arrCities[i] = arrCities[cities];
				arrCities[cities] = null;
			}
		}
		for(int i = 0; i < cities; i++) {
			for(int a = 0; a < maxSize; a++) {
				if(arrCities[i][a].equals(name))
					arrCities[i][a] = null;
			}
		}
	}
	
	public java.lang.String toString(){
		String str = "";
		
		Arrays.sort(arrCities);
		for(int i = 0; i < cities; i++) {
			Arrays.sort(arrCities[i]); 
		}
		
		for(int i = 0; i < cities; i++) {
			str += arrCities[i][0];
			str += "[";
			for(int a = 0; a < maxSize; a++)
				str += arrCities[i][a] + ",";
			str += "]";
		}
		return str;
	
	}

}